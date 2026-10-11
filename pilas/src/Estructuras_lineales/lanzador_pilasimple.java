package Estructuras_lineales;

public class lanzador_pilasimple {
    public static void main(String[] args) {
        PilaSimple p = new PilaSimple();

        System.out.println("=== PILA ESTATICA ===");
        System.out.println("Esta vacia: " + p.isEmpty());
        p.push(10);
        p.push(20);
        p.push(30);
        p.mostrar();
        p.peek(); // Consulta el 30 sin sacarlo.
        p.pop();
        p.mostrar();

        System.out.println("\n=== LLENAR LA PILA ===");
        p.push(30);
        p.push(40);
        p.push(50);
        System.out.println("Esta llena: " + p.isFull());
        p.push(60); // El arreglo solo tiene cinco posiciones.
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
