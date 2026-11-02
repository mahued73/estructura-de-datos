/** Datos de un producto. El nombre es la llave del inventario. */
public final class Producto {
    // Los datos quedan juntos y no cambian después de crear el producto.
    private final String nombre;
    private final int stock;
    private final double precio;

    public Producto(String nombre, int stock, double precio) {
        // Revisamos los datos antes de permitir que el producto entre al inventario.
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        // Además de los negativos, descartamos valores como infinito o NaN.
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio debe ser finito y no negativo.");
        }
        this.nombre = nombre.trim();
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }
}
