package Estructuras_lineales;

public class Main {
    public static void main(String[] args) {
        PilaDinamica p = new PilaDinamica();

        System.out.println("=== PILA DINAMICA ===");
        System.out.println("Esta vacia: " + p.isEmpty());
        p.push(10);
        p.push(20);
        p.push(30);
        p.mostrar();
        p.peek(); // Consulta el 30 sin quitar el nodo.
        p.pop();
        p.mostrar();

        System.out.println("\n=== AGREGAR MAS NODOS ===");
        p.push(30);
        p.push(40);
        p.push(50);
        p.push(60);
        p.mostrar();
        p.peek();

        System.out.println("\n=== VACIAR LA PILA ===");
        while (!p.isEmpty()) {
            p.pop();
        }
        System.out.println("Esta vacia: " + p.isEmpty());
        p.peek();
        p.pop(); // Comprueba el control de pila vacia.
    }
}
