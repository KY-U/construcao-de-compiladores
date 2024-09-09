// Classe TabelaDeSimbolos, inspirada no código apresentado pelo
// professor em sala de aula.
package br.ufscar.dc.compiladores.t5;

import java.util.HashMap;
import java.util.Map;
import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.reduzNome;

public class TabelaDeSimbolos {

    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    // Tipos possíveis de variáveis.
    public enum TipoT5 {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        VOID,
        REGISTRO,
        TIPOESTENDIDO,
        INVALIDO
    }
    
    // Tipos possíveis de declarações.
    public enum TipoEntrada {
        VARIAVEL, // Para fins de simplificação, tudo que não for um procedimento ou função será considerado uma variável.
        PROCEDIMENTO,
        FUNCAO
    }

    class EntradaTabelaDeSimbolos {
        String nome;
        TipoT5 tipo;
        TipoEntrada tipoE;

        private EntradaTabelaDeSimbolos(String nome, TipoT5 tipo, TipoEntrada tipoE) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipoE = tipoE;
        }
    }

    public TipoT5 verificar(String nome) {
        // Remoção do índice de um vetor.
        nome = reduzNome(nome, "[");
        
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, TipoT5 tipo, TipoEntrada tipoE) {
        // Remoção do índice de um vetor.
        nome = reduzNome(nome, "[");
        
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoE));
    }    

    public boolean existe(String nome) {
        // Remoção do índice de um vetor.
        nome = reduzNome(nome, "[");

        return tabela.containsKey(nome);
    }
}
