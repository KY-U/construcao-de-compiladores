package br.ufscar.dc.compiladores.linguagem.algoritmica;

import br.ufscar.dc.compiladores.linguagem.algoritmica.TabelaDeSimbolos.TipoLinguagemAlgoritmica;
import br.ufscar.dc.compiladores.linguagem.algoritmica.LinguagemAlgoritmicaParser.*;

public class LinguagemAlgoritmicaSemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {

    Escopos escopos = new Escopos();

    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }

    //verifica se a constante foi declarada anteriormente (ela não pode ser alterada por se tratar de uma constante)
    @Override
    public Object visitDeclaracao_local(Declaracao_localContext ctx) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        if (escopoAtual.existe(ctx.IDENT().getText()) && ) {
            AlgumaSemanticoUtils.adicionarErroSemantico(ctx.start, "constante" + ctx.IDENT().getText()
                    + " ja declarado anteriormente");
        } else {
            TabelaDeSimbolos.TipoAlguma tipo = TabelaDeSimbolos.TipoAlguma.INTEIRO;
            switch(ctx.tipo_basico().getText()) {
               case "literal":
                        tipo = TabelaDeSimbolos.TipoAlguma.CADEIA;
                        break;
               case "inteiro":
                        tipo = TabelaDeSimbolos.TipoAlguma.INTEIRO;
                        break;
               case "real":
                        tipo = TabelaDeSimbolos.TipoAlguma.REAL;
                        break;
               case "logico":
                        tipo = TabelaDeSimbolos.TipoAlguma.LOGICO;
                        break;
            }
            escopoAtual.adicionar(ctx.IDENT().getText(), tipo);
        }

        return super.visitDeclaracao_constante(ctx);
    }
}