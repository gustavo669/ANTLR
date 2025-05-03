package org.umg;

import org.umg.arbol.Nodo;
import org.umg.lexico.Token;
import org.umg.lexico.AnalizadorLexico;
import org.umg.modelo.ResultadoCompilacion;
import org.umg.modelo.TablaSimbolos;
import org.umg.sintactico.Parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del compilador temático y multi-lenguaje.
 */
public class Principal {

    private static final String EJEMPLO_CODIGO = """
     titan (45 + 5) {
         orden "¡Ataquen!";
     }
    """;

    public static void main(String[] args) {
        System.out.println("\n===== COMPILADOR TITAN / MULTI-LENGUAJE =====\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione tipo de compilador:");
        System.out.println("1. Temático Attack on Titan");
        System.out.println("2. Multi-Lenguaje (ANTLR)");
        System.out.print("Opción: ");
        String tipo = scanner.nextLine();

        String codigo = obtenerCodigo(scanner);

        if (tipo.equals("1")) {
            ejecutarTematico(codigo);
        } else {
            ejecutarMultiLenguaje(codigo);
        }

        if (codigo.equals(EJEMPLO_CODIGO)) {
            System.out.println("\nPresione Enter para salir...");
            scanner.nextLine();
        }
    }

    // === EJECUCIÓN DEL COMPILADOR TEMÁTICO ===
    private static void ejecutarTematico(String codigo) {
        System.out.println("\nIniciando análisis TEMÁTICO...\n");

        // 1. Análisis Léxico
        AnalizadorLexico analizador = new AnalizadorLexico();
        List<Token> tokens = analizador.analizar(codigo);
        mostrarResultadosLexicos(tokens);

        // 2. Análisis Sintáctico
        try {
            Parser parser = new Parser(tokens);
            Nodo arbol = parser.parse();
            mostrarArbol(arbol);

            // 3. Ejecución
            EntornoEjecucion entorno = new EntornoEjecucion();
            ejecutarPrograma(arbol, entorno);

            System.out.println("\n===== TABLA DE SÍMBOLOS =====");
            TablaSimbolos.imprimir();

        } catch (Exception e) {
            System.err.println("\nError durante el análisis o ejecución:");
            e.printStackTrace();
        }
    }

    // === EJECUCIÓN DEL COMPILADOR MULTILENGUAJE ===
    private static void ejecutarMultiLenguaje(String codigo) {
        System.out.println("\nIniciando análisis MULTI-LENGUAJE (ANTLR)...\n");

        // 1. Detectar el lenguaje
        String lenguajeDetectado = LenguajeDetector.detectarLenguaje(codigo);
        System.out.println("Lenguaje detectado: " + lenguajeDetectado);

        // 2. Analizar con el analizador general
        ResultadoCompilacion resultado = AnalizadorGeneral.analizar(codigo);

        // 3. Mostrar resultados
        System.out.println("\n===== RESULTADO DEL ANÁLISIS =====");
        System.out.println("Lenguaje: " + resultado.lenguajeDetectado);
        System.out.println("Resultado: " + resultado.resultado);
        System.out.println("Errores: " + (resultado.hayErrores ? "Sí" : "No"));
    }

    /**
     * Permite al usuario elegir entre código de ejemplo, ingresar su propio código o cargar desde un archivo.
     */
    private static String obtenerCodigo(Scanner scanner) {
        String codigo = EJEMPLO_CODIGO;

        System.out.println("\n¿Desea usar el código de ejemplo, ingresar su propio código o cargar desde un archivo?");
        System.out.println("1. Usar ejemplo");
        System.out.println("2. Ingresar código propio");
        System.out.println("3. Cargar código desde archivo");
        System.out.print("Seleccione una opción (1-3): ");

        String opcion = scanner.nextLine();
        switch (opcion) {
            case "2":
                System.out.println("\nIngrese su código (termine con una línea vacía):");
                StringBuilder sb = new StringBuilder();
                String linea;
                while (!(linea = scanner.nextLine()).isEmpty()) {
                    sb.append(linea).append("\n");
                }
                codigo = sb.toString();
                break;

            case "3":
                System.out.print("Ingrese la ruta del archivo: ");
                String rutaArchivo = scanner.nextLine();
                try {
                    codigo = new String(Files.readAllBytes(new File(rutaArchivo).toPath()));
                    System.out.println("Código cargado correctamente desde el archivo.");
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                    codigo = "";
                }
                break;

            default:
                break;
        }

        return codigo;
    }

    /**
     * Muestra todos los tokens encontrados durante el análisis léxico (temático).
     */
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

    /**
     * Muestra el árbol de derivación generado por el análisis sintáctico (temático).
     */
    private static void mostrarArbol(Nodo arbol) {
        System.out.println("\nÁRBOL DE DERIVACIÓN");
        if (arbol != null) {
            arbol.imprimirArbol();
        } else {
            System.out.println("No se pudo generar el árbol de derivación.");
        }
    }

    /**
     * Ejecuta el programa usando el árbol generado y el entorno de ejecución (temático).
     */
    private static void ejecutarPrograma(Nodo arbol, EntornoEjecucion entorno) {
        System.out.println("\n===== EJECUTANDO PROGRAMA =====");
        Evaluador evaluador = new Evaluador(entorno);
        try {
            Object resultado = evaluador.evaluar(arbol);
            if (resultado != null) {
                System.out.println("\nResultado final: " + resultado);
            } else {
                System.out.println("El resultado es nulo, posible error en la ejecución.");
            }
        } catch (Exception e) {
            System.err.println("Error al ejecutar el programa: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("\n===== EJECUCIÓN COMPLETADA =====");
    }

    /**
     * Trunca una cadena de texto si excede cierta longitud.
     */
    private static String truncar(String valor, int maxLength) {
        return valor.length() > maxLength ? valor.substring(0, maxLength) + "..." : valor;
    }
}
