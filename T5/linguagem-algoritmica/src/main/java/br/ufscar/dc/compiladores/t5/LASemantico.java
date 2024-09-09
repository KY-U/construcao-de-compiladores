package br.ufscar.dc.compiladores.t5;

// Importações básicas para o funcionamento do programa.
import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.verificarTipo;
import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.verificaCompatibilidade;
import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.confereTipo;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoT5;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
import java.util.HashMap;

// Esta classe implementará, de fato, os métodos "visit", responsáveis por
// definir a estrutura das partes do código que será analisado.
public class LASemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {

    // Tabela utilizada para armazenar os escopos gerados ao longo da análise.
    // organiza essas tabelas
    TabelaDeSimbolos tabela;

    // Geração de um conjunto de escopos que serão analisados de forma auxiliar
    // no decorrer da análise.
    static Escopos escoposAninhados = new Escopos();
    
    // Criação de uma tabela auxiliar que armazenará os nomes e parâmetros das funções e procedimentos.
    static HashMap<String, ArrayList<TipoT5>> dadosFuncaoProcedimento = new HashMap<>();

    // Criação de uma tabela que armazenará as variaveis pertencentes a um registro.
    HashMap<String, ArrayList<String>> tabelaRegistro = new HashMap<>();

    // Método que adiciona o símbolo que está sendo analisado à tabela.
    public void adicionaSimboloTabela(String nome, String tipo, Token nomeT, Token tipoT, TipoEntrada tipoE) {
        // Obtenção do escopo que está sendo atualmente manipulado.
        TabelaDeSimbolos tabelaLocal = escoposAninhados.obterEscopoAtual();

        TipoT5 tipoItem;
        
        // Remoção do ponteiro do tipo pra verificação.
        if (tipo.charAt(0) == '^')
            tipo = tipo.substring(1);
        
        switch (tipo) {
            case "literal":
                tipoItem = TipoT5.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoT5.INTEIRO;
                break;
            case "real":
                tipoItem = TipoT5.REAL;
                break;
            case "logico":
                tipoItem = TipoT5.LOGICO;
                break;
            case "void":
                tipoItem = TipoT5.VOID;
                break;
            case "registro":
                tipoItem = TipoT5.REGISTRO;
                break;
            default:
                tipoItem = TipoT5.INVALIDO;
                break;
        }
        
        // Caso o tipo seja inválido, exibe a mensagem de que o tipo não foi declarado.
        if (tipoItem == TipoT5.INVALIDO)
            adicionaErroSemantico(tipoT, "tipo " + tipo + " nao declarado");
        
        // Verifica a existência do símbolo no escopo atual e exibe um erro caso já tenha sido declarado.
        if (!tabelaLocal.existe(nome))
            tabelaLocal.adicionar(nome, tipoItem, tipoE);
        else
            adicionaErroSemantico(nomeT, "identificador " + nome + " ja declarado anteriormente");
    }

    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {
        // Inicialização do programa.

        // Verifica se há alguma utilização do comando retorne no escopo do programa principal
        // para indicar o erro.
        for (LinguagemAlgoritmicaParser.CmdContext c : ctx.corpo().cmd())
            if (c.cmdRetorne() != null)
                adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");

        return super.visitPrograma(ctx);
    }
    
    @Override
    public Void visitCorpo(LinguagemAlgoritmicaParser.CorpoContext ctx) {
        super.visitCorpo(ctx);

        return null;
    }

    @Override
    public Void visitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        String tipoVariavel;
        String nomeVariavel;
                
        // Tenta identificar uma declaração local.
        if (ctx.getText().contains("declare")) {
            // Verifica se é a declaração de algum tipo de registro.
            if (ctx.variavel().tipo().registro() != null) {

                for (LinguagemAlgoritmicaParser.IdentificadorContext ic : ctx.variavel().identificador()) {
                    adicionaSimboloTabela(ic.getText(), "registro", ic.getStart(), null, TipoEntrada.VARIAVEL);

                    for (LinguagemAlgoritmicaParser.VariavelContext vc : ctx.variavel().tipo().registro().variavel()) {
                        tipoVariavel = vc.tipo().getText();
                        
                        for (LinguagemAlgoritmicaParser.IdentificadorContext icr : vc.identificador())
                            adicionaSimboloTabela(ic.getText() + "." + icr.getText(), tipoVariavel, icr.getStart(), vc.tipo().getStart(), TipoEntrada.VARIAVEL);
                    }
                }
            // Verifica se é um tipo já declarado.
            } else {
                tipoVariavel = ctx.variavel().tipo().getText(); 
                // Verifica se o tipo é um registro já declarado anteriormente.
                if (tabelaRegistro.containsKey(tipoVariavel)) {
                    ArrayList<String> variaveisRegistro = tabelaRegistro.get(tipoVariavel);
                    
                    for (LinguagemAlgoritmicaParser.IdentificadorContext ic : ctx.variavel().identificador()) {
                        nomeVariavel = ic.IDENT().get(0).getText();
                        
                        if (tabela.existe(nomeVariavel) || tabelaRegistro.containsKey(nomeVariavel)) {
                            adicionaErroSemantico(ic.getStart(), "identificador " + nomeVariavel + " ja declarado anteriormente");
                        } else {  
                            adicionaSimboloTabela(nomeVariavel, "registro", ic.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);                            

                            for (int i = 0; i < variaveisRegistro.size(); i = i + 2) {
                                adicionaSimboloTabela(nomeVariavel + "." + variaveisRegistro.get(i), variaveisRegistro.get(i+1), ic.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL);
                            }
                        }
                    }
                // Caso em que apenas é uma variável de um dos tipos básicos.
                } else {
                    for (LinguagemAlgoritmicaParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        nomeVariavel = ident.getText();
                        
                        // Verifica se a declaração atual é o nome de uma função ou procedimento.
                        if (dadosFuncaoProcedimento.containsKey(nomeVariavel))
                            adicionaErroSemantico(ident.getStart(), "identificador " + nomeVariavel + " ja declarado anteriormente");
                        else
                            adicionaSimboloTabela(nomeVariavel, tipoVariavel, ident.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL); 
                    }
                }
            }
        // Verifica se é a declaração de um novo tipo (registro).
        } else if (ctx.getText().contains("tipo")) {
            
            if (ctx.tipo().registro() != null) {
                ArrayList<String> variaveisRegistro = new ArrayList<>();
                
                for (LinguagemAlgoritmicaParser.VariavelContext vc : ctx.tipo().registro().variavel()) {
                    tipoVariavel = vc.tipo().getText();
                    
                    for (LinguagemAlgoritmicaParser.IdentificadorContext ic : vc.identificador()) {
                        variaveisRegistro.add(ic.getText());
                        variaveisRegistro.add(tipoVariavel);
                    }
                }
                tabelaRegistro.put(ctx.IDENT().getText(), variaveisRegistro);
            }
        // Verifica se é a declaração de uma constante.
        } else if (ctx.getText().contains("constante"))
            adicionaSimboloTabela(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), TipoEntrada.VARIAVEL);
        
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx) {
        // Cria um novo escopo para cada novo procedimento ou função.
        escoposAninhados.criarNovoEscopo();
        
        tabela = escoposAninhados.obterEscopoAtual();

        // Lista auxiliar que armazenará os tipos das variáveis.
        ArrayList<TipoT5> tiposVariaveis = new ArrayList<>();
        ArrayList<String> variaveisRegistro;
                
        String tipoVariavel;
        TipoT5 tipoAux;
        
        // Verifica se o escopo atual pertence a um procedimento.
        if (ctx.getText().contains("procedimento")) {
            
            for (LinguagemAlgoritmicaParser.ParametroContext parametro : ctx.parametros().parametro()) {
                // Verifica se é um tipo básico válido.
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                    // Adiciona o parâmetro na tabela.
                    adicionaSimboloTabela(parametro.identificador().get(0).getText(), parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), parametro.getStart(), parametro.getStart(), TipoEntrada.VARIAVEL);
                    
                    // Obtém os tipos dos parâmetros para adicioná-las na tabela de dados de funções e procedimentos.
                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                // Verifica se é um registro
                } else if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                    // Recupera os elementos do registro.
                    variaveisRegistro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());

                    // Obtém os tipos dos parâmetros para adicioná-las na tabela de dados de funções e procedimentos.
                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);

                    for (LinguagemAlgoritmicaParser.IdentificadorContext ic : parametro.identificador())
                        // Adiciona os elementos do registro na tabela no formato adequado com seus
                        // respectivos tipos individuais.
                        for (int i = 0; i < variaveisRegistro.size(); i = i + 2)
                            adicionaSimboloTabela(ic.getText() + "." + variaveisRegistro.get(i), variaveisRegistro.get(i + 1), ic.getStart(), ic.getStart(), TipoEntrada.VARIAVEL);                       
                } else
                    adicionaErroSemantico(parametro.getStart(), "tipo nao declarado");                       
            }
            // Verifica se há algum comando "retorne" dentro de um procedimento e indica o erro.
            for (LinguagemAlgoritmicaParser.CmdContext c : ctx.cmd())    
                if (c.cmdRetorne() != null)  
                    adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");    
            
            // Adiciona o nome do procedimento e os tipos dos parâmetros na tabela de dados.
            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);
            
        // Verifica se o escopo atual pertence a uma função.
        } else if (ctx.getText().contains("funcao")) {
            // A partir daqui, utiliza uma lógica semelhante às verificações para o procedimento.
            for (LinguagemAlgoritmicaParser.ParametroContext parametro : ctx.parametros().parametro()) {
                
                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                
                    adicionaSimboloTabela(parametro.identificador().get(0).getText(), parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), parametro.getStart(), parametro.getStart(), TipoEntrada.VARIAVEL);

                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                } else if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {

                    variaveisRegistro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());

                    tipoVariavel = parametro.tipo_estendido().tipo_basico_ident().IDENT().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);
                    
                    for (LinguagemAlgoritmicaParser.IdentificadorContext ic : parametro.identificador())
                        for (int i = 0; i < variaveisRegistro.size(); i = i + 2)
                                adicionaSimboloTabela(ic.getText() + "." + variaveisRegistro.get(i), variaveisRegistro.get(i + 1), ic.getStart(), ic.getStart(), TipoEntrada.VARIAVEL);
                } else
                    adicionaErroSemantico(parametro.getStart(), "tipo nao declarado");
            }
            
            // Adiciona o nome da função e os tipos dos parâmetros na tabela de dados.
            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);
        }
        
        super.visitDeclaracao_global(ctx);
        
        // Desempilha o escopo atual
        escoposAninhados.abandonarEscopo();
        
        // Adiciona o nome do procedimento/função na tabela
        if (ctx.getText().contains("procedimento"))      
            adicionaSimboloTabela(ctx.IDENT().getText(), "void", ctx.getStart(), ctx.getStart(), TipoEntrada.PROCEDIMENTO);
        else if (ctx.getText().contains("funcao"))
            adicionaSimboloTabela(ctx.IDENT().getText(), ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.getStart(), ctx.getStart(), TipoEntrada.FUNCAO);

        return null;
    }

    @Override
    public Void visitCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        for (LinguagemAlgoritmicaParser.IdentificadorContext id : ctx.identificador()) 
            // Verifica se está lendo uma variável que ainda não foi declarada.
            if (!tabela.existe(id.getText()))
                adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");

        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
                
        TipoT5 tipo;
                
        for (LinguagemAlgoritmicaParser.ExpressaoContext expressao : ctx.expressao())
            tipo = verificarTipo(tabela, expressao);

        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT5 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT5 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdSe(ctx);
    }
        
    @Override
    public Void visitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT5 tipoExpressao = verificarTipo(tabela, ctx.expressao());
        
        String varNome = ctx.identificador().getText();
        
        if (tipoExpressao != TipoT5.INVALIDO) {
            // Caso a variável não tenha sido declarada, informa o erro.
            if (!tabela.existe(varNome))
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            else {
                TipoT5 varTipo = verificarTipo(tabela, varNome);
                
                // Caso o tipo seja inteiro ou real, é utilizada a função verificaCompatibilidade para verificar
                // se o valor a ser trabalhado é real ou não (mais informações sobre a função podem ser encontradas
                // no arquivo T4SemanticoUtils.java.
                if (varTipo == TipoT5.INTEIRO || varTipo == TipoT5.REAL) {
                    // Verifica se a variável atual é um ponteiro para apresentar uma mensagem personalizada
                    // para este caso.
                    if (ctx.getText().contains("ponteiro")) {
                        if (!verificaCompatibilidade(varTipo, tipoExpressao))
                            // Caso o tipo da expressão (restante da parcela sendo analisada) seja diferente de inteiro,
                            // não é possível tratar o valor como um número real, logo, os tipos são incompatíveis, pois
                            // seria a situação de estar comparando um número com um literal, por exemplo.
                            if (tipoExpressao != TipoT5.INTEIRO)
                                adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + ctx.identificador().getText());
                    } else if (!verificaCompatibilidade(varTipo, tipoExpressao))
                        if (tipoExpressao != TipoT5.INTEIRO)
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());               
                // Caso a expressão analisada não tenha números que precisem ser tratados de maneira especial,
                // apenas verifica se os tipos são diferentes.
                } else if (varTipo != tipoExpressao)
                    adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }
}