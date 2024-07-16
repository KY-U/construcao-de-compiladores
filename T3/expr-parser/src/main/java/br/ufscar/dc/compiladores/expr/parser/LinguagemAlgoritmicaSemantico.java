package br.ufscar.dc.compiladores.expr.parser;

import br.ufscar.dc.compiladores.expr.parser.TabelaDeSimbolos;

public class LinguagemAlgoritmicaSemantico extends LinguagemAlgoritmicaBaseVisitor<Void>{

    TabelaDeSimbolos tabela;

    //inicializa a tabela de símbolos e continua a visitação nos nós filhos.
    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    //obtém o nome e o tipo da variável, verifica se a variável já foi declarada, e se não, a adiciona à tabela de símbolos
    @Override
    public Void visitDeclaracao(LinguagemAlgoritmica.DeclaracaoContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        String strTipoVar = ctx.TIPO_VAR().getText();
        TipoAlguma tipoVar = TipoAlguma.INVALIDO;
        switch (strTipoVar) {
            case "inteiro":
                tipoVar = TipoAlguma.INTEIRO;
                break;
            case "real":
                tipoVar = TipoAlguma.REAL;
                break;
            case "literal":
                tipoVar = TipoAlguma.LITERAL;
                break;
            case "logico":
                tipoVar = TipoAlguma.LOGICO;
                break;
            default:
                // Nunca irá acontecer, pois o analisador sintático
                // não permite
                break;
        }

        // Verificar se a variável já foi declarada
        if (tabela.existe(nomeVar)) {
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " já existe");
        } else {
            tabela.adicionar(nomeVar, tipoVar);
        }

        return super.visitDeclaracao(ctx);
    }

    @Override
    public Void visitComandoAtribuicao(LinguagemAlgoritmicaParser.ComandoAtribuicaoContext ctx) {
        TipoAlguma tipoExpressao = LinguagemAlgoritmicaSemanticoUtils.verificarTipo(tabela, ctx.expressaoAritmetica());
        if (tipoExpressao != TipoAlguma.INVALIDO) {
            String nomeVar = ctx.VARIAVEL().getText();
            if (!tabela.existe(nomeVar)) {
                LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " não foi declarada antes do uso");
            } else {
                TipoAlguma tipoVariavel = LinguagemAlgoritmicaSemanticoUtils.verificarTipo(tabela, nomeVar);
                if (tipoVariavel != tipoExpressao) {
                    LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Tipo da variável " + nomeVar + " não é compatível com o tipo da expressão");
                }
            }
        }
        return super.visitComandoAtribuicao(ctx);
    }

    @Override
    public Void visitComandoEntrada(LinguagemAlgoritmicaParser.ComandoEntradaContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        if (!tabela.existe(nomeVar)) {
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " não foi declarada antes do uso");
        }
        return super.visitComandoEntrada(ctx);
    }

    @Override
    public Void visitExpressaoAritmetica(LinguagemAlgoritmicaParser.ExpressaoAritmeticaContext ctx) {
        LinguagemAlgoritmicaSemanticoUtils.verificarTipo(tabela, ctx);
        return super.visitExpressaoAritmetica(ctx);
    }
}
