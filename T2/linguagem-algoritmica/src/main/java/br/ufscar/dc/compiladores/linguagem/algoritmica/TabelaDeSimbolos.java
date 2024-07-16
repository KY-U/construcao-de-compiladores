package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.util.HashMap;
import java.util.Map;

public class TabelaDeSimbolos {
    public enum TipoLinguagemAlgoritmica{
        INTEIRO,
        REAL,
        CADEIA,
        LOGICO,
        TIPO,
        IDENT,
        INVALIDO
    }

        class EntradaTabelaDeSimbolos {
        TipoLinguagemAlgoritmica tipo;
        String nome;

        private EntradaTabelaDeSimbolos(String nome, TipoLinguagemAlgoritmica tipo) {
            this.tipo = tipo;
            this.nome = nome;
        }
    }

     private final Map<String, EntradaTabelaDeSimbolos> tabela;

        public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public void adicionar(String nome, TipoLinguagemAlgoritmica tipo) {
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo));
    }

    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }

    public TipoLinguagemAlgoritmica verificarTipos(String nome) {
        return tabela.get(nome).tipo;
    }
}