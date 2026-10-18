# Colas en Java

Tarea 2 de la unidad 3 de Estructura de Datos. Entrega del 18 de octubre de 2026.

Alumno: Mauricio Ahued Cortés.  
Docente: Víctor Hugo Vásquez Herrera.

La práctica compara una cola estática lineal, una circular y una dinámica. Cada una tiene su propio programa `Main`. El método `peek()` consulta el primer dato sin sacarlo; en la dinámica, `contarElementos()` cuenta los nodos mediante un recorrido.

## Organización

```text
src/Estructuras_lineales/
  Nodo.java
  COLA_ESTATICA/
    ColaEstatica.java
    MainColaEstatica.java
  COLA_CIRCULAR/
    ColaEstaticaCircular.java
    MainColaCircular.java
  COLA/
    ColaDinamica.java
    MainColaDinamica.java
reporte/
  Estructura_de_Datos_Tarea_02_U3_20261018_AhuedCortes_M.pdf
```

Las tres colas están en paquetes separados. La dinámica utiliza la clase `Nodo`.

## Ejecución

Con un JDK instalado, abre la carpeta `colas` en Visual Studio Code. Abre el archivo `MainColaEstatica.java`, `MainColaCircular.java` o `MainColaDinamica.java` y selecciona **Run** sobre su método `main`. Cada programa usa datos fijos y no pide información por teclado.

También puedes compilar desde una terminal situada en `colas`:

```text
javac -encoding UTF-8 -d bin src/Estructuras_lineales/Nodo.java src/Estructuras_lineales/COLA_ESTATICA/ColaEstatica.java src/Estructuras_lineales/COLA_ESTATICA/MainColaEstatica.java src/Estructuras_lineales/COLA_CIRCULAR/ColaEstaticaCircular.java src/Estructuras_lineales/COLA_CIRCULAR/MainColaCircular.java src/Estructuras_lineales/COLA/ColaDinamica.java src/Estructuras_lineales/COLA/MainColaDinamica.java
```

Ejecuta cada demostración por separado:

```text
java -cp bin Estructuras_lineales.COLA_ESTATICA.MainColaEstatica
java -cp bin Estructuras_lineales.COLA_CIRCULAR.MainColaCircular
java -cp bin Estructuras_lineales.COLA.MainColaDinamica
```

## Resultados

- En la cola lineal entran 10, 20 y 30. Después de retirar 10, la posición libre al inicio no se vuelve a usar y se rechaza la inserción de 40.
- La circular sí reutiliza ese espacio. Después de sacar 10, acepta 40 y muestra la fila 20, 30 y 40.
- La dinámica cuenta tres nodos. Al vaciarla, el conteo es cero; después acepta un nuevo dato, 50.

En las tres se conserva el orden FIFO: sale primero el dato que entró primero. Los mensajes de cola llena o vacía corresponden a las operaciones que se prueban. Cuando no hay elementos, `peek()` muestra un mensaje y devuelve `-1`.

## Reporte

[Ver el PDF con la explicación, la comparación y las tres capturas de ejecución](reporte/Estructura_de_Datos_Tarea_02_U3_20261018_AhuedCortes_M.pdf).
