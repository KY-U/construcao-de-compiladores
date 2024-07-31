package br.ufscar.dc.compiladores.t3;

// Importações básicas para o funcionamento do programa.
import static br.ufscar.dc.compiladores.t3.LASemanticoUtils.verificarTipo;
import static br.ufscar.dc.compiladores.t3.LASemanticoUtils.adicionaErroSemantico;
import static br.ufscar.dc.compiladores.t3.LASemanticoUtils.verificaCompatibilidade;
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoT3;
import org.antlr.v4.runtime.Token;

// Esta classe implementará, de fato, os métodos "visit", responsáveis por
// definir a estrutura das partes do código que será analisado.
public class LASemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {

    // Tabela utilizada para armazenar os escopos gerados ao longo da análise.
    TabelaDeSimbolos tabela;

    // Geração de um conjunto de escopos que serão analisados de forma auxiliar
    // no decorrer da análise.
    static Escopos escoposAninhados = new Escopos();
    
    TabelaDeSimbolos tabelaEscopo;

    // Método que adiciona a variável que está sendo analisado à tabela.
    public void adicionaVariavelTabela(String nome, String tipo, Token nomeT, Token tipoT) {
        tabelaEscopo = escoposAninhados.obterEscopoAtual();

        TipoT3 tipoItem;

        switch (tipo) {
            case "literal":
                tipoItem = TipoT3.LITERAL;
                break;
            case "inteiro":
                tipoItem = TipoT3.INTEIRO;
                break;
            case "real":
                tipoItem = TipoT3.REAL;
                break;
            case "logico":
                tipoItem = TipoT3.LOGICO;
                break;
            default:
                tipoItem = TipoT3.INVALIDO;
                break;
        }

        // Caso o tipo seja inválido, exibe a mensagem de que o tipo não foi declarado.
        if (tipoItem == TipoT3.INVALIDO)
            adicionaErroSemantico(tipoT, "tipo " + tipo + " nao declarado");

        // Verifica se a variável já foi declarada, ou seja, já foi adicionada na tabela.
        if (!tabelaEscopo.existe(nome))
            tabelaEscopo.adicionar(nome, tipoItem);
        else
            adicionaErroSemantico(nomeT, "identificador " + nome + " ja declarado anteriormente");
    }

    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {
        // Inicialização do programa.
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracoes(LinguagemAlgoritmicaParser.DeclaracoesContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Verifica a declaração atual.
        for (LinguagemAlgoritmicaParser.Decl_local_globalContext declaracao : ctx.decl_local_global())
            visitDecl_local_global(declaracao);
        
        return super.visitDeclaracoes(ctx);
    }

    @Override
    public Void visitDecl_local_global(LinguagemAlgoritmicaParser.Decl_local_globalContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        // Identifica se é uma declaração local ou global.
        if (ctx.declaracao_local() != null)
            visitDeclaracao_local(ctx.declaracao_local());
        else if (ctx.declaracao_global() != null)
            visitDeclaracao_global(ctx.declaracao_global());

        return super.visitDecl_local_global(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        String tipoVariavel;
        String nomeVariavel;

        // Tenta identificar uma declaração
        if (ctx.getText().contains("declare")) {
            tipoVariavel = ctx.variavel().tipo().getText();

            // Adiciona a variável atual na tabela (a verificação de variável repetida ocorre
            // no método adicionaVariavelTabela.
            for (LinguagemAlgoritmicaParser.IdentificadorContext ident : ctx.variavel().identificador()) {
                nomeVariavel = ident.getText();
                adicionaVariavelTabela(nomeVariavel, tipoVariavel, ident.getStart(), ctx.variavel().tipo().getStart());
            }
        }

        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();

        for (LinguagemAlgoritmicaParser.IdentificadorContext id : ctx.identificador())
            // Verifica se a variável já foi declarada.
            if (!tabela.existe(id.getText()))
                adicionaErroSemantico(id.getStart(), "identificador " + id.getText() + " nao declarado");

        return super.visitCmdLeia(ctx);
    }

    @Override
    public Void visitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipo;

        for (LinguagemAlgoritmicaParser.ExpressaoContext expressao : ctx.expressao())
            tipo = verificarTipo(tabela, expressao);

        return super.visitCmdEscreva(ctx);
    }

    @Override
    public Void visitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipo = verificarTipo(tabela, ctx.expressao());
        
        return super.visitCmdEnquanto(ctx);
    }

    @Override
    public Void visitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx) {
        tabela = escoposAninhados.obterEscopoAtual();
        
        TipoT3 tipoExpressao = verificarTipo(tabela, ctx.expressao());
        
        String varNome = ctx.identificador().getText();
        
        if (tipoExpressao != TipoT3.INVALIDO) {
            // Caso a variável não tenha sido declarada, informa o erro.
            if (!tabela.existe(varNome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
            } else {
                // Caso contrário, identifica o tipo da variável para as condições posteriores.
                TipoT3 varTipo = verificarTipo(tabela, varNome);
                
                // Caso o tipo seja inteiro ou real, é utilizada a função verificaCompatibilidade para verificar
                // se o valor a ser trabalhado é real ou não (mais informações sobre a função podem ser encontradas
                // no arquivo LASemanticoUtils.java.
                if (varTipo == TipoT3.INTEIRO || varTipo == TipoT3.REAL) {
                    if (!verificaCompatibilidade(varTipo, tipoExpressao)) {
                        // Caso o tipo da expressão (restante da parcela sendo analisada) seja diferente de inteiro,
                        // não é possível tratar o valor como um número real, logo, os tipos são incompatíveis, pois
                        // seria a situação de estar comparando um número com um literal, por exemplo.
                        if (tipoExpressao != TipoT3.INTEIRO) {
                            adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
                        }
                    }
                // Caso a expressão analisada não tenha números que precisem ser tratados de maneira especial,
                // apenas verifica se os tipos são diferentes.
                } else if (varTipo != tipoExpressao)
                    adicionaErroSemantico(ctx.identificador().getStart(), "atribuicao nao compativel para " + ctx.identificador().getText());
            }
        }
        
        return super.visitCmdAtribuicao(ctx);
    }

}
