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
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Clase principal del compilador temático y multi-lenguaje.
 * Proporciona interfaz de línea de comandos para seleccionar y ejecutar
 * diferentes tipos de análisis de código.
 */
public class Principal {

    private static final Logger logger = Logger.getLogger(Principal.class.getName());

    private static final String EJEMPLO_CODIGO = """
     titan (45 + 5) {
         orden "¡Ataquen!";
     }
    """;

    // Constantes para opciones de menú
    private static final String OPCION_TEMATICO = "1";
    private static final String OPCION_MULTILENGUAJE = "2";
    private static final String OPCION_EJEMPLO = "1";
    private static final String OPCION_CODIGO_PROPIO = "2";
    private static final String OPCION_ARCHIVO = "3";

    public static void main(String[] args) {
        System.out.println("\n===== COMPILADOR TITAN / MULTI-LENGUAJE =====\n");

        try (Scanner scanner = new Scanner(System.in)) {
            String tipoCompilador = seleccionarTipoCompilador(scanner);
            String codigo = obtenerCodigo(scanner);

            if (codigo == null || codigo.trim().isEmpty()) {
                System.err.println("Error: No se pudo obtener el código fuente.");
                return;
            }

            ejecutarCompilador(tipoCompilador, codigo);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado en la aplicación", e);
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Permite al usuario seleccionar el tipo de compilador a usar.
     */
    private static String seleccionarTipoCompilador(Scanner scanner) {
        while (true) {
            System.out.println("Seleccione tipo de compilador:");
            System.out.println("1. Temático Attack on Titan");
            System.out.println("2. Multi-Lenguaje (ANTLR)");
            System.out.print("Opción (1-2): ");

            String opcion = scanner.nextLine().trim();

            if (OPCION_TEMATICO.equals(opcion) || OPCION_MULTILENGUAJE.equals(opcion)) {
                return opcion;
            }

            System.out.println("Opción inválida. Por favor seleccione 1 o 2.\n");
        }
    }

    /**
     * Ejecuta el compilador seleccionado con el código proporcionado.
     */
    private static void ejecutarCompilador(String tipo, String codigo) {
        if (OPCION_TEMATICO.equals(tipo)) {
            ejecutarTematico(codigo);
        } else if (OPCION_MULTILENGUAJE.equals(tipo)) {
            ejecutarMultiLenguaje(codigo);
        } else {
            System.err.println("Tipo de compilador no válido: " + tipo);
        }
    }

    /**
     * Ejecuta el análisis con el compilador temático de Attack on Titan.
     */
    private static void ejecutarTematico(String codigo) {
        System.out.println("\nIniciando análisis TEMÁTICO...\n");

        try {
            // 1. Análisis Léxico
            AnalizadorLexico analizador = new AnalizadorLexico();
            List<Token> tokens = analizador.analizar(codigo);

            if (tokens == null || tokens.isEmpty()) {
                System.err.println("Error: No se generaron tokens durante el análisis léxico.");
                return;
            }

            mostrarResultadosLexicos(tokens);

            // 2. Análisis Sintáctico
            Parser parser = new Parser(tokens);
            Nodo arbol = parser.parse();

            if (arbol == null) {
                System.err.println("Error: No se pudo generar el árbol sintáctico.");
                return;
            }

            mostrarArbol(arbol);

            // 3. Ejecución (solo si las clases existen)
            ejecutarSiEsPosible(arbol);

            // 4. Mostrar tabla de símbolos
            mostrarTablaSimbolos();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error durante el análisis temático", e);
            System.err.println("Error durante el análisis: " + e.getMessage());
        }
    }

    /**
     * Ejecuta el programa si las clases de ejecución están disponibles.
     */
    private static void ejecutarSiEsPosible(Nodo arbol) {
        try {
            // Verificar si las clases existen usando reflection
            Class.forName("org.umg.EntornoEjecucion");
            Class.forName("org.umg.Evaluador");

            System.out.println("\n===== EJECUTANDO PROGRAMA =====");
            // EntornoEjecucion entorno = new EntornoEjecucion();
            // Evaluador evaluador = new Evaluador(entorno);
            // Object resultado = evaluador.evaluar(arbol);

            System.out.println("Nota: Ejecución deshabilitada - implementar clases de ejecución");
            System.out.println("===== EJECUCIÓN COMPLETADA =====");

        } catch (ClassNotFoundException e) {
            System.out.println("Nota: Clases de ejecución no disponibles. Solo se mostró el análisis.");
        }
    }

    /**
     * Ejecuta el análisis con el compilador multi-lenguaje usando ANTLR.
     */
    private static void ejecutarMultiLenguaje(String codigo) {
        System.out.println("\nIniciando análisis MULTI-LENGUAJE (ANTLR)...\n");

        try {
            // Verificar si las clases necesarias existen
            verificarClasesMultiLenguaje();

            // 1. Detectar el lenguaje
            // String lenguajeDetectado = LenguajeDetector.detectarLenguaje(codigo);
            String lenguajeDetectado = "Genérico"; // Placeholder
            System.out.println("Lenguaje detectado: " + lenguajeDetectado);

            // 2. Analizar con el analizador general
            // ResultadoCompilacion resultado = AnalizadorGeneral.analizar(codigo);
            ResultadoCompilacion resultado = crearResultadoPlaceholder(lenguajeDetectado);

            // 3. Mostrar resultados
            mostrarResultadosMultiLenguaje(resultado);

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Clases de análisis multi-lenguaje no disponibles.");
            System.err.println("Implemente las clases: LenguajeDetector y AnalizadorGeneral");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error durante el análisis multi-lenguaje", e);
            System.err.println("Error durante el análisis multi-lenguaje: " + e.getMessage());
        }
    }

    /**
     * Verifica que las clases necesarias para multi-lenguaje existan.
     */
    private static void verificarClasesMultiLenguaje() throws ClassNotFoundException {
        Class.forName("org.umg.LenguajeDetector");
        Class.forName("org.umg.AnalizadorGeneral");
    }

    /**
     * Crea un resultado placeholder para demostración.
     */
    private static ResultadoCompilacion crearResultadoPlaceholder(String lenguaje) {
        // Assumiendo que ResultadoCompilacion tiene constructor apropiado
        // return new ResultadoCompilacion(lenguaje, "Análisis exitoso", false);

        // Placeholder - ajustar según la implementación real
        System.out.println("Nota: Usando resultado placeholder - implementar AnalizadorGeneral");
        return null;
    }

    /**
     * Muestra los resultados del análisis multi-lenguaje.
     */
    private static void mostrarResultadosMultiLenguaje(ResultadoCompilacion resultado) {
        System.out.println("\n===== RESULTADO DEL ANÁLISIS =====");
        if (resultado != null) {
            System.out.println("Lenguaje: " + resultado.lenguajeDetectado);
            System.out.println("Resultado: " + resultado.resultado);
            System.out.println("Errores: " + (resultado.hayErrores ? "Sí" : "No"));
        } else {
            System.out.println("No se pudo generar resultado del análisis.");
        }
    }

    /**
     * Permite al usuario elegir entre código de ejemplo, ingresar su propio código o cargar desde un archivo.
     */
    private static String obtenerCodigo(Scanner scanner) {
        while (true) {
            System.out.println("\n¿Cómo desea proporcionar el código?");
            System.out.println("1. Usar código de ejemplo");
            System.out.println("2. Ingresar código propio");
            System.out.println("3. Cargar código desde archivo");
            System.out.print("Seleccione una opción (1-3): ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case OPCION_EJEMPLO:
                    return EJEMPLO_CODIGO;

                case OPCION_CODIGO_PROPIO:
                    return leerCodigoPropio(scanner);

                case OPCION_ARCHIVO:
                    String codigo = cargarDesdeArchivo(scanner);
                    if (codigo != null) {
                        return codigo;
                    }
                    // Si falla, continúa el bucle para permitir otra opción
                    break;

                default:
                    System.out.println("Opción inválida. Por favor seleccione 1, 2 o 3.\n");
            }
        }
    }

    /**
     * Lee código ingresado por el usuario.
     */
    private static String leerCodigoPropio(Scanner scanner) {
        System.out.println("\nIngrese su código (termine con una línea que contenga solo 'FIN'):");
        StringBuilder sb = new StringBuilder();
        String linea;

        while (!(linea = scanner.nextLine()).trim().equals("FIN")) {
            sb.append(linea).append("\n");
        }

        String codigo = sb.toString().trim();
        if (codigo.isEmpty()) {
            System.out.println("Advertencia: Se ingresó código vacío.");
        }

        return codigo;
    }

    /**
     * Carga código desde un archivo.
     */
    private static String cargarDesdeArchivo(Scanner scanner) {
        System.out.print("Ingrese la ruta del archivo: ");
        String rutaArchivo = scanner.nextLine().trim();

        if (rutaArchivo.isEmpty()) {
            System.err.println("Error: Ruta de archivo vacía.");
            return null;
        }

        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.err.println("Error: El archivo no existe: " + rutaArchivo);
                return null;
            }

            if (!archivo.canRead()) {
                System.err.println("Error: No se puede leer el archivo: " + rutaArchivo);
                return null;
            }

            String codigo = Files.readString(archivo.toPath());
            System.out.println("Código cargado correctamente desde: " + rutaArchivo);
            return codigo;

        } catch (IOException e) {
            logger.log(Level.WARNING, "Error al leer archivo: " + rutaArchivo, e);
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    /**
     * Muestra todos los tokens encontrados durante el análisis léxico.
     */
    private static void mostrarResultadosLexicos(List<Token> tokens) {
        System.out.println("\n===== TOKENS DETECTADOS =====");
        System.out.printf("%-20s %-30s %s\n", "VALOR", "TIPO", "LÍNEA");
        System.out.println("-".repeat(65));

        if (tokens.isEmpty()) {
            System.out.println("No se encontraron tokens.");
            return;
        }

        tokens.forEach(token -> {
            if (token != null) {
                System.out.printf("%-20s %-30s %d\n",
                        truncar(token.getValor(), 18),
                        token.getTipo(),
                        token.getLinea());
            }
        });
    }

    /**
     * Muestra el árbol de derivación generado por el análisis sintáctico.
     */
    private static void mostrarArbol(Nodo arbol) {
        System.out.println("\n===== ÁRBOL DE DERIVACIÓN =====");
        if (arbol != null) {
            try {
                arbol.imprimirArbol();
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error al imprimir árbol", e);
                System.err.println("Error al mostrar el árbol: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo generar el árbol de derivación.");
        }
    }

    /**
     * Muestra la tabla de símbolos si está disponible.
     */
    private static void mostrarTablaSimbolos() {
        try {
            System.out.println("\n===== TABLA DE SÍMBOLOS =====");
            TablaSimbolos.imprimir();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error al mostrar tabla de símbolos", e);
            System.err.println("Error al mostrar tabla de símbolos: " + e.getMessage());
        }
    }

    /**
     * Trunca una cadena de texto si excede cierta longitud.
     */
    private static String truncar(String valor, int maxLength) {
        if (valor == null) {
            return "null";
        }
        return valor.length() > maxLength ? valor.substring(0, maxLength) + "..." : valor;
    }
}