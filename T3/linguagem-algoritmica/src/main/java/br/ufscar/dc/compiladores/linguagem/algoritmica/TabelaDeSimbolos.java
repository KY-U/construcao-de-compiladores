package br.ufscar.dc.compiladores.expr.parser;

import java.util.HashMap;
import java.util.Map;

public class TabelaDeSimbolos {
    public enum TipoToken {
        INTEIRO,
        REAL,
        INVALIDO,
        //CADEIA,
        //IDENT,
        LITERAL,
        LOGICO
        //REGISTRO
        //FUNCAO
        //PROCEDIMENTO
    }
    
    class EntradaTabelaDeSimbolos {
        String nome;
        TipoToken tipo;

        private EntradaTabelaDeSimbolos(String nome, TipoToken tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }
    }
    
    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void adicionar(String nome, TipoToken tipo) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public TipoToken getTipo(String nome) {
        return tabela.get(nome).tipo;
    }
}
