package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.PrintWriter;

public class Principal {
    public static void main(String[] args) {
        String arquivoSaida = args[1]; //variável para armazenar arquivo de saída
        String palavra; //variável para testar se a palavra analisada no momento é algum token de excessão

        try(PrintWriter pw = new PrintWriter(arquivoSaida)) {
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            LinguagemAlgoritmicaLexer lexer = new LinguagemAlgoritmicaLexer(cs);

            Token t = null;
            //while para analisar caracter por caracter do arquivo de entrada
            while ((t = lexer.nextToken()).getType() != Token.EOF) {
                System.out.println("<" + LinguagemAlgoritmicaLexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
            }

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LinguagemAlgoritmicaParser parser = new LinguagemAlgoritmicaParser(tokens);
            parser.programa();
        } catch (IOException ex) { //mensagem de erro
            ex.printStackTrace();
        }
    }
}