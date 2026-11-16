# Mezcla Directa

Actividad 1 de la Unidad 5 de Estructura de Datos. Cada entrada contiene 20 enteros distintos elegidos al azar entre 10 y 99, escritos en orden aleatorio. El programa empieza con bloques de un elemento, los intercala y aumenta el tamaño de los bloques en cada pasada. Cuando queda un único bloque ordenado, guarda los 40 números en f3.txt.

[Ver el reporte de la práctica en PDF](reporte/Estructura_de_Datos_Actividad_01_Unidad_05_20261118_AhuedCortes_M.pdf)

## Clonar y ejecutar en Visual Studio Code

1. Instala Git, un JDK (se usó el 21.0.11) y la extensión **Extension Pack for Java** de Microsoft en Visual Studio Code.
2. Abre PowerShell y clona el repositorio.

   ```powershell
   git clone https://github.com/mahued73/estructura-de-datos.git
   cd estructura-de-datos\mezcla-directa
   ```

3. En Visual Studio Code, usa **Archivo > Abrir carpeta** y selecciona `mezcla-directa`. Si el IDE no detecta el JDK, abre la paleta de comandos y selecciona **Java: Configure Java Runtime** para elegirlo.
4. Comprueba que `f1.txt` y `f2.txt` estén en esa carpeta, al mismo nivel que `src`. En **Ejecutar y depurar**, selecciona **Ejecutar Mezcla Directa** y presiona **F5**. El programa parte de la raíz del proyecto.
5. Abre `f3.txt` en el explorador del IDE para verificar el resultado.

## Compilar desde PowerShell

Desde la carpeta `mezcla-directa`:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -Xlint:all -d out src\mezcladirecta\MezclaDirectaPractica.java
java -cp out mezcladirecta.MezclaDirectaPractica
```

## Salida exacta del programa

```text
Mezcla completada. Se generó f3.txt.
```

El archivo f3.txt contiene los 40 números de ambas entradas en orden ascendente. El programa escribe un número por renglón. La lista se agrupa de diez en diez para facilitar la lectura.

```text
13 14 17 20 23 24 26 28 31 32
34 37 39 41 44 47 50 52 53 58
60 62 63 64 66 67 68 69 72 77
81 82 86 89 90 91 92 95 97 98
```

[Ver la captura de los tres archivos en Visual Studio Code](evidencias/Archivos_F1_F2_F3_VSCode.jpg).
