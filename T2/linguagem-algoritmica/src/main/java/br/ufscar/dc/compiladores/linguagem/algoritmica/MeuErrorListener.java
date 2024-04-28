package br.ufscar.dc.compiladores.linguagem.algoritmica;

import java.io.PrintWriter;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.dfa.DFA;
import java.util.BitSet;
import org.antlr.v4.runtime.atn.ATNConfigSet;


public class MeuErrorListener implements ANTLRErrorListener {
    PrintWriter pw;
    public MeuErrorListener(PrintWriter pw){
        this.pw = pw;
    }

    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado

        Token t = (Token) offendingSymbol;

        pw.println("Linha "+ line +": erro sintatico proximo a "+t.getText()+"\nFim da compilacao");
    }
}
