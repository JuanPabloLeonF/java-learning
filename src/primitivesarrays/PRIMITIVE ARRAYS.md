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

Si quieres, en el siguiente paso puedo enseñarte también:

* 🚀 **Toda la jerarquía completa de Java Collections con diagramas**
* 🚀 **TODOS los métodos de List (más de 25)**
* 🚀 **Cómo funciona HashMap internamente (hashing, buckets, resize)**
* 🚀 **Cómo lo preguntan en entrevistas de Java senior**

y convertir todo esto en un **README de nivel profesional para GitHub**.

