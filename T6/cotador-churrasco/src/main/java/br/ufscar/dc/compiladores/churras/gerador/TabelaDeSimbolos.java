package br.ufscar.dc.compiladores.churras.gerador;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TabelaDeSimbolos {
    public enum TipoLc {
        UN,
        KG,
        L,
        INVALIDO,
        MERCADO;
    }

    public class EntradaTabelaDeSimbolos {
        public String nome;
        public TipoLc tipo;
        public TabelaDeSimbolos items;
        public Float preco;
        public Float quantidade;

        private EntradaTabelaDeSimbolos(String nome, TipoLc tipo, TabelaDeSimbolos items, Float preco, Float quantidade) {
            this.nome = nome;
            this.tipo = tipo;
            this.items = items;
            this.preco = preco;
            this.quantidade = quantidade;
        }

    }

    private final Map<String, EntradaTabelaDeSimbolos> tabela;

    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public Map<String, EntradaTabelaDeSimbolos> getTabela() {
        return Collections.unmodifiableMap(tabela) ;
    }

    public void adicionar(String nome, TipoLc tipo, TabelaDeSimbolos items, String preco, String quantidade) {
        Float precoConvertido = preco != null ? Float.parseFloat(preco.replace(",", ".")): null;
        Float quantidadeConvertida = quantidade != null ? Float.parseFloat(quantidade.replace(",", ".")): null;
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, items, precoConvertido, quantidadeConvertida));
    }

    public boolean boolMercado(String nomeMercado){
        if (tabela.containsKey(nomeMercado)){
            return tabela.get(nomeMercado).tipo.equals(TipoLc.MERCADO);
        }
        return false;
    }

    public boolean existe(String nome){
        return tabela.containsKey(nome);
    }

    public TipoLc verificaTipo(String nome){
       return tabela.get(nome).tipo;
    }

    public TipoLc typeItemMercados(String nome){
        for (Entry<String, EntradaTabelaDeSimbolos> entry : tabela.entrySet()) {
            String chave = entry.getKey();
            EntradaTabelaDeSimbolos entrada = tabela.get(chave);
            if(entrada.tipo.equals(TipoLc.MERCADO)){
                TabelaDeSimbolos items = entrada.items;
                if(items.tabela.containsKey(nome)){
                    return items.verificaTipo(nome);
                }
            }
        }
        return null;
    }


}