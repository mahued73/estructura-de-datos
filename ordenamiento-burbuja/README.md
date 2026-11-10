# Ordenamiento por burbuja

Práctica de la unidad 5 de Estructura de Datos. El programa muestra un arreglo de enteros, lo ordena de menor a mayor con el método burbuja y vuelve a imprimirlo.

## Clonar el repositorio

Abre PowerShell en la carpeta donde quieras guardar el repositorio. Necesitas Git y un JDK con java y javac disponibles. La práctica se verificó con JDK 21.0.11.

```powershell
git clone https://github.com/mahued73/estructura-de-datos.git
cd estructura-de-datos\ordenamiento-burbuja
```

## Compilar y ejecutar

Ejecuta estos comandos desde la carpeta de la práctica.

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -Xlint:all -d out src\Metodos_de_ordenamiento\*.java
java -cp out Metodos_de_ordenamiento.Mainburbuja
```

El primer comando crea out para guardar los archivos compilados. El segundo compila las dos clases de src y el tercero ejecuta Mainburbuja. El arreglo se define en el código y se imprime antes y después de llamar al método de ordenamiento.

```text
Arreglo original:
[64 34 25 12 22 11 90]
Arreglo ordenado:
[11 12 22 25 34 64 90]
```

## Archivos del proyecto

- [Burbuja.java](src/Metodos_de_ordenamiento/Burbuja.java) compara e intercambia elementos vecinos hasta ordenar el arreglo.
- [Mainburbuja.java](src/Metodos_de_ordenamiento/Mainburbuja.java) prepara los datos, ejecuta el método e imprime ambos arreglos.

