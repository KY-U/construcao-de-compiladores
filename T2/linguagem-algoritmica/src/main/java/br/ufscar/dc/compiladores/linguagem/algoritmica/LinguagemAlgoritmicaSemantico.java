package br.ufscar.dc.compiladores.linguagem.algoritmica;

import br.ufscar.dc.compiladores.linguagem.algoritmica.TabelaDeSimbolos.TipoLinguagemAlgoritmica;
import br.ufscar.dc.compiladores.linguagem.algoritmica.LinguagemAlgoritmicaParser.*;

public class LinguagemAlgoritmicaSemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {

    Escopos escopos = new Escopos();

    @Override
    public Object visitDeclaracao_tipo(decTipoContext decT){
        TabelaDeSimbolos escopo = escopos.obterEscopoAtual();
        String identificador = decT.IDENT().getText();
        if (escopo.existe(identificador)){
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(decT.start, identificador + identificador + " já declarado");
        } else {
            escopo.adicionar(identificador, TabelaDeSimbolos.TipoLinguagemAlgoritmica.TIPO);

        }
    }

}