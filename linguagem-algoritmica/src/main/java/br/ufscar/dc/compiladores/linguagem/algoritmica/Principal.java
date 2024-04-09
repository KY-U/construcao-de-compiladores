package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

public class Principal {

    public static void main(String[] args) {
        String arquivoSaida = args[1];

        try(PrintWriter pw = new PrintWriter(arquivoSaida)) {
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            LinguagemAlgoritmicaLexer lex = new LinguagemAlgoritmicaLexer(cs);

            Token t = null;
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                pw.println("<" + LinguagemAlgoritmicaLexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}