package Estructuras_lineales.COLA_ESTATICA;

public class MainColaEstatica {
    public static void main(String[] args) {
        ColaEstatica cola = new ColaEstatica(3);
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.mostrar();
        System.out.println("Peek: " + cola.peek());
        cola.mostrar();
        cola.enqueue(40);
        cola.dequeue();
        cola.enqueue(40);
        cola.mostrar();
        cola.dequeue();
        cola.dequeue();
        cola.dequeue();
        System.out.println("Peek vacía: " + cola.peek());
    }
}
