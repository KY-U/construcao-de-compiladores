package br.ufscar.dc.compiladores.t5;

// Importações básicas para o funcionamento do programa.
import static br.ufscar.dc.compiladores.t5.LASemantico.dadosFuncaoProcedimento;
import static br.ufscar.dc.compiladores.t5.LASemantico.escoposAninhados;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoT5;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
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
    public static boolean verificaCompatibilidade(TipoT5 T1, TipoT5 T2) {
        boolean flag = false;
        
        if (T1 == TipoT5.INTEIRO && T2 == TipoT5.REAL)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.INTEIRO)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.REAL)
            flag = true;
        
        return flag;
    }
    
    // Método auxiliar que verifica a compatibilidade entre operadores para tratá-los
    // como uma operação lógica.
    public static boolean verificaCompatibilidadeLogica(TipoT5 T1, TipoT5 T2) {
        boolean flag = false;
        
        if (T1 == TipoT5.INTEIRO && T2 == TipoT5.REAL)
            flag = true;
        else if (T1 == TipoT5.REAL && T2 == TipoT5.INTEIRO)
            flag = true;

        return flag;
    }
    
    // Método auxiliar que reduz o nome de um identificador de vetor ou procedimento/função.
    // O parâmetro símbolo refere-se ao "[" no caso de vetor, ou "(" no caso de procedimento/função.
    // Exemplo: vetor[i] vira apenas vetor.
    public static String reduzNome(String nome, String simbolo) {
        
        if (nome.contains(simbolo)) {

            boolean continua = true;
            int cont = 0;
            String nomeAux;

            while (continua) {
                nomeAux = nome.substring(cont);

                if (nomeAux.startsWith(simbolo))
                    continua = false;
                else
                    cont++;
            }

            nome = nome.substring(0, cont); 
        }
        
        return nome;
        
    }   
    
    // Método auxiliar utilizado para retornar o TipoT5 referente ao literal que está sendo analisado.
    public static TipoT5 confereTipo (HashMap<String, ArrayList<String>> tabela, String tipoRetorno) {
        TipoT5 tipoAux;
        
        // Remoção do ponteiro.
        if (tipoRetorno.charAt(0) == '^') {
            tipoRetorno = tipoRetorno.substring(1);
        }
        
        if (tabela.containsKey(tipoRetorno))
            tipoAux = TipoT5.REGISTRO;
        else if (tipoRetorno.equals("literal"))
            tipoAux = TipoT5.LITERAL;
        else if (tipoRetorno.equals("inteiro"))
            tipoAux = TipoT5.INTEIRO;
        else if (tipoRetorno.equals("real"))
            tipoAux = TipoT5.REAL;
        else if (tipoRetorno.equals("logico"))
            tipoAux = TipoT5.LOGICO;
        else
            tipoAux = TipoT5.INVALIDO;
        
        return tipoAux;
    }
                    
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.termo().get(0));
                
        for (var termoArit : ctx.termo()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT5 tipoAtual = verificarTipo(tabela, termoArit);

            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT5.INVALIDO))
                tipoRetorno = TipoT5.REAL;
            else
                tipoRetorno = tipoAtual;
        }

        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.TermoContext ctx) {
        // A variável que será retornada ao fim da execução é inicializada com o tipo
        // do primeiro elemento que será verificado, para fins de comparação.
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.fator().get(0));
                
        for (LinguagemAlgoritmicaParser.FatorContext fatorArit : ctx.fator()) {
            // Esta outra variável recebe os tipos dos outros termos da expressão.
            TipoT5 tipoAtual = verificarTipo(tabela, fatorArit);
            
            // Com o auxílio do método declarado anteriormente, o programa verifica se deve tratar a
            // verificação atual como uma operação entre números reais.
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT5.INVALIDO))
                tipoRetorno = TipoT5.REAL;
            else
                tipoRetorno = tipoAtual;
        }
        
        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.FatorContext ctx) {
        TipoT5 tipoRetorno = null;
        
        for (LinguagemAlgoritmicaParser.ParcelaContext parcela : ctx.parcela()) {
            tipoRetorno = verificarTipo(tabela, parcela);
        
            // Utilização da função auxiliar para reduzir o nome de determinadas parcelas
            // e verificar o tipo correto.
            if (tipoRetorno == TipoT5.REGISTRO) {                
                String nome = parcela.getText();
                nome = reduzNome(nome, "(");
                tipoRetorno = verificarTipo(tabela, nome);
            }
        }
        
        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ParcelaContext ctx) {
        // Identifica se é uma parcela unária ou não unária.
        if (ctx.parcela_unario() != null)
            return verificarTipo(tabela, ctx.parcela_unario());
        else
            return verificarTipo(tabela, ctx.parcela_nao_unario());
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_unarioContext ctx) {
        TipoT5 tipoRetorno = null;
        String nome;
        
        if (ctx.identificador() != null) {            
            // Se a dimensão não é vazia, pega o nome do vetor
            if (!ctx.identificador().dimensao().exp_aritmetica().isEmpty())
                nome = ctx.identificador().IDENT().get(0).getText();
            else
                nome = ctx.identificador().getText();
            
            // Caso a variável já tenha sido declarada, apenas retorna o tipo associado a ela.
            if (tabela.existe(nome)) {
                tipoRetorno = tabela.verificar(nome);
            
            }
            // Caso contrário, utiliza uma tabela auxiliar para prosseguir com a verificação. Se a variável não
            // tiver sido declarada, utiliza o método adicionaErroSemantico para verificar se o erro já foi
            // exibido e, caso ainda não tenha sido, o adiciona à lista.
            else {
                TabelaDeSimbolos tabelaAux = escoposAninhados.obterEscopoAtual();
                
                if (!tabelaAux.existe(nome)) {
                    if (!ctx.identificador().getText().contains(nome)) {
                        adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                        tipoRetorno = TipoT5.INVALIDO;
                    } else {
                        adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                        tipoRetorno = TipoT5.INVALIDO;
                    }
                } else
                    tipoRetorno = tabelaAux.verificar(nome);
            }
        } else if (ctx.IDENT() != null) {
            if (dadosFuncaoProcedimento.containsKey(ctx.IDENT().getText())) {
                List<TipoT5> aux = dadosFuncaoProcedimento.get(ctx.IDENT().getText());

                if (aux.size() == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++)
                        if (aux.get(i) != verificarTipo(tabela, ctx.expressao().get(i)))
                            adicionaErroSemantico(ctx.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());

                    tipoRetorno = aux.get(aux.size() - 1);
                    
                } else
                    adicionaErroSemantico(ctx.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
            } else
                tipoRetorno = TipoT5.INVALIDO;
        } else if (ctx.NUM_INT() != null)
            tipoRetorno = TipoT5.INTEIRO;
        else if (ctx.NUM_REAL() != null)
            tipoRetorno = TipoT5.REAL;
        else
            tipoRetorno = verificarTipo(tabela, ctx.expressao().get(0));

        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx) {
        TipoT5 tipoRetorno;
        String nome;

        // Utiliza uma lógica semelhante à verificação de tipo anterior, verificando a existência da variável
        // e tentando adicioná-la à lista de erros.
        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();

            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                tipoRetorno = TipoT5.INVALIDO;
            } else 
                tipoRetorno = tabela.verificar(ctx.identificador().getText());
        } else
            tipoRetorno = TipoT5.LITERAL;

        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ExpressaoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.termo_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (LinguagemAlgoritmicaParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            TipoT5 tipoAtual = verificarTipo(tabela, termoLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT5.INVALIDO)
                tipoRetorno = TipoT5.INVALIDO;
        }

        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Termo_logicoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));

        // Para expressões lógicas, a ideia resume-se apenas em verificar se os tipos analisados
        // são diferentes.
        for (LinguagemAlgoritmicaParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            TipoT5 tipoAtual = verificarTipo(tabela, fatorLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT5.INVALIDO)
                tipoRetorno = TipoT5.INVALIDO;
        }
        
        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Fator_logicoContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.parcela_logica());
        return tipoRetorno;
    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_logicaContext ctx) {
        TipoT5 tipoRetorno;

        if (ctx.exp_relacional() != null)
            tipoRetorno = verificarTipo(tabela, ctx.exp_relacional());
        else
            tipoRetorno = TipoT5.LOGICO;

        return tipoRetorno;

    }

    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_relacionalContext ctx) {
        TipoT5 tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        if (ctx.exp_aritmetica().size() > 1) {
            TipoT5 tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));

            // Semelhante ao que foi feito com as expressões aritméticas, ocorre uma verificação
            // para saber se a expressão atual pode ser tratada como uma operação lógica.
            if (tipoRetorno == tipoAtual || verificaCompatibilidadeLogica(tipoRetorno, tipoAtual))
                tipoRetorno = TipoT5.LOGICO;
            else
                tipoRetorno = TipoT5.INVALIDO;
        }

        return tipoRetorno;

    }
    
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.IdentificadorContext ctx) {
        String nomeVar = ctx.IDENT().get(0).getText();
        
        return tabela.verificar(nomeVar);
    }

    // Verificação padrão de tipos de variáveis a partir da tabela.
    public static TipoT5 verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }
}
