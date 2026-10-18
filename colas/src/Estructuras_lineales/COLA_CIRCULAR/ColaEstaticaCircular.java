package Estructuras_lineales.COLA_CIRCULAR;

public class ColaEstaticaCircular {
  private int[] arreglo;
    private int frente;
    private int fin;
    private int capacidad;

    private int tamano;

    public ColaEstaticaCircular(int capacidad) {
        this.capacidad = capacidad ;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;
        this.fin = -1 ;
        this.tamano = 0;
    }

    public void enqueue(int valor) {
        if (tamano == capacidad) {
            System.out.println("Error: La cola está llena.") ;
            return;
        } 

        fin = (fin + 1) % capacidad;
        arreglo[fin] = valor;
        tamano++; 
        System.out.println("Entró a la fila: " + valor);
    }

    public int dequeue() {
        if (tamano == 0) {
            System.out.println("Error: La cola está vacía.") ;
            return -1; 
        } 

        int valor = arreglo[frente];
        frente = (frente + 1) % capacidad;
        tamano--; 
        System.out.println("Atendido y fuera: " + valor);
        return valor;
    }
    
    public void mostrar() {
        if (tamano == 0) {
            System.out.println("La cola está vacía.") ;
            return;
        }
        System.out.print("Fila actual: ") ; 
        for (int i = 0; i < tamano; i++) {
            int index = (frente + i) % capacidad;
            System.out.print(arreglo[index] + " ") ;
        }
        System.out.println() ;
    }
    
    public int peek() {
        if (tamano == 0) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }
}
