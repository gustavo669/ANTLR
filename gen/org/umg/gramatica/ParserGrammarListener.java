// Generated from C:/Users/barre/IdeaProjects/ANTLR/src/main/java/org/umg/gramatica/ParserGrammar.g4 by ANTLR 4.13.2
package org.umg.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserGrammar}.
 */
public interface ParserGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ParserGrammar.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ParserGrammar.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(ParserGrammar.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(ParserGrammar.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(ParserGrammar.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(ParserGrammar.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#estructuraTitan}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraTitan(ParserGrammar.EstructuraTitanContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#estructuraTitan}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraTitan(ParserGrammar.EstructuraTitanContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#estructuraAtaque}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraAtaque(ParserGrammar.EstructuraAtaqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#estructuraAtaque}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraAtaque(ParserGrammar.EstructuraAtaqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#estructuraMuro}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraMuro(ParserGrammar.EstructuraMuroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#estructuraMuro}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraMuro(ParserGrammar.EstructuraMuroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#sentenciaOrden}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaOrden(ParserGrammar.SentenciaOrdenContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#sentenciaOrden}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaOrden(ParserGrammar.SentenciaOrdenContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserGrammar#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(ParserGrammar.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserGrammar#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(ParserGrammar.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprParentesis(ParserGrammar.ExprParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprParentesis(ParserGrammar.ExprParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSuma}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprSuma(ParserGrammar.ExprSumaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSuma}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprSuma(ParserGrammar.ExprSumaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprString(ParserGrammar.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprString(ParserGrammar.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumero}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNumero(ParserGrammar.ExprNumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumero}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNumero(ParserGrammar.ExprNumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiplicacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicacion(ParserGrammar.ExprMultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiplicacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicacion(ParserGrammar.ExprMultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprComparacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprComparacion(ParserGrammar.ExprComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComparacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprComparacion(ParserGrammar.ExprComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprVariable(ParserGrammar.ExprVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprVariable(ParserGrammar.ExprVariableContext ctx);
}