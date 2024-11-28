public class Arbol {

    public class Arbol {

        // Función para insertar una palabra en el árbol n-ario
        public static void insertarPalabra(Nodo raiz, String palabra) {
            Nodo actual = raiz;

            // Recorremos la palabra letra por letra
            for (int i = 0; i < palabra.length(); i++) {
                Nodo hijoExistente = null;

                // Buscar si ya existe un hijo con la misma letra
                Nodo temp = actual.primerHijo;
                while (temp != null) {
                    if (temp.valor == palabra.charAt(i)) {
                        hijoExistente = temp;
                        break;
                    }
                    temp = temp.siguienteHermano;
                }

                // Si no existe, insertar el nuevo nodo
                if (hijoExistente == null) {
                    Nodo nuevoNodo = new Nodo(palabra.charAt(i));

                    if (actual.primerHijo == null) {
                        actual.primerHijo = nuevoNodo;
                    } else {
                        Nodo ultimoHermano = actual.primerHijo;
                        while (ultimoHermano.siguienteHermano != null) {
                            ultimoHermano = ultimoHermano.siguienteHermano;
                        }
                        ultimoHermano.siguienteHermano = nuevoNodo;
                    }
                    actual = nuevoNodo;  // Avanzamos al nuevo nodo (hijo)
                } else {
                    actual = hijoExistente;  // Si ya existe, nos movemos a ese hijo
                }
            }
        }

        // Función para mostrar el árbol n-ario de manera recursiva
        public static void mostrarArbol(Nodo nodo, int nivel, boolean imprimirRaiz) {
            if (nodo == null) return;

            // Mostrar los hijos (llamadas recursivas)
            Nodo hijo = nodo.primerHijo;
            while (hijo != null) {
                // Imprimir el valor del nodo con una indentación por nivel
                for (int i = 0; i < nivel; i++) {
                    System.out.print("  "); // Espacios para cada nivel
                }
                System.out.println("|-- " + hijo.valor);
                mostrarArbol(hijo, nivel + 1, false); // Llamada recursiva para cada hijo
                hijo = hijo.siguienteHermano;  // Pasar al siguiente hermano
            }
        }

        // Función para liberar la memoria del árbol (aunque no es necesario en Java)
        public static void destruirArbol(Nodo nodo) {
            if (nodo == null) return;

            // Liberar los hijos
            Nodo hijo = nodo.primerHijo;
            while (hijo != null) {
                Nodo siguienteHijo = hijo.siguienteHermano;  // Guardamos el siguiente hijo
                destruirArbol(hijo);  // Llamada recursiva
                hijo = siguienteHijo;  // Continuar con el siguiente hijo
            }
        }


}
