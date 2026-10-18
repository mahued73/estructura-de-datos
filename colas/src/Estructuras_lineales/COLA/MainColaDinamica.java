package Estructuras_lineales.COLA;

public class MainColaDinamica {
    public static void main(String[] args) {
        ColaDinamica cola = new ColaDinamica();
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.mostrar();
        System.out.println("Cantidad: " + cola.contarElementos());
        System.out.println("Peek: " + cola.peek());
        cola.mostrar();
        System.out.println("Sale: " + cola.desencolar());
        cola.encolar(40);
        cola.mostrar();
        System.out.println("Cantidad: " + cola.contarElementos());
        System.out.println("Sale: " + cola.desencolar());
        System.out.println("Sale: " + cola.desencolar());
        System.out.println("Sale: " + cola.desencolar());
        System.out.println("Cantidad vacía: " + cola.contarElementos());
        System.out.println("Peek vacía: " + cola.peek());
        System.out.println("Sale vacía: " + cola.desencolar());
        cola.encolar(50);
        cola.mostrar();
    }
}
