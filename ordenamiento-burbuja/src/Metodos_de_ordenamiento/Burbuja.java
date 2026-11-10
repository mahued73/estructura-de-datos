package Metodos_de_ordenamiento;

/** Variante existente: comparaciones adyacentes, limite decreciente y salida temprana. */
public class Burbuja {
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar arreglo[j] y arreglo[j+1]
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                // Si no se realizaron intercambios, el arreglo ya está ordenado
                break;
            }
        }
    }
    public static void imprimirArreglo(int[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(arreglo[i]);
        }
        System.out.println("]");
    }

}
