package br.ufscar.dc.compiladores.churras.gerador;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.ufscar.dc.compiladores.parser.ChurrasLexer;
import br.ufscar.dc.compiladores.parser.ChurrasParser;
import br.ufscar.dc.compiladores.parser.ChurrasParser.ProgramaContext;


public class Principal {
    public static void main(String args[]) throws IOException {
        // args[0] é o primeiro argumento da linha de comando que representa o CAMINHO PARA O ARQUIVO DE ENTRADA COM A LINGUAGEM
        CharStream cs = CharStreams.fromFileName(args[0]);
        ChurrasLexer lexer = new ChurrasLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ChurrasParser parser = new ChurrasParser(tokens);
        ProgramaContext arvore = parser.programa();
        ChurrasSemantico as = new ChurrasSemantico();
        as.visitPrograma(arvore);
        // Pega o segundo argumento da linha de comando que representa o CAMINHO PARA O ARQUIVO DE SAÍDA
        // E Cria um objeto para escrever no arquivo
        if(ChurrasSemanticoUtils.errosSemanticos.isEmpty()) {
            ChurrasGerador agc = new ChurrasGerador();
            agc.visitPrograma(arvore);
            try(PrintWriter pw = new PrintWriter(args[1], StandardCharsets.UTF_8)) {
                pw.print(agc.saida.toString());
            }
        } else{
            for (String string : ChurrasSemanticoUtils.errosSemanticos) {
                System.out.println(string);
            }
            if(!ChurrasSemanticoUtils.errosSemanticos.isEmpty()){
                System.out.println("Fim da compilacao");
            }
        }
    }
}