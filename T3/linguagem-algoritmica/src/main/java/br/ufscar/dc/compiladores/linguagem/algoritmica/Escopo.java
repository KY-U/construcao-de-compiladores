package br.ufscar.dc.compiladores.expr.parser;

import java.util.LinkedList;

public class Escopo {
    private LinkedList<TabelaDeSimbolos> pilhaTabelaDeSimbolos;

    public Escopo() {
        pilhaTabelaDeSimbolos = new LinkedList<TabelaDeSimbolos>();
        pushEscopo();
    }

    public void pushEscopo(){
        pilhaTabelaDeSimbolos.push(new TabelaDeSimbolos());
    }

    public void popEscopo(){
        pilhaTabelaDeSimbolos.pop();
    }

    public TabelaDeSimbolos getFirstEscopo(){
        return pilhaTabelaDeSimbolos.peek();
    }

    public LinkedList<TabelaDeSimbolos> getAllEscopos(){
        return pilhaTabelaDeSimbolos;
    }
}
