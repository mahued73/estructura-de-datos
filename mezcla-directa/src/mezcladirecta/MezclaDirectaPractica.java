package mezcladirecta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MezclaDirectaPractica {

    /** Intercala por pares los bloques ordenados de hasta L enteros. */
    public static void intercalarBloques(String archivoF1, String archivoF2,
            String archivoSalida, int L) throws IOException {
        if (L < 1) {
            throw new IllegalArgumentException("El tamaño del bloque debe ser positivo.");
        }

        try (BufferedReader lector1 = new BufferedReader(new FileReader(archivoF1));
                BufferedReader lector2 = new BufferedReader(new FileReader(archivoF2));
                BufferedWriter escritor = new BufferedWriter(
                        new FileWriter(archivoSalida))) {

            Integer valor1 = leerEntero(lector1);
            Integer valor2 = leerEntero(lector2);

            while (valor1 != null || valor2 != null) {
                int restantes1 = L;
                int restantes2 = L;

                while (true) {
                    boolean hay1 = valor1 != null && restantes1 > 0;
                    boolean hay2 = valor2 != null && restantes2 > 0;
                    if (!hay1 && !hay2) {
                        break;
                    }

                    // Si el otro bloque se agotó, se copia el resto del actual.
                    if (hay1 && (!hay2 || valor1 <= valor2)) {
                        escritor.write(Integer.toString(valor1));
                        escritor.newLine();
                        valor1 = leerEntero(lector1);
                        restantes1--;
                    } else {
                        escritor.write(Integer.toString(valor2));
                        escritor.newLine();
                        valor2 = leerEntero(lector2);
                        restantes2--;
                    }
                }
                // Cada par nuevo vuelve a tener un límite de L por entrada.
            }
        }
    }

    private static Integer leerEntero(BufferedReader lector) throws IOException {
        String linea = lector.readLine();
        return linea == null ? null : Integer.valueOf(linea.trim());
    }

    public static void main(String[] args) {
        try {
            intercalarBloques("f1.txt", "f2.txt", "f3.txt", 20);
            System.out.println("Mezcla completada. Se generó f3.txt.");
        } catch (IOException e) {
            System.err.println("Error de lectura o escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Cada renglón de entrada debe contener un entero válido.");
        }
    }
}
