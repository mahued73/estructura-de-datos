# Inventario con Árbol Binario de Búsqueda

Proyecto integrador de Estructura de Datos, ITSX. Aplicación Java de consola que organiza productos por nombre utilizando un ABB propio, adaptado de las clases `Nodo` y `ArbolBinarioBusqueda` trabajadas en clase.

## Integrantes

| Integrante | Número de control |
| --- | --- |
| Mauricio Ahued Cortés | 257O02229 |
| Fátima Itzel Martínez Salamanca | 257O03058 |
| Morales Merino Aretzy Esmeralda | 257O00622 |

Docente: Víctor Hugo Vásquez Herrera. Entrega: 5 de noviembre de 2026.

Proyecto: https://github.com/mahued73/estructura-de-datos/tree/main/inventario-abb

Reporte: [PDF con explicación y evidencias](reporte/Estructura_de_Datos_Proyecto_ABB_20261105_Equipo.pdf).

## Ejecutar

Requiere JDK 17 o posterior. Se compiló y probó con JDK 21. No necesita Maven ni bibliotecas externas. Desde la carpeta del proyecto (`inventario-abb` en este repositorio):

```text
javac -encoding UTF-8 -d out src/Producto.java src/Nodo.java src/ArbolBinarioBusqueda.java src/Main.java
java -cp out Main
```

Usar una terminal con entrada UTF-8 si se escriben nombres con acentos. En un IDE, abrir `src` como carpeta de fuentes y ejecutar `Main`. Las clases no declaran paquete, de modo que pueden compilarse con los comandos anteriores.

El menú permite registrar, buscar, eliminar, mostrar el inventario por InOrder y salir. Un registro pide nombre, stock entero y precio; admite punto o coma decimal, sin separadores de miles. Rechaza nombres vacíos, stock negativo y precios negativos, infinitos o NaN. Los registros permanecen en memoria durante la ejecución; al salir no se guardan en disco.

## Organización del código

- `Producto`: reúne nombre, stock y precio; esos valores no cambian una vez creado el objeto.
- `Nodo`: contiene el producto y los enlaces `izq` y `der`.
- `ArbolBinarioBusqueda`: inserta, busca, elimina y obtiene los productos en InOrder.
- `Main`: muestra el menú y valida la entrada.
- `pruebas/PruebasInventario.java`: verifica los casos funcionales sin frameworks externos.

## Adaptación del ABB

Las comparaciones de enteros se sustituyeron por `nombre.compareTo(actual.producto.getNombre())`. Un resultado negativo conduce a la izquierda; uno positivo, a la derecha; cero identifica el mismo nombre y evita duplicados. Se quitan espacios al principio y al final. `compareTo` distingue mayúsculas, minúsculas y acentos: todos los nombres de la demostración empiezan con mayúscula para mantener una comparación consistente. El orden del inventario sigue esta comparación de cadenas.

En la eliminación se conservan los tres casos del código de clase. Si el nodo tiene dos hijos, `obtenerMinimo(actual.der)` localiza el sucesor inorden. Se reemplaza el producto completo y después se elimina la aparición original del sucesor. Así no se mezclan el nombre de un producto con las existencias o el precio de otro.

Cada operación de búsqueda, inserción o eliminación depende de la altura `h` del árbol: O(h), contando las comparaciones como unidad de trabajo. En un árbol equilibrado la altura es O(log n); si se insertan nombres ya ordenados puede degenerar y llegar a O(n). El recorrido InOrder visita los `n` nodos. Este ABB no realiza balanceo automático.

## Pruebas ejecutadas

```text
javac -encoding UTF-8 -d out src/Producto.java src/Nodo.java src/ArbolBinarioBusqueda.java src/Main.java pruebas/PruebasInventario.java
java -cp out PruebasInventario
```

Resultado de las pruebas:

```text
CORRECTO: 52 verificaciones funcionales.
```

Se comprobaron búsquedas en vacío y con datos, orden InOrder, duplicados, eliminación de hoja, nodo con un hijo, raíz con dos hijos, sucesor con hijo derecho, borrado hasta vaciar y rechazo de datos inválidos.

El menú también se ejecutó con la entrada guardada en `evidencias/entrada_demostracion.txt`. La salida completa está en `evidencias/salida_demostracion.txt`; las pruebas de entradas inválidas están en `evidencias/salida_validaciones.txt`. Esos archivos conservan la salida de las pruebas. La carpeta `evidencias` también contiene 21 capturas de la ejecución en consola, numeradas desde `01_menu_ejecucion.png` hasta `21_salida.png`.

## Demostración realizada en consola

Los productos se registraron en este orden:

| Nombre | Stock | Precio |
| --- | ---: | ---: |
| Leche | 10 | 25.00 |
| Arroz | 20 | 18.50 |
| Pan | 30 | 4.00 |
| Aceite | 5 | 40.00 |
| Frijol | 8 | 32.00 |
| Miel | 11 | 90.00 |
| Queso | 6 | 75.00 |

1. Se mostró el inventario y se buscó Miel.
2. Se eliminó **Aceite**, una hoja, y se consultó el inventario.
3. Se eliminó **Arroz**, que después del primer borrado tenía solo el hijo Frijol.
4. Se eliminó **Leche**, la raíz con dos hijos. Miel ocupó su lugar como sucesor inorden y se mostró el inventario final.

Después de esos tres borrados quedan Frijol, Miel, Pan y Queso. Miel conserva stock 11 y precio 90.00. El orden de las operaciones importa para demostrar los casos descritos.

## Evidencias de la ejecución

| Operación | Capturas |
| --- | --- |
| Menú y altas | [Menú](evidencias/01_menu_ejecucion.png), registros 03 a 09 |
| Inventario alfabético | [Inventario completo](evidencias/10_inventario_completo.png) |
| Búsqueda existente | [Miel](evidencias/12_busqueda_miel.png) |
| Búsqueda inexistente | [Cafe](evidencias/13_busqueda_no_encontrado.png) |
| Eliminar una hoja | [Aceite](evidencias/15_eliminacion_aceite.png), [resultado](evidencias/16_inventario_sin_aceite.png) |
| Eliminar un nodo con un hijo | [Arroz](evidencias/17_eliminacion_arroz.png), [resultado](evidencias/18_inventario_sin_arroz.png) |
| Eliminar un nodo con dos hijos | [Leche](evidencias/19_eliminacion_leche.png), [resultado](evidencias/20_inventario_final.png) |
| Salir | [Cierre del programa](evidencias/21_salida.png) |

Las capturas muestran la ejecución en consola. En el reporte se explica cada caso de eliminación y se compara el inventario antes y después de los borrados.
