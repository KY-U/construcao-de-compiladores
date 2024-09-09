package br.ufscar.dc.compiladores.t5;

import static br.ufscar.dc.compiladores.t5.LASemanticoUtils.verificarTipo;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoEntrada;
import br.ufscar.dc.compiladores.t5.TabelaDeSimbolos.TipoT5;

public class Gerador extends LinguagemAlgoritmicaBaseVisitor<Void> {

    // String que receberá o programa em C ao longo da análise.
    StringBuilder saida  = new StringBuilder();
    
    // Criação da tabela principal e inicialização de escopos.
    TabelaDeSimbolos tabela  = new TabelaDeSimbolos();
    Escopos escopos = new Escopos();
    static Escopos escoposAninhados = new Escopos();
    
    // Método auxiliar que recebe um TipoT5 e o converte para a
    // String equivalente de um tipo em C.
    public String converteTipo(TipoT5 tipoAuxT5) {
        
        String tipoRetorno = null;
        
        if (tipoAuxT5 != null) { 
            switch (tipoAuxT5) {
                case INTEIRO:
                    tipoRetorno = "int";
                    break; 
                case LITERAL:
                    tipoRetorno = "char";
                    break; 
                case REAL:
                    tipoRetorno = "float";
                    break; 
                default:
                    break;
            }
        }
        
        return tipoRetorno;
    }

    // Método auxiliar que recebe uma string de um tipo dos casos
    // de entrada e retorna o TipoT5 auxiliar.
    public TipoT5 converteTipoT5(String tipo) {

        TipoT5 tipoRetorno = TipoT5.INVALIDO;

        switch (tipo) {
            case "literal":
                tipoRetorno = TipoT5.LITERAL;
                break;
            case "inteiro":
                tipoRetorno = TipoT5.INTEIRO;
                break;
            case "real":
                tipoRetorno = TipoT5.REAL;
                break;
            case "logico":
                tipoRetorno = TipoT5.LOGICO;
                break;
            default:
                break;
        }

        return tipoRetorno;
    }

    // Método auxiliar que recebe uma string com um tipo e retorna
    // o tipo C equivalente.
    public String verificaTipoC(String tipo) {
        
        String tipoRetorno = null;
        
        switch (tipo) {
            case "inteiro":
                tipoRetorno = "int";
                break; 
            case "literal":
                tipoRetorno = "char";
                break; 
            case "real":
                tipoRetorno = "float";
                break; 
            default:
                break;
        }
        
        return tipoRetorno;
    }

    // Método auxiiliar que recebe uma string que representa um tipo C
    // e retorna o parâmetro equivalente para sua leitura ou impressão em C.
    public String verificaParamTipo(String tipo) {
        
        String tipoRetorno = null;

        switch (tipo) {
            case "int":
                tipoRetorno = "d";
                break; 
            case "float":
                tipoRetorno = "f";
                break; 
            case "char":
                tipoRetorno = "s";
                break; 
            default:
                break;
        }

        return tipoRetorno;
    }

    // Método auxiiliar que recebe um TipoT5 e retorna o parâmetro 
    // equivalente para sua leitura ou impressão em C.  
    public String verificaParamTipoT5(TipoT5 tipoAuxT5) {

        String tipoRetorno = null;

        if (tipoAuxT5 != null) {
            switch (tipoAuxT5) {
                case INTEIRO:
                    tipoRetorno = "d";
                    break;
                case REAL:
                    tipoRetorno = "f";
                    break;
                case LITERAL:
                    tipoRetorno = "s";
                    break;
                default:
                    break;
            }
        }
        
        return tipoRetorno;
    }

    // Método auxiliar que verifica a existência de um tipo na tabela.
    public boolean verificaTipoTabela(TabelaDeSimbolos tabela, String tipo){

        return tabela.existe(tipo);
    }
    
    // Método auxiliar que recebe uma string e retorna os limites utilizados
    // em um comando Caso (Switch).
    public String getLimitesCaso(String str, boolean ehEsquerda) {
                
        String strAux;
        
        // Verificação necessária para identificar se trata-se de uma expressão
        // com limites esquerdo e direito, ou se é apenas um único valor.
        if (str.contains(".")) {

            int cont = 0;
            boolean continua = true;
            
            while (continua) {
                strAux = str.substring(cont);

                if (strAux.startsWith("."))
                    continua = false;
                else
                    cont++;
            }

            if (ehEsquerda)
                strAux = str.substring(0, cont);
            else
                strAux = str.substring(cont + 2);
        
        } else
            strAux = str;

        return strAux;
    }
    
    // Método auxiliar que separa os argumentos de um expressão relacional,
    // usado nos casos dos operadores de igual e diferente.
    public String separaArg(String total, int valor) {
        
        String argAux;
        boolean continua = true;
        int cont = 0;

        total = total.substring(1);
        
        while (continua) {
            argAux = total.substring(cont);

            if (argAux.startsWith("=") || argAux.startsWith("<>"))
                continua = false;
            else
                cont++;
        }

        if (valor == 0) {
            argAux = total.substring(0, cont);
        } else {
            total = total.substring(cont+1);
            cont = 0;
            continua = true;
            while (continua) {
                argAux = total.substring(cont);

                if (argAux.startsWith(")"))
                    continua = false;
                else
                    cont++;
            }
            argAux = total.substring(0, cont);
        }
        
        return argAux;
    }
    
    // Método auxiliar que recebe uma string e separa as parcelas de
    // uma expressão aritmética.
    public String separaExp(String total, int valor) {
        
        String argAux;
        boolean continua = true;
        int cont = 0;
        
        while (continua) {
            argAux = total.substring(cont);

            if (argAux.startsWith("+") || argAux.startsWith("-") || argAux.startsWith("*") || argAux.startsWith("/"))
                continua = false;
            else
                cont++;
        }

        if (valor == 0)
            argAux = total.substring(0, cont);
        else
            argAux = total.substring(cont + 1);

        return argAux;
    }
    
    // Método auxiliar que recebe uma string de uma expressão e retorna
    // apenas o operador utilizado na expressão.
    public String verificaOp(String total) {
        String opRetorno = null;
        
        if (total.contains("+"))
            opRetorno = "+";
        else if (total.contains("-"))
            opRetorno = "-";
        else if (total.contains("*"))
            opRetorno = "*";
        else if (total.contains("/"))
            opRetorno = "/";

        return opRetorno;
    }
    
    @Override
    public Void visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx) {
        
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
         
        visitDeclaracoes(ctx.declaracoes());

        saida.append("\nint main() {\n"); 

        visitCorpo(ctx.corpo());

        saida.append("\nreturn 0;\n");
        saida.append("}\n");

        return null;
    }
    
    @Override
    public Void visitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx) {
        
        String str;

        // Verifica se é uma declaração de constante.
        if (ctx.valor_constante() != null) {
            str = "#define " + ctx.IDENT().getText() + " " + ctx.valor_constante().getText() + "\n";
            saida.append(str);
        // Verifica se é a criação de um registro.  
        } else if (ctx.tipo() != null) {
            TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
            escopos.criarNovoEscopo();

            saida.append("typedef struct {\n");
            super.visitRegistro(ctx.tipo().registro());
            escopos.abandonarEscopo();
            
            escopoAtual.adicionar(ctx.IDENT().getText(), TipoT5.REGISTRO, TipoEntrada.VARIAVEL);
            
            str = "} " + ctx.IDENT().getText() + ";\n";
            saida.append(str);
        // Caso em que é uma declaração de um tipo básico.
        } else if (ctx.variavel() != null)
            visitVariavel(ctx.variavel());
        
        return null;
    }
    
    @Override
    public Void visitVariavel(LinguagemAlgoritmicaParser.VariavelContext ctx) {

        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        boolean tipoEstendido = false;
        String str;

        // Verifica se é um tipo básico.
        if (ctx.tipo().tipo_estendido() != null) {
            String nomeVar;
            String tipoVariavel = ctx.tipo().getText();
            TipoT5 tipoAuxT5;
            boolean ehPonteiro = false;

            // Verifica se é um ponteiro.
            if (tipoVariavel.contains("^")) {
                ehPonteiro = true;
                tipoVariavel = tipoVariavel.substring(1);
            }

            // Verifica a existência do tipo na tabela.
            if (verificaTipoTabela(escopoAtual, tipoVariavel)) {
                tipoEstendido = true;
                tipoAuxT5 = TipoT5.TIPOESTENDIDO;
            } else {
                tipoAuxT5 = converteTipoT5(tipoVariavel);
                tipoVariavel = converteTipo(tipoAuxT5);
            }

            if (ehPonteiro == true) {
                tipoVariavel += "*";
            }

            for (LinguagemAlgoritmicaParser.IdentificadorContext ictx : ctx.identificador()) {
                nomeVar = ictx.getText();

                if (tipoEstendido)
                    escopoAtual.adicionar(nomeVar, TipoT5.REGISTRO, TipoEntrada.VARIAVEL);
                else
                    escopoAtual.adicionar(nomeVar, tipoAuxT5, TipoEntrada.VARIAVEL);

                // Impressão das declarações do programa.
                if (tipoAuxT5 == TipoT5.LITERAL) {
                    str = tipoVariavel + " " + nomeVar + "[80];\n";
                    saida.append(str);
                } else {
                    str = tipoVariavel + " " + nomeVar + ";\n";
                    saida.append(str);
                }
            }
        // Caso seja a declaração de um novo registro.
        } else {
            // Criação de um escopo para as variáveis do registro.
            escopos.criarNovoEscopo();

            // Imprime a struct em C e adiciona as variáveis na tabela através
            // do visitante de variáveis.
            saida.append("struct{\n");
            for (LinguagemAlgoritmicaParser.VariavelContext vctx : ctx.tipo().registro().variavel()) {
                visitVariavel(vctx);
            }
            str = "}" + ctx.identificador(0).getText() + ";\n";
            saida.append(str);

            // Remove o escopo atual e grava o registro no escopo global.
            escopos.abandonarEscopo();
            escopoAtual.adicionar(ctx.identificador(0).getText(), TipoT5.REGISTRO, TipoEntrada.VARIAVEL);
        }

        return null;
    }
    
    @Override
    public Void visitDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx) {

        String str;
        
        // Obtém o escopo global.
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        escopos.criarNovoEscopo();
        
        // Cria um novo escopo para os parâmetros de procedimentos e funções.  
        TabelaDeSimbolos escopoParametros = escopos.obterEscopoAtual();
        String tipo, nomeVariaveis;

        // Verifica e imprime o tipo da função em C.
        if (ctx.tipo_estendido() != null)
            saida.append(verificaTipoC(ctx.tipo_estendido().getText()));
        else // Caso em que é um procedimento.
            saida.append("void");

        // Imprime o nome da função/procedimento.
        str = " " + ctx.IDENT().getText() + "(";
        saida.append(str);

        // Adiciona os parâmetros no escopo e os imprime.
        if (ctx.parametros() != null) {
            for (LinguagemAlgoritmicaParser.ParametroContext pctx : ctx.parametros().parametro()) {
                tipo = verificaTipoC(pctx.tipo_estendido().getText());
                nomeVariaveis = "";

                for (LinguagemAlgoritmicaParser.IdentificadorContext ictx : pctx.identificador()) {
                    nomeVariaveis += ictx.getText();
                    escopoParametros.adicionar(ictx.getText(), converteTipoT5(pctx.tipo_estendido().getText()), TipoEntrada.VARIAVEL);
                }

                if (tipo.equals("char")) {
                    tipo = "char*";
                }
                
                str = tipo + " " + nomeVariaveis;
                saida.append(str);
            }
        }

        saida.append(") {\n");

        // Adiciona o identificador do procedimento/função no escopo global.
        if (ctx.tipo_estendido() != null)
            escopoAtual.adicionar(ctx.IDENT().getText(), converteTipoT5(ctx.tipo_estendido().getText()), TipoEntrada.FUNCAO);
        else
            escopoAtual.adicionar(ctx.IDENT().getText(), TipoT5.VOID, TipoEntrada.PROCEDIMENTO);

        // Executa os comandos.
        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmd()) {
            visitCmd(cctx);
        }

        saida.append("}\n");
        escopos.abandonarEscopo();

        return null;
    }
    
    @Override
    public Void visitParcela_nao_unario(LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx) {

        // Imprime o identificador da parcela.
        if (ctx.identificador() != null)
            saida.append(ctx.identificador().getText());

        super.visitParcela_nao_unario(ctx);

        return null;
    }
    
    @Override
    public Void visitParcela_unario(LinguagemAlgoritmicaParser.Parcela_unarioContext ctx) {
        
        // Verifica se é uma expressão sem parênteses.
        if (!ctx.expressao().get(0).getText().contains("(")) {
            saida.append(ctx.getText());
        // Caso a expressão tenha parênteses, analisa as expressões internas de forma
        // individual e recursiva.
        } else {
            saida.append("(");
            super.visitParcela_unario(ctx);
            saida.append(")");
        }
        
        return null;
    }
    
    @Override
    public Void visitOp_relacional(LinguagemAlgoritmicaParser.Op_relacionalContext ctx) {

        // String criada para receber o operador da expressão atual.
        String strRetorno = ctx.getText();

        // Verifica se é o operador de igual para substituí-lo pelo operador
        // correto em C.
        if (ctx.getText().contains("="))
            if (!ctx.getText().contains("<=") || !ctx.getText().contains(">="))
                strRetorno = "==";

        saida.append(strRetorno);

        super.visitOp_relacional(ctx);

        return null;
    }
    
    @Override
    public Void visitCmdRetorne(LinguagemAlgoritmicaParser.CmdRetorneContext ctx) {

        saida.append("return ");
        // Análise da expressão que está sendo retornada.
        super.visitExpressao(ctx.expressao());
        saida.append(";\n");

        return null;
    }
    
    @Override
    public Void visitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx) {

        String str;
        tabela = escoposAninhados.obterEscopoAtual();

        // Verifica se é um ponteiro.
        if (ctx.getText().contains("^")) {
            str = "*" + ctx.identificador().getText() + " = " + ctx.expressao().getText() + ";\n";
            saida.append(str);
        // Verifica se é um registro.
        } else if (ctx.identificador().getText().contains(".") && ctx.getText().contains("\"")) {
            str = "strcpy(" + ctx.identificador().getText() + "," + ctx.expressao().getText() + ");\n";
            saida.append(str);
        // Verifica se é uma variável de um tipo básico.
        } else {
            str = ctx.identificador().getText() + " = " + ctx.expressao().getText() + ";\n";
            saida.append(str);
        }

        return null;
    }
    
    @Override
    public Void visitExpressao(LinguagemAlgoritmicaParser.ExpressaoContext ctx) {

        // Verifica se existe mais de um argumento no termo e, caso
        // não exista, executa a visitação apenas no primeiro e único termo.
        if (ctx.termo_logico().size() > 1) {
        
            for(LinguagemAlgoritmicaParser.Termo_logicoContext termoLogico : ctx.termo_logico()) {
                saida.append(" || ");
                visitTermo_logico(termoLogico);
            }
        
        } else
            visitTermo_logico(ctx.termo_logico(0));

        return null;
    }
    
    @Override 
    public Void visitTermo_logico(LinguagemAlgoritmicaParser.Termo_logicoContext ctx){
        
        // Verifica se existe mais de um argumento no fator e, caso
        // não exista, executa a visitação apenas no primeiro e único fator.
        if (ctx.fator_logico().size() > 1) {
        
            for(LinguagemAlgoritmicaParser.Fator_logicoContext fatorLogico : ctx.fator_logico()) {
                saida.append(" && ");
                visitFator_logico(fatorLogico);
            }
        } else
            visitFator_logico(ctx.fator_logico(0));

        return null;
        
    }
    
    @Override
    public Void visitFator_logico(LinguagemAlgoritmicaParser.Fator_logicoContext ctx) {
        
        // Verifica a existência do operador de negação.
        if(ctx.getText().contains("nao"))
            saida.append("!");

        visitParcela_logica(ctx.parcela_logica());
        
        return null;
    }
    
    @Override
    public Void visitOp2(LinguagemAlgoritmicaParser.Op2Context ctx) {

        saida.append(ctx.getText());

        super.visitOp2(ctx);

        return null;
    }
    
    @Override
    public Void visitParcela_logica(LinguagemAlgoritmicaParser.Parcela_logicaContext ctx) {
        
        if(ctx.getText().contains("falso"))
            saida.append("false");
        else if(ctx.getText().contains("verdadeiro"))
            saida.append("true");
        else
            visitExp_relacional(ctx.exp_relacional());

        return null;
    }
    
    @Override
    public Void visitExp_relacional(LinguagemAlgoritmicaParser.Exp_relacionalContext ctx) {
        
        String str;
        String opAtual = ctx.getText();
        String expAtual = ctx.exp_aritmetica().get(0).getText();

        // Verifica se o operador atual é o de diferença ou igualdade, para tratá-los
        // de forma especial visto que precisam ser substituídos por seus equivalentes
        // em C.
        if (expAtual.contains("<>"))
            opAtual = "<>";
        else if (expAtual.contains("="))
            if (!expAtual.contains("<=") || !expAtual.contains(">="))
                opAtual = "=";

        if (ctx.op_relacional() != null) {
            saida.append(expAtual);
            saida.append(ctx.op_relacional().getText());
            saida.append(ctx.exp_aritmetica(1).getText());
        // Situação em que precisa tratar dos operadores de igualdade e diferença,
        // ou de uma expressão aritmética.
        } else {
            switch(opAtual) {
                case "=" :
                    String arg1, arg2;
                    arg1 = separaArg(expAtual, 0);
                    arg2 = separaArg(expAtual, 1);
                    str = "(" + arg1;
                    saida.append(str);
                    saida.append("==");
                    str = arg2 + ")";
                    saida.append(str);
                    break;
                case "<>":
                    saida.append("!=");
                    break;
                // Caso não seja nenhum dos casos anteriores, trata-se de uma
                // expressão aritmética.
                default:
                    arg1 = separaExp(expAtual, 0);
                    arg2 = separaExp(expAtual, 1);
                    saida.append(arg1);
                    String op = verificaOp(opAtual);
                    saida.append(op);
                    saida.append(arg2);
                    break;
            }
        }

        return null;
    }
    
    @Override
    public Void visitCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx) {

        String str;
        String textoExpressao;
        
        // Susbtitui os operadores nas expressões da condição.
        textoExpressao = ctx.expressao().getText().replace("e", "&&");
        textoExpressao = textoExpressao.replace("=", "==");

        str = "if (" + textoExpressao + "){\n";
        saida.append(str);

        // Realiza os comandos do if.
        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmdEntao)
            super.visitCmd(cctx);

        saida.append("}\n");

        // Verifica se existe um comando else e o imprime.
        if (ctx.getText().contains("senao")) {

            saida.append("else{\n");
            
            // Realiza os comandos do else.
            for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmdSenao)
                super.visitCmd(cctx);
            
            saida.append("}\n");
        }

        return null;
    }
    
    @Override
    public Void visitCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx) {

        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        String nomeVar;
        TipoT5 tipoAuxT5;
        String codigoTipo;
        String str;

        // Executa as verificações dos parâmetros atuais.
        for (LinguagemAlgoritmicaParser.IdentificadorContext ictx : ctx.identificador()) {
            nomeVar = ictx.getText();
            tipoAuxT5 = escopoAtual.verificar(nomeVar);
            codigoTipo = verificaParamTipoT5(tipoAuxT5);

            // Caso seja um literal, imprime a leitura adequada em C.
            if (tipoAuxT5 == TipoT5.LITERAL) {
                str = "gets(" + nomeVar + ");\n";
                saida.append(str);
            // Impressão dos outros tipos básicos.
            } else {
                str = "scanf(\"%" + codigoTipo + "\",&" + nomeVar + ");\n";
                saida.append(str);
            }
        }

        return null;
    }

    @Override
    public Void visitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx) {

        saida.append("while(");
        super.visitExpressao(ctx.expressao());
        saida.append("){\n");
        
        // Executa os comandos dentro do while.
        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmd())
            super.visitCmd(cctx);

        saida.append("}\n");

        return null;
    }
    
    @Override
    public Void visitCmdPara(LinguagemAlgoritmicaParser.CmdParaContext ctx) {

        String str;
        String nomeVariavel, limiteEsq, limiteDir;

        nomeVariavel = ctx.IDENT().getText();
        limiteEsq = ctx.exp_aritmetica(0).getText();
        limiteDir = ctx.exp_aritmetica(1).getText();

        // Impressão do comando for com os limites obtidos anteriormente.
        str = "for(" + nomeVariavel + " = " + limiteEsq + "; " + nomeVariavel + " <= " + limiteDir + "; " + nomeVariavel + "++){\n";
        saida.append(str);

        // Executa os comandos do for.
        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmd())
            visitCmd(cctx);
            
        saida.append("}\n");

        return null;
    }
    
    @Override
    public Void visitCmdFaca(LinguagemAlgoritmicaParser.CmdFacaContext ctx) {

        saida.append("do{\n");

        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmd())
            super.visitCmd(cctx);

        saida.append("}while(");
        super.visitExpressao(ctx.expressao());
        saida.append(");\n");

        return null;
    } 
    
    @Override
    public Void visitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx) {

        TipoT5 tipoAuxT5Exp;
        String codTipoExp;
        
        TabelaDeSimbolos escopoAtual = escopos.obterEscopoAtual();
        
        for (LinguagemAlgoritmicaParser.ExpressaoContext ectx : ctx.expressao()) {

            String str;

            saida.append("printf(\"");

            // Remoção das aspas de uma cadeia passada explicitamente.
            if (ectx.getText().contains("\"")) {
                str = ectx.getText().replace("\"", "") + "\");\n";
                saida.append(str);
            } else {
                tipoAuxT5Exp = verificarTipo(escopoAtual, ectx);

                // Caso seja uma cadeia, imprime com o parâmetro adequado.
                if (tipoAuxT5Exp == TipoT5.LITERAL) {
                    str = "%s" + "\", " + ectx.getText() + ");\n";
                    saida.append(str);
                // Caso seja um outro tipo básico, verifica qual é o parâmetro adequado.
                } else {
                    codTipoExp = verificaParamTipoT5(tipoAuxT5Exp);
                    str = "%" + codTipoExp + "\", " + ectx.getText() + ");\n";
                    saida.append(str);
                }
            }
        }

        return null;
    }
    
    @Override
    public Void visitCmdCaso(LinguagemAlgoritmicaParser.CmdCasoContext ctx) {

        String str;
        String limiteEsq, limiteDir;

        str = "switch (" + ctx.exp_aritmetica().getText() + "){\n";
        saida.append(str);

        // Executa os blocos do comando Caso.
        for (LinguagemAlgoritmicaParser.Item_selecaoContext sctx : ctx.selecao().item_selecao()) {

            String strOriginal = sctx.constantes().numero_intervalo(0).getText();
            
            // Obtém os limites esquero e direito do caso atual.
            if (strOriginal.contains(".")) {
                limiteEsq = getLimitesCaso(strOriginal, true);
                limiteDir = getLimitesCaso(strOriginal, false);
            // Caso seja um valor único, ambos os limites podem receber o mesmo valor.
            } else {
                limiteEsq = getLimitesCaso(strOriginal, true);
                limiteDir = getLimitesCaso(strOriginal, true);
            }

            if (!sctx.constantes().isEmpty()) {
                for (int i = Integer.parseInt(limiteEsq); i <= Integer.parseInt(limiteDir); i++) {
                    str = "case " + Integer.toString(i) + ":\n";
                    saida.append(str);
                }
            } else {
                str = "case " + limiteEsq + ":\n";
                saida.append(str);
            }
            
            for (LinguagemAlgoritmicaParser.CmdContext cctx : sctx.cmd())
                visitCmd(cctx);

            saida.append("break;\n");
        }

        saida.append("default:\n");
        
        for (LinguagemAlgoritmicaParser.CmdContext cctx : ctx.cmd())
            visitCmd(cctx);

        saida.append("}\n");

        return null;
    }
    
    @Override
    public Void visitCmdChamada(LinguagemAlgoritmicaParser.CmdChamadaContext ctx) {

        String str;
        str = ctx.IDENT().getText() + "(";
        saida.append(str);

        int cont = 0;

        for (LinguagemAlgoritmicaParser.ExpressaoContext ectx : ctx.expressao()) {
            if (cont >= 1)
                saida.append(", ");

            saida.append(ectx.getText());
            cont += 1;
        }

        saida.append(");\n");

        return null;
    }
}