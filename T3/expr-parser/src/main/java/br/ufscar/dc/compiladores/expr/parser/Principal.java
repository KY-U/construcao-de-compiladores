package br.ufscar.dc.compiladores.expr.parser;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {
    public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        LinguagemAlgoritmicaLexer lexer = new LinguagemAlgoritmicaLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LinguagemAlgoritmicaParser parser = new LinguagemAlgoritmicaParser(tokens);
        LinguagemAlgoritmicaParser.ProgramaContext arvore = parser.programa();
        LinguagemAlgoritmicaSemantico as = new LinguagemAlgoritmicaSemantico();
        as.visitPrograma(arvore);
        LinguagemAlgoritmicaSemanticoUtils.errosSemanticos.forEach((s) -> System.out.println(s));
    }
}
