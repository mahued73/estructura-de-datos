package mezcladirecta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MezclaDirectaPractica {

    /** Intercala por pares los bloques ordenados de hasta L enteros. */
    public static void intercalarBloques(String archivoF1, String archivoF2,
            String archivoSalida, long L) throws IOException {
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
                long restantes1 = L;
                long restantes2 = L;

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
            ordenarArchivos("f1.txt", "f2.txt", "f3.txt");
            System.out.println("Mezcla completada. Se generó f3.txt.");
        } catch (IOException e) {
            System.err.println("Error de lectura o escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Cada renglón de entrada debe contener un entero válido.");
        }
    }

    /** Ordena dos entradas por pasadas de mezcla directa. */
    public static void ordenarArchivos(String f1, String f2, String f3) throws IOException {
        Path temporales = Files.createTempDirectory("mezcla-directa-");
        Path mezclado = temporales.resolve("mezclado.txt");
        Path auxiliar1 = temporales.resolve("auxiliar1.txt");
        Path auxiliar2 = temporales.resolve("auxiliar2.txt");
        try {
            try (BufferedWriter salida = Files.newBufferedWriter(mezclado)) {
                for (String archivo : new String[]{f1, f2}) {
                    try (BufferedReader entrada = Files.newBufferedReader(Path.of(archivo))) {
                        String linea;
                        while ((linea = entrada.readLine()) != null) {
                            salida.write(linea);
                            salida.newLine();
                        }
                    }
                }
            }
            long L = 1;
            while (repartirBloques(mezclado, auxiliar1, auxiliar2, L)) {
                intercalarBloques(auxiliar1.toString(), auxiliar2.toString(),
                        mezclado.toString(), L);
                L *= 2;
            }
            Files.copy(mezclado, Path.of(f3), StandardCopyOption.REPLACE_EXISTING);
        } finally {
            Files.deleteIfExists(mezclado);
            Files.deleteIfExists(auxiliar1);
            Files.deleteIfExists(auxiliar2);
            Files.deleteIfExists(temporales);
        }
    }

    // Reparte los bloques completos o parciales, alternando el archivo de destino.
    private static boolean repartirBloques(Path fuente, Path auxiliar1, Path auxiliar2, long L)
            throws IOException {
        boolean aPrimero = true;
        boolean haySegundoBloque = false;
        long enBloque = 0;
        try (BufferedReader lector = Files.newBufferedReader(fuente);
                BufferedWriter primero = Files.newBufferedWriter(auxiliar1);
                BufferedWriter segundo = Files.newBufferedWriter(auxiliar2)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                BufferedWriter destino = aPrimero ? primero : segundo;
                destino.write(linea);
                destino.newLine();
                if (!aPrimero) {
                    haySegundoBloque = true;
                }
                enBloque++;
                if (enBloque == L) {
                    enBloque = 0;
                    aPrimero = !aPrimero;
                }
            }
        }
        return haySegundoBloque;
    }
}
