package Estructuras_lineales;

public class PilaSimple {
    private int[] datos = new int[5]; // La capacidad sigue siendo fija.
    private int tope = -1;

    public void push(int x) {
        if (!isFull()) {
            tope++;
            datos[tope] = x;
            System.out.println("Metiste: " + x);
        } else {
            System.out.println("Pila llena: no se pudo insertar " + x + ".");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            System.out.println("Sacaste: " + datos[tope]);
            tope--;
        } else {
            System.out.println("Pila vacia: no hay elementos para sacar.");
        }
    }

    public void mostrar() {
        System.out.print("Pila actual (Fondo -> Tope): ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == datos.length - 1;
    }

    // Muestra el dato sin retirarlo de la pila.
    public void peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia: no hay un dato para consultar.");
        } else {
            System.out.println("Dato en el tope: " + datos[tope]);
        }
    }
}
