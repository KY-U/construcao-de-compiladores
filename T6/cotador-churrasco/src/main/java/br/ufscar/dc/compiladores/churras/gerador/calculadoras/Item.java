package br.ufscar.dc.compiladores.churras.gerador.calculadoras;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos;
import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos.TipoLc;

/**
 * Classe para a representação de um Produto na tabela de simbolos
 */
public class Item {

    private String nome;
    private Float preco;
    private Float medida;
    
    private TipoLc tipo;
    private Float custoBeneficio;
    private Float quantoComprar = 1f;
    
    private Float sobra = 0f;
    
    public Item(String nome, Float preco, Float medida) {
        this.nome = nome;
        this.preco = preco;
        this.medida = medida;
        this.custoBeneficio = preco / medida;
    }
    
    public Item(TabelaDeSimbolos.EntradaTabelaDeSimbolos entradaTabelaDeSimbolos) {
        // Transforma a tabela de simbolos em um Produto
        // O custo beneficio já é calculado durante a criacao do objeto
        this.nome = entradaTabelaDeSimbolos.nome;
        this.preco = entradaTabelaDeSimbolos.preco != null ? entradaTabelaDeSimbolos.preco : null;
        this.medida = entradaTabelaDeSimbolos.quantidade;
        this.tipo = entradaTabelaDeSimbolos.tipo;
        this.custoBeneficio = preco != null ? medida / preco : null;
    }
    
    public Item() {
    }
    
    public Float getSobra() {
        return sobra;
    }

    // Define a quantidade de produtos que deve ser comprada para atender a demanda da lista
    public void setQuantoComprar(Float precisaComprar) {
        Float diferença = this.medida - precisaComprar;
        Float medidaAux = this.medida;
        Float quantoComprarAux = this.quantoComprar;
        if(diferença < 0){
            do {
                medidaAux += this.medida;
                quantoComprarAux ++;
                
            } while (medidaAux - precisaComprar < 0);

            this.sobra = medidaAux - precisaComprar;

            this.quantoComprar = quantoComprarAux;
        }

        if(diferença > 0){
            this.sobra = diferença;
        }
    }


    public TipoLc getTipo() {
        return tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public Float getQuantoComprar() {
        return quantoComprar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getMedida() {
        return medida;
    }

    public void setMedida(Float medida) {
        this.medida = medida;
    }

    public Float getCustoBeneficio() {
        return custoBeneficio;
    }

    public void setCustoBeneficio(Float custoBeneficio) {
        this.custoBeneficio = custoBeneficio;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", medida=" + medida + ", tipo=" + tipo
                + ", custoBeneficio=" + custoBeneficio + ", quantoComprar=" + quantoComprar + "]";
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
        br.ufscar.dc.compiladores.churras.gerador.calculadoras.Item other = (br.ufscar.dc.compiladores.churras.gerador.calculadoras.Item) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}
