package br.ufscar.dc.compiladores.t4;


import static br.ufscar.dc.compiladores.t4.LASemanticoUtils.verificarTipo;
import static br.ufscar.dc.compiladores.t4.LASemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.t4.LASemanticoUtils.verificaCompatibilidade;
import static br.ufscar.dc.compiladores.t4.LASemanticoUtils.confereTipo;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoT4;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;
import java.util.HashMap;


public class LASemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {


    TabelaDeSimbolos tabela;


    static Escopos escoposAninhados = new Escopos();
    

    static HashMap<String, ArrayList<TipoT4>> dadosFuncaoProcedimento = new HashMap<>();


    HashMap<String, ArrayList<String>> tabelaRegistro = new HashMap<>();


    public void adicionaSimboloTabela(String nome, String tipo, Token nomeT, Token tipoT, TipoEntrada tipoE) {

        TabelaDeSimbolos tabelaLocal = escoposAninhados.obterEscopoAtual();

        TipoT4 tipoItem;
        

        if (tipo.charAt(0) == '^')
            tipo = tipo.substring(1);
        
        switch (tipo) {
            case "literal":
                tipoItem = TipoT4.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoT4.INTEIRO;
                break;
            case "real":
                tipoItem = TipoT4.REAL;
                break;
            case "logico":
                tipoItem = TipoT4.LOGICO;
                break;
            case "void":
                tipoItem = TipoT4.VOID;
                break;
            case "registro":
                tipoItem = TipoT4.REGISTRO;
                break;
            default:
                tipoItem = TipoT4.INVALIDO;
                break;
        }
        

        if (tipoItem == TipoT4.INVALIDO)
            adicionaErroSemantico(tipoT, "tipo " + tipo + " nao declarado");
        

        if (!tabelaLocal.existe(nome))
            tabelaLocal.adicionar(nome, tipoItem, tipoE);
        else
            adicionaErroSemantico(nomeT, "identificador " + nome + " ja declarado anteriormente");
    }

    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {

        for (LinguagemAlgoritmicaParser.CmdContext c : ctx.corpo().cmd())
            if (c.cmdRetorne() != null)
                adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");

        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        String tipoVariavel;
        String nomeVariavel;
                

        if (ctx.getText().contains("declare")) {

            if (ctx.variavel().tipo().registro() != null) {

                for (LinguagemAlgoritmicaParser.IdentificadorContext ic : ctx.variavel().identificador()) {
                    adicionaSimboloTabela(ic.getText(), "registro", ic.getStart(), null, TipoEntrada.VARIAVEL);

                    for (LinguagemAlgoritmicaParser.VariavelContext vc : ctx.variavel().tipo().registro().variavel()) {
                        tipoVariavel = vc.tipo().getText();
                        
                        for (LinguagemAlgoritmicaParser.IdentificadorContext icr : vc.identificador())
                            adicionaSimboloTabela(ic.getText() + "." + icr.getText(), tipoVariavel, icr.getStart(), vc.tipo().getStart(), TipoEntrada.VARIAVEL);
                    }
                }

            } else {
                tipoVariavel = ctx.variavel().tipo().getText(); 

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

                } else {
                    for (LinguagemAlgoritmicaParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                        nomeVariavel = ident.getText();
                        

                        if (dadosFuncaoProcedimento.containsKey(nomeVariavel))
                            adicionaErroSemantico(ident.getStart(), "identificador " + nomeVariavel + " ja declarado anteriormente");
                        else
                            adicionaSimboloTabela(nomeVariavel, tipoVariavel, ident.getStart(), ctx.variavel().tipo().getStart(), TipoEntrada.VARIAVEL); 
                    }
                }
            }

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

        } else if (ctx.getText().contains("constante"))
            adicionaSimboloTabela(ctx.IDENT().getText(), ctx.tipo_basico().getText(), ctx.IDENT().getSymbol(), ctx.IDENT().getSymbol(), TipoEntrada.VARIAVEL);
        
        return super.visitDeclaracao_local(ctx);
    }
    
    @Override
    public Void visitDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx) {

        escoposAninhados.criarNovoEscopo();
        
        tabela = escoposAninhados.obterEscopoAtual();


        ArrayList<TipoT4> tiposVariaveis = new ArrayList<>();
        ArrayList<String> variaveisRegistro;
                
        String tipoVariavel;
        TipoT4 tipoAux;

        if (ctx.getText().contains("procedimento")) {
            
            for (LinguagemAlgoritmicaParser.ParametroContext parametro : ctx.parametros().parametro()) {

                if (parametro.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {

                    adicionaSimboloTabela(parametro.identificador().get(0).getText(), parametro.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), parametro.getStart(), parametro.getStart(), TipoEntrada.VARIAVEL);
                    

                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);

                } else if (tabelaRegistro.containsKey(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText())) {

                    variaveisRegistro = tabelaRegistro.get(parametro.tipo_estendido().tipo_basico_ident().IDENT().getText());


                    tipoVariavel = parametro.tipo_estendido().getText();
                    tipoAux = confereTipo(tabelaRegistro, tipoVariavel);
                    tiposVariaveis.add(tipoAux);

                    for (LinguagemAlgoritmicaParser.IdentificadorContext ic : parametro.identificador())

                        for (int i = 0; i < variaveisRegistro.size(); i = i + 2)
                            adicionaSimboloTabela(ic.getText() + "." + variaveisRegistro.get(i), variaveisRegistro.get(i + 1), ic.getStart(), ic.getStart(), TipoEntrada.VARIAVEL);                       
                } else
                    adicionaErroSemantico(parametro.getStart(), "tipo nao declarado");                       
            }
            for (LinguagemAlgoritmicaParser.CmdContext c : ctx.cmd())    
                if (c.cmdRetorne() != null)  
                    adicionaErroSemantico(c.getStart(), "comando retorne nao permitido nesse escopo");    

            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);

        } else if (ctx.getText().contains("funcao")) {
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

            dadosFuncaoProcedimento.put(ctx.IDENT().getText(), tiposVariaveis);
        }
        
        super.visitDeclaracao_global(ctx);

        escoposAninhados.abandonarEscopo();

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
            if (!tabela.existe(id.getText()))
                adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");

        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
                
        TipoT4 tipo;
                
        for (LinguagemAlgoritmicaParser.ExpressaoContext expressao : ctx.expressao())
            tipo = verificarTipo(tabela, expressao);

        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT4 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT4 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdSe(ctx);
    }
        
    @Override
    public Void visitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT4 tipoExpressao = verificarTipo(tabela, ctx.expressao());
        
        String varNome = ctx.identificador().getText();
        
        if (tipoExpressao != TipoT4.INVALIDO) {
            // Caso a variável não tenha sido declarada, informa o erro.
            if (!tabela.existe(varNome))
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            else {
                TipoT4 varTipo = verificarTipo(tabela, varNome);
                if (varTipo == TipoT4.INTEIRO || varTipo == TipoT4.REAL) {
                    if (ctx.getText().contains("ponteiro")) {
                        if (!verificaCompatibilidade(varTipo, tipoExpressao))
                            if (tipoExpressao != TipoT4.INTEIRO)
                                adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para ^" + ctx.identificador().getText());
                    } else if (!verificaCompatibilidade(varTipo, tipoExpressao))
                        if (tipoExpressao != TipoT4.INTEIRO)
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                } else if (varTipo != tipoExpressao)
                    adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }

}
