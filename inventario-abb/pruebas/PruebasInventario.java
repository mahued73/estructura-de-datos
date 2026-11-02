import java.util.List;

/** Pruebas funcionales sin frameworks externos; fallan con AssertionError. */
public class PruebasInventario {
    private static int verificaciones;

    private static void comprobar(boolean condicion, String detalle) {
        // Detenemos la prueba en cuanto un resultado no coincide con lo esperado.
        if (!condicion) throw new AssertionError(detalle);
        verificaciones++;
    }

    private static void orden(ArbolBinarioBusqueda arbol, String... nombres) {
        // Comprobamos tanto los nombres como la cantidad, para detectar pérdidas o duplicados.
        List<Producto> productos = arbol.inOrder();
        comprobar(productos.size() == nombres.length, "Cantidad incorrecta");
        for (int i = 0; i < nombres.length; i++) {
            comprobar(productos.get(i).getNombre().equals(nombres[i]), "Orden incorrecto");
        }
    }

    private static void invalido(Runnable operacion) {
        try { operacion.run(); throw new AssertionError("Se aceptó un dato inválido"); }
        catch (IllegalArgumentException esperado) { verificaciones++; }
    }

    public static void main(String[] args) {
        // Empezamos con el árbol vacío y después cargamos un ejemplo conocido.
        ArbolBinarioBusqueda a = new ArbolBinarioBusqueda();
        orden(a);
        comprobar(a.buscar("Leche") == null, "Búsqueda en vacío");
        comprobar(!a.eliminar("Leche"), "Eliminación en vacío");
        a.insertar(new Producto("Leche", 10, 25));
        a.insertar(new Producto("Arroz", 20, 18.50));
        a.insertar(new Producto("Pan", 30, 4));
        a.insertar(new Producto("Aceite", 5, 40));
        a.insertar(new Producto("Frijol", 8, 32));
        a.insertar(new Producto("Miel", 11, 90));
        a.insertar(new Producto("Queso", 6, 75));
        orden(a, "Aceite", "Arroz", "Frijol", "Leche", "Miel", "Pan", "Queso");
        comprobar(a.buscar(" Leche ").getStock() == 10, "Búsqueda y espacios");
        comprobar(!a.insertar(new Producto("Leche", 99, 99)), "Duplicado permitido");
        comprobar(a.buscar("Leche").getStock() == 10, "Duplicado sobrescribió datos");
        // El orden de estos borrados permite probar hoja, un hijo y dos hijos.
        comprobar(a.eliminar("Aceite"), "Hoja no eliminada");
        comprobar(a.eliminar("Arroz"), "Nodo con un hijo no eliminado");
        comprobar(a.buscar("Frijol") != null, "Se perdió el hijo");
        comprobar(a.eliminar("Leche"), "Raíz con dos hijos no eliminada");
        comprobar(a.buscar("Leche") == null, "Sigue la llave borrada");
        // Miel sustituye a Leche y debe conservar sus propias existencias y precio.
        Producto miel = a.buscar("Miel");
        comprobar(miel != null && miel.getStock() == 11 && miel.getPrecio() == 90,
            "El sucesor mezcló los datos del producto");
        orden(a, "Frijol", "Miel", "Pan", "Queso");
        comprobar(!a.eliminar("No existe"), "Se eliminó un valor inexistente");
        for (String n : new String[]{"Frijol", "Miel", "Pan", "Queso"}) comprobar(a.eliminar(n), "Borrado hasta vaciar");
        orden(a);
        a.insertar(new Producto("Pan", 1, 2)); a.insertar(new Producto("Arroz", 2, 3));
        comprobar(a.eliminar("Pan"), "Raíz con un hijo"); orden(a, "Arroz");
        a.insertar(new Producto("Pan", 3, 4));a.insertar(new Producto("Queso", 4, 5));
        comprobar(a.eliminar("Pan"), "Nodo con hijo derecho");orden(a, "Arroz", "Queso");
        // El sucesor tiene a su vez un hijo derecho: ese hijo debe conservarse.
        ArbolBinarioBusqueda b = new ArbolBinarioBusqueda();
        for (String n : new String[]{"M", "C", "T", "P", "Q"}) b.insertar(new Producto(n, 1, 1));
        comprobar(b.eliminar("M"), "Sucesor con hijo derecho");orden(b, "C", "P", "Q", "T");
        // También verificamos que las validaciones rechacen entradas incorrectas.
        invalido(() -> new Producto(" ", 1, 1));
        invalido(() -> new Producto(null, 1, 1));
        invalido(() -> new Producto("X", -1, 1));
        invalido(() -> new Producto("X", 1, -1));
        invalido(() -> new Producto("X", 1, Double.NaN));
        invalido(() -> new Producto("X", 1, Double.POSITIVE_INFINITY));
        invalido(() -> a.buscar(" "));
        invalido(() -> a.eliminar(null));
        System.out.println("CORRECTO: " + verificaciones + " verificaciones funcionales.");
    }
}
