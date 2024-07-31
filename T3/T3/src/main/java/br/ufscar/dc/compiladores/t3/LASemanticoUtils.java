package br.ufscar.dc.compiladores.t3;

// Importações básicas para o funcionamento do programa.
import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.TipoT3;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class LASemanticoUtils {

    // Criação da lista que armazenará os erros identificados pelo analisador.
    public static List<String> errosSemanticos = new ArrayList<>();

    // Método auxiliar utilizado para adicionar um novo erro identificado na lista.
    public static void adicionaErroSemantico(Token tok, String mensagem) {
        int linha = tok.getLine();
        
        // Verifica se o erro já foi identificado para poder adicioná-lo à lista.
        if (!errosSemanticos.contains("Linha " + linha + ": " + mensagem)) 
            errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    // Método auxiliar que verifica a compatibilidade entre operadores aritméticos.
    // Caso a operação envolva pelo menos um valor real, a operação deve ser tratada
    // como uma operação entre números reais, mesmo que um deles seja um inteiro.
    public static boolean verificaCompatibilidade(TipoT3 T1, TipoT3 T2) {
        boolean flag = false;
        
        if (T1 == TipoT3.INTEIRO && T2 == TipoT3.REAL)
            flag = true;
        else if (T1 == TipoT3.REAL && T2 == TipoT3.INTEIRO)
            flag = true;
        else if (T1 == TipoT3.REAL && T2 == TipoT3.REAL)
            flag = true;
        
        return flag;
    }
    
    // Método auxiliar que verifica a compatibilidade entre operadores para tratá-los
    // como uma operação lógica.
    public static boolean verificaCompatibilidadeLogica(TipoT3 T1, TipoT3 T2) {
        boolean flag = false;
        
        if (T1 == TipoT3.INTEIRO && T2 == TipoT3.REAL)
            flag = true;
        else if (T1 == TipoT3.REAL && T2 == TipoT3.INTEIRO)
            flag = true;

        return flag;
    }
                    
    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.termo().get(0));
                
        for (var termoArit : ctx.termo()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT3 tipoAtual = verificarTipo(tabela, termoArit);
            
            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT3.INVALIDO))
                tipoRetorno = TipoT3.REAL;
            else
                tipoRetorno = tipoAtual;
        }

        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.TermoContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.fator().get(0));
                
        for (LinguagemAlgoritmicaParser.FatorContext fatorArit : ctx.fator()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT3 tipoAtual = verificarTipo(tabela, fatorArit);
            
            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT3.INVALIDO))
                tipoRetorno = TipoT3.REAL;
            else
                tipoRetorno = tipoAtual;
        }
        
        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.FatorContext ctx) {
        TipoT3 tipoRetorno = null;
        
        for (LinguagemAlgoritmicaParser.ParcelaContext parcela : ctx.parcela())
            tipoRetorno = verificarTipo(tabela, parcela);

        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ParcelaContext ctx) {
        // Identifica se é uma parcela unária ou não unária.
        if (ctx.parcela_unario() != null)
            return verificarTipo(tabela, ctx.parcela_unario());
        else
            return verificarTipo(tabela, ctx.parcela_nao_unario());
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_unarioContext ctx) {
        TipoT3 tipoRetorno;
        String nome;
        
        if (ctx.identificador() != null) {
            // Obtém o nome da variável atual.
            nome = ctx.identificador().getText();
            
            // Caso a variável já tenha sido declarada, apenas retorna o tipo associado a ela.
            if (tabela.existe(nome))
                tipoRetorno = tabela.verificar(nome);
            // Caso contrário, utiliza uma tabela auxiliar para prosseguir com a verificação. Se a variável não
            // tiver sido declarada, utiliza o método adicionaErroSemantico para verificar se o erro já foi
            // exibido e, caso ainda não tenha sido, o adiciona à lista.
            else {
                TabelaDeSimbolos tabelaAux = LASemantico.escoposAninhados.percorrerEscoposAninhados().get(LASemantico.escoposAninhados.percorrerEscoposAninhados().size() - 1);
                if (!tabelaAux.existe(nome)) {
                    adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                    tipoRetorno = TipoT3.INVALIDO;
                } else 
                    tipoRetorno = tabelaAux.verificar(nome);
            }
        } else if (ctx.NUM_INT() != null)
            tipoRetorno = TipoT3.INTEIRO;
        else if (ctx.NUM_REAL() != null)
            tipoRetorno = TipoT3.REAL;
        else
            tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx) {
        TipoT3 tipoRetorno;
        String nome;

        // Utiliza uma lógica semelhante à verificação de tipo anterior, verificando a existência da variável
        // e tentando adicioná-la à lista de erros.
        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();
        
            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                tipoRetorno = TipoT3.INVALIDO;
            } else 
                tipoRetorno = tabela.verificar(ctx.identificador().getText());
        } else
            tipoRetorno = TipoT3.LITERAL;

        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ExpressaoContext ctx) {
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.termo_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (LinguagemAlgoritmicaParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            TipoT3 tipoAtual = verificarTipo(tabela, termoLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT3.INVALIDO)
                tipoRetorno = TipoT3.INVALIDO;
        }

        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Termo_logicoContext ctx) {
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (LinguagemAlgoritmicaParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            TipoT3 tipoAtual = verificarTipo(tabela, fatorLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT3.INVALIDO)
                tipoRetorno = TipoT3.INVALIDO;
        }
        return tipoRetorno;
    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Fator_logicoContext ctx) {
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.parcela_logica());
        return tipoRetorno;

    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_logicaContext ctx) {
        TipoT3 tipoRetorno;

        if (ctx.exp_relacional() != null)
            tipoRetorno = verificarTipo(tabela, ctx.exp_relacional());
         else
            tipoRetorno = TipoT3.LOGICO;

        return tipoRetorno;

    }

    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_relacionalContext ctx) {
        TipoT3 tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        if (ctx.exp_aritmetica().size() > 1) {
            TipoT3 tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));

            // Semelhante ao que foi feito com as expressões aritméticas, ocorre uma verificação
            // para saber se a expressão atual pode ser tratada como uma operação lógica.
            if (tipoRetorno == tipoAtual || verificaCompatibilidadeLogica(tipoRetorno, tipoAtual))
                tipoRetorno = TipoT3.LOGICO;
            else
                tipoRetorno = TipoT3.INVALIDO;
        }

        return tipoRetorno;

    }

    // Verificação padrão de tipos de variáveis a partir da tabela.
    public static TipoT3 verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }
}
