/** Conserva el producto completo y los enlaces del ABB de clase. */
final class Nodo {
    Producto producto;
    // Estos enlaces nos llevan a los nombres menores y mayores, respectivamente.
    Nodo izq;
    Nodo der;

    Nodo(Producto producto) {
        // El nodo empieza sin hijos; la inserción lo conecta con el resto del árbol.
        this.producto = producto;
    }
}
