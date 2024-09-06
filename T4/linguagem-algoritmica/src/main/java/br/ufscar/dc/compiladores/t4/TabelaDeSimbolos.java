// Classe TabelaDeSimbolos, inspirada no código apresentado pelo
// professor em sala de aula.

package br.ufscar.dc.compiladores.t4;

import java.util.HashMap;
import java.util.Map;
import static br.ufscar.dc.compiladores.t4.LASemanticoUtils.reduzNome;

public class TabelaDeSimbolos {

    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public enum TipoT4 {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        VOID,
        REGISTRO,
        INVALIDO
    }
    
    public enum TipoEntrada {
        VARIAVEL, 
        PROCEDIMENTO,
        FUNCAO
    }

    class EntradaTabelaDeSimbolos {
        String nome;
        TipoT4 tipo;
        TipoEntrada tipoE;

        private EntradaTabelaDeSimbolos(String nome, TipoT4 tipo, TipoEntrada tipoE) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipoE = tipoE;
        }
    }

    public TipoT4 verificar(String nome) {
        nome = reduzNome(nome, "[");
        
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, TipoT4 tipo, TipoEntrada tipoE) {
        nome = reduzNome(nome, "[");
        
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoE));
    }    

    public boolean existe(String nome) {
        nome = reduzNome(nome, "[");

        return tabela.containsKey(nome);
    }
}
