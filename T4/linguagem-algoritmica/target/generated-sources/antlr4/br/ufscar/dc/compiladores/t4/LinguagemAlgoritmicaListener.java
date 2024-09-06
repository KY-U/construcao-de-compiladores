// Generated from br\u005Cufscar\dc\compiladores\t4\LinguagemAlgoritmica.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LinguagemAlgoritmicaParser}.
 */
public interface LinguagemAlgoritmicaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(LinguagemAlgoritmicaParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(LinguagemAlgoritmicaParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(LinguagemAlgoritmicaParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(LinguagemAlgoritmicaParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(LinguagemAlgoritmicaParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(LinguagemAlgoritmicaParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(LinguagemAlgoritmicaParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(LinguagemAlgoritmicaParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(LinguagemAlgoritmicaParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(LinguagemAlgoritmicaParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LinguagemAlgoritmicaParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LinguagemAlgoritmicaParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(LinguagemAlgoritmicaParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(LinguagemAlgoritmicaParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(LinguagemAlgoritmicaParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(LinguagemAlgoritmicaParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(LinguagemAlgoritmicaParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(LinguagemAlgoritmicaParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(LinguagemAlgoritmicaParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(LinguagemAlgoritmicaParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(LinguagemAlgoritmicaParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(LinguagemAlgoritmicaParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(LinguagemAlgoritmicaParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(LinguagemAlgoritmicaParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LinguagemAlgoritmicaParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LinguagemAlgoritmicaParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(LinguagemAlgoritmicaParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(LinguagemAlgoritmicaParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LinguagemAlgoritmicaParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LinguagemAlgoritmicaParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(LinguagemAlgoritmicaParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(LinguagemAlgoritmicaParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(LinguagemAlgoritmicaParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(LinguagemAlgoritmicaParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(LinguagemAlgoritmicaParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(LinguagemAlgoritmicaParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(LinguagemAlgoritmicaParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(LinguagemAlgoritmicaParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(LinguagemAlgoritmicaParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(LinguagemAlgoritmicaParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(LinguagemAlgoritmicaParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(LinguagemAlgoritmicaParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(LinguagemAlgoritmicaParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(LinguagemAlgoritmicaParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(LinguagemAlgoritmicaParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(LinguagemAlgoritmicaParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(LinguagemAlgoritmicaParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(LinguagemAlgoritmicaParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(LinguagemAlgoritmicaParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(LinguagemAlgoritmicaParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LinguagemAlgoritmicaParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LinguagemAlgoritmicaParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(LinguagemAlgoritmicaParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(LinguagemAlgoritmicaParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(LinguagemAlgoritmicaParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(LinguagemAlgoritmicaParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(LinguagemAlgoritmicaParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(LinguagemAlgoritmicaParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(LinguagemAlgoritmicaParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(LinguagemAlgoritmicaParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(LinguagemAlgoritmicaParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(LinguagemAlgoritmicaParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(LinguagemAlgoritmicaParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(LinguagemAlgoritmicaParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(LinguagemAlgoritmicaParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(LinguagemAlgoritmicaParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(LinguagemAlgoritmicaParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(LinguagemAlgoritmicaParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(LinguagemAlgoritmicaParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(LinguagemAlgoritmicaParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(LinguagemAlgoritmicaParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(LinguagemAlgoritmicaParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(LinguagemAlgoritmicaParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(LinguagemAlgoritmicaParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(LinguagemAlgoritmicaParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(LinguagemAlgoritmicaParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(LinguagemAlgoritmicaParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(LinguagemAlgoritmicaParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(LinguagemAlgoritmicaParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(LinguagemAlgoritmicaParser.Op_logico_2Context ctx);
}