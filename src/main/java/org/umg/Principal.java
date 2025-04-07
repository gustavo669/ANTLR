package org.umg;

import org.umg.arbol.Nodo;
import org.umg.sintactico.Parser;
import org.umg.lexico.AnalizadorLexico;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final String EJEMPLO_CODIGO = """
      titan (Gustavo + 5) {
                   orden "Hola Mundo";
               }
    """;

    public static void main(String[] args) {
        System.out.println("\n===== COMPILADOR TITAN =====\n");

        Scanner scanner = new Scanner(System.in);
        String codigo = obtenerCodigo(scanner);

        System.out.println("\nIniciando análisis del código...\n");

        // 1. Análisis Léxico
        AnalizadorLexico analizador = new AnalizadorLexico();
        List<Token> tokens = analizador.analizar(codigo);

        mostrarResultadosLexicos(tokens);

        // 2. Análisis Sintáctico
        try {
            Parser parser = new Parser(tokens);
            Nodo arbol = parser.parse();
            mostrarResultadosSintacticos(arbol);

            EntornoEjecucion entorno = new EntornoEjecucion();

            ejecutarPrograma(arbol, entorno);

        } catch (Exception e) {
            System.err.println("\nError durante el análisis o ejecución:");
            e.printStackTrace();
        }

        if (codigo.equals(EJEMPLO_CODIGO)) {
            System.out.println("\nPresione Enter para salir...");
            scanner.nextLine();
        }
    }

    private static String obtenerCodigo(Scanner scanner) {
        String codigo = EJEMPLO_CODIGO;
        boolean modoInteractivo = false;

        System.out.println("¿Desea usar el código de ejemplo o ingresar su propio código?");
        System.out.println("1. Usar ejemplo");
        System.out.println("2. Ingresar código propio");
        System.out.print("Seleccione una opción (1-2): ");

        String opcion = scanner.nextLine();
        if (opcion.equals("2")) {
            modoInteractivo = true;
            System.out.println("\nIngrese su código (termine con una línea vacía):");
            StringBuilder sb = new StringBuilder();
            String linea;
            while (!(linea = scanner.nextLine()).isEmpty()) {
                sb.append(linea).append("\n");
            }
            codigo = sb.toString();
        }

        return codigo;
    }

    private static void mostrarResultadosLexicos(List<Token> tokens) {
        System.out.println("TOKENS DETECTADOS");
        System.out.printf("%-20s %-30s %s\n", "VALOR", "TIPO", "LÍNEA");
        System.out.println("---------------------------------------------------");

        tokens.forEach(token ->
                System.out.printf("%-20s %-30s %d\n",
                        truncar(token.getValor(), 18),
                        token.getTipo(),
                        token.getLinea())
        );
    }

    private static void mostrarResultadosSintacticos(Nodo arbol) {
        System.out.println("\nÁRBOL DE DERIVACIÓN");
        if (arbol != null) {
            arbol.imprimirArbol();
        } else {
            System.out.println("No se pudo generar el árbol de derivación");
        }
    }

    private static void ejecutarPrograma(Nodo arbol, EntornoEjecucion entorno) {
        System.out.println("\n===== EJECUTANDO PROGRAMA =====");
        Evaluador evaluador = new Evaluador(entorno); // Pasa el entorno al evaluador
        Object resultado = evaluador.evaluar(arbol); // Evaluar el árbol

        if (resultado != null) {
            System.out.println("\nResultado final: " + resultado);
        }

        System.out.println("\n===== EJECUCIÓN COMPLETADA =====");
    }

    private static String truncar(String valor, int maxLength) {
        return valor.length() > maxLength ? valor.substring(0, maxLength) + "..." : valor;
    }
}
