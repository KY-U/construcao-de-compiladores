package br.ufscar.dc.compiladores.linguagem.algoritmica;

import br.ufscar.dc.compiladores.linguagem.algoritmica.TabelaDeSimbolos.TipoLinguagemAlgoritmica;
import br.ufscar.dc.compiladores.linguagem.algoritmica.LinguagemAlgoritmicaParser.*;

public class LinguagemAlgoritmicaSemantico extends LinguagemAlgoritmicaBaseVisitor<Void> {

    Escopos escopos = new Escopos();

    @Override
    public Object visitDecConst(DecConstContext contexto) {
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        String identificador = contexto.IDENT().getText();
        boolean erro = escopoAtual.existe(identificador);

        if (erro) {
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                    contexto.start,
                    "Constante " + identificador + " já declarada anteriormente"
            );
        } else {
            TabelaDeSimbolos.TipoLinguagemAlgoritmica tipoConstante;
            String tipoBasico = contexto.tipo_basico().getText();

            switch (tipoBasico) {
                case "literal":
                    tipoConstante = TabelaDeSimbolos.TipoLinguagemAlgoritmica.CADEIA;
                    break;
                case "inteiro":
                    tipoConstante = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
                    break;
                case "real":
                    tipoConstante = TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL;
                    break;
                case "logico":
                    tipoConstante = TabelaDeSimbolos.TipoLinguagemAlgoritmica.LOGICO;
                    break;
                default:
                    throw new IllegalArgumentException("Tipo básico desconhecido: " + tipoBasico);
            }

            escopoAtual.adicionar(identificador, tipoConstante);
        }
        return super.visitDecConst(contexto);
    }

    @Override
    public Object visitDecTipo(DecTipoContext decT){
        TabelaDeSimbolos escopo = escopos.obterEscopoAtual();
        String identificador = decT.IDENT().getText();
        if (escopo.existe(identificador)){
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(decT.start, identificador + identificador + " já declarado");
        } else {
            escopo.adicionar(identificador, TabelaDeSimbolos.TipoLinguagemAlgoritmica.TIPO);
        }
    }

    @Override
    public Object visitDecVar(DecVarContext contexto) {
        TabelaDeSimbolos escopo = escopos.obterEscopoAtual();

        for (IdentificadorContext identificador : contexto.variavel().identificador()) {
            String nomeIdentificador = identificador.getText();

            if (escopo.existe(nomeIdentificador)) {
                LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                        identificador.start,
                        "Identificador " + nomeIdentificador + " já declarado anteriormente"
                );
            } else {
                TabelaDeSimbolos.TipoLinguagemAlgoritmica tipoVariavel;
                String tipoBasico = contexto.variavel().tipo().getText();

                switch (tipoBasico) {
                    case "literal":
                        tipoVariavel = TabelaDeSimbolos.TipoLinguagemAlgoritmica.CADEIA;
                        break;
                    case "inteiro":
                        tipoVariavel = TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO;
                        break;
                    case "real":
                        tipoVariavel = TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL;
                        break;
                    case "logico":
                        tipoVariavel = TabelaDeSimbolos.TipoLinguagemAlgoritmica.LOGICO;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo básico desconhecido: " + tipoBasico);
                }

                escopo.adicionar(nomeIdentificador, tipoVariavel);
            }
        }

        return super.visitDecVar(contexto);
    }

    @Override
    public Object visitDeclaracao_global(Declaracao_globalContext contexto) {
        TabelaDeSimbolos escopo = escopos.obterEscopoAtual();
        String identificador = contexto.IDENT().getText();

        if (escopo.existe(identificador)) {
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                    contexto.start,
                    identificador + " declarado anteriormente"
            );
        } else {
            escopo.adicionar(identificador, TabelaDeSimbolos.TipoLinguagemAlgoritmica.TIPO);
        }

        return super.visitDeclaracao_global(contexto);
    }

    @Override
    public Object visitTipo_basico_ident(Tipo_basico_identContext contexto) {
        if (contexto.IDENT() != null) {
            String identificador = contexto.IDENT().getText();
            boolean encontrado = false;

            for (TabelaDeSimbolos escopo : escopos.percorrerEscoposAninhados()) {
                encontrado = escopo.existe(identificador);
                if (!encontrado) {
                    LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                            contexto.start,
                            "Tipo " + identificador + " não declarado"
                    );
                }
            }
        }
        return super.visitTipo_basico_ident(contexto);
    }

    @Override
    public Object visitIdentificador(IdentificadorContext contexto) {
        String identificador = contexto.IDENT(0).getText();
        boolean encontrado = false;

        for (TabelaDeSimbolos escopo : escopos.percorrerEscoposAninhados()) {
            encontrado = escopo.existe(identificador);
            if (!encontrado) {
                LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                        contexto.start,
                        "Identificador " + identificador + " não declarado"
                );
            }
        }
        return super.visitIdentificador(contexto);
    }

    @Override
    public Object visitCmdAtribuicao(CmdAtribuicaoContext contexto) {
        String nomeVariavel = contexto.identificador().getText();
        TabelaDeSimbolos.TipoLinguagemAlgoritmica tipoExpressao = LinguagemAlgoritmicaSemanticoUtils.verificarTipos(escopos, contexto.expressao());
        boolean erro = tipoExpressao == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INVALIDO;

        if (!erro) {
            boolean variavelExistente = false;

            for (TabelaDeSimbolos escopo : escopos.percorrerEscoposAninhados()) {
                if (escopo.existe(nomeVariavel)) {
                    variavelExistente = true;
                    TabelaDeSimbolos.TipoLinguagemAlgoritmica tipoVariavel = LinguagemAlgoritmicaSemanticoUtils.verificarTipos(escopos, nomeVariavel);

                    boolean tipoExpressaoNumerico = tipoExpressao == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO || tipoExpressao == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL;
                    boolean tipoVariavelNumerico = tipoVariavel == TabelaDeSimbolos.TipoLinguagemAlgoritmica.INTEIRO || tipoVariavel == TabelaDeSimbolos.TipoLinguagemAlgoritmica.REAL;

                    if (!(tipoExpressaoNumerico && tipoVariavelNumerico) && tipoVariavel != tipoExpressao) {
                        erro = true;
                    }
                    break; // Não é necessário continuar verificando outros escopos
                }
            }

            if (!variavelExistente) {
                erro = true; // Variável não encontrada em nenhum escopo
            }
        }

        if (erro) {
            LinguagemAlgoritmicaSemanticoUtils.adicionarErroSemantico(
                    contexto.identificador().start,
                    "Atribuição não compatível para " + nomeVariavel
            );
        }
        return super.visitCmdAtribuicao(contexto);
    }


}