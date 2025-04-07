package org.umg;

import org.umg.arbol.Nodo;
import java.util.List;

public class Evaluador {
    private final EntornoEjecucion entornoGlobal;
    private boolean retornando = false;
    private Object valorRetorno = null;

    public Evaluador(EntornoEjecucion entornoGlobal) {
        this.entornoGlobal = entornoGlobal;
    }

    public Object evaluar(Nodo nodo) {
        return evaluar(nodo, entornoGlobal);
    }

    private Object evaluar(Nodo nodo, EntornoEjecucion entorno) {
        if (nodo == null) return null;

        switch (nodo.getTipo()) {
            case MISION:
                return evaluarMision(nodo, entorno);

            case TITAN:
                return evaluarTitan(nodo, entorno);

            case ATAQUE:
                return evaluarAtaque(nodo, entorno);

            case MURO:
                return evaluarMuro(nodo, entorno);

            case DISTRITO:
                return evaluarDistrito(nodo, entorno);

            case ORDEN_MILITAR:
                return evaluarOrden(nodo, entorno);

            case TACTICA:
                return evaluarTactica(nodo, entorno);

            case SCOUT:
                return evaluarScout(nodo, entorno);

            case RECURSO:
                return evaluarRecurso(nodo);


            default:
                throw new RuntimeException("Tipo de nodo no soportado: " + nodo.getTipo());
        }
    }

    private Object evaluarMision(Nodo nodo, EntornoEjecucion entorno) {
        Object ultimoValor = null;

        for (Nodo hijo : nodo.getHijos()) {
            ultimoValor = evaluar(hijo, entorno);

            if (retornando) {
                break;
            }
        }

        return ultimoValor;
    }

    private Object evaluarTitan(Nodo nodo, EntornoEjecucion entorno) {
        List<Nodo> hijos = nodo.getHijos();

        // Evaluar condición
        Object condicion = evaluar(hijos.get(0), entorno);

        // Si la condición es verdadera, ejecutar el bloque principal
        if (esVerdadero(condicion)) {
            return evaluar(hijos.get(1), entorno);
        }
        // Si hay un bloque "legion" (else) y la condición es falsa, ejecutarlo
        else if (hijos.size() > 2) {
            return evaluar(hijos.get(2), entorno);
        }

        return null;
    }

    private Object evaluarAtaque(Nodo nodo, EntornoEjecucion entorno) {
        List<Nodo> hijos = nodo.getHijos();

        // Nodo de condición y nodo de cuerpo
        Nodo condicionNodo = hijos.get(0);
        Nodo cuerpoNodo = hijos.get(1);

        Object ultimoValor = null;

        // Mientras la condición sea verdadera, ejecutar el cuerpo
        while (true) {
            Object condicion = evaluar(condicionNodo, entorno);

            if (!esVerdadero(condicion)) break;

            ultimoValor = evaluar(cuerpoNodo, entorno);

            if (retornando) break;
        }

        return ultimoValor;
    }

    private Object evaluarMuro(Nodo nodo, EntornoEjecucion entorno) {
        List<Nodo> hijos = nodo.getHijos();

        // Crear un nuevo entorno para el bucle
        EntornoEjecucion entornoFor = new EntornoEjecucion(entorno);

        // Inicialización, condición, actualización, cuerpo
        Nodo inicializacionNodo = hijos.get(0);
        Nodo condicionNodo = hijos.get(1);
        Nodo actualizacionNodo = hijos.get(2);
        Nodo cuerpoNodo = hijos.get(3);

        Object ultimoValor = null;

        // Ejecutar inicialización
        evaluar(inicializacionNodo, entornoFor);

        // Bucle principal
        while (true) {
            // Evaluar condición
            Object condicion = evaluar(condicionNodo, entornoFor);

            if (!esVerdadero(condicion)) break;

            // Ejecutar cuerpo
            ultimoValor = evaluar(cuerpoNodo, entornoFor);

            if (retornando) break;

            // Ejecutar actualización
            evaluar(actualizacionNodo, entornoFor);
        }

        return ultimoValor;
    }

    private Object evaluarDistrito(Nodo nodo, EntornoEjecucion entorno) {
        // Crear un nuevo entorno para el bloque
        EntornoEjecucion entornoBloque = new EntornoEjecucion(entorno);

        Object ultimoValor = null;

        for (Nodo hijo : nodo.getHijos()) {
            ultimoValor = evaluar(hijo, entornoBloque);

            if (retornando) break;
        }

        return ultimoValor;
    }

    private Object evaluarOrden(Nodo nodo, EntornoEjecucion entorno) {
        // Evaluar la expresión a imprimir
        Object valor = evaluar(nodo.getHijos().get(0), entorno);

        // Imprimir el resultado
        System.out.println("➤ " + valor);

        return valor;
    }

    private Object evaluarTactica(Nodo nodo, EntornoEjecucion entorno) {
        String operador = nodo.getValor();
        List<Nodo> hijos = nodo.getHijos();

        // Evaluar operandos
        Object izquierda = evaluar(hijos.get(0), entorno);
        Object derecha = evaluar(hijos.get(1), entorno);

        // Convertir operandos a números si es necesario
        double numIzquierda = convertirANumero(izquierda);
        double numDerecha = convertirANumero(derecha);

        // Realizar operación según el operador
        return switch (operador) {
            case "+" -> {
                // Caso especial: concatenación de strings
                if (izquierda instanceof String || derecha instanceof String) {
                    yield String.valueOf(izquierda) + String.valueOf(derecha);
                } else {
                    yield numIzquierda + numDerecha;
                }
            }
            case "-" -> numIzquierda - numDerecha;
            case "*" -> numIzquierda * numDerecha;
            case "/" -> {
                if (numDerecha == 0) {
                    throw new RuntimeException("¡Los titanes no pueden ser divididos por cero!");
                }
                yield numIzquierda / numDerecha;
            }
            case "%" -> numIzquierda % numDerecha;
            case "==" -> numIzquierda == numDerecha;
            case "!=" -> numIzquierda != numDerecha;
            case "<" -> numIzquierda < numDerecha;
            case ">" -> numIzquierda > numDerecha;
            case "<=" -> numIzquierda <= numDerecha;
            case ">=" -> numIzquierda >= numDerecha;
            case "&&" -> esVerdadero(izquierda) && esVerdadero(derecha);
            case "||" -> esVerdadero(izquierda) || esVerdadero(derecha);
            default -> throw new RuntimeException("Operador desconocido: " + operador);
        };
    }

    private Object evaluarScout(Nodo nodo, EntornoEjecucion entorno) {
        String nombre = nodo.getValor();
        return entorno.obtenerVariable(nombre);
    }

    private Object evaluarRecurso(Nodo nodo) {
        String valor = nodo.getValor();

        // Si es un número
        if (valor.matches("\\d+(\\.\\d+)?")) {
            return valor.contains(".") ? Double.parseDouble(valor) : Integer.parseInt(valor);
        }

        // Si es una cadena (eliminar comillas)
        if (valor.startsWith("\"") && valor.endsWith("\"")) {
            return valor.substring(1, valor.length() - 1);
        }

        return valor;
    }

    // Métodos de utilidad

    private boolean esVerdadero(Object valor) {
        if (valor instanceof Boolean) {
            return (Boolean) valor;
        }

        if (valor instanceof Number) {
            return ((Number) valor).doubleValue() != 0;
        }

        if (valor instanceof String) {
            return !((String) valor).isEmpty();
        }

        return valor != null;
    }

    private double convertirANumero(Object valor) {
        if (valor instanceof Number) {
            return ((Number) valor).doubleValue();
        }

        if (valor instanceof Boolean) {
            return ((Boolean) valor) ? 1 : 0;
        }

        if (valor instanceof String) {
            try {
                return Double.parseDouble((String) valor);
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return 0;
    }
}
