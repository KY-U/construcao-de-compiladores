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

        try(PrintWriter pw = new PrintWriter(arquivoSaida)) {
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            //Linguagem Lexer
            LinguagemAlgoritmicaLexer lexer = new LinguagemAlgoritmicaLexer(cs);

            //Token
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //Linguagem Parser
            LinguagemAlgoritmicaParser parser = new LinguagemAlgoritmicaParser(tokens);
            LinguagemAlgoritmicaParser.ProgramaContext arvore = parser.programa();
            LinguagemAlgoritmicaSemantico LAS = new LinguagemAlgoritmicaSemantico();

            LAS.visitPrograma(arvore);
            for(String erro: LinguagemAlgoritmicaSemanticoUtils.errosSemanticos){
                pw.println(erro);
            }
            pw.close();
            //Chama classe ErrorListener com argumento do PrintWritter
            MeuErrorListener mcel = new MeuErrorListener(pw);
            parser.addErrorListener(mcel);
            
            parser.programa();
        } catch (IOException ex) { //mensagem de erro
            ex.printStackTrace();
        }
    }
}