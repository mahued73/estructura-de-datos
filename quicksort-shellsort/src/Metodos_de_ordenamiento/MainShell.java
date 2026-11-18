package Metodos_de_ordenamiento;
public class MainShell {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 8, 3, 2, 7, 4};
        System.out.println("Arreglo original:");
        ShellSort.imprimirArreglo(arr);
        ShellSort.ordenar(arr);
        System.out.println("Arreglo ordenado con ShellSort:");
        ShellSort.imprimirArreglo(arr);
    }
}
