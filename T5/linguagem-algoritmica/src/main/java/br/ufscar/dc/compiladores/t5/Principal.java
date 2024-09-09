package br.ufscar.dc.compiladores.t5;

// Importações básicas para o funcionamento do programa.
import br.ufscar.dc.compiladores.t5.LinguagemAlgoritmicaParser.ProgramaContext;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {

    public static void main(String args[]) throws IOException {

        // Inicialização da leitura e escrita em arquivo.
        CharStream cs = CharStreams.fromFileName(args[0]);

        //Analisador léxico.
        LinguagemAlgoritmicaLexer lexer = new LinguagemAlgoritmicaLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //Analisador sintático.
        LinguagemAlgoritmicaParser parser = new LinguagemAlgoritmicaParser(tokens);
        ProgramaContext arvore = parser.programa();
        LASemantico t5s = new LASemantico();

        // Inicialização do programa.
        t5s.visitPrograma(arvore);

        // Verifica a existência de erros, imprime todos os que foram identificados
        // e encerra a execução do analisador.
        LASemanticoUtils.errosSemanticos.forEach((s) -> System.out.println(s));

        // Caso não tenham erros no programa, também é gerado no código em C.
        if (LASemanticoUtils.errosSemanticos.isEmpty()) {
            Gerador agc = new Gerador();
            agc.visitPrograma(arvore);
            
            try(PrintWriter pw = new PrintWriter(args[1])) {
                pw.print(agc.saida.toString());
            }
        }
    }
}
