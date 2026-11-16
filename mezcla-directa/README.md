# Mezcla Directa

Actividad 1 de la Unidad 5 de Estructura de Datos. El programa lee los enteros de `f1.txt` y `f2.txt`, mezcla por pares sus bloques ya ordenados y escribe el resultado en `f3.txt`. La demostración usa bloques de un elemento.

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

Con `45` en `f1.txt` y `12` en `f2.txt`, el archivo generado queda así:

```text
12
45
```

Cada archivo de entrada lleva un entero por renglón. Para probar bloques mayores, cambia el valor de `L` en la llamada de `main` y ordena de menor a mayor los valores de cada bloque de entrada. El último bloque puede tener menos de `L` elementos. Una pasada garantiza el orden dentro de cada bloque combinado. Para ordenar un archivo completo con varios bloques se requieren más pasadas con bloques de mayor tamaño.
