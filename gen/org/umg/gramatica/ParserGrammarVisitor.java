// Generated from C:/Users/barre/IdeaProjects/ANTLR/src/main/java/org/umg/gramatica/ParserGrammar.g4 by ANTLR 4.13.2
package org.umg.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserGrammar}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ParserGrammar.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(ParserGrammar.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(ParserGrammar.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#estructuraTitan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraTitan(ParserGrammar.EstructuraTitanContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#estructuraAtaque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraAtaque(ParserGrammar.EstructuraAtaqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#estructuraMuro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraMuro(ParserGrammar.EstructuraMuroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#sentenciaOrden}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaOrden(ParserGrammar.SentenciaOrdenContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserGrammar#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(ParserGrammar.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentesis(ParserGrammar.ExprParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSuma}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSuma(ParserGrammar.ExprSumaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprString(ParserGrammar.ExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNumero}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNumero(ParserGrammar.ExprNumeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultiplicacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicacion(ParserGrammar.ExprMultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprComparacion}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComparacion(ParserGrammar.ExprComparacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVariable}
	 * labeled alternative in {@link ParserGrammar#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariable(ParserGrammar.ExprVariableContext ctx);
}