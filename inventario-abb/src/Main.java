import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Menú repetitivo del sistema de inventario. */
public class Main {
    public static void main(String[] args) {
        // Usamos el mismo inventario durante toda la ejecución del menú.
        ArbolBinarioBusqueda inventario = new ArbolBinarioBusqueda();
        try (Scanner entrada = new Scanner(System.in, StandardCharsets.UTF_8)) {
            // Después de cada operación volvemos a mostrar las opciones.
            while (true) {
                System.out.println("\n=== INVENTARIO CON ABB ===");
                System.out.println("1. Registrar producto\n2. Buscar por nombre\n3. Eliminar producto");
                System.out.println("4. Mostrar inventario (InOrder)\n5. Salir");
                System.out.print("Opción: ");
                if (!entrada.hasNextLine()) break;
                String opcion = entrada.nextLine().trim();
                if (opcion.equals("5")) { System.out.println("Programa terminado."); break; }
                try {
                    switch (opcion) {
                        case "1": {
                            String nombre = leer(entrada, "Nombre: ");
                            int stock = Integer.parseInt(leer(entrada, "Stock: "));
                            // Admitimos punto o coma decimal; no se usan separadores de miles.
                            double precio = Double.parseDouble(leer(entrada, "Precio (ej. 25.50): ").replace(',', '.'));
                            // Solo registramos el producto cuando sus datos ya pudieron validarse.
                            boolean agregado = inventario.insertar(new Producto(nombre, stock, precio));
                            System.out.println(agregado ? "Producto registrado." : "Ese nombre ya existe; no se modificó el producto.");
                            break;
                        }
                        case "2": {
                            Producto encontrado = inventario.buscar(leer(entrada, "Nombre a buscar: "));
                            if (encontrado == null) System.out.println("Producto no encontrado.");
                            else { encabezado(); mostrar(encontrado); }
                            break;
                        }
                        case "3":
                            System.out.println(inventario.eliminar(leer(entrada, "Nombre a eliminar: "))
                                ? "Producto eliminado." : "Producto no encontrado.");
                            break;
                        case "4": {
                            // El árbol entrega los productos en el orden de sus nombres.
                            List<Producto> productos = inventario.inOrder();
                            if (productos.isEmpty()) System.out.println("El inventario está vacío.");
                            else { encabezado(); for (Producto producto : productos) mostrar(producto); }
                            break;
                        }
                        default: System.out.println("Elige una opción del 1 al 5.");
                    }
                } catch (NumberFormatException error) {
                    // Una entrada numérica incorrecta no debe terminar el programa.
                    System.out.println("Dato numérico inválido. Stock: entero; precio: número sin separador de miles. No se registró el producto.");
                } catch (IllegalArgumentException error) {
                    // Mostramos el motivo concreto: nombre vacío, stock negativo o precio inválido.
                    System.out.println(error.getMessage());
                } catch (FinEntrada error) {
                    // También terminamos con normalidad si se acaba la entrada a mitad de un registro.
                    System.out.println("\nFin de entrada. Programa terminado.");
                    break;
                }
            }
        }
    }

    private static String leer(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
        if (!entrada.hasNextLine()) throw new FinEntrada();
        // Leer la línea completa permite escribir nombres que contienen espacios.
        return entrada.nextLine().trim();
    }

    private static void encabezado() {
        System.out.printf("%-25s %8s %12s%n", "PRODUCTO", "STOCK", "PRECIO");
    }

    private static void mostrar(Producto producto) {
        // Presentamos el precio con dos decimales y el stock como número entero.
        System.out.printf(Locale.ROOT, "%-25s %8d %12.2f%n",
            producto.getNombre(), producto.getStock(), producto.getPrecio());
    }

    private static class FinEntrada extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}
