# QuickSort y ShellSort

Tarea 2 de la Unidad 5 de Estructura de Datos. Se usa el QuickSort de la asignatura con partición de Lomuto y pivote final. ShellSort completa el ciclo de desplazamiento del PDF con intervalos n/2, n/4 y así hasta 1.

## Clonar el repositorio

Abre PowerShell en la carpeta donde guardarás el repositorio.

```powershell
git clone https://github.com/mahued73/estructura-de-datos.git
cd estructura-de-datos\quicksort-shellsort
```

## Reporte y evidencias

[Ver el reporte completo en PDF](reporte/Estructura_de_Datos_Tarea_02_Unidad_05_20261122_AhuedCortes_M.pdf)

- [Ejecución de QuickSort en Visual Studio Code](evidencias/QuickSort_VSCode.jpg)
- [Ejecución de ShellSort en Visual Studio Code](evidencias/ShellSort_VSCode.jpg)

## Compilar y ejecutar

Requisito: JDK con java y javac disponibles. Verificado con JDK 21.0.11.

Desde la carpeta quicksort-shellsort, abre PowerShell y ejecuta:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -Xlint:all -d out src\Metodos_de_ordenamiento\*.java
java -cp out Metodos_de_ordenamiento.MainQuick
java -cp out Metodos_de_ordenamiento.MainShell
```

## Visual Studio Code

Abre esta carpeta en Visual Studio Code y usa la extensión Extension Pack for Java. En Ejecutar y depurar selecciona QuickSort o ShellSort y presiona F5. La salida se muestra en la consola de depuración.

## Salida de QuickSort

```text
Arreglo original:
[6, 1, 5, 8, 3, 2, 7, 4]
Arreglo ordenado con Quicksort:
[1, 2, 3, 4, 5, 6, 7, 8]
```

## Salida de ShellSort

```text
Arreglo original:
[6, 1, 5, 8, 3, 2, 7, 4]
Arreglo ordenado con ShellSort:
[1, 2, 3, 4, 5, 6, 7, 8]
```
