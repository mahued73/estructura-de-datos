package Estructuras_lineales;

public class PilaDinamica {
    private Nodo cima;

    public PilaDinamica() {
        cima = null;
    }

    public void push(int x) {
        Nodo nuevo = new Nodo(x);
        nuevo.siguiente = cima; // Conserva el enlace con la cima anterior.
        cima = nuevo;
    }

    public void pop() {
        if (!isEmpty()) {
            System.out.println("Sacaste de la pila: " + cima.dato);
            cima = cima.siguiente;
        } else {
            System.out.println("Pila dinamica vacia: no hay elementos para sacar.");
        }
    }

    public void mostrar() {
        Nodo actual = cima;
        System.out.print("Pila dinamica (Cima -> Fondo): ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return cima == null;
    }

    // Muestra el dato sin retirarlo de la pila.
    public void peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia: no hay un dato para consultar.");
        } else {
            System.out.println("Dato en la cima: " + cima.dato);
        }
    }
}
