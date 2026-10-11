package Estructuras_lineales;

public class Nodo {
    int dato;
    Nodo siguiente; // Referencia al nodo que queda debajo.

    public Nodo(int x) {
        dato = x;
        siguiente = null;
    }
}
