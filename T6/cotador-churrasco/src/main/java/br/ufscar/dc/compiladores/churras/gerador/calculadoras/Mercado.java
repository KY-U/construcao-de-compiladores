package br.ufscar.dc.compiladores.churras.gerador.calculadoras;

import java.util.Collections;
import java.util.List;

/* Classe para o objeto Mercado */
public class Mercado {
    
    private String nome;
    private List<Item> items;

    
    public Mercado(String nome, List<Item> items) {
        this.nome = nome;
        this.items = items;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void adicionarItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Mercado [nome=" + nome + ", items=" + items + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mercado other = (Mercado) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
}
