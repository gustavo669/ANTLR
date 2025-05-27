// Generated from C:/Users/barre/IdeaProjects/ANTLR/src/main/java/org/umg/gramatica/ParserGrammar.g4 by ANTLR 4.13.2
package org.umg.gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ParserGrammar extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TITAN=1, LEGION=2, ORDEN=3, ATAQUE=4, HUMANIDAD=5, MURO=6, RECONOCER=7, 
		TROPAS=8, MUL=9, DIV=10, ADD=11, SUB=12, MOD=13, PUNTAZOS=14, RETIRADA=15, 
		MAYOR_QUE=16, MENOR_QUE=17, IGUALDAD=18, DESIGUALDAD=19, MAYOR_IGUAL=20, 
		MENOR_IGUAL=21, LPAREN=22, RPAREN=23, LBRACE=24, RBRACE=25, SEMI=26, COMA=27, 
		PUNTO=28, ASIGNACION=29, NUMERO=30, GRITO=31, ID=32, INFORME=33, INFORME_SECRETO=34, 
		ESPACIOS=35;
	public static final int
		RULE_programa = 0, RULE_declaracion = 1, RULE_asignacion = 2, RULE_estructuraTitan = 3, 
		RULE_estructuraAtaque = 4, RULE_estructuraMuro = 5, RULE_sentenciaOrden = 6, 
		RULE_bloque = 7, RULE_expresion = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracion", "asignacion", "estructuraTitan", "estructuraAtaque", 
			"estructuraMuro", "sentenciaOrden", "bloque", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'titan'", "'legion'", "'orden'", "'ataque'", "'humanidad'", "'muro'", 
			"'reconocer'", "'tropas'", "'*'", "'/'", "'+'", "'-'", "'%'", "'++'", 
			"'--'", "'>'", "'<'", "'=='", "'!='", "'>='", "'<='", "'('", "')'", "'{'", 
			"'}'", "';'", "','", "'.'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TITAN", "LEGION", "ORDEN", "ATAQUE", "HUMANIDAD", "MURO", "RECONOCER", 
			"TROPAS", "MUL", "DIV", "ADD", "SUB", "MOD", "PUNTAZOS", "RETIRADA", 
			"MAYOR_QUE", "MENOR_QUE", "IGUALDAD", "DESIGUALDAD", "MAYOR_IGUAL", "MENOR_IGUAL", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "COMA", "PUNTO", "ASIGNACION", 
			"NUMERO", "GRITO", "ID", "INFORME", "INFORME_SECRETO", "ESPACIOS"
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
	public String getGrammarFileName() { return "ParserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserGrammar(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ParserGrammar.EOF, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7520387162L) != 0)) {
				{
				{
				setState(18);
				declaracion();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public EstructuraTitanContext estructuraTitan() {
			return getRuleContext(EstructuraTitanContext.class,0);
		}
		public EstructuraAtaqueContext estructuraAtaque() {
			return getRuleContext(EstructuraAtaqueContext.class,0);
		}
		public EstructuraMuroContext estructuraMuro() {
			return getRuleContext(EstructuraMuroContext.class,0);
		}
		public SentenciaOrdenContext sentenciaOrden() {
			return getRuleContext(SentenciaOrdenContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ParserGrammar.SEMI, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracion);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				estructuraTitan();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				estructuraAtaque();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				estructuraMuro();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				sentenciaOrden();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(30);
				asignacion();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(31);
				expresion(0);
				setState(32);
				match(SEMI);
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
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ParserGrammar.ID, 0); }
		public TerminalNode ASIGNACION() { return getToken(ParserGrammar.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ParserGrammar.SEMI, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ID);
			setState(37);
			match(ASIGNACION);
			setState(38);
			expresion(0);
			setState(39);
			match(SEMI);
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
	public static class EstructuraTitanContext extends ParserRuleContext {
		public TerminalNode TITAN() { return getToken(ParserGrammar.TITAN, 0); }
		public TerminalNode LPAREN() { return getToken(ParserGrammar.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ParserGrammar.RPAREN, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode LEGION() { return getToken(ParserGrammar.LEGION, 0); }
		public EstructuraTitanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructuraTitan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterEstructuraTitan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitEstructuraTitan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitEstructuraTitan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstructuraTitanContext estructuraTitan() throws RecognitionException {
		EstructuraTitanContext _localctx = new EstructuraTitanContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_estructuraTitan);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(TITAN);
			setState(42);
			match(LPAREN);
			setState(43);
			expresion(0);
			setState(44);
			match(RPAREN);
			setState(45);
			bloque();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEGION) {
				{
				setState(46);
				match(LEGION);
				setState(47);
				bloque();
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
	public static class EstructuraAtaqueContext extends ParserRuleContext {
		public TerminalNode ATAQUE() { return getToken(ParserGrammar.ATAQUE, 0); }
		public TerminalNode LPAREN() { return getToken(ParserGrammar.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ParserGrammar.RPAREN, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public EstructuraAtaqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructuraAtaque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterEstructuraAtaque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitEstructuraAtaque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitEstructuraAtaque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstructuraAtaqueContext estructuraAtaque() throws RecognitionException {
		EstructuraAtaqueContext _localctx = new EstructuraAtaqueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_estructuraAtaque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ATAQUE);
			setState(51);
			match(LPAREN);
			setState(52);
			expresion(0);
			setState(53);
			match(RPAREN);
			setState(54);
			bloque();
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
	public static class EstructuraMuroContext extends ParserRuleContext {
		public TerminalNode MURO() { return getToken(ParserGrammar.MURO, 0); }
		public TerminalNode LPAREN() { return getToken(ParserGrammar.LPAREN, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ParserGrammar.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ParserGrammar.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(ParserGrammar.RPAREN, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public EstructuraMuroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructuraMuro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterEstructuraMuro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitEstructuraMuro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitEstructuraMuro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstructuraMuroContext estructuraMuro() throws RecognitionException {
		EstructuraMuroContext _localctx = new EstructuraMuroContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_estructuraMuro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(MURO);
			setState(57);
			match(LPAREN);
			setState(58);
			expresion(0);
			setState(59);
			match(SEMI);
			setState(60);
			expresion(0);
			setState(61);
			match(SEMI);
			setState(62);
			expresion(0);
			setState(63);
			match(RPAREN);
			setState(64);
			bloque();
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
	public static class SentenciaOrdenContext extends ParserRuleContext {
		public TerminalNode ORDEN() { return getToken(ParserGrammar.ORDEN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ParserGrammar.SEMI, 0); }
		public SentenciaOrdenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaOrden; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterSentenciaOrden(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitSentenciaOrden(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitSentenciaOrden(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaOrdenContext sentenciaOrden() throws RecognitionException {
		SentenciaOrdenContext _localctx = new SentenciaOrdenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentenciaOrden);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ORDEN);
			setState(67);
			expresion(0);
			setState(68);
			match(SEMI);
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
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ParserGrammar.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ParserGrammar.RBRACE, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(LBRACE);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7520387162L) != 0)) {
				{
				{
				setState(71);
				declaracion();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(RBRACE);
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
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentesisContext extends ExpresionContext {
		public TerminalNode LPAREN() { return getToken(ParserGrammar.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ParserGrammar.RPAREN, 0); }
		public ExprParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSumaContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ParserGrammar.ADD, 0); }
		public TerminalNode SUB() { return getToken(ParserGrammar.SUB, 0); }
		public ExprSumaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprSuma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprSuma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprSuma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStringContext extends ExpresionContext {
		public TerminalNode GRITO() { return getToken(ParserGrammar.GRITO, 0); }
		public ExprStringContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNumeroContext extends ExpresionContext {
		public TerminalNode NUMERO() { return getToken(ParserGrammar.NUMERO, 0); }
		public ExprNumeroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprNumero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprNumero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultiplicacionContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ParserGrammar.MUL, 0); }
		public TerminalNode DIV() { return getToken(ParserGrammar.DIV, 0); }
		public ExprMultiplicacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprMultiplicacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprMultiplicacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprMultiplicacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprComparacionContext extends ExpresionContext {
		public Token op;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR_QUE() { return getToken(ParserGrammar.MAYOR_QUE, 0); }
		public TerminalNode MENOR_QUE() { return getToken(ParserGrammar.MENOR_QUE, 0); }
		public TerminalNode IGUALDAD() { return getToken(ParserGrammar.IGUALDAD, 0); }
		public TerminalNode DESIGUALDAD() { return getToken(ParserGrammar.DESIGUALDAD, 0); }
		public ExprComparacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprComparacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVariableContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(ParserGrammar.ID, 0); }
		public ExprVariableContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).enterExprVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserGrammarListener ) ((ParserGrammarListener)listener).exitExprVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserGrammarVisitor ) return ((ParserGrammarVisitor<? extends T>)visitor).visitExprVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ExprParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80);
				match(LPAREN);
				setState(81);
				expresion(0);
				setState(82);
				match(RPAREN);
				}
				break;
			case NUMERO:
				{
				_localctx = new ExprNumeroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(NUMERO);
				}
				break;
			case GRITO:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(GRITO);
				}
				break;
			case ID:
				{
				_localctx = new ExprVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(98);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(89);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(90);
						((ExprMultiplicacionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ExprMultiplicacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						expresion(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprSumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(92);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(93);
						((ExprSumaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprSumaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expresion(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprComparacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(95);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(96);
						((ExprComparacionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
							((ExprComparacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expresion(6);
						}
						break;
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#h\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00031\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0005\u0007I\b\u0007\n\u0007\f\u0007L\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\bX\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\bc\b\b\n\b\f\bf\t\b\u0001\b\u0000\u0001\u0010\t\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0003\u0001\u0000\t\n\u0001"+
		"\u0000\u000b\f\u0001\u0000\u0010\u0013l\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000"+
		"\u0006)\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000\n8\u0001\u0000"+
		"\u0000\u0000\fB\u0001\u0000\u0000\u0000\u000eF\u0001\u0000\u0000\u0000"+
		"\u0010W\u0001\u0000\u0000\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013"+
		"\u0012\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015"+
		"\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016"+
		"\u0018\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0000\u0000\u0001\u0019\u0001\u0001\u0000\u0000\u0000\u001a"+
		"#\u0003\u0006\u0003\u0000\u001b#\u0003\b\u0004\u0000\u001c#\u0003\n\u0005"+
		"\u0000\u001d#\u0003\f\u0006\u0000\u001e#\u0003\u0004\u0002\u0000\u001f"+
		" \u0003\u0010\b\u0000 !\u0005\u001a\u0000\u0000!#\u0001\u0000\u0000\u0000"+
		"\"\u001a\u0001\u0000\u0000\u0000\"\u001b\u0001\u0000\u0000\u0000\"\u001c"+
		"\u0001\u0000\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000\"\u001e\u0001"+
		"\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000#\u0003\u0001\u0000"+
		"\u0000\u0000$%\u0005 \u0000\u0000%&\u0005\u001d\u0000\u0000&\'\u0003\u0010"+
		"\b\u0000\'(\u0005\u001a\u0000\u0000(\u0005\u0001\u0000\u0000\u0000)*\u0005"+
		"\u0001\u0000\u0000*+\u0005\u0016\u0000\u0000+,\u0003\u0010\b\u0000,-\u0005"+
		"\u0017\u0000\u0000-0\u0003\u000e\u0007\u0000./\u0005\u0002\u0000\u0000"+
		"/1\u0003\u000e\u0007\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u00001\u0007\u0001\u0000\u0000\u000023\u0005\u0004\u0000\u000034\u0005"+
		"\u0016\u0000\u000045\u0003\u0010\b\u000056\u0005\u0017\u0000\u000067\u0003"+
		"\u000e\u0007\u00007\t\u0001\u0000\u0000\u000089\u0005\u0006\u0000\u0000"+
		"9:\u0005\u0016\u0000\u0000:;\u0003\u0010\b\u0000;<\u0005\u001a\u0000\u0000"+
		"<=\u0003\u0010\b\u0000=>\u0005\u001a\u0000\u0000>?\u0003\u0010\b\u0000"+
		"?@\u0005\u0017\u0000\u0000@A\u0003\u000e\u0007\u0000A\u000b\u0001\u0000"+
		"\u0000\u0000BC\u0005\u0003\u0000\u0000CD\u0003\u0010\b\u0000DE\u0005\u001a"+
		"\u0000\u0000E\r\u0001\u0000\u0000\u0000FJ\u0005\u0018\u0000\u0000GI\u0003"+
		"\u0002\u0001\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000"+
		"JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\u0019\u0000\u0000N\u000f\u0001"+
		"\u0000\u0000\u0000OP\u0006\b\uffff\uffff\u0000PQ\u0005\u0016\u0000\u0000"+
		"QR\u0003\u0010\b\u0000RS\u0005\u0017\u0000\u0000SX\u0001\u0000\u0000\u0000"+
		"TX\u0005\u001e\u0000\u0000UX\u0005\u001f\u0000\u0000VX\u0005 \u0000\u0000"+
		"WO\u0001\u0000\u0000\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000WV\u0001\u0000\u0000\u0000Xd\u0001\u0000\u0000\u0000YZ\n\u0007\u0000"+
		"\u0000Z[\u0007\u0000\u0000\u0000[c\u0003\u0010\b\b\\]\n\u0006\u0000\u0000"+
		"]^\u0007\u0001\u0000\u0000^c\u0003\u0010\b\u0007_`\n\u0005\u0000\u0000"+
		"`a\u0007\u0002\u0000\u0000ac\u0003\u0010\b\u0006bY\u0001\u0000\u0000\u0000"+
		"b\\\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0011\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000\u0007\u0015\"0JWbd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}