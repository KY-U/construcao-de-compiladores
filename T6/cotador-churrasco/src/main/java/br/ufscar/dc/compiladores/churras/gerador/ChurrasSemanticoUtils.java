package br.ufscar.dc.compiladores.churras.gerador;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos.TipoLc;

public class ChurrasSemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();

    // Mensagens erros
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static TipoLc verificaTipo(String tipo){
        switch(tipo){
            case "KG":
                return TipoLc.KG;
            case "L":
                return TipoLc.L;
            case "UN":
                return TipoLc.UN;
            default:
                return TipoLc.INVALIDO;
        }
    }
}