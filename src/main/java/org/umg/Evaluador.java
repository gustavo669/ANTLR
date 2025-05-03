package org.umg;

import org.umg.arbol.Nodo;
import org.umg.modelo.TablaSimbolos;

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

        return switch (nodo.getTipo()) {
            case MISION -> evaluarMision(nodo, entorno);
            case TITAN -> evaluarTitan(nodo, entorno);
            case ATAQUE -> evaluarAtaque(nodo, entorno);
            case MURO -> evaluarMuro(nodo, entorno);
            case DISTRITO -> evaluarDistrito(nodo, entorno);
            case ORDEN_MILITAR -> evaluarOrden(nodo, entorno);
            case TACTICA -> evaluarTactica(nodo, entorno);
            case SCOUT -> evaluarScout(nodo, entorno);
            case RECURSO -> evaluarRecurso(nodo);
            case EQUIPO -> evaluarAsignacion(nodo, entorno);
            default -> throw new RuntimeException("Nodo no reconocido: " + nodo.getTipo());
        };
    }

    private Object evaluarMision(Nodo nodo, EntornoEjecucion entorno) {
        Object ultimoValor = null;
        for (Nodo hijo : nodo.getHijos()) {
            ultimoValor = evaluar(hijo, entorno);
            if (retornando) break;
        }
        return ultimoValor;
    }

    private Object evaluarTitan(Nodo nodo, EntornoEjecucion entorno) {
        List<Nodo> hijos = nodo.getHijos();
        Object condicion = evaluar(hijos.get(0), entorno);
        if (esVerdadero(condicion)) {
            return evaluar(hijos.get(1), entorno);
        } else if (hijos.size() > 2) {
            return evaluar(hijos.get(2), entorno);
        }
        return null;
    }

    private Object evaluarAtaque(Nodo nodo, EntornoEjecucion entorno) {
        Nodo condicion = nodo.getHijos().get(0);
        Nodo cuerpo = nodo.getHijos().get(1);
        Object resultado = null;
        while (esVerdadero(evaluar(condicion, entorno))) {
            resultado = evaluar(cuerpo, entorno);
            if (retornando) break;
        }
        return resultado;
    }

    private Object evaluarMuro(Nodo nodo, EntornoEjecucion entorno) {
        List<Nodo> hijos = nodo.getHijos();
        EntornoEjecucion local = new EntornoEjecucion(entorno);

        evaluar(hijos.get(0), local);
        while (esVerdadero(evaluar(hijos.get(1), local))) {
            Object res = evaluar(hijos.get(3), local);
            if (retornando) break;
            evaluar(hijos.get(2), local);
        }
        return null;
    }

    private Object evaluarDistrito(Nodo nodo, EntornoEjecucion entorno) {
        EntornoEjecucion local = new EntornoEjecucion(entorno);
        Object resultado = null;
        for (Nodo hijo : nodo.getHijos()) {
            resultado = evaluar(hijo, local);
            if (retornando) break;
        }
        return resultado;
    }

    private Object evaluarOrden(Nodo nodo, EntornoEjecucion entorno) {
        Object valor = evaluar(nodo.getHijos().get(0), entorno);
        System.out.println(" ➤ " + valor);
        return valor;
    }

    private Object evaluarTactica(Nodo nodo, EntornoEjecucion entorno) {
        String operador = nodo.getValor();
        Object izq = evaluar(nodo.getHijos().get(0), entorno);
        Object der = evaluar(nodo.getHijos().get(1), entorno);

        double a = convertirANumero(izq);
        double b = convertirANumero(der);

        return switch (operador) {
            case "+" -> (izq instanceof String || der instanceof String)
                    ? String.valueOf(izq) + der : a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new RuntimeException("No se puede dividir por cero.");
                yield a / b;
            }
            case "%" -> a % b;
            case "==" -> a == b;
            case "!=" -> a != b;
            case "<" -> a < b;
            case ">" -> a > b;
            case "<=" -> a <= b;
            case ">=" -> a >= b;
            case "&&" -> esVerdadero(izq) && esVerdadero(der);
            case "||" -> esVerdadero(izq) || esVerdadero(der);
            default -> throw new RuntimeException("Táctica desconocida: " + operador);
        };
    }

    private Object evaluarScout(Nodo nodo, EntornoEjecucion entorno) {
        String nombre = nodo.getValor();
        return entorno.obtenerVariable(nombre);
    }

    private Object evaluarRecurso(Nodo nodo) {
        String val = nodo.getValor();
        if (val.matches("\\d+(\\.\\d+)?")) return val.contains(".") ? Double.parseDouble(val) : Integer.parseInt(val);
        if (val.startsWith("\"") && val.endsWith("\"")) return val.substring(1, val.length() - 1);
        return val;
    }

    private boolean esVerdadero(Object valor) {
        if (valor instanceof Boolean b) return b;
        if (valor instanceof Number n) return n.doubleValue() != 0;
        if (valor instanceof String s) return !s.isEmpty();
        return valor != null;
    }

    private double convertirANumero(Object valor) {
        if (valor instanceof Number) return ((Number) valor).doubleValue();
        if (valor instanceof Boolean) return (Boolean) valor ? 1 : 0;
        if (valor instanceof String s) {
            try { return Double.parseDouble(s); }
            catch (NumberFormatException e) { return 0; }
        }
        return 0;
    }

    private Object evaluarAsignacion(Nodo nodo, EntornoEjecucion entorno) {
        String nombre = nodo.getHijos().get(0).getValor();
        Object valor = evaluar(nodo.getHijos().get(1), entorno);

        entorno.setVariable(nombre, valor);
        TablaSimbolos.agregar(nombre, tipoDeValor(valor));

        System.out.println("Asignado " + nombre + " = " + valor);
        return valor;
    }

    private String tipoDeValor(Object valor) {
        if (valor == null) return "Nulo";
        if (valor instanceof Integer) return "Entero";
        if (valor instanceof Double) return "Decimal";
        if (valor instanceof Boolean) return "Booleano";
        if (valor instanceof String) return "Cadena";
        return valor.getClass().getSimpleName();
    }
}
