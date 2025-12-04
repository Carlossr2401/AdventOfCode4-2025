# Advent of Code 2025 - Day 4: Printing Department

Este repositorio contiene la solución para el **Día 4** del Advent of Code 2025, desarrollado en **Java**. El objetivo del reto es optimizar el trabajo de los montacargas en el departamento de impresión del Polo Norte, identificando y eliminando rollos de papel accesibles en una cuadrícula.

## 🧩 Descripción del Problema

El problema se divide en dos partes:

1.  **Parte 1**: Calcular cuántos rollos de papel (`@`) son accesibles para un montacargas. Un rollo es accesible si tiene **menos de 4** rollos adyacentes (en las 8 direcciones posibles).
2.  **Parte 2**: Simular un proceso iterativo donde, una vez que un rollo es accesible, se elimina. Esto puede hacer que nuevos rollos se vuelvan accesibles. El objetivo es calcular el número total de rollos que se pueden eliminar hasta que no queden más accesibles.

## 🏗️ Arquitectura y Principios de Diseño

La solución ha sido diseñada siguiendo estrictamente los principios de **Modularidad** y **Responsabilidad Única (SRP - Single Responsibility Principle)**. Esto asegura que el código sea mantenible, legible y fácil de testear.

### 1. Modularidad

El código se ha dividido en paquetes (`software.aoc.day4.a` y `software.aoc.day4.b`) y en clases pequeñas y cohesivas, donde cada una encapsula una parte específica de la lógica del dominio. No existe una "clase divina" que haga todo; en su lugar, los componentes colaboran entre sí.

### 2. Principio de Responsabilidad Única (SRP)

Cada clase tiene una única razón para cambiar. A continuación se detalla la responsabilidad de cada componente:

- **`FileInstructionReader`**:

  - **Responsabilidad**: Manejar la entrada/salida (I/O). Su único trabajo es leer el archivo de texto y transformar las líneas crudas en una estructura de datos inicial (`PaperRollMap`).
  - **Por qué cumple SRP**: No sabe nada sobre las reglas de los montacargas ni sobre cómo contar vecinos. Solo sabe leer archivos.

- **`PaperRollMap`**:

  - **Responsabilidad**: Representar el estado de la cuadrícula (el mapa de rollos). Proporciona métodos para acceder a los datos de manera segura (`getValue`, `getRows`, `getCols`).
  - **Por qué cumple SRP**: Es una estructura de datos pura (un `record`). No contiene lógica de negocio compleja, solo la representación del terreno. En la Parte 2, también maneja la creación de nuevos estados del mapa (inmutabilidad).

- **`MapFinder`**:

  - **Responsabilidad**: Contiene la **lógica de negocio** pura. Es el "cerebro" que conoce las reglas del problema: cómo contar vecinos, qué constituye un rollo accesible y (en la Parte 2) cómo iterar el proceso de eliminación.
  - **Por qué cumple SRP**: No se preocupa por de dónde vienen los datos (archivo) ni cómo se muestran. Solo recibe un mapa y aplica algoritmos sobre él.

- **`Main`**:

  - **Responsabilidad**: Es el punto de entrada y orquestador. Conecta los componentes: llama al lector, crea el mapa, instancia el buscador y muestra el resultado.
  - **Por qué cumple SRP**: Su única función es iniciar la aplicación.

- **`Coordinate`** (Clase auxiliar):
  - **Responsabilidad**: Representar un punto `(fila, columna)` en el espacio 2D. Simplifica el paso de coordenadas entre métodos.

## 🚀 Cómo Ejecutar el Proyecto

El proyecto es una aplicación Java estándar gestionada con Maven.

### Requisitos

- Java 17 o superior.
- Maven.

### Ejecución

Puedes ejecutar la clase `Main` de cada parte directamente desde tu IDE o mediante línea de comandos si está configurado.

El archivo de entrada se espera en: `src/main/resources/map`.

---

_Desarrollado con ❤️ y código limpio para el Advent of Code 2025._
