package br.ufscar.dc.compiladores.churras.gerador;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos.TipoLc;
import br.ufscar.dc.compiladores.parser.ChurrasBaseVisitor;
import br.ufscar.dc.compiladores.parser.ChurrasParser.MercadoContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.Item_listaContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.Item_mercadoContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.ProgramaContext;

public class ChurrasSemantico extends ChurrasBaseVisitor<Void> {

    TabelaDeSimbolos tabela;

    @Override
    public Void visitPrograma(ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitMercado(MercadoContext ctx) {
        String nomeMercado = ctx.IDENT().getText();

        // Verifica se já existe algum mercado com o nome declarado
        if (tabela.boolMercado(nomeMercado)) {
            ChurrasSemanticoUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(),
                    "Mercado " + nomeMercado + " já declarada anteriormente");
        } else {
            // adiciona mercado na tabela vazia
            // foreach para ir adicionando os items nas tabela adicional
            TabelaDeSimbolos tabelaItems = new TabelaDeSimbolos();
            for (Item_mercadoContext item : ctx.item_mercado()) {
                adicionarItemMercado(tabelaItems, item);
            }
            tabela.adicionar(nomeMercado, TipoLc.MERCADO, tabelaItems, null, null);
        }
        return super.visitMercado(ctx);
    }

    @Override
    public Void visitItem_lista(Item_listaContext ctx) {
        adicionarItemLista(tabela, ctx);
        return super.visitItem_lista(ctx);
    }

    private void adicionarItemLista(TabelaDeSimbolos tabelaItems, Item_listaContext item) {
        String nomeItem = item.IDENT().getText();
        if (!tabelaItems.existe(nomeItem)) { // verifica se já foi declarado na lista
            String unidade = item.UNIDADE().getText();

            // Checa se a UN nao possui um nomero real como valor
            if (!(unidade.equals("UN") && item.quant.getText().contains(","))) { // se não tem frações de uma unidade
                TipoLc tipoItem = tabela.typeItemMercados(nomeItem);

                // Verifica se o item existe em algum mercado
                if(tipoItem != null){

                    // Verifica se a unidade de medida na lista é compativel com as do mercado
                    if(tipoItem.equals(ChurrasSemanticoUtils.verificaTipo(unidade))){
                        tabelaItems.adicionar(nomeItem, ChurrasSemanticoUtils.verificaTipo(unidade), null,
                    null, item.quant.getText());
                    } else{
                        ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
                    "Unidade " + unidade + " Incompatível para Medida " + tipoItem);
                    }
                    
                } else{
                    ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
                        "Item " + nomeItem + " não declarado anteriormente nos mercados");
                }
            } else {
                ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
                    "Valor Incompatível para Medida " + unidade);
            }
        } else {
            ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
            "Item " + nomeItem + " já declarado anteriormente na Lista");
        }
    }

    // Adiciona os items do mercado fazendo as verificacoes necessárias
    private void adicionarItemMercado(TabelaDeSimbolos tabelaItems, Item_mercadoContext item) {
        String nomeItem = item.IDENT().getText();

        // Checa se o item já está registrado no mercado
        if (!tabelaItems.existe(nomeItem)) {
            String unidade = item.UNIDADE().getText();

            // Checa se a UN nao possui um nomero real como valor
            if (unidade.equals("UN") && item.quant.getText().contains(",")) {
            ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
                    "Valor Incompatível para Medida " + unidade);
            } else{
                TipoLc tipoItem = tabela.typeItemMercados(nomeItem);

                // Verifica se os items declarados com mesmo nome em mercados diferentes possuem a mesma unidade de medida
                if(tipoItem == null || tipoItem.equals(ChurrasSemanticoUtils.verificaTipo(unidade))){
                    tabelaItems.adicionar(nomeItem, ChurrasSemanticoUtils.verificaTipo(unidade), null,
                item.valor.getText(), item.quant.getText());
                } else {
                    ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
                        "Item " + nomeItem + " já declarado anteriormente em outro mercado com outra medida");
                }
            }
        } else {
            ChurrasSemanticoUtils.adicionarErroSemantico(item.UNIDADE().getSymbol(),
            "Item " + nomeItem + " já declarado anteriormente no mercado");
        }
    }

}