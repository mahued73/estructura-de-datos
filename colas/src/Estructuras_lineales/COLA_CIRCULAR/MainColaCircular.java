package Estructuras_lineales.COLA_CIRCULAR;

public class MainColaCircular {
    public static void main(String[] args) {
        ColaEstaticaCircular cola = new ColaEstaticaCircular(3);
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        System.out.println("Peek: " + cola.peek());
        cola.mostrar();
        cola.dequeue();
        cola.enqueue(40);
        cola.mostrar();
        cola.dequeue();
        cola.dequeue();
        cola.dequeue();
        cola.dequeue();
        System.out.println("Peek vacía: " + cola.peek());
    }
}
