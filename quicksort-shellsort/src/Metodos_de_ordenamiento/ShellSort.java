package Metodos_de_ordenamiento;

/** Base del PDF, completada en el ciclo while. Usa intervalos n/2, n/4, ..., 1. */
public class ShellSort {
    /** Ordena ascendentemente in situ. Requiere arr no nulo. */
    public static void ordenar(int[] arr) {
        int n = arr.length;
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int temp = arr[i];
                int j = i;
                // Completado: primero validar indice; luego desplazar por el salto.
                while (j >= intervalo && arr[j - intervalo] > temp) {
                    arr[j] = arr[j - intervalo];
                    j -= intervalo;
                }
                arr[j] = temp;
            }
        }
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
