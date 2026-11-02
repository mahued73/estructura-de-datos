import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Adaptación del ABB con enteros trabajado en clase. */
public class ArbolBinarioBusqueda {
    // Desde aquí empezamos a recorrer el árbol; null indica que está vacío.
    private Nodo raiz;

    public boolean insertar(Producto producto) {
        Objects.requireNonNull(producto, "Se requiere un producto.");
        // Un nombre repetido no debe reemplazar las existencias ni el precio guardados.
        if (buscar(producto.getNombre()) != null) return false;
        // Guardamos el resultado porque el primer producto también crea la raíz.
        raiz = insertarRecursivo(raiz, producto);
        return true;
    }

    private Nodo insertarRecursivo(Nodo actual, Producto producto) {
        // Encontramos un espacio libre: aquí se enlaza el nuevo producto.
        if (actual == null) return new Nodo(producto);
        // compareTo nos dice de qué lado debe quedar el nombre.
        int comparacion = producto.getNombre().compareTo(actual.producto.getNombre());
        if (comparacion < 0) actual.izq = insertarRecursivo(actual.izq, producto);
        else if (comparacion > 0) actual.der = insertarRecursivo(actual.der, producto);
        return actual;
    }

    public Producto buscar(String nombre) {
        // Buscamos desde la raíz, quitando los espacios sobrantes del nombre.
        return buscarRecursivo(raiz, nombreValido(nombre));
    }

    private Producto buscarRecursivo(Nodo actual, String nombre) {
        // Llegar a una rama vacía significa que no encontramos el producto.
        if (actual == null) return null;
        int comparacion = nombre.compareTo(actual.producto.getNombre());
        // Si el nombre coincide, devolvemos todos los datos de ese producto.
        if (comparacion == 0) return actual.producto;
        if (comparacion < 0) return buscarRecursivo(actual.izq, nombre);
        return buscarRecursivo(actual.der, nombre);
    }

    public boolean eliminar(String nombre) {
        String llave = nombreValido(nombre);
        // Así el menú puede avisar cuando el producto que se quiere borrar no existe.
        if (buscar(llave) == null) return false;
        // La raíz puede cambiar si eliminamos el primer nodo del árbol.
        raiz = eliminarRecursivo(raiz, llave);
        return true;
    }

    private Nodo eliminarRecursivo(Nodo actual, String nombre) {
        // Si llegamos a una rama vacía, el producto no está por aquí.
        if (actual == null) return null;
        int comparacion = nombre.compareTo(actual.producto.getNombre());
        // Seguimos el mismo orden que usamos al registrar los productos.
        if (comparacion < 0) actual.izq = eliminarRecursivo(actual.izq, nombre);
        else if (comparacion > 0) actual.der = eliminarRecursivo(actual.der, nombre);
        else {
            // Encontramos el producto. Si es una hoja, basta con quitarlo.
            if (actual.izq == null && actual.der == null) return null;
            // Si tiene un solo hijo, ese hijo ocupa su lugar en el árbol.
            if (actual.izq == null) return actual.der;
            if (actual.der == null) return actual.izq;

            // Con dos hijos buscamos el menor de la rama derecha.
            // Ese producto puede ocupar este lugar sin romper el orden.
            Nodo sucesor = obtenerMinimo(actual.der);
            // Movemos el producto completo para conservar juntos
            // su nombre, sus existencias y su precio.
            actual.producto = sucesor.producto;
            // Quitamos el sucesor de su posición anterior para no repetirlo.
            actual.der = eliminarRecursivo(actual.der, sucesor.producto.getNombre());
        }
        // Devolvemos esta parte del árbol con sus enlaces actualizados.
        return actual;
    }

    private Nodo obtenerMinimo(Nodo actual) {
        // El nombre menor de esta rama está en el último nodo que alcanzamos hacia la izquierda.
        while (actual.izq != null) actual = actual.izq;
        return actual;
    }

    public List<Producto> inOrder() {
        // La lista solo reúne el resultado del recorrido; el inventario sigue en el ABB.
        List<Producto> resultado = new ArrayList<>();
        recorrerInOrder(raiz, resultado);
        return resultado;
    }

    private void recorrerInOrder(Nodo actual, List<Producto> resultado) {
        // Izquierda, producto actual y derecha: ese orden deja los nombres ordenados.
        if (actual != null) {
            recorrerInOrder(actual.izq, resultado);
            resultado.add(actual.producto);
            recorrerInOrder(actual.der, resultado);
        }
    }

    private String nombreValido(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Escribe un nombre de producto.");
        }
        return nombre.trim();
    }
}
