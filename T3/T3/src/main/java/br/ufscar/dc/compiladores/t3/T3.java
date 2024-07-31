package br.ufscar.dc.compiladores.t3;

// Importações básicas para o funcionamento do programa.
import br.ufscar.dc.compiladores.t3.LinguagemAlgoritmicaParser.ProgramaContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class T3 {

    public static void main(String args[]) throws IOException {

        // Inicialização da leitura e escrita em arquivo.
        try (PrintWriter pw = new PrintWriter(new FileWriter(args[1]))) {
            try {
                // args[0] é o primeiro argumento da linha de comando
                CharStream cs = CharStreams.fromFileName(args[0]);
                
                // Linguagem lexer
                LinguagemAlgoritmicaLexer lexer = new LinguagemAlgoritmicaLexer(cs);

                // Token
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                
                // Linguagem Parser
                LinguagemAlgoritmicaParser parser = new LinguagemAlgoritmicaParser(tokens);
                ProgramaContext arvore = parser.programa();
                LASemantico las = new LASemantico();
                
                // Inicialização do programa.
                las.visitPrograma(arvore);
                
                // Verifica a existência de erros, imprime todos os que foram identificados
                // e encerra a execução do analisador.
                LASemanticoUtils.errosSemanticos.forEach((s) -> pw.println(s));
                pw.println("Fim da compilacao");
                pw.close();                
            } catch (RuntimeException e) {
            }
        }
    }
}
