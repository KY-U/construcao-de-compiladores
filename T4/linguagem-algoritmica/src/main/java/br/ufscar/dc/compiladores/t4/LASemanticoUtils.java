package br.ufscar.dc.compiladores.t4;

import static br.ufscar.dc.compiladores.t4.LASemantico.dadosFuncaoProcedimento;
import static br.ufscar.dc.compiladores.t4.LASemantico.escoposAninhados;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.TipoT4;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.antlr.v4.runtime.Token;

public class LASemanticoUtils {
    // lista de erros
    public static List<String> errosSemanticos = new ArrayList<>();
    // adiciona erro à lista
    public static void adicionaErroSemantico(Token tok, String mensagem) {
        int linha = tok.getLine();
        //verifica erro duplicado
        if (!errosSemanticos.contains("Linha " + linha + ": " + mensagem)) 
            errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    // checa compatibilidade entre operadores
    public static boolean verificaCompatibilidade(TipoT4 T1, TipoT4 T2) {
        boolean flag = false;
        
        if (T1 == TipoT4.INTEIRO && T2 == TipoT4.REAL)
            flag = true;
        else if (T1 == TipoT4.REAL && T2 == TipoT4.INTEIRO)
            flag = true;
        else if (T1 == TipoT4.REAL && T2 == TipoT4.REAL)
            flag = true;
        
        return flag;
    }
    // checa compatilibilidade entre operadores como operção lógica
    public static boolean verificaCompatibilidadeLogica(TipoT4 T1, TipoT4 T2) {
        boolean flag = false;
        
        if (T1 == TipoT4.INTEIRO && T2 == TipoT4.REAL)
            flag = true;
        else if (T1 == TipoT4.REAL && T2 == TipoT4.INTEIRO)
            flag = true;

        return flag;
    }
    // limpa o nome de um identificador
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
    // retorna o tipo do literal
    public static TipoT4 confereTipo (HashMap<String, ArrayList<String>> tabela, String tipoRetorno) {
        TipoT4 tipoAux;
        
        //remove ponteiro.
        if (tipoRetorno.charAt(0) == '^') {
            tipoRetorno = tipoRetorno.substring(1);
        }
        
        if (tabela.containsKey(tipoRetorno))
            tipoAux = TipoT4.REGISTRO;
        else if (tipoRetorno.equals("literal"))
            tipoAux = TipoT4.LITERAL;
        else if (tipoRetorno.equals("inteiro"))
            tipoAux = TipoT4.INTEIRO;
        else if (tipoRetorno.equals("real"))
            tipoAux = TipoT4.REAL;
        else if (tipoRetorno.equals("logico"))
            tipoAux = TipoT4.LOGICO;
        else
            tipoAux = TipoT4.INVALIDO;
        
        return tipoAux;
    }
    // métodos de verificação de tipo                
    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.termo().get(0));
                
        for (var termoArit : ctx.termo()) {
            TipoT4 tipoAtual = verificarTipo(tabela, termoArit);

            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT4.INVALIDO))
                tipoRetorno = TipoT4.REAL;
            else
                tipoRetorno = tipoAtual;
        }

        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.TermoContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.fator().get(0));
                
        for (LinguagemAlgoritmicaParser.FatorContext fatorArit : ctx.fator()) {
            TipoT4 tipoAtual = verificarTipo(tabela, fatorArit);
            
            if ((verificaCompatibilidade(tipoAtual, tipoRetorno)) && (tipoAtual != TipoT4.INVALIDO))
                tipoRetorno = TipoT4.REAL;
            else
                tipoRetorno = tipoAtual;
        }
        
        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.FatorContext ctx) {
        TipoT4 tipoRetorno = null;
        
        for (LinguagemAlgoritmicaParser.ParcelaContext parcela : ctx.parcela()) {
            tipoRetorno = verificarTipo(tabela, parcela);
        
            if (tipoRetorno == TipoT4.REGISTRO) {                
                String nome = parcela.getText();
                nome = reduzNome(nome, "(");
                tipoRetorno = verificarTipo(tabela, nome);
            }
        }
        
        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ParcelaContext ctx) {
        if (ctx.parcela_unario() != null)
            return verificarTipo(tabela, ctx.parcela_unario());
        else
            return verificarTipo(tabela, ctx.parcela_nao_unario());
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_unarioContext ctx) {
        TipoT4 tipoRetorno = null;
        String nome;
        
        if (ctx.identificador() != null) {            
            if (!ctx.identificador().dimensao().exp_aritmetica().isEmpty())
                nome = ctx.identificador().IDENT().get(0).getText();
            else
                nome = ctx.identificador().getText();
            
            if (tabela.existe(nome)) {
                tipoRetorno = tabela.verificar(nome);
            
            }
            else {
                TabelaDeSimbolos tabelaAux = escoposAninhados.obterEscopoAtual();
                
                if (!tabelaAux.existe(nome)) {
                    if (!ctx.identificador().getText().contains(nome)) {
                        adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                        tipoRetorno = TipoT4.INVALIDO;
                    } else {
                        adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                        tipoRetorno = TipoT4.INVALIDO;
                    }
                } else
                    tipoRetorno = tabelaAux.verificar(nome);
            }
        } else if (ctx.IDENT() != null) {
            if (dadosFuncaoProcedimento.containsKey(ctx.IDENT().getText())) {
                List<TipoT4> aux = dadosFuncaoProcedimento.get(ctx.IDENT().getText());

                if (aux.size() == ctx.expressao().size()) {
                    for (int i = 0; i < ctx.expressao().size(); i++)
                        if (aux.get(i) != verificarTipo(tabela, ctx.expressao().get(i)))
                            adicionaErroSemantico(ctx.expressao().get(i).getStart(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());

                    tipoRetorno = aux.get(aux.size() - 1);
                    
                } else
                    adicionaErroSemantico(ctx.IDENT().getSymbol(), "incompatibilidade de parametros na chamada de " + ctx.IDENT().getText());
            } else
                tipoRetorno = TipoT4.INVALIDO;
        } else if (ctx.NUM_INT() != null)
            tipoRetorno = TipoT4.INTEIRO;
        else if (ctx.NUM_REAL() != null)
            tipoRetorno = TipoT4.REAL;
        else
            tipoRetorno = verificarTipo(tabela, ctx.expressao().get(0));

        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx) {
        TipoT4 tipoRetorno;
        String nome;

        if (ctx.identificador() != null) {
            nome = ctx.identificador().getText();

            if (!tabela.existe(nome)) {
                adicionaErroSemantico(ctx.identificador().getStart(), "identificador " + ctx.identificador().getText() + " nao declarado");
                tipoRetorno = TipoT4.INVALIDO;
            } else 
                tipoRetorno = tabela.verificar(ctx.identificador().getText());
        } else
            tipoRetorno = TipoT4.LITERAL;

        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.ExpressaoContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.termo_logico(0));
        for (LinguagemAlgoritmicaParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
            TipoT4 tipoAtual = verificarTipo(tabela, termoLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT4.INVALIDO)
                tipoRetorno = TipoT4.INVALIDO;
        }

        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Termo_logicoContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.fator_logico(0));

        for (LinguagemAlgoritmicaParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
            TipoT4 tipoAtual = verificarTipo(tabela, fatorLogico);
            if (tipoRetorno != tipoAtual && tipoAtual != TipoT4.INVALIDO)
                tipoRetorno = TipoT4.INVALIDO;
        }
        
        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Fator_logicoContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.parcela_logica());
        return tipoRetorno;
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Parcela_logicaContext ctx) {
        TipoT4 tipoRetorno;

        if (ctx.exp_relacional() != null)
            tipoRetorno = verificarTipo(tabela, ctx.exp_relacional());
        else
            tipoRetorno = TipoT4.LOGICO;

        return tipoRetorno;

    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.Exp_relacionalContext ctx) {
        TipoT4 tipoRetorno = verificarTipo(tabela, ctx.exp_aritmetica().get(0));

        if (ctx.exp_aritmetica().size() > 1) {
            TipoT4 tipoAtual = verificarTipo(tabela, ctx.exp_aritmetica().get(1));

            if (tipoRetorno == tipoAtual || verificaCompatibilidadeLogica(tipoRetorno, tipoAtual))
                tipoRetorno = TipoT4.LOGICO;
            else
                tipoRetorno = TipoT4.INVALIDO;
        }

        return tipoRetorno;

    }
    
    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, LinguagemAlgoritmicaParser.IdentificadorContext ctx) {
        String nomeVar = ctx.IDENT().get(0).getText();
        
        return tabela.verificar(nomeVar);
    }

    public static TipoT4 verificarTipo(TabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }
}
