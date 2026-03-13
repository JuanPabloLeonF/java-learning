# ☕ Java Collections Framework (JCF)

El **Java Collections Framework** es un conjunto de **interfaces y clases** que permiten **almacenar, manipular y procesar grupos de objetos de manera eficiente**.

Proporciona estructuras de datos como:

* Listas
* Conjuntos
* Colas
* Mapas

Estas estructuras ayudan a **organizar datos, buscar elementos, ordenar información y mejorar el rendimiento de aplicaciones**.

---

# 📚 Jerarquía del Java Collections Framework

```
Iterable
   │
Collection
   ├── List
   │     ├── ArrayList
   │     ├── LinkedList
   │     ├── Vector
   │     └── Stack
   │
   ├── Set
   │     ├── HashSet
   │     ├── LinkedHashSet
   │     └── TreeSet
   │
   └── Queue
         ├── PriorityQueue
         └── Deque
               └── ArrayDeque

Map (no extiende Collection)
   ├── HashMap
   ├── LinkedHashMap
   ├── TreeMap
   └── Hashtable
```

---

# 1️⃣ Interfaz `Collection`

## ¿Qué es?

Es la **interfaz raíz del framework de colecciones**.

Define los **métodos básicos para trabajar con grupos de objetos**.

Todas las estructuras como `List`, `Set` y `Queue` heredan de esta interfaz.

---

## ¿Para qué se usa?

Para trabajar con colecciones **sin importar la implementación concreta**.

Ejemplo:

```java
Collection<String> nombres = new ArrayList<>();
```

---

## Métodos principales

### add()

Agrega un elemento.

```java
Collection<String> nombres = new ArrayList<>();

nombres.add("Juan");
nombres.add("Maria");
```

---

### remove()

Elimina un elemento.

```java
nombres.remove("Juan");
```

---

### size()

Devuelve el número de elementos.

```java
System.out.println(nombres.size());
```

---

### contains()

Verifica si existe un elemento.

```java
System.out.println(nombres.contains("Maria"));
```

---

### iterator()

Permite recorrer la colección.

```java
Iterator<String> it = nombres.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

---

### clear()

Elimina todos los elementos.

```java
nombres.clear();
```

---

# 2️⃣ Interfaz `List`

Una **List** es una colección **ordenada**.

Características:

✔ Mantiene el orden de inserción
✔ Permite duplicados
✔ Permite acceso por índice

---

## ¿Cuándo usar List?

Cuando:

* necesitas mantener el orden
* necesitas acceder por índice
* permites duplicados

---

## Crear una instancia

```java
List<String> lista = new ArrayList<>();
```

---

## Métodos importantes

### add()

```java
lista.add("Java");
lista.add("Python");
```

---

### add(index, element)

```java
lista.add(1, "C++");
```

---

### get()

Obtiene un elemento por índice.

```java
System.out.println(lista.get(0));
```

---

### set()

Reemplaza un elemento.

```java
lista.set(0, "JavaScript");
```

---

### remove()

```java
lista.remove(1);
```

---

### indexOf()

```java
System.out.println(lista.indexOf("Python"));
```

---

### size()

```java
System.out.println(lista.size());
```

---

### recorrer lista

```java
for(String lenguaje : lista){
    System.out.println(lenguaje);
}
```

---

# Implementaciones de List

---

# 📦 ArrayList

Lista basada en **arreglo dinámico**.

Características:

✔ acceso rápido por índice
✔ inserción lenta en medio
✔ muy usada

---

## Crear ArrayList

```java
List<String> lista = new ArrayList<>();
```

---

## Ejemplo completo

```java
import java.util.ArrayList;
import java.util.List;

public class EjemploArrayList {

    public static void main(String[] args) {

        List<String> lenguajes = new ArrayList<>();

        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("C#");

        System.out.println(lenguajes.get(1));

        lenguajes.remove("Python");

        for(String l : lenguajes){
            System.out.println(l);
        }

    }

}
```

---

# 🔗 LinkedList

Lista basada en **nodos enlazados**.

Cada elemento apunta al siguiente.

---

## Ventajas

✔ insertar rápido
✔ eliminar rápido

---

## Desventajas

❌ acceso lento por índice

---

## Crear LinkedList

```java
List<String> lista = new LinkedList<>();
```

---

## Ejemplo

```java
LinkedList<String> lista = new LinkedList<>();

lista.add("A");
lista.add("B");

lista.addFirst("Inicio");
lista.addLast("Final");

System.out.println(lista);
```

---

# 🧵 Vector

Versión **sincronizada** de ArrayList.

Hoy en día **casi no se usa**.

---

```java
Vector<Integer> vector = new Vector<>();

vector.add(10);
vector.add(20);
```

---

# 📚 Stack

Implementa una **pila (LIFO)**.

Last In First Out.

---

## Métodos

| método | descripción |
| ------ | ----------- |
| push() | insertar    |
| pop()  | eliminar    |
| peek() | ver cima    |

---

## Ejemplo

```java
Stack<Integer> pila = new Stack<>();

pila.push(10);
pila.push(20);

System.out.println(pila.peek());

pila.pop();
```

---

# 3️⃣ Interfaz `Set`

Un **Set** es una colección que **NO permite duplicados**.

---

## Características

✔ elementos únicos
✔ no acceso por índice

---

## Crear Set

```java
Set<String> set = new HashSet<>();
```

---

## Métodos principales

```java
set.add("Java");

set.remove("Java");

set.contains("Java");

set.size();
```

---

# Implementaciones de Set

---

# HashSet

Basado en **tabla hash**.

✔ muy rápido
❌ no mantiene orden

```java
Set<String> tecnologias = new HashSet<>();

tecnologias.add("Java");
tecnologias.add("Java");

System.out.println(tecnologias);
```

---

# LinkedHashSet

Mantiene **orden de inserción**.

```java
Set<String> datos = new LinkedHashSet<>();

datos.add("A");
datos.add("B");
datos.add("C");
```

---

# TreeSet

Ordena automáticamente.

```java
Set<Integer> numeros = new TreeSet<>();

numeros.add(5);
numeros.add(2);
numeros.add(8);

System.out.println(numeros);
```

Resultado

```
[2,5,8]
```

---

# 4️⃣ Queue

Una **cola FIFO**.

First In First Out.

---

## Crear Queue

```java
Queue<String> cola = new LinkedList<>();
```

---

## Métodos

| método  | descripción |
| ------- | ----------- |
| offer() | agregar     |
| poll()  | eliminar    |
| peek()  | ver         |

---

## Ejemplo

```java
Queue<String> cola = new LinkedList<>();

cola.offer("Cliente1");
cola.offer("Cliente2");

System.out.println(cola.poll());
```

---

# PriorityQueue

Ordena por **prioridad**.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(5);
pq.add(1);
pq.add(3);

System.out.println(pq.poll());
```

---

# Deque

Cola de **doble extremo**.

Permite insertar por ambos lados.

---

## Ejemplo

```java
Deque<Integer> deque = new ArrayDeque<>();

deque.addFirst(1);
deque.addLast(2);

System.out.println(deque);
```

---

# 5️⃣ Map

Un **Map** guarda **clave → valor**.

No extiende `Collection`.

---

## Crear Map

```java
Map<Integer,String> usuarios = new HashMap<>();
```

---

## Métodos principales

### put()

```java
usuarios.put(1,"Juan");
```

---

### get()

```java
System.out.println(usuarios.get(1));
```

---

### remove()

```java
usuarios.remove(1);
```

---

### containsKey()

```java
usuarios.containsKey(2);
```

---

### keySet()

```java
for(Integer id : usuarios.keySet()){
    System.out.println(id);
}
```

---

# Implementaciones de Map

---

# HashMap

✔ muy rápido
❌ sin orden

```java
Map<Integer,String> map = new HashMap<>();
```

---

# LinkedHashMap

Mantiene orden de inserción.

```java
Map<Integer,String> map = new LinkedHashMap<>();
```

---

# TreeMap

Ordena por clave.

```java
Map<Integer,String> map = new TreeMap<>();
```

---

# Hashtable

Versión sincronizada antigua.

---

# 6️⃣ Ordenamiento

Para ordenar objetos usamos dos interfaces.

---

# Comparable

Define **orden natural**.

```java
class Persona implements Comparable<Persona>{

    int edad;

    public int compareTo(Persona p){
        return this.edad - p.edad;
    }

}
```

---

# Comparator

Define **orden externo**.

```java
Comparator<Persona> ordenarEdad = (a,b) -> a.edad - b.edad;
```

---

# Diferencia entre List Set y Map

| estructura | duplicados  | orden   | acceso |
| ---------- | ----------- | ------- | ------ |
| List       | si          | si      | índice |
| Set        | no          | depende | no     |
| Map        | clave única | depende | clave  |

---

# Cómo elegir la colección correcta

Usa **ArrayList**

✔ acceso rápido
✔ listas grandes

---

Usa **LinkedList**

✔ muchas inserciones

---

Usa **HashSet**

✔ eliminar duplicados

---

Usa **HashMap**

✔ búsquedas rápidas

---

Usa **TreeMap / TreeSet**

✔ datos ordenados automáticamente

---

Aquí tienes una **sección lista para pegar en tu `README.md`** que muestra **toda la jerarquía del Java Collections Framework con diagramas** y una pequeña explicación de cada nivel.

---

# 🚀 Jerarquía Completa de Java Collections Framework

El **Java Collections Framework (JCF)** es un conjunto de **interfaces y clases** diseñadas para almacenar y manipular grupos de objetos de manera eficiente.

La jerarquía comienza desde **interfaces generales** y termina en **implementaciones concretas** que usamos en el código.

---

# 📊 Diagrama General de la Jerarquía

```text
                         Iterable
                             │
                             ▼
                         Collection
                ┌────────────┼────────────┐
                ▼            ▼            ▼
               List          Set         Queue
                │             │            │
     ┌──────────┼──────┐      │      ┌─────┴────────┐
     ▼          ▼      ▼      ▼      ▼              ▼
 ArrayList   LinkedList Vector  HashSet     PriorityQueue
                │        │        │
                │        ▼        ▼
                │      Stack   LinkedHashSet
                │
                ▼
             Deque
                │
           ArrayDeque


Map (no extiende Collection)
     │
     ├── HashMap
     ├── LinkedHashMap
     ├── TreeMap
     └── Hashtable
```

---

# 📚 Nivel 1 — `Iterable`

`Iterable` es la interfaz más básica que permite **recorrer elementos usando un iterador**.

Es lo que hace posible usar el **for-each**.

```java
List<String> nombres = new ArrayList<>();

for(String nombre : nombres){
    System.out.println(nombre);
}
```

---

# 📚 Nivel 2 — `Collection`

La interfaz `Collection` es la **raíz de todas las colecciones (excepto Map)**.

Define operaciones básicas como:

| método     | descripción          |
| ---------- | -------------------- |
| add()      | agregar elemento     |
| remove()   | eliminar elemento    |
| size()     | tamaño               |
| clear()    | eliminar todo        |
| contains() | verificar existencia |

Ejemplo:

```java
Collection<String> datos = new ArrayList<>();

datos.add("Java");
datos.add("Python");

System.out.println(datos.size());
```

---

# 📚 Nivel 3 — `List`

`List` representa una **colección ordenada**.

Características:

✔ mantiene orden
✔ permite duplicados
✔ acceso por índice

Implementaciones principales:

```
List
 ├── ArrayList
 ├── LinkedList
 ├── Vector
 └── Stack
```

Ejemplo:

```java
List<String> lista = new ArrayList<>();

lista.add("Java");
lista.add("C++");

System.out.println(lista.get(0));
```

---

# 📚 Nivel 3 — `Set`

`Set` es una colección que **no permite elementos duplicados**.

Implementaciones:

```
Set
 ├── HashSet
 ├── LinkedHashSet
 └── TreeSet
```

Ejemplo:

```java
Set<String> tecnologias = new HashSet<>();

tecnologias.add("Java");
tecnologias.add("Java");

System.out.println(tecnologias);
```

Resultado

```
[Java]
```

---

# 📚 Nivel 3 — `Queue`

`Queue` representa una **cola FIFO**.

First In First Out.

Implementaciones principales:

```
Queue
 ├── PriorityQueue
 └── LinkedList
```

Ejemplo:

```java
Queue<String> cola = new LinkedList<>();

cola.offer("cliente1");
cola.offer("cliente2");

System.out.println(cola.poll());
```

---

# 📚 Nivel 3 — `Deque`

`Deque` significa **Double Ended Queue**.

Permite insertar y eliminar por ambos extremos.

Implementaciones:

```
Deque
 └── ArrayDeque
```

Ejemplo:

```java
Deque<Integer> deque = new ArrayDeque<>();

deque.addFirst(10);
deque.addLast(20);

System.out.println(deque);
```

---

# 📚 Map (Estructura Separada)

`Map` **no pertenece a Collection**.

Guarda datos en **pares clave → valor**.

```
Map
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 └── Hashtable
```

Ejemplo:

```java
Map<Integer,String> usuarios = new HashMap<>();

usuarios.put(1,"Juan");
usuarios.put(2,"Ana");

System.out.println(usuarios.get(1));
```

---

# 📊 Resumen de cuándo usar cada estructura

| estructura | usar cuando              |
| ---------- | ------------------------ |
| ArrayList  | acceso rápido por índice |
| LinkedList | muchas inserciones       |
| HashSet    | evitar duplicados        |
| TreeSet    | mantener orden           |
| HashMap    | búsquedas rápidas        |
| TreeMap    | claves ordenadas         |

---

# 🧠 Idea Clave

El **Java Collections Framework** separa:

```
Interfaces (contratos)
      ↓
Implementaciones (estructuras reales)
```

Ejemplo recomendado:

```java
List<String> lista = new ArrayList<>();
```

No:

```java
ArrayList<String> lista = new ArrayList<>();
```

Esto permite **cambiar la implementación sin modificar el resto del código**.

---
Tu README ya está **muy bien estructurado** 👌.
Te agrego **las secciones que faltan** para que quede **completo y moderno (Java funcional)**.
Esto lo puedes **pegar directamente al final de tu `README.md`**.

---

# 🔥 Java Streams (Procesamiento Funcional de Datos)

Los **Streams** introducidos en **Java 8** permiten procesar colecciones de forma **funcional, declarativa y eficiente**.

Un **Stream** es un **pipeline de operaciones** que procesa datos provenientes de una fuente como:

* List
* Set
* Map
* Arrays
* Archivos

Importante:

> **Un Stream no almacena datos. Solo los procesa.**

---

# 📊 Flujo de un Stream

```text
Source → Stream → Intermediate Operations → Terminal Operation → Result
```

Ejemplo conceptual:

```
List
 ↓
stream()
 ↓
filter()
 ↓
map()
 ↓
collect()
```

---

# 📦 Crear Streams

Desde una colección:

```java
List<String> nombres = List.of("Juan","Maria","Pedro");

Stream<String> stream = nombres.stream();
```

Desde un array:

```java
String[] datos = {"A","B","C"};

Stream<String> stream = Arrays.stream(datos);
```

Desde valores directos:

```java
Stream<Integer> numeros = Stream.of(1,2,3,4);
```

---

# ⚙️ Tipos de operaciones

## 1️⃣ Operaciones intermedias

Transforman el stream.

| método     | descripción           |
| ---------- | --------------------- |
| filter()   | filtrar elementos     |
| map()      | transformar elementos |
| sorted()   | ordenar               |
| distinct() | eliminar duplicados   |
| limit()    | limitar resultados    |

Ejemplo:

```java
List<Integer> numeros = List.of(1,2,3,4,5,6);

numeros.stream()
       .filter(n -> n % 2 == 0);
```

Estas **no ejecutan el stream todavía**.

---

## 2️⃣ Operaciones terminales

Producen el resultado final.

| método      | descripción             |
| ----------- | ----------------------- |
| forEach()   | recorrer                |
| collect()   | convertir a colección   |
| count()     | contar                  |
| reduce()    | reducir valores         |
| findFirst() | obtener primer elemento |

Ejemplo:

```java
numeros.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

---

# 🧪 Ejemplo completo

```java
List<String> nombres = List.of("juan","ana","pedro");

List<String> resultado = nombres.stream()
        .map(String::toUpperCase)
        .filter(nombre -> nombre.startsWith("J"))
        .toList();

System.out.println(resultado);
```

Resultado

```
[JUAN]
```

---

# ⚡ Collectors (Explicado)

`Collectors` permite **transformar el resultado de un stream en diferentes estructuras**.

Clase:

```java
java.util.stream.Collectors
```

Ejemplos comunes:

---

## Convertir a List

```java
List<String> resultado = nombres.stream()
        .collect(Collectors.toList());
```

---

## Convertir a Set

```java
Set<String> resultado = nombres.stream()
        .collect(Collectors.toSet());
```

---

## Agrupar elementos

```java
Map<Integer, List<String>> agrupado =
        nombres.stream()
               .collect(Collectors.groupingBy(String::length));
```

Resultado conceptual:

```
{
 3 -> [Ana]
 4 -> [Juan]
}
```

---

## Contar elementos

```java
long total = nombres.stream()
        .collect(Collectors.counting());
```

---

# 🚀 flatMap() explicado visualmente

`flatMap()` se usa cuando tenemos **colecciones dentro de colecciones**.

Ejemplo:

```
Lista de listas
```

```java
List<List<String>> datos = List.of(
        List.of("Java","Python"),
        List.of("C++","Go")
);
```

Sin `flatMap`:

```
[[Java,Python],[C++,Go]]
```

Con `flatMap`:

```java
List<String> resultado = datos.stream()
        .flatMap(List::stream)
        .toList();
```

Resultado:

```
[Java,Python,C++,Go]
```

Visualmente:

```
Stream
 ↓
[List1,List2]
 ↓
flatMap
 ↓
[Java,Python,C++,Go]
```

---

# 🔥 Optional (Programación Funcional Segura)

`Optional` es un contenedor que **puede o no contener un valor**.

Evita el clásico error:

```
NullPointerException
```

Clase:

```
java.util.Optional
```

---

## Crear Optional

```java
Optional<String> nombre = Optional.of("Juan");
```

---

## Optional vacío

```java
Optional<String> nombre = Optional.empty();
```

---

## Verificar valor

```java
if(nombre.isPresent()){
    System.out.println(nombre.get());
}
```

---

## Usar valor por defecto

```java
String resultado = nombre.orElse("Desconocido");
```

---

## Usar con Streams

```java
Optional<Integer> numero =
        List.of(1,2,3,4)
        .stream()
        .filter(n -> n > 3)
        .findFirst();
```

---

# 🧠 Complejidad y rendimiento (Streams vs Loops)

| operación | Loop tradicional | Stream     |
| --------- | ---------------- | ---------- |
| filtrar   | O(n)             | O(n)       |
| mapear    | O(n)             | O(n)       |
| ordenar   | O(n log n)       | O(n log n) |

En complejidad **son iguales**.

La diferencia está en:

| característica         | Loop   | Stream     |
| ---------------------- | ------ | ---------- |
| legibilidad            | baja   | alta       |
| paralelismo            | manual | automático |
| programación funcional | no     | sí         |

---

# ⚡ Streams Paralelos

Java permite usar múltiples núcleos CPU fácilmente.

```java
numeros.parallelStream()
       .forEach(System.out::println);
```

Esto divide el trabajo entre varios hilos.

---

# 🧠 Estilo Imperativo vs Funcional

### Imperativo

```java
List<Integer> resultado = new ArrayList<>();

for(int n : numeros){
    if(n > 3){
        resultado.add(n * 2);
    }
}
```

---

### Funcional (Streams)

```java
List<Integer> resultado = numeros.stream()
        .filter(n -> n > 3)
        .map(n -> n * 2)
        .toList();
```

---

# 🚀 Idea Final

El **Java moderno** combina:

```
Collections Framework
        +
Streams
        +
Optional
```

Esto permite escribir código **más declarativo, seguro y expresivo** en **Java**.

---