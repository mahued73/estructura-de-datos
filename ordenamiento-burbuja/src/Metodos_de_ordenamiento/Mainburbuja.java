package Metodos_de_ordenamiento;

public class Mainburbuja{

    public static void main(String[] args) {
        int[] arreglo = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Arreglo original:");
        Burbuja.imprimirArreglo(arreglo);
        Burbuja.ordenar(arreglo);
        System.out.println("Arreglo ordenado:");
        Burbuja.imprimirArreglo(arreglo);
    }
  
}
