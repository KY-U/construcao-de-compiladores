// Generated from br\u005Cufscar\dc\compiladores\t5\LinguagemAlgoritmica.g4 by ANTLR 4.10.1
package br.ufscar.dc.compiladores.t5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinguagemAlgoritmicaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinguagemAlgoritmicaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LinguagemAlgoritmicaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(LinguagemAlgoritmicaParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(LinguagemAlgoritmicaParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(LinguagemAlgoritmicaParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(LinguagemAlgoritmicaParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(LinguagemAlgoritmicaParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(LinguagemAlgoritmicaParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LinguagemAlgoritmicaParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(LinguagemAlgoritmicaParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(LinguagemAlgoritmicaParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(LinguagemAlgoritmicaParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(LinguagemAlgoritmicaParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(LinguagemAlgoritmicaParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(LinguagemAlgoritmicaParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(LinguagemAlgoritmicaParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(LinguagemAlgoritmicaParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(LinguagemAlgoritmicaParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(LinguagemAlgoritmicaParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(LinguagemAlgoritmicaParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(LinguagemAlgoritmicaParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(LinguagemAlgoritmicaParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(LinguagemAlgoritmicaParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(LinguagemAlgoritmicaParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(LinguagemAlgoritmicaParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(LinguagemAlgoritmicaParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(LinguagemAlgoritmicaParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(LinguagemAlgoritmicaParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(LinguagemAlgoritmicaParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(LinguagemAlgoritmicaParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(LinguagemAlgoritmicaParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(LinguagemAlgoritmicaParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(LinguagemAlgoritmicaParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(LinguagemAlgoritmicaParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(LinguagemAlgoritmicaParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(LinguagemAlgoritmicaParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(LinguagemAlgoritmicaParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(LinguagemAlgoritmicaParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(LinguagemAlgoritmicaParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(LinguagemAlgoritmicaParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(LinguagemAlgoritmicaParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(LinguagemAlgoritmicaParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(LinguagemAlgoritmicaParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(LinguagemAlgoritmicaParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(LinguagemAlgoritmicaParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(LinguagemAlgoritmicaParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(LinguagemAlgoritmicaParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(LinguagemAlgoritmicaParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(LinguagemAlgoritmicaParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(LinguagemAlgoritmicaParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemAlgoritmicaParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(LinguagemAlgoritmicaParser.Op_logico_2Context ctx);
}