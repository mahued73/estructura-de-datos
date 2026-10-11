# Pilas estáticas y dinámicas en Java

Estructura de Datos · Tarea 1 de la unidad 3

## Archivos

- `PilaSimple.java`: guarda hasta cinco enteros en un arreglo.
- `PilaDinamica.java`: guarda los datos en nodos enlazados.
- `Nodo.java`: contiene el dato y la referencia al siguiente nodo.
- `lanzador_pilasimple.java`: ejecuta el ejemplo de la pila estática.
- `Main.java`: ejecuta el ejemplo de la pila dinámica.

Los cinco fuentes están en `src/Estructuras_lineales`. El [reporte en PDF](reporte/Estructura_de_Datos_Tarea_01_Unidad_03_20261011_AhuedCortes_M.pdf) incluye la explicación, el diagrama LIFO, las pruebas y las conclusiones.

## Funcionamiento

Ambas pilas siguen LIFO: el último dato que entra es el primero que sale. La estática usa un arreglo de capacidad fija y un índice llamado `tope`. La dinámica usa nodos enlazados y una referencia llamada `cima`; puede agregar nodos mientras haya memoria disponible.

Se conservan las operaciones de clase: `push`, `pop` y `mostrar`. Se agregaron `isEmpty` y `peek` a ambas pilas, además de `isFull` a la estática. `peek()` muestra el dato de arriba sin retirarlo. Si la pila está vacía, muestra un mensaje.

En la estática, `push()` comprueba que haya espacio. En ambas, `pop()` comprueba que haya un dato para sacar. `mostrar()` recorre la estática del fondo al tope y la dinámica de la cima al fondo; la salida indica esa dirección.

## Compilar y ejecutar

Desde esta carpeta, con un JDK instalado:

```text
javac -encoding UTF-8 -d out src/Estructuras_lineales/*.java
java -cp out Estructuras_lineales.lanzador_pilasimple
java -cp out Estructuras_lineales.Main
```

En el IDE se ejecutan las clases `lanzador_pilasimple` y `Main`, que pertenecen al paquete `Estructuras_lineales`.

## Ejecuciones

Se insertan 10, 20 y 30, se consulta el dato de arriba y se retira el 30. Después se llena el arreglo de cinco posiciones y se intenta agregar un sexto dato. La dinámica sí conserva los seis datos porque no tiene esa capacidad fija. Al final se vacía cada pila y se intenta consultar y retirar un dato cuando ya no hay elementos.

### Pila estática

```text
=== PILA ESTATICA ===
Esta vacia: true
Metiste: 10
Metiste: 20
Metiste: 30
Pila actual (Fondo -> Tope): 10 20 30 
Dato en el tope: 30
Sacaste: 30
Pila actual (Fondo -> Tope): 10 20 

=== LLENAR LA PILA ===
Metiste: 30
Metiste: 40
Metiste: 50
Esta llena: true
Pila llena: no se pudo insertar 60.
Pila actual (Fondo -> Tope): 10 20 30 40 50 
Dato en el tope: 50

=== VACIAR LA PILA ===
Sacaste: 50
Sacaste: 40
Sacaste: 30
Sacaste: 20
Sacaste: 10
Esta vacia: true
Pila vacia: no hay un dato para consultar.
Pila vacia: no hay elementos para sacar.
```

### Pila dinámica

```text
=== PILA DINAMICA ===
Esta vacia: true
Pila dinamica (Cima -> Fondo): 30 20 10 
Dato en la cima: 30
Sacaste de la pila: 30
Pila dinamica (Cima -> Fondo): 20 10 

=== AGREGAR MAS NODOS ===
Pila dinamica (Cima -> Fondo): 60 50 40 30 20 10 
Dato en la cima: 60

=== VACIAR LA PILA ===
Sacaste de la pila: 60
Sacaste de la pila: 50
Sacaste de la pila: 40
Sacaste de la pila: 30
Sacaste de la pila: 20
Sacaste de la pila: 10
Esta vacia: true
Pila vacia: no hay un dato para consultar.
Pila dinamica vacia: no hay elementos para sacar.
```
