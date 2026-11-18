package Metodos_de_ordenamiento;

/**
 * Clase que implementa el algoritmo de ordenamiento Quicksort (Rápido)
 * utilizando la estrategia de "Divide y Vencerás".
 *
 * Complejidad temporal:
 * - Mejor y Promedio: O(N log N)
 * - Peor caso: O(N^2) [Ocurre cuando el pivote es siempre el menor o mayor elemento]
 */
public class QuickSort {

    /**
     * Método principal recursivo de Quicksort.
     * Divide el arreglo en subarreglos alrededor de un pivote.
     *
     * @param arr  Arreglo de enteros a ordenar.
     * @param bajo Índice inicial del subarreglo (usualmente 0).
     * @param alto Índice final del subarreglo (usualmente arr.length - 1).
     */
    public static void ordenar(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            // 1. Particionamiento: Coloca el pivote en su lugar correcto
            // y divide los elementos menores a la izquierda y mayores a la derecha.
            int pivote = particionar(arr, bajo, alto);

            // 2. Llamada recursiva para la sub-lista izquierda (menores al pivote)
            ordenar(arr, bajo, pivote - 1);

            // 3. Llamada recursiva para la sub-lista derecha (mayores al pivote)
            ordenar(arr, pivote + 1, alto);
        }
    }

    /**
     * Método de partición (Esquema de Lomuto).
     * Toma el último elemento como pivote y reorganiza el arreglo.
     */
    private static int particionar(int[] arr, int bajo, int alto) {
        // Elegimos el último elemento como valor del pivote
        int valorPivote = arr[alto];

        // Índice del elemento más pequeño (delimita la frontera de los menores)
        int i = (bajo - 1);

        // Recorremos desde 'bajo' hasta 'alto - 1'
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= valorPivote) {
                i++; // Avanzamos la frontera de los menores

                // Intercambio (swap) clásico usando variable temporal
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Finalmente, colocamos el pivote en su posición correcta
        // (intercambiándolo con el primer elemento mayor que encontramos)
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        // Retornamos el índice exacto donde quedó ubicado el pivote
        return i + 1;
    }

    /**
     * Método auxiliar para imprimir los elementos del arreglo.
     */
    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}