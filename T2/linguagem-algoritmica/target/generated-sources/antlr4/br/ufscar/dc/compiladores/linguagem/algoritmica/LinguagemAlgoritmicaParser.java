// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.linguagem.algoritmica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LinguagemAlgoritmicaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO=1, REAL=2, ALGORITMO=3, DECLARE=4, LITERAL=5, INTEIRO=6, LEIA=7, 
		ESCREVA=8, FIM_ALGORITMO=9, CADEIA=10, VIRGULA=11, NUM_INT=12, NUM_REAL=13, 
		MAIS=14, MENOS=15, VEZES=16, DIV=17, ATRIB=18, PORCENTO=19, COMERCIAL=20, 
		ELEVADO=21, REGISTRO=22, FIM_REGISTRO=23, PONTO=24, IGUAL=25, DIFERENTE=26, 
		MAIOR_IGUAL=27, MENOR_IGUAL=28, MAIOR=29, MENOR=30, E=31, NAO=32, OU=33, 
		LOGICO=34, SE=35, ENTAO=36, SENAO=37, FIM_SE=38, CASO=39, SEJA=40, FIM_CASO=41, 
		DOIS_PONTOS=42, PARA=43, ATE=44, FACA=45, FIM_PARA=46, ENQUANTO=47, FIM_ENQUANTO=48, 
		PROCEDIMENTO=49, FIM_PROCEDIMENTO=50, FUNCAO=51, RETORNE=52, FIM_FUNCAO=53, 
		TIPO=54, VAR=55, CONST=56, VERDADEIRO=57, FALSO=58, SIMB_N_IDENT=59, CADEIA_N_FECHADA=60, 
		COMENTARIO_N_FECHADO=61, IDENT=62, WS=63, DELIM=64, ABRECOL=65, FECHACOL=66, 
		ABREPAR=67, FECHAPAR=68, ERRO=69;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_decl_local_global = 2, RULE_declaracao_local = 3, 
		RULE_variavel = 4, RULE_decConst = 5, RULE_decTipo = 6, RULE_decVar = 7, 
		RULE_identificador = 8, RULE_dimensao = 9, RULE_tipo = 10, RULE_tipo_basico = 11, 
		RULE_tipo_basico_ident = 12, RULE_tipo_estendido = 13, RULE_valor_constante = 14, 
		RULE_registro = 15, RULE_declaracao_global = 16, RULE_parametro = 17, 
		RULE_parametros = 18, RULE_corpo = 19, RULE_cmd = 20, RULE_cmdLeia = 21, 
		RULE_cmdEscreva = 22, RULE_cmdSe = 23, RULE_cmdCaso = 24, RULE_cmdPara = 25, 
		RULE_cmdEnquanto = 26, RULE_cmdFaca = 27, RULE_cmdAtribuicao = 28, RULE_cmdChamada = 29, 
		RULE_cmdRetorne = 30, RULE_selecao = 31, RULE_item_selecao = 32, RULE_constantes = 33, 
		RULE_numero_intervalo = 34, RULE_op_unario = 35, RULE_exp_aritmetica = 36, 
		RULE_termo = 37, RULE_fator = 38, RULE_op1 = 39, RULE_op2 = 40, RULE_op3 = 41, 
		RULE_parcela = 42, RULE_parcela_unario = 43, RULE_parcela_nao_unario = 44, 
		RULE_exp_relacional = 45, RULE_op_relacional = 46, RULE_expressao = 47, 
		RULE_termo_logico = 48, RULE_fator_logico = 49, RULE_parcela_logica = 50, 
		RULE_op_logico_1 = 51, RULE_op_logico_2 = 52;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracoes", "decl_local_global", "declaracao_local", "variavel", 
			"decConst", "decTipo", "decVar", "identificador", "dimensao", "tipo", 
			"tipo_basico", "tipo_basico_ident", "tipo_estendido", "valor_constante", 
			"registro", "declaracao_global", "parametro", "parametros", "corpo", 
			"cmd", "cmdLeia", "cmdEscreva", "cmdSe", "cmdCaso", "cmdPara", "cmdEnquanto", 
			"cmdFaca", "cmdAtribuicao", "cmdChamada", "cmdRetorne", "selecao", "item_selecao", 
			"constantes", "numero_intervalo", "op_unario", "exp_aritmetica", "termo", 
			"fator", "op1", "op2", "op3", "parcela", "parcela_unario", "parcela_nao_unario", 
			"exp_relacional", "op_relacional", "expressao", "termo_logico", "fator_logico", 
			"parcela_logica", "op_logico_1", "op_logico_2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'real'", "'algoritmo'", "'declare'", "'literal'", "'inteiro'", 
			"'leia'", "'escreva'", "'fim_algoritmo'", null, "','", null, null, "'+'", 
			"'-'", "'*'", "'/'", "'<-'", "'%'", "'&'", "'^'", "'registro'", "'fim_registro'", 
			"'.'", "'='", "'<>'", "'>='", "'<='", "'>'", "'<'", "'e'", "'nao'", "'ou'", 
			"'logico'", "'se'", "'entao'", "'senao'", "'fim_se'", "'caso'", "'seja'", 
			"'fim_caso'", "'..'", "'para'", "'ate'", "'faca'", "'fim_para'", "'enquanto'", 
			"'fim_enquanto'", "'procedimento'", "'fim_procedimento'", "'funcao'", 
			"'retorne'", "'fim_funcao'", "'tipo'", "'var'", "'constante'", "'verdadeiro'", 
			"'falso'", null, null, null, null, null, "':'", "'['", "']'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO", "REAL", "ALGORITMO", "DECLARE", "LITERAL", "INTEIRO", 
			"LEIA", "ESCREVA", "FIM_ALGORITMO", "CADEIA", "VIRGULA", "NUM_INT", "NUM_REAL", 
			"MAIS", "MENOS", "VEZES", "DIV", "ATRIB", "PORCENTO", "COMERCIAL", "ELEVADO", 
			"REGISTRO", "FIM_REGISTRO", "PONTO", "IGUAL", "DIFERENTE", "MAIOR_IGUAL", 
			"MENOR_IGUAL", "MAIOR", "MENOR", "E", "NAO", "OU", "LOGICO", "SE", "ENTAO", 
			"SENAO", "FIM_SE", "CASO", "SEJA", "FIM_CASO", "DOIS_PONTOS", "PARA", 
			"ATE", "FACA", "FIM_PARA", "ENQUANTO", "FIM_ENQUANTO", "PROCEDIMENTO", 
			"FIM_PROCEDIMENTO", "FUNCAO", "RETORNE", "FIM_FUNCAO", "TIPO", "VAR", 
			"CONST", "VERDADEIRO", "FALSO", "SIMB_N_IDENT", "CADEIA_N_FECHADA", "COMENTARIO_N_FECHADO", 
			"IDENT", "WS", "DELIM", "ABRECOL", "FECHACOL", "ABREPAR", "FECHAPAR", 
			"ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguagemAlgoritmicaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode ALGORITMO() { return getToken(LinguagemAlgoritmicaParser.ALGORITMO, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode FIM_ALGORITMO() { return getToken(LinguagemAlgoritmicaParser.FIM_ALGORITMO, 0); }
		public TerminalNode EOF() { return getToken(LinguagemAlgoritmicaParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			declaracoes();
			setState(107);
			match(ALGORITMO);
			setState(108);
			corpo();
			setState(109);
			match(FIM_ALGORITMO);
			setState(110);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Decl_local_globalContext> decl_local_global() {
			return getRuleContexts(Decl_local_globalContext.class);
		}
		public Decl_local_globalContext decl_local_global(int i) {
			return getRuleContext(Decl_local_globalContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 92886742314516496L) != 0) {
				{
				{
				setState(112);
				decl_local_global();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decl_local_globalContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracao_globalContext declaracao_global() {
			return getRuleContext(Declaracao_globalContext.class,0);
		}
		public Decl_local_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDecl_local_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDecl_local_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDecl_local_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_local_globalContext decl_local_global() throws RecognitionException {
		Decl_local_globalContext _localctx = new Decl_local_globalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_local_global);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
			case TIPO:
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				declaracao_local();
				}
				break;
			case PROCEDIMENTO:
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				declaracao_global();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_localContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(LinguagemAlgoritmicaParser.DECLARE, 0); }
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public TerminalNode CONST() { return getToken(LinguagemAlgoritmicaParser.CONST, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LinguagemAlgoritmicaParser.IGUAL, 0); }
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public TerminalNode TIPO() { return getToken(LinguagemAlgoritmicaParser.TIPO, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDeclaracao_local(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao_local);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(DECLARE);
				setState(123);
				variavel();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(CONST);
				setState(125);
				match(IDENT);
				setState(126);
				match(DELIM);
				setState(127);
				tipo_basico();
				setState(128);
				match(IGUAL);
				setState(129);
				valor_constante();
				}
				break;
			case TIPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(TIPO);
				setState(132);
				match(IDENT);
				setState(133);
				match(DELIM);
				setState(134);
				tipo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariavelContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variavel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			identificador();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(138);
				match(VIRGULA);
				setState(139);
				identificador();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(DELIM);
			setState(146);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecConstContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(LinguagemAlgoritmicaParser.CONST, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LinguagemAlgoritmicaParser.IGUAL, 0); }
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public DecConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDecConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDecConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDecConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecConstContext decConst() throws RecognitionException {
		DecConstContext _localctx = new DecConstContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(CONST);
			setState(149);
			match(IDENT);
			setState(150);
			match(DELIM);
			setState(151);
			tipo_basico();
			setState(152);
			match(IGUAL);
			setState(153);
			valor_constante();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecTipoContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(LinguagemAlgoritmicaParser.TIPO, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DecTipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decTipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDecTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDecTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDecTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecTipoContext decTipo() throws RecognitionException {
		DecTipoContext _localctx = new DecTipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decTipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(TIPO);
			setState(156);
			match(IDENT);
			setState(157);
			match(DELIM);
			setState(158);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecVarContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(LinguagemAlgoritmicaParser.DECLARE, 0); }
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public DecVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDecVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDecVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDecVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecVarContext decVar() throws RecognitionException {
		DecVarContext _localctx = new DecVarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_decVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(DECLARE);
			setState(161);
			variavel();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(LinguagemAlgoritmicaParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LinguagemAlgoritmicaParser.IDENT, i);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public List<TerminalNode> PONTO() { return getTokens(LinguagemAlgoritmicaParser.PONTO); }
		public TerminalNode PONTO(int i) {
			return getToken(LinguagemAlgoritmicaParser.PONTO, i);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(IDENT);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PONTO) {
				{
				{
				setState(164);
				match(PONTO);
				setState(165);
				match(IDENT);
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			dimensao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensaoContext extends ParserRuleContext {
		public List<TerminalNode> ABRECOL() { return getTokens(LinguagemAlgoritmicaParser.ABRECOL); }
		public TerminalNode ABRECOL(int i) {
			return getToken(LinguagemAlgoritmicaParser.ABRECOL, i);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public List<TerminalNode> FECHACOL() { return getTokens(LinguagemAlgoritmicaParser.FECHACOL); }
		public TerminalNode FECHACOL(int i) {
			return getToken(LinguagemAlgoritmicaParser.FECHACOL, i);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDimensao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimensao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABRECOL) {
				{
				{
				setState(173);
				match(ABRECOL);
				setState(174);
				exp_aritmetica();
				setState(175);
				match(FECHACOL);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				registro();
				}
				break;
			case REAL:
			case LITERAL:
			case INTEIRO:
			case ELEVADO:
			case LOGICO:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				tipo_estendido();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_basicoContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(LinguagemAlgoritmicaParser.LITERAL, 0); }
		public TerminalNode INTEIRO() { return getToken(LinguagemAlgoritmicaParser.INTEIRO, 0); }
		public TerminalNode REAL() { return getToken(LinguagemAlgoritmicaParser.REAL, 0); }
		public TerminalNode LOGICO() { return getToken(LinguagemAlgoritmicaParser.LOGICO, 0); }
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTipo_basico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo_basico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 17179869284L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_basico_identContext extends ParserRuleContext {
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTipo_basico_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo_basico_ident);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
			case LITERAL:
			case INTEIRO:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				tipo_basico();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_estendidoContext extends ParserRuleContext {
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public TerminalNode ELEVADO() { return getToken(LinguagemAlgoritmicaParser.ELEVADO, 0); }
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTipo_estendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_estendido);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELEVADO) {
				{
				setState(192);
				match(ELEVADO);
				}
			}

			setState(195);
			tipo_basico_ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Valor_constanteContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(LinguagemAlgoritmicaParser.CADEIA, 0); }
		public TerminalNode NUM_INT() { return getToken(LinguagemAlgoritmicaParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LinguagemAlgoritmicaParser.NUM_REAL, 0); }
		public TerminalNode VERDADEIRO() { return getToken(LinguagemAlgoritmicaParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LinguagemAlgoritmicaParser.FALSO, 0); }
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitValor_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_valor_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 432345564227580928L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegistroContext extends ParserRuleContext {
		public TerminalNode REGISTRO() { return getToken(LinguagemAlgoritmicaParser.REGISTRO, 0); }
		public TerminalNode FIM_REGISTRO() { return getToken(LinguagemAlgoritmicaParser.FIM_REGISTRO, 0); }
		public List<VariavelContext> variavel() {
			return getRuleContexts(VariavelContext.class);
		}
		public VariavelContext variavel(int i) {
			return getRuleContext(VariavelContext.class,i);
		}
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_registro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(REGISTRO);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(200);
				variavel();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(FIM_REGISTRO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_globalContext extends ParserRuleContext {
		public TerminalNode PROCEDIMENTO() { return getToken(LinguagemAlgoritmicaParser.PROCEDIMENTO, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LinguagemAlgoritmicaParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(LinguagemAlgoritmicaParser.FECHAPAR, 0); }
		public TerminalNode FIM_PROCEDIMENTO() { return getToken(LinguagemAlgoritmicaParser.FIM_PROCEDIMENTO, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode FUNCAO() { return getToken(LinguagemAlgoritmicaParser.FUNCAO, 0); }
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TerminalNode FIM_FUNCAO() { return getToken(LinguagemAlgoritmicaParser.FIM_FUNCAO, 0); }
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitDeclaracao_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declaracao_global);
		int _la;
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDIMENTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(PROCEDIMENTO);
				setState(209);
				match(IDENT);
				setState(210);
				match(ABREPAR);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(211);
					parametros();
					}
				}

				setState(214);
				match(FECHAPAR);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 90071992547409936L) != 0) {
					{
					{
					setState(215);
					declaracao_local();
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
					{
					{
					setState(221);
					cmd();
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(227);
				match(FIM_PROCEDIMENTO);
				}
				break;
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(FUNCAO);
				setState(229);
				match(IDENT);
				setState(230);
				match(ABREPAR);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(231);
					parametros();
					}
				}

				setState(234);
				match(FECHAPAR);
				setState(235);
				match(DELIM);
				setState(236);
				tipo_estendido();
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 90071992547409936L) != 0) {
					{
					{
					setState(237);
					declaracao_local();
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
					{
					{
					setState(243);
					cmd();
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249);
				match(FIM_FUNCAO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LinguagemAlgoritmicaParser.VAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(253);
				match(VAR);
				}
			}

			setState(256);
			identificador();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(257);
				match(VIRGULA);
				setState(258);
				identificador();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(DELIM);
			setState(265);
			tipo_estendido();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			parametro();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(268);
				match(VIRGULA);
				setState(269);
				parametro();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CorpoContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 90071992547409936L) != 0) {
				{
				{
				setState(275);
				declaracao_local();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(281);
				cmd();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeiaContext cmdLeia() {
			return getRuleContext(CmdLeiaContext.class,0);
		}
		public CmdEscrevaContext cmdEscreva() {
			return getRuleContext(CmdEscrevaContext.class,0);
		}
		public CmdSeContext cmdSe() {
			return getRuleContext(CmdSeContext.class,0);
		}
		public CmdCasoContext cmdCaso() {
			return getRuleContext(CmdCasoContext.class,0);
		}
		public CmdParaContext cmdPara() {
			return getRuleContext(CmdParaContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdFacaContext cmdFaca() {
			return getRuleContext(CmdFacaContext.class,0);
		}
		public CmdAtribuicaoContext cmdAtribuicao() {
			return getRuleContext(CmdAtribuicaoContext.class,0);
		}
		public CmdChamadaContext cmdChamada() {
			return getRuleContext(CmdChamadaContext.class,0);
		}
		public CmdRetorneContext cmdRetorne() {
			return getRuleContext(CmdRetorneContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cmd);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				cmdLeia();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				cmdEscreva();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(289);
				cmdSe();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(290);
				cmdCaso();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(291);
				cmdPara();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(292);
				cmdEnquanto();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(293);
				cmdFaca();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(294);
				cmdAtribuicao();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(295);
				cmdChamada();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(296);
				cmdRetorne();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeiaContext extends ParserRuleContext {
		public TerminalNode LEIA() { return getToken(LinguagemAlgoritmicaParser.LEIA, 0); }
		public TerminalNode ABREPAR() { return getToken(LinguagemAlgoritmicaParser.ABREPAR, 0); }
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LinguagemAlgoritmicaParser.FECHAPAR, 0); }
		public List<TerminalNode> ELEVADO() { return getTokens(LinguagemAlgoritmicaParser.ELEVADO); }
		public TerminalNode ELEVADO(int i) {
			return getToken(LinguagemAlgoritmicaParser.ELEVADO, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public CmdLeiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdLeia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdLeia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdLeia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdLeiaContext cmdLeia() throws RecognitionException {
		CmdLeiaContext _localctx = new CmdLeiaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cmdLeia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(LEIA);
			setState(300);
			match(ABREPAR);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELEVADO) {
				{
				setState(301);
				match(ELEVADO);
				}
			}

			setState(304);
			identificador();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(305);
				match(VIRGULA);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELEVADO) {
					{
					setState(306);
					match(ELEVADO);
					}
				}

				setState(309);
				identificador();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(315);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscrevaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(LinguagemAlgoritmicaParser.ESCREVA, 0); }
		public TerminalNode ABREPAR() { return getToken(LinguagemAlgoritmicaParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LinguagemAlgoritmicaParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public CmdEscrevaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscreva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdEscreva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdEscreva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdEscreva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEscrevaContext cmdEscreva() throws RecognitionException {
		CmdEscrevaContext _localctx = new CmdEscrevaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cmdEscreva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(ESCREVA);
			setState(318);
			match(ABREPAR);
			setState(319);
			expressao();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(320);
				match(VIRGULA);
				setState(321);
				expressao();
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(327);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdSeContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(LinguagemAlgoritmicaParser.SE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(LinguagemAlgoritmicaParser.ENTAO, 0); }
		public TerminalNode FIM_SE() { return getToken(LinguagemAlgoritmicaParser.FIM_SE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(LinguagemAlgoritmicaParser.SENAO, 0); }
		public CmdSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdSe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdSeContext cmdSe() throws RecognitionException {
		CmdSeContext _localctx = new CmdSeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cmdSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(SE);
			setState(330);
			expressao();
			setState(331);
			match(ENTAO);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(332);
				cmd();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(338);
				match(SENAO);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
					{
					{
					setState(339);
					cmd();
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347);
			match(FIM_SE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdCasoContext extends ParserRuleContext {
		public TerminalNode CASO() { return getToken(LinguagemAlgoritmicaParser.CASO, 0); }
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public TerminalNode SEJA() { return getToken(LinguagemAlgoritmicaParser.SEJA, 0); }
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode FIM_CASO() { return getToken(LinguagemAlgoritmicaParser.FIM_CASO, 0); }
		public TerminalNode SENAO() { return getToken(LinguagemAlgoritmicaParser.SENAO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdCaso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCasoContext cmdCaso() throws RecognitionException {
		CmdCasoContext _localctx = new CmdCasoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cmdCaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(CASO);
			setState(350);
			exp_aritmetica();
			setState(351);
			match(SEJA);
			setState(352);
			selecao();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(353);
				match(SENAO);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
					{
					{
					setState(354);
					cmd();
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(362);
			match(FIM_CASO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdParaContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(LinguagemAlgoritmicaParser.PARA, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode ATRIB() { return getToken(LinguagemAlgoritmicaParser.ATRIB, 0); }
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public TerminalNode ATE() { return getToken(LinguagemAlgoritmicaParser.ATE, 0); }
		public TerminalNode FACA() { return getToken(LinguagemAlgoritmicaParser.FACA, 0); }
		public TerminalNode FIM_PARA() { return getToken(LinguagemAlgoritmicaParser.FIM_PARA, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdParaContext cmdPara() throws RecognitionException {
		CmdParaContext _localctx = new CmdParaContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cmdPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(PARA);
			setState(365);
			match(IDENT);
			setState(366);
			match(ATRIB);
			setState(367);
			exp_aritmetica();
			setState(368);
			match(ATE);
			setState(369);
			exp_aritmetica();
			setState(370);
			match(FACA);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(371);
				cmd();
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(377);
			match(FIM_PARA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(LinguagemAlgoritmicaParser.ENQUANTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FACA() { return getToken(LinguagemAlgoritmicaParser.FACA, 0); }
		public TerminalNode FIM_ENQUANTO() { return getToken(LinguagemAlgoritmicaParser.FIM_ENQUANTO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(ENQUANTO);
			setState(380);
			expressao();
			setState(381);
			match(FACA);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(382);
				cmd();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			match(FIM_ENQUANTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdFacaContext extends ParserRuleContext {
		public TerminalNode FACA() { return getToken(LinguagemAlgoritmicaParser.FACA, 0); }
		public TerminalNode ATE() { return getToken(LinguagemAlgoritmicaParser.ATE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdFacaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFaca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdFaca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdFaca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdFaca(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdFacaContext cmdFaca() throws RecognitionException {
		CmdFacaContext _localctx = new CmdFacaContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cmdFaca);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(FACA);
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(391);
				cmd();
				}
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
			match(ATE);
			setState(398);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtribuicaoContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ATRIB() { return getToken(LinguagemAlgoritmicaParser.ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ELEVADO() { return getToken(LinguagemAlgoritmicaParser.ELEVADO, 0); }
		public CmdAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAtribuicaoContext cmdAtribuicao() throws RecognitionException {
		CmdAtribuicaoContext _localctx = new CmdAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cmdAtribuicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELEVADO) {
				{
				setState(400);
				match(ELEVADO);
				}
			}

			setState(403);
			identificador();
			setState(404);
			match(ATRIB);
			setState(405);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdChamadaContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LinguagemAlgoritmicaParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LinguagemAlgoritmicaParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public CmdChamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdChamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdChamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdChamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdChamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdChamadaContext cmdChamada() throws RecognitionException {
		CmdChamadaContext _localctx = new CmdChamadaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cmdChamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(IDENT);
			setState(408);
			match(ABREPAR);
			setState(409);
			expressao();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(410);
				match(VIRGULA);
				setState(411);
				expressao();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(417);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdRetorneContext extends ParserRuleContext {
		public TerminalNode RETORNE() { return getToken(LinguagemAlgoritmicaParser.RETORNE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CmdRetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRetorne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterCmdRetorne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitCmdRetorne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitCmdRetorne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdRetorneContext cmdRetorne() throws RecognitionException {
		CmdRetorneContext _localctx = new CmdRetorneContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cmdRetorne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(RETORNE);
			setState(420);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelecaoContext extends ParserRuleContext {
		public List<Item_selecaoContext> item_selecao() {
			return getRuleContexts(Item_selecaoContext.class);
		}
		public Item_selecaoContext item_selecao(int i) {
			return getRuleContext(Item_selecaoContext.class,i);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUM_INT || _la==MENOS) {
				{
				{
				setState(422);
				item_selecao();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_selecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(LinguagemAlgoritmicaParser.DELIM, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public Item_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterItem_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitItem_selecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitItem_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_selecaoContext item_selecao() throws RecognitionException {
		Item_selecaoContext _localctx = new Item_selecaoContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_item_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			constantes();
			setState(429);
			match(DELIM);
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4616374920125874560L) != 0) {
				{
				{
				setState(430);
				cmd();
				}
				}
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantesContext extends ParserRuleContext {
		public List<Numero_intervaloContext> numero_intervalo() {
			return getRuleContexts(Numero_intervaloContext.class);
		}
		public Numero_intervaloContext numero_intervalo(int i) {
			return getRuleContext(Numero_intervaloContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_constantes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			numero_intervalo();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(437);
				match(VIRGULA);
				setState(438);
				numero_intervalo();
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numero_intervaloContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(LinguagemAlgoritmicaParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(LinguagemAlgoritmicaParser.NUM_INT, i);
		}
		public List<Op_unarioContext> op_unario() {
			return getRuleContexts(Op_unarioContext.class);
		}
		public Op_unarioContext op_unario(int i) {
			return getRuleContext(Op_unarioContext.class,i);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LinguagemAlgoritmicaParser.DOIS_PONTOS, 0); }
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitNumero_intervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_numero_intervalo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(444);
				op_unario();
				}
			}

			setState(447);
			match(NUM_INT);
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOIS_PONTOS) {
				{
				setState(448);
				match(DOIS_PONTOS);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MENOS) {
					{
					setState(449);
					op_unario();
					}
				}

				setState(452);
				match(NUM_INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_unarioContext extends ParserRuleContext {
		public TerminalNode MENOS() { return getToken(LinguagemAlgoritmicaParser.MENOS, 0); }
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_op_unario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(MENOS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<Op1Context> op1() {
			return getRuleContexts(Op1Context.class);
		}
		public Op1Context op1(int i) {
			return getRuleContext(Op1Context.class,i);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_exp_aritmetica);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			termo();
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(458);
					op1();
					setState(459);
					termo();
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<Op2Context> op2() {
			return getRuleContexts(Op2Context.class);
		}
		public Op2Context op2(int i) {
			return getRuleContext(Op2Context.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			fator();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VEZES || _la==DIV) {
				{
				{
				setState(467);
				op2();
				setState(468);
				fator();
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public List<ParcelaContext> parcela() {
			return getRuleContexts(ParcelaContext.class);
		}
		public ParcelaContext parcela(int i) {
			return getRuleContext(ParcelaContext.class,i);
		}
		public List<Op3Context> op3() {
			return getRuleContexts(Op3Context.class);
		}
		public Op3Context op3(int i) {
			return getRuleContext(Op3Context.class,i);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_fator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			parcela();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PORCENTO) {
				{
				{
				setState(476);
				op3();
				setState(477);
				parcela();
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op1Context extends ParserRuleContext {
		public TerminalNode MAIS() { return getToken(LinguagemAlgoritmicaParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(LinguagemAlgoritmicaParser.MENOS, 0); }
		public Op1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op1Context op1() throws RecognitionException {
		Op1Context _localctx = new Op1Context(_ctx, getState());
		enterRule(_localctx, 78, RULE_op1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			_la = _input.LA(1);
			if ( !(_la==MAIS || _la==MENOS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op2Context extends ParserRuleContext {
		public TerminalNode VEZES() { return getToken(LinguagemAlgoritmicaParser.VEZES, 0); }
		public TerminalNode DIV() { return getToken(LinguagemAlgoritmicaParser.DIV, 0); }
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 80, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			_la = _input.LA(1);
			if ( !(_la==VEZES || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op3Context extends ParserRuleContext {
		public TerminalNode PORCENTO() { return getToken(LinguagemAlgoritmicaParser.PORCENTO, 0); }
		public Op3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op3Context op3() throws RecognitionException {
		Op3Context _localctx = new Op3Context(_ctx, getState());
		enterRule(_localctx, 82, RULE_op3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(PORCENTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParcelaContext extends ParserRuleContext {
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parcela);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_INT:
			case NUM_REAL:
			case MENOS:
			case ELEVADO:
			case IDENT:
			case ABREPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MENOS) {
					{
					setState(490);
					op_unario();
					}
				}

				setState(493);
				parcela_unario();
				}
				break;
			case CADEIA:
			case COMERCIAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				parcela_nao_unario();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_unarioContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ELEVADO() { return getToken(LinguagemAlgoritmicaParser.ELEVADO, 0); }
		public TerminalNode IDENT() { return getToken(LinguagemAlgoritmicaParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LinguagemAlgoritmicaParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LinguagemAlgoritmicaParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LinguagemAlgoritmicaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LinguagemAlgoritmicaParser.VIRGULA, i);
		}
		public TerminalNode NUM_INT() { return getToken(LinguagemAlgoritmicaParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LinguagemAlgoritmicaParser.NUM_REAL, 0); }
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parcela_unario);
		int _la;
		try {
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELEVADO) {
					{
					setState(497);
					match(ELEVADO);
					}
				}

				setState(500);
				identificador();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(501);
				match(IDENT);
				setState(502);
				match(ABREPAR);
				setState(503);
				expressao();
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(504);
					match(VIRGULA);
					setState(505);
					expressao();
					}
					}
					setState(510);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(511);
				match(FECHAPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				match(NUM_INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(514);
				match(NUM_REAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(515);
				match(ABREPAR);
				setState(516);
				expressao();
				setState(517);
				match(FECHAPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public TerminalNode COMERCIAL() { return getToken(LinguagemAlgoritmicaParser.COMERCIAL, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(LinguagemAlgoritmicaParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_parcela_nao_unario);
		try {
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMERCIAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				match(COMERCIAL);
				setState(522);
				identificador();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				match(CADEIA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exp_relacionalContext extends ParserRuleContext {
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_exp_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			exp_aritmetica();
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0) {
				{
				setState(527);
				op_relacional();
				setState(528);
				exp_aritmetica();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_relacionalContext extends ParserRuleContext {
		public TerminalNode IGUAL() { return getToken(LinguagemAlgoritmicaParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(LinguagemAlgoritmicaParser.DIFERENTE, 0); }
		public TerminalNode MAIOR_IGUAL() { return getToken(LinguagemAlgoritmicaParser.MAIOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(LinguagemAlgoritmicaParser.MENOR_IGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(LinguagemAlgoritmicaParser.MAIOR, 0); }
		public TerminalNode MENOR() { return getToken(LinguagemAlgoritmicaParser.MENOR, 0); }
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_op_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public List<Termo_logicoContext> termo_logico() {
			return getRuleContexts(Termo_logicoContext.class);
		}
		public Termo_logicoContext termo_logico(int i) {
			return getRuleContext(Termo_logicoContext.class,i);
		}
		public List<Op_logico_1Context> op_logico_1() {
			return getRuleContexts(Op_logico_1Context.class);
		}
		public Op_logico_1Context op_logico_1(int i) {
			return getRuleContext(Op_logico_1Context.class,i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			termo_logico();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OU) {
				{
				{
				setState(535);
				op_logico_1();
				setState(536);
				termo_logico();
				}
				}
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Termo_logicoContext extends ParserRuleContext {
		public List<Fator_logicoContext> fator_logico() {
			return getRuleContexts(Fator_logicoContext.class);
		}
		public Fator_logicoContext fator_logico(int i) {
			return getRuleContext(Fator_logicoContext.class,i);
		}
		public List<Op_logico_2Context> op_logico_2() {
			return getRuleContexts(Op_logico_2Context.class);
		}
		public Op_logico_2Context op_logico_2(int i) {
			return getRuleContext(Op_logico_2Context.class,i);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_termo_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			fator_logico();
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E) {
				{
				{
				setState(544);
				op_logico_2();
				setState(545);
				fator_logico();
				}
				}
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fator_logicoContext extends ParserRuleContext {
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public TerminalNode NAO() { return getToken(LinguagemAlgoritmicaParser.NAO, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitFator_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_fator_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAO) {
				{
				setState(552);
				match(NAO);
				}
			}

			setState(555);
			parcela_logica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_logicaContext extends ParserRuleContext {
		public TerminalNode VERDADEIRO() { return getToken(LinguagemAlgoritmicaParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LinguagemAlgoritmicaParser.FALSO, 0); }
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_parcela_logica);
		int _la;
		try {
			setState(559);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VERDADEIRO:
			case FALSO:
				enterOuterAlt(_localctx, 1);
				{
				setState(557);
				_la = _input.LA(1);
				if ( !(_la==VERDADEIRO || _la==FALSO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CADEIA:
			case NUM_INT:
			case NUM_REAL:
			case MENOS:
			case COMERCIAL:
			case ELEVADO:
			case IDENT:
			case ABREPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(558);
				exp_relacional();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_logico_1Context extends ParserRuleContext {
		public TerminalNode OU() { return getToken(LinguagemAlgoritmicaParser.OU, 0); }
		public Op_logico_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp_logico_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp_logico_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp_logico_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_1Context op_logico_1() throws RecognitionException {
		Op_logico_1Context _localctx = new Op_logico_1Context(_ctx, getState());
		enterRule(_localctx, 102, RULE_op_logico_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(OU);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_logico_2Context extends ParserRuleContext {
		public TerminalNode E() { return getToken(LinguagemAlgoritmicaParser.E, 0); }
		public Op_logico_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).enterOp_logico_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemAlgoritmicaListener ) ((LinguagemAlgoritmicaListener)listener).exitOp_logico_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemAlgoritmicaVisitor ) return ((LinguagemAlgoritmicaVisitor<? extends T>)visitor).visitOp_logico_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_2Context op_logico_2() throws RecognitionException {
		Op_logico_2Context _localctx = new Op_logico_2Context(_ctx, getState());
		enterRule(_localctx, 104, RULE_op_logico_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(E);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001E\u0236\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001r\b\u0001"+
		"\n\u0001\f\u0001u\t\u0001\u0001\u0002\u0001\u0002\u0003\u0002y\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003\u0088\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u008d\b\u0004\n\u0004\f\u0004\u0090\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u00a7\b\b\n\b\f\b\u00aa\t\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00b2\b\t\n\t\f\t\u00b5\t\t\u0001\n\u0001\n"+
		"\u0003\n\u00b9\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00bf"+
		"\b\f\u0001\r\u0003\r\u00c2\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00ca\b\u000f\n\u000f\f\u000f\u00cd"+
		"\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00d5\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00d9"+
		"\b\u0010\n\u0010\f\u0010\u00dc\t\u0010\u0001\u0010\u0005\u0010\u00df\b"+
		"\u0010\n\u0010\f\u0010\u00e2\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00e9\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00ef\b\u0010\n\u0010\f\u0010\u00f2"+
		"\t\u0010\u0001\u0010\u0005\u0010\u00f5\b\u0010\n\u0010\f\u0010\u00f8\t"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00fc\b\u0010\u0001\u0011\u0003"+
		"\u0011\u00ff\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0104"+
		"\b\u0011\n\u0011\f\u0011\u0107\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u010f\b\u0012\n\u0012"+
		"\f\u0012\u0112\t\u0012\u0001\u0013\u0005\u0013\u0115\b\u0013\n\u0013\f"+
		"\u0013\u0118\t\u0013\u0001\u0013\u0005\u0013\u011b\b\u0013\n\u0013\f\u0013"+
		"\u011e\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u012a\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u012f\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0134\b\u0015\u0001"+
		"\u0015\u0005\u0015\u0137\b\u0015\n\u0015\f\u0015\u013a\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u0143\b\u0016\n\u0016\f\u0016\u0146\t\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u014e"+
		"\b\u0017\n\u0017\f\u0017\u0151\t\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0155\b\u0017\n\u0017\f\u0017\u0158\t\u0017\u0003\u0017\u015a\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0164\b\u0018\n\u0018\f\u0018\u0167"+
		"\t\u0018\u0003\u0018\u0169\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0175\b\u0019\n\u0019\f\u0019\u0178\t\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u0180\b\u001a\n\u001a\f\u001a\u0183\t\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u0189\b\u001b\n\u001b\f\u001b\u018c"+
		"\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0003\u001c\u0192"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u019d\b\u001d\n"+
		"\u001d\f\u001d\u01a0\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0005\u001f\u01a8\b\u001f\n\u001f\f\u001f"+
		"\u01ab\t\u001f\u0001 \u0001 \u0001 \u0005 \u01b0\b \n \f \u01b3\t \u0001"+
		"!\u0001!\u0001!\u0005!\u01b8\b!\n!\f!\u01bb\t!\u0001\"\u0003\"\u01be\b"+
		"\"\u0001\"\u0001\"\u0001\"\u0003\"\u01c3\b\"\u0001\"\u0003\"\u01c6\b\""+
		"\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0005$\u01ce\b$\n$\f$\u01d1"+
		"\t$\u0001%\u0001%\u0001%\u0001%\u0005%\u01d7\b%\n%\f%\u01da\t%\u0001&"+
		"\u0001&\u0001&\u0001&\u0005&\u01e0\b&\n&\f&\u01e3\t&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0003*\u01ec\b*\u0001*\u0001*\u0003*\u01f0"+
		"\b*\u0001+\u0003+\u01f3\b+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0005"+
		"+\u01fb\b+\n+\f+\u01fe\t+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0003+\u0208\b+\u0001,\u0001,\u0001,\u0003,\u020d\b,\u0001-\u0001"+
		"-\u0001-\u0001-\u0003-\u0213\b-\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"/\u0005/\u021b\b/\n/\f/\u021e\t/\u00010\u00010\u00010\u00010\u00050\u0224"+
		"\b0\n0\f0\u0227\t0\u00011\u00031\u022a\b1\u00011\u00011\u00012\u00012"+
		"\u00032\u0230\b2\u00013\u00013\u00014\u00014\u00014\u0000\u00005\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfh\u0000\u0006\u0003\u0000"+
		"\u0002\u0002\u0005\u0006\"\"\u0003\u0000\n\n\f\r9:\u0001\u0000\u000e\u000f"+
		"\u0001\u0000\u0010\u0011\u0001\u0000\u0019\u001e\u0001\u00009:\u0245\u0000"+
		"j\u0001\u0000\u0000\u0000\u0002s\u0001\u0000\u0000\u0000\u0004x\u0001"+
		"\u0000\u0000\u0000\u0006\u0087\u0001\u0000\u0000\u0000\b\u0089\u0001\u0000"+
		"\u0000\u0000\n\u0094\u0001\u0000\u0000\u0000\f\u009b\u0001\u0000\u0000"+
		"\u0000\u000e\u00a0\u0001\u0000\u0000\u0000\u0010\u00a3\u0001\u0000\u0000"+
		"\u0000\u0012\u00b3\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000"+
		"\u0000\u0016\u00ba\u0001\u0000\u0000\u0000\u0018\u00be\u0001\u0000\u0000"+
		"\u0000\u001a\u00c1\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000\u0000"+
		"\u0000\u001e\u00c7\u0001\u0000\u0000\u0000 \u00fb\u0001\u0000\u0000\u0000"+
		"\"\u00fe\u0001\u0000\u0000\u0000$\u010b\u0001\u0000\u0000\u0000&\u0116"+
		"\u0001\u0000\u0000\u0000(\u0129\u0001\u0000\u0000\u0000*\u012b\u0001\u0000"+
		"\u0000\u0000,\u013d\u0001\u0000\u0000\u0000.\u0149\u0001\u0000\u0000\u0000"+
		"0\u015d\u0001\u0000\u0000\u00002\u016c\u0001\u0000\u0000\u00004\u017b"+
		"\u0001\u0000\u0000\u00006\u0186\u0001\u0000\u0000\u00008\u0191\u0001\u0000"+
		"\u0000\u0000:\u0197\u0001\u0000\u0000\u0000<\u01a3\u0001\u0000\u0000\u0000"+
		">\u01a9\u0001\u0000\u0000\u0000@\u01ac\u0001\u0000\u0000\u0000B\u01b4"+
		"\u0001\u0000\u0000\u0000D\u01bd\u0001\u0000\u0000\u0000F\u01c7\u0001\u0000"+
		"\u0000\u0000H\u01c9\u0001\u0000\u0000\u0000J\u01d2\u0001\u0000\u0000\u0000"+
		"L\u01db\u0001\u0000\u0000\u0000N\u01e4\u0001\u0000\u0000\u0000P\u01e6"+
		"\u0001\u0000\u0000\u0000R\u01e8\u0001\u0000\u0000\u0000T\u01ef\u0001\u0000"+
		"\u0000\u0000V\u0207\u0001\u0000\u0000\u0000X\u020c\u0001\u0000\u0000\u0000"+
		"Z\u020e\u0001\u0000\u0000\u0000\\\u0214\u0001\u0000\u0000\u0000^\u0216"+
		"\u0001\u0000\u0000\u0000`\u021f\u0001\u0000\u0000\u0000b\u0229\u0001\u0000"+
		"\u0000\u0000d\u022f\u0001\u0000\u0000\u0000f\u0231\u0001\u0000\u0000\u0000"+
		"h\u0233\u0001\u0000\u0000\u0000jk\u0003\u0002\u0001\u0000kl\u0005\u0003"+
		"\u0000\u0000lm\u0003&\u0013\u0000mn\u0005\t\u0000\u0000no\u0005\u0000"+
		"\u0000\u0001o\u0001\u0001\u0000\u0000\u0000pr\u0003\u0004\u0002\u0000"+
		"qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000t\u0003\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000vy\u0003\u0006\u0003\u0000wy\u0003 \u0010\u0000xv\u0001"+
		"\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\u0005\u0001\u0000\u0000"+
		"\u0000z{\u0005\u0004\u0000\u0000{\u0088\u0003\b\u0004\u0000|}\u00058\u0000"+
		"\u0000}~\u0005>\u0000\u0000~\u007f\u0005@\u0000\u0000\u007f\u0080\u0003"+
		"\u0016\u000b\u0000\u0080\u0081\u0005\u0019\u0000\u0000\u0081\u0082\u0003"+
		"\u001c\u000e\u0000\u0082\u0088\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"6\u0000\u0000\u0084\u0085\u0005>\u0000\u0000\u0085\u0086\u0005@\u0000"+
		"\u0000\u0086\u0088\u0003\u0014\n\u0000\u0087z\u0001\u0000\u0000\u0000"+
		"\u0087|\u0001\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0088"+
		"\u0007\u0001\u0000\u0000\u0000\u0089\u008e\u0003\u0010\b\u0000\u008a\u008b"+
		"\u0005\u000b\u0000\u0000\u008b\u008d\u0003\u0010\b\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001"+
		"\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005"+
		"@\u0000\u0000\u0092\u0093\u0003\u0014\n\u0000\u0093\t\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u00058\u0000\u0000\u0095\u0096\u0005>\u0000\u0000\u0096"+
		"\u0097\u0005@\u0000\u0000\u0097\u0098\u0003\u0016\u000b\u0000\u0098\u0099"+
		"\u0005\u0019\u0000\u0000\u0099\u009a\u0003\u001c\u000e\u0000\u009a\u000b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u00056\u0000\u0000\u009c\u009d\u0005"+
		">\u0000\u0000\u009d\u009e\u0005@\u0000\u0000\u009e\u009f\u0003\u0014\n"+
		"\u0000\u009f\r\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0004\u0000\u0000"+
		"\u00a1\u00a2\u0003\b\u0004\u0000\u00a2\u000f\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a8\u0005>\u0000\u0000\u00a4\u00a5\u0005\u0018\u0000\u0000\u00a5\u00a7"+
		"\u0005>\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0003\u0012\t\u0000\u00ac\u0011\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005A\u0000\u0000\u00ae\u00af\u0003H$\u0000"+
		"\u00af\u00b0\u0005B\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1"+
		"\u00ad\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u0013\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b9\u0003\u001e\u000f\u0000\u00b7\u00b9\u0003\u001a\r\u0000\u00b8\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u0015"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0007\u0000\u0000\u0000\u00bb\u0017"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bf\u0003\u0016\u000b\u0000\u00bd\u00bf"+
		"\u0005>\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bf\u0019\u0001\u0000\u0000\u0000\u00c0\u00c2\u0005"+
		"\u0015\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003"+
		"\u0018\f\u0000\u00c4\u001b\u0001\u0000\u0000\u0000\u00c5\u00c6\u0007\u0001"+
		"\u0000\u0000\u00c6\u001d\u0001\u0000\u0000\u0000\u00c7\u00cb\u0005\u0016"+
		"\u0000\u0000\u00c8\u00ca\u0003\b\u0004\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0017\u0000"+
		"\u0000\u00cf\u001f\u0001\u0000\u0000\u0000\u00d0\u00d1\u00051\u0000\u0000"+
		"\u00d1\u00d2\u0005>\u0000\u0000\u00d2\u00d4\u0005C\u0000\u0000\u00d3\u00d5"+
		"\u0003$\u0012\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00da\u0005"+
		"D\u0000\u0000\u00d7\u00d9\u0003\u0006\u0003\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00e0\u0001\u0000"+
		"\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00df\u0003(\u0014"+
		"\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00fc\u00052\u0000\u0000\u00e4\u00e5\u00053\u0000\u0000\u00e5"+
		"\u00e6\u0005>\u0000\u0000\u00e6\u00e8\u0005C\u0000\u0000\u00e7\u00e9\u0003"+
		"$\u0012\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005D\u0000"+
		"\u0000\u00eb\u00ec\u0005@\u0000\u0000\u00ec\u00f0\u0003\u001a\r\u0000"+
		"\u00ed\u00ef\u0003\u0006\u0003\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f5\u0003(\u0014\u0000\u00f4"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u00055\u0000\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000\u00fb\u00d0"+
		"\u0001\u0000\u0000\u0000\u00fb\u00e4\u0001\u0000\u0000\u0000\u00fc!\u0001"+
		"\u0000\u0000\u0000\u00fd\u00ff\u00057\u0000\u0000\u00fe\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000"+
		"\u0000\u0000\u0100\u0105\u0003\u0010\b\u0000\u0101\u0102\u0005\u000b\u0000"+
		"\u0000\u0102\u0104\u0003\u0010\b\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0108\u0001\u0000\u0000\u0000"+
		"\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0109\u0005@\u0000\u0000\u0109"+
		"\u010a\u0003\u001a\r\u0000\u010a#\u0001\u0000\u0000\u0000\u010b\u0110"+
		"\u0003\"\u0011\u0000\u010c\u010d\u0005\u000b\u0000\u0000\u010d\u010f\u0003"+
		"\"\u0011\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000"+
		"\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000"+
		"\u0000\u0000\u0111%\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000"+
		"\u0000\u0113\u0115\u0003\u0006\u0003\u0000\u0114\u0113\u0001\u0000\u0000"+
		"\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u011c\u0001\u0000\u0000"+
		"\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011b\u0003(\u0014\u0000"+
		"\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000"+
		"\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000"+
		"\u011d\'\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f"+
		"\u012a\u0003*\u0015\u0000\u0120\u012a\u0003,\u0016\u0000\u0121\u012a\u0003"+
		".\u0017\u0000\u0122\u012a\u00030\u0018\u0000\u0123\u012a\u00032\u0019"+
		"\u0000\u0124\u012a\u00034\u001a\u0000\u0125\u012a\u00036\u001b\u0000\u0126"+
		"\u012a\u00038\u001c\u0000\u0127\u012a\u0003:\u001d\u0000\u0128\u012a\u0003"+
		"<\u001e\u0000\u0129\u011f\u0001\u0000\u0000\u0000\u0129\u0120\u0001\u0000"+
		"\u0000\u0000\u0129\u0121\u0001\u0000\u0000\u0000\u0129\u0122\u0001\u0000"+
		"\u0000\u0000\u0129\u0123\u0001\u0000\u0000\u0000\u0129\u0124\u0001\u0000"+
		"\u0000\u0000\u0129\u0125\u0001\u0000\u0000\u0000\u0129\u0126\u0001\u0000"+
		"\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u0128\u0001\u0000"+
		"\u0000\u0000\u012a)\u0001\u0000\u0000\u0000\u012b\u012c\u0005\u0007\u0000"+
		"\u0000\u012c\u012e\u0005C\u0000\u0000\u012d\u012f\u0005\u0015\u0000\u0000"+
		"\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000"+
		"\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0138\u0003\u0010\b\u0000\u0131"+
		"\u0133\u0005\u000b\u0000\u0000\u0132\u0134\u0005\u0015\u0000\u0000\u0133"+
		"\u0132\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0003\u0010\b\u0000\u0136\u0131"+
		"\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b"+
		"\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0005D\u0000\u0000\u013c+\u0001\u0000\u0000\u0000\u013d\u013e\u0005\b"+
		"\u0000\u0000\u013e\u013f\u0005C\u0000\u0000\u013f\u0144\u0003^/\u0000"+
		"\u0140\u0141\u0005\u000b\u0000\u0000\u0141\u0143\u0003^/\u0000\u0142\u0140"+
		"\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000\u0144\u0142"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0147"+
		"\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0005D\u0000\u0000\u0148-\u0001\u0000\u0000\u0000\u0149\u014a\u0005#"+
		"\u0000\u0000\u014a\u014b\u0003^/\u0000\u014b\u014f\u0005$\u0000\u0000"+
		"\u014c\u014e\u0003(\u0014\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014e"+
		"\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0001\u0000\u0000\u0000\u0150\u0159\u0001\u0000\u0000\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0152\u0156\u0005%\u0000\u0000\u0153\u0155"+
		"\u0003(\u0014\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0155\u0158\u0001"+
		"\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001"+
		"\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001"+
		"\u0000\u0000\u0000\u0159\u0152\u0001\u0000\u0000\u0000\u0159\u015a\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c\u0005"+
		"&\u0000\u0000\u015c/\u0001\u0000\u0000\u0000\u015d\u015e\u0005\'\u0000"+
		"\u0000\u015e\u015f\u0003H$\u0000\u015f\u0160\u0005(\u0000\u0000\u0160"+
		"\u0168\u0003>\u001f\u0000\u0161\u0165\u0005%\u0000\u0000\u0162\u0164\u0003"+
		"(\u0014\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0164\u0167\u0001\u0000"+
		"\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000"+
		"\u0000\u0000\u0166\u0169\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000"+
		"\u0000\u0000\u0168\u0161\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016b\u0005)\u0000"+
		"\u0000\u016b1\u0001\u0000\u0000\u0000\u016c\u016d\u0005+\u0000\u0000\u016d"+
		"\u016e\u0005>\u0000\u0000\u016e\u016f\u0005\u0012\u0000\u0000\u016f\u0170"+
		"\u0003H$\u0000\u0170\u0171\u0005,\u0000\u0000\u0171\u0172\u0003H$\u0000"+
		"\u0172\u0176\u0005-\u0000\u0000\u0173\u0175\u0003(\u0014\u0000\u0174\u0173"+
		"\u0001\u0000\u0000\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174"+
		"\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0179"+
		"\u0001\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017a"+
		"\u0005.\u0000\u0000\u017a3\u0001\u0000\u0000\u0000\u017b\u017c\u0005/"+
		"\u0000\u0000\u017c\u017d\u0003^/\u0000\u017d\u0181\u0005-\u0000\u0000"+
		"\u017e\u0180\u0003(\u0014\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u0180"+
		"\u0183\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0001\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0184\u0185\u00050\u0000\u0000\u01855\u0001"+
		"\u0000\u0000\u0000\u0186\u018a\u0005-\u0000\u0000\u0187\u0189\u0003(\u0014"+
		"\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0189\u018c\u0001\u0000\u0000"+
		"\u0000\u018a\u0188\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000"+
		"\u0000\u018b\u018d\u0001\u0000\u0000\u0000\u018c\u018a\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u0005,\u0000\u0000\u018e\u018f\u0003^/\u0000\u018f"+
		"7\u0001\u0000\u0000\u0000\u0190\u0192\u0005\u0015\u0000\u0000\u0191\u0190"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0193"+
		"\u0001\u0000\u0000\u0000\u0193\u0194\u0003\u0010\b\u0000\u0194\u0195\u0005"+
		"\u0012\u0000\u0000\u0195\u0196\u0003^/\u0000\u01969\u0001\u0000\u0000"+
		"\u0000\u0197\u0198\u0005>\u0000\u0000\u0198\u0199\u0005C\u0000\u0000\u0199"+
		"\u019e\u0003^/\u0000\u019a\u019b\u0005\u000b\u0000\u0000\u019b\u019d\u0003"+
		"^/\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000\u0000"+
		"\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000"+
		"\u0000\u019f\u01a1\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0005D\u0000\u0000\u01a2;\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a4\u00054\u0000\u0000\u01a4\u01a5\u0003^/\u0000\u01a5=\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a8\u0003@ \u0000\u01a7\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a8\u01ab\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa?\u0001\u0000\u0000\u0000\u01ab"+
		"\u01a9\u0001\u0000\u0000\u0000\u01ac\u01ad\u0003B!\u0000\u01ad\u01b1\u0005"+
		"@\u0000\u0000\u01ae\u01b0\u0003(\u0014\u0000\u01af\u01ae\u0001\u0000\u0000"+
		"\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2A\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b9\u0003D\"\u0000\u01b5"+
		"\u01b6\u0005\u000b\u0000\u0000\u01b6\u01b8\u0003D\"\u0000\u01b7\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01baC\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bc\u01be\u0003"+
		"F#\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000"+
		"\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c5\u0005\f\u0000\u0000"+
		"\u01c0\u01c2\u0005*\u0000\u0000\u01c1\u01c3\u0003F#\u0000\u01c2\u01c1"+
		"\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4"+
		"\u0001\u0000\u0000\u0000\u01c4\u01c6\u0005\f\u0000\u0000\u01c5\u01c0\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6E\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c8\u0005\u000f\u0000\u0000\u01c8G\u0001\u0000\u0000"+
		"\u0000\u01c9\u01cf\u0003J%\u0000\u01ca\u01cb\u0003N\'\u0000\u01cb\u01cc"+
		"\u0003J%\u0000\u01cc\u01ce\u0001\u0000\u0000\u0000\u01cd\u01ca\u0001\u0000"+
		"\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0I\u0001\u0000\u0000"+
		"\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d8\u0003L&\u0000\u01d3"+
		"\u01d4\u0003P(\u0000\u01d4\u01d5\u0003L&\u0000\u01d5\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d3\u0001\u0000\u0000\u0000\u01d7\u01da\u0001\u0000"+
		"\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000"+
		"\u0000\u0000\u01d9K\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000\u0000"+
		"\u0000\u01db\u01e1\u0003T*\u0000\u01dc\u01dd\u0003R)\u0000\u01dd\u01de"+
		"\u0003T*\u0000\u01de\u01e0\u0001\u0000\u0000\u0000\u01df\u01dc\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2M\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4\u01e5\u0007\u0002\u0000"+
		"\u0000\u01e5O\u0001\u0000\u0000\u0000\u01e6\u01e7\u0007\u0003\u0000\u0000"+
		"\u01e7Q\u0001\u0000\u0000\u0000\u01e8\u01e9\u0005\u0013\u0000\u0000\u01e9"+
		"S\u0001\u0000\u0000\u0000\u01ea\u01ec\u0003F#\u0000\u01eb\u01ea\u0001"+
		"\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001"+
		"\u0000\u0000\u0000\u01ed\u01f0\u0003V+\u0000\u01ee\u01f0\u0003X,\u0000"+
		"\u01ef\u01eb\u0001\u0000\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000"+
		"\u01f0U\u0001\u0000\u0000\u0000\u01f1\u01f3\u0005\u0015\u0000\u0000\u01f2"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f4\u0001\u0000\u0000\u0000\u01f4\u0208\u0003\u0010\b\u0000\u01f5\u01f6"+
		"\u0005>\u0000\u0000\u01f6\u01f7\u0005C\u0000\u0000\u01f7\u01fc\u0003^"+
		"/\u0000\u01f8\u01f9\u0005\u000b\u0000\u0000\u01f9\u01fb\u0003^/\u0000"+
		"\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000"+
		"\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000"+
		"\u01fd\u01ff\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000"+
		"\u01ff\u0200\u0005D\u0000\u0000\u0200\u0208\u0001\u0000\u0000\u0000\u0201"+
		"\u0208\u0005\f\u0000\u0000\u0202\u0208\u0005\r\u0000\u0000\u0203\u0204"+
		"\u0005C\u0000\u0000\u0204\u0205\u0003^/\u0000\u0205\u0206\u0005D\u0000"+
		"\u0000\u0206\u0208\u0001\u0000\u0000\u0000\u0207\u01f2\u0001\u0000\u0000"+
		"\u0000\u0207\u01f5\u0001\u0000\u0000\u0000\u0207\u0201\u0001\u0000\u0000"+
		"\u0000\u0207\u0202\u0001\u0000\u0000\u0000\u0207\u0203\u0001\u0000\u0000"+
		"\u0000\u0208W\u0001\u0000\u0000\u0000\u0209\u020a\u0005\u0014\u0000\u0000"+
		"\u020a\u020d\u0003\u0010\b\u0000\u020b\u020d\u0005\n\u0000\u0000\u020c"+
		"\u0209\u0001\u0000\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020d"+
		"Y\u0001\u0000\u0000\u0000\u020e\u0212\u0003H$\u0000\u020f\u0210\u0003"+
		"\\.\u0000\u0210\u0211\u0003H$\u0000\u0211\u0213\u0001\u0000\u0000\u0000"+
		"\u0212\u020f\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000"+
		"\u0213[\u0001\u0000\u0000\u0000\u0214\u0215\u0007\u0004\u0000\u0000\u0215"+
		"]\u0001\u0000\u0000\u0000\u0216\u021c\u0003`0\u0000\u0217\u0218\u0003"+
		"f3\u0000\u0218\u0219\u0003`0\u0000\u0219\u021b\u0001\u0000\u0000\u0000"+
		"\u021a\u0217\u0001\u0000\u0000\u0000\u021b\u021e\u0001\u0000\u0000\u0000"+
		"\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000"+
		"\u021d_\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021f"+
		"\u0225\u0003b1\u0000\u0220\u0221\u0003h4\u0000\u0221\u0222\u0003b1\u0000"+
		"\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0220\u0001\u0000\u0000\u0000"+
		"\u0224\u0227\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000"+
		"\u0225\u0226\u0001\u0000\u0000\u0000\u0226a\u0001\u0000\u0000\u0000\u0227"+
		"\u0225\u0001\u0000\u0000\u0000\u0228\u022a\u0005 \u0000\u0000\u0229\u0228"+
		"\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022b"+
		"\u0001\u0000\u0000\u0000\u022b\u022c\u0003d2\u0000\u022cc\u0001\u0000"+
		"\u0000\u0000\u022d\u0230\u0007\u0005\u0000\u0000\u022e\u0230\u0003Z-\u0000"+
		"\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u022e\u0001\u0000\u0000\u0000"+
		"\u0230e\u0001\u0000\u0000\u0000\u0231\u0232\u0005!\u0000\u0000\u0232g"+
		"\u0001\u0000\u0000\u0000\u0233\u0234\u0005\u001f\u0000\u0000\u0234i\u0001"+
		"\u0000\u0000\u00009sx\u0087\u008e\u00a8\u00b3\u00b8\u00be\u00c1\u00cb"+
		"\u00d4\u00da\u00e0\u00e8\u00f0\u00f6\u00fb\u00fe\u0105\u0110\u0116\u011c"+
		"\u0129\u012e\u0133\u0138\u0144\u014f\u0156\u0159\u0165\u0168\u0176\u0181"+
		"\u018a\u0191\u019e\u01a9\u01b1\u01b9\u01bd\u01c2\u01c5\u01cf\u01d8\u01e1"+
		"\u01eb\u01ef\u01f2\u01fc\u0207\u020c\u0212\u021c\u0225\u0229\u022f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}