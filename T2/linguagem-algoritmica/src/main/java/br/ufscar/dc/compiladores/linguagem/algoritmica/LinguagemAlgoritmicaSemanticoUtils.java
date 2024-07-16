package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.linguagem.algoritmica.LinguagemAlgoritmicaParser.*;


public class LinguagemAlgoritmicaSemanticoUtils {
    // Lista que armazena mensagens de erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();

    // Método para adicionar uma mensagem de erro semântico à lista
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        // Formata a mensagem de erro com a linha do token e a mensagem fornecida
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    // Método que realiza a verificação semântica de uma expressão
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.ExpressaoContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Percorre todos os termos lógicos presentes na expressão
        for (Termo_logicoContext ta : ctx.termo_logico()) {
            // Realiza a verificação semântica do termo lógico
            TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, ta);
            // Atualiza o tipo de retorno da expressão de acordo com o tipo do termo lógico
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
            }
        }
        return ret;
    }

    // Método que realiza a verificação semântica de um termo lógico
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Termo_logicoContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Percorre todos os fatores lógicos presentes no termo lógico
        for (Fator_logicoContext ta : ctx.fator_logico()) {
            // Realiza a verificação semântica do fator lógico
            TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, ta);
            // Atualiza o tipo de retorno do termo lógico de acordo com o tipo do fator lógico
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
            }
        }

        return ret;
    }
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Fator_logicoContext ctx) {
        // Verifica o fator lógico chamando o método verificarTipos para a parcela lógica
        return verificarTipos(escopos, ctx.parcela_logica());
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Parcela_logicaContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Verifica se a parcela lógica contém uma expressão relacional
        if (ctx.exp_relacional() != null) {
            // Verifica a expressão relacional
            ret = verificarTipos(escopos, ctx.exp_relacional());
        } else {
            // Caso contrário, o tipo de retorno é lógico
            ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.LOGICO;
        }
    
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Exp_relacionalContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Verifica se a expressão relacional possui um operador relacional
        if (ctx.op_relacional() != null) {
            // Percorre as expressões aritméticas presentes na expressão relacional
            for (Exp_aritmeticaContext ta : ctx.exp_aritmetica()) {
                // Verifica a expressão aritmética
                TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, ta);
                Boolean auxNumeric = aux == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL || aux == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
                Boolean retNumeric = ret == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL || ret == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
                // Atualiza o tipo de retorno da expressão relacional de acordo com o tipo da expressão aritmética
                if (ret == null) {
                    ret = aux;
                } else if (!(auxNumeric && retNumeric) && aux != ret) {
                    ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
                }
            }
            // Se o tipo de retorno da expressão relacional não for inválido, ele é do tipo lógico
            if (ret != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.LOGICO;
            }
        } else {
            // Caso contrário, a expressão relacional é reduzida para uma expressão aritmética
            ret = verificarTipos(escopos, ctx.exp_aritmetica(0));
        }
    
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Percorre os termos presentes na expressão aritmética
        for (TermoContext ta : ctx.termo()) {
            // Verifica o termo
            TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, ta);
            // Atualiza o tipo de retorno da expressão aritmética de acordo com o tipo do termo
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
            }
        }
    
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.TermoContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
        // Percorre os fatores presentes no termo
        for (FatorContext fa : ctx.fator()) {
            // Verifica o fator
            TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, fa);
            Boolean auxNumeric = aux == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL || aux == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
            Boolean retNumeric = ret == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL || ret == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
            // Atualiza o tipo de retorno do termo de acordo com o tipo do fator
            if (ret == null) {
                ret = aux;
            } else if (!(auxNumeric && retNumeric) && aux != ret) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
            }
        }
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.FatorContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;

        for (ParcelaContext fa : ctx.parcela()) {
            TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, fa);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
            }
        }
        return ret;
    }
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.ParcelaContext ctx) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;

        if(ctx.parcela_nao_unario() != null){
            ret = verificarTipos(escopos, ctx.parcela_nao_unario());
        }
        else {
            ret = verificarTipos(escopos, ctx.parcela_unario());
        }
        return ret;
    }

    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx) {
        if (ctx.identificador() != null) {
            return verificarTipos(escopos, ctx.identificador());
        }
        return TabelaDeSimbolos.TipoLinguagemAlgoritmica.CADEIA;
    }

    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.IdentificadorContext ctx) {//kk suspeitos
        String nomeVar = "";
        TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
        for(int i = 0; i < ctx.IDENT().size(); i++){
            nomeVar += ctx.IDENT(i).getText();
            if(i != ctx.IDENT().size() - 1){
                nomeVar += ".";
            }
        }
        for(TabelaDeSimbolos tabela : escopos.percorrerEscoposAninhados()){
            if (tabela.existe(nomeVar)) {
                ret = verificarTipos(escopos, nomeVar);
            }
        }
        System.out.println(nomeVar);
        return ret;
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, LinguagemAlgoritmicaParser.Parcela_unarioContext ctx) {
        if (ctx.NUM_INT() != null) {
            return TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
        }
        if (ctx.NUM_REAL() != null) {
            return TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL;
        }
        if(ctx.identificador() != null){
            return verificarTipos(escopos, ctx.identificador());
        }
        if (ctx.IDENT() != null) {
            TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
            ret = verificarTipos(escopos, ctx.IDENT().getText());
            for (ExpressaoContext fa : ctx.expressao()) {
                TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                    ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
                }
            }
            return ret;
        } else {
            TabelaDeSimbolos.TipoLinguagemAlgoritmica ret = null;
            for (ExpressaoContext fa : ctx.expressao()) {
                TabelaDeSimbolos.TipoLinguagemAlgoritmica aux = verificarTipos(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO) {
                    ret = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;
                }
            }
            return ret;
        }
    }
    
    public static TabelaDeSimbolos.TipoLinguagemAlgoritmica verificarTipos(Escopos escopos, String nomeVar) {
        TabelaDeSimbolos.TipoLinguagemAlgoritmica type = null;
        for(TabelaDeSimbolos tabela : escopos.percorrerEscoposAninhados()){
            type = tabela.verificarTipos(nomeVar);
        }
        return type;
    }
}