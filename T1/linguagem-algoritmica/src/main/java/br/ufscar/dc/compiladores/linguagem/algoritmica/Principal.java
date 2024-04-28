package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

public class Principal {
    public static void main(String[] args) {
        String arquivoSaida = args[1]; //variável para armazenar arquivo de saída
        String palavra; //variável para testar se a palavra analisada no momento é algum token de excessão

        try(PrintWriter pw = new PrintWriter(arquivoSaida)) {
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            LinguagemAlgoritmicaLexer lex = new LinguagemAlgoritmicaLexer(cs);

            Token t = null;
            //while para analisar caracter por caracter do arquivo de entrada
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                palavra = LinguagemAlgoritmicaLexer.VOCABULARY.getDisplayName(t.getType());
                if(palavra.equals("SIMB_N_IDENT")){ //caso o token seja um simbolo não identificado, printar linha do erro
                    pw.println("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado");
                    break;
                }
                else if(palavra.equals("CADEIA_N_FECHADA")){ //caso a cadeia não seja fechada, printar linha do erro
                    pw.println("Linha " + t.getLine() + ": cadeia literal nao fechada");
                    break;
                }
                else if(palavra.equals("COMENTARIO_N_FECHADO")){ //caso o comentário não seja fechado, printar linha do erro
                    pw.println("Linha " + t.getLine() + ": comentario nao fechado");
                    break;
                }
                else { //printa o conteúdo e o tipo do Token 
                    pw.println("<'" + t.getText() + "'," + LinguagemAlgoritmicaLexer.VOCABULARY.getDisplayName(t.getType()) + ">");
                }
            }
        } catch (IOException ex) { //mensagem de erro
            ex.printStackTrace();
        }
    }
}