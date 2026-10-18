package Estructuras_lineales.COLA_ESTATICA;

public class ColaEstatica{
    private int[] arreglo;
    private int frente;
    private int fin;
    private int capacidad;

    public ColaEstatica(int tamano) {
        this.capacidad = tamano ;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;
        this.fin = -1 ;
    }

    public void enqueue(int valor) {
        if (fin == capacidad - 1) {
            System.out.println("Error: La cola está llena.") ;
        } else {
            fin++;
            arreglo[fin] = valor ;
            System.out.println("Entró a la fila: " + valor);
        }
    }

    public void dequeue() {
        if (frente > fin) {
            System.out.println("Error: La cola está vacía.") ;
        } else {
            System.out.println("Atendido y fuera: " + arreglo[frente]);
            frente++;
        }
    }
    
    public void mostrar() {
        if (frente > fin) {
            System.out.println("La cola está vacía.") ;
            return;
        }
        System.out.print("Fila actual:" ) ; 
        for (int i = frente; i <= fin; i++){
            System.out.print(arreglo[i] + " ") ;
        }
        System.out.println() ;
    }
    
    public int peek() {
        if (frente > fin) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }
}
