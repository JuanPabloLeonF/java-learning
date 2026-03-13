# 🧵 ¿Qué es un Thread?

Un **Thread (hilo de ejecución)** es la **unidad más pequeña de ejecución dentro de un proceso** en **Java**.

Un programa puede tener **uno o varios threads ejecutándose al mismo tiempo**.

Cada thread tiene su propio:

* contador de programa
* stack de ejecución
* estado de ejecución

Pero **comparte la memoria del proceso**, como:

* Heap
* Variables estáticas
* Objetos

---

# 🧠 Explicación simple

Un **thread** es básicamente **una tarea que se ejecuta de forma independiente dentro de un programa**.

Ejemplo conceptual:

```text
Programa
   │
   ├── Thread 1 → procesar datos
   ├── Thread 2 → leer base de datos
   └── Thread 3 → responder petición HTTP
```

Esto permite que varias operaciones se ejecuten **concurrentemente**.

---

# 📦 Ejemplo sin Threads

Un programa sin threads ejecuta tareas **una después de otra**.

```text
Descargar archivo
      ↓
Procesar archivo
      ↓
Guardar resultado
```

Todo ocurre **secuencialmente**.

---

# ⚡ Ejemplo con Threads

Con threads las tareas pueden ejecutarse **al mismo tiempo**.

```text
Thread 1 → Descargar archivo
Thread 2 → Procesar archivo
Thread 3 → Guardar resultado
```

Esto mejora el **rendimiento y la capacidad de respuesta del sistema**.

---

# 🧠 Threads en la JVM

La **Java Virtual Machine (JVM)** ejecuta cada hilo como un **thread del sistema operativo**.

Esto significa que los threads en **Java** pueden aprovechar:

* múltiples núcleos de CPU
* ejecución concurrente real
* paralelismo en hardware moderno

---

# 📊 Ejemplo real en aplicaciones

Los threads se usan en muchos escenarios:

| aplicación       | uso de threads                     |
| ---------------- | ---------------------------------- |
| servidores web   | manejar múltiples peticiones       |
| videojuegos      | física, renderizado, audio         |
| bases de datos   | consultas concurrentes             |
| aplicaciones GUI | interfaz + tareas en segundo plano |

---

# 🚀 Ejemplo básico de Thread en Java

```java
class MiThread extends Thread {

    public void run() {
        System.out.println("Hola desde un Thread!");
    }

}

public class Main {

    public static void main(String[] args) {

        MiThread hilo = new MiThread();
        hilo.start();

    }

}
```

Salida:

```
Hola desde un Thread!
```

Aquí:

* `start()` inicia el thread
* `run()` contiene la lógica que ejecutará el hilo

---

# 🧠 Idea clave

Un **thread permite dividir un programa en múltiples flujos de ejecución concurrentes**, lo que mejora el rendimiento y la capacidad de manejar múltiples tareas al mismo tiempo en **Java**.

---

# 🧠 Memoria y Threads dentro de un Proceso

Cuando un programa se ejecuta en **Java**, el sistema operativo crea un **proceso**.
Dentro de ese proceso pueden existir **varios threads**.

Los threads **comparten la memoria del proceso**, pero **cada uno tiene su propio stack**.

---

# 📊 Diagrama del Proceso y Threads

```text
Proceso (JVM)
│
├── Heap (memoria compartida)
│     ├── Objetos
│     ├── Variables estáticas
│     └── Instancias de clases
│
├── Thread 1
│     └── Stack
│           ├── métodoA()
│           └── métodoB()
│
├── Thread 2
│     └── Stack
│           ├── métodoC()
│           └── métodoD()
│
└── Thread 3
      └── Stack
            ├── métodoE()
            └── métodoF()
```

---

# 📦 Explicación del diagrama

### Heap (memoria compartida)

Todos los threads pueden acceder a:

* objetos
* variables estáticas
* estructuras de datos

Por eso pueden ocurrir problemas como:

```text
Race Conditions
```

si dos threads modifican el mismo objeto.

---

### Stack (memoria privada del thread)

Cada thread tiene su propio stack donde guarda:

* variables locales
* llamadas a métodos
* estado de ejecución

Ejemplo conceptual:

```text
Thread 1 Stack
 ├── main()
 └── procesarDatos()

Thread 2 Stack
 ├── main()
 └── guardarDatos()
```

---

# ⚡ Visualización simplificada

```text
           PROCESO (JVM)
      ┌─────────────────────┐
      │        HEAP         │
      │  (memoria global)   │
      └─────────┬───────────┘
                │
     ┌──────────┼───────────┐
     │          │           │
 ┌───────┐  ┌───────┐  ┌───────┐
 │Thread1│  │Thread2│  │Thread3│
 └───┬───┘  └───┬───┘  └───┬───┘
     │          │          │
  ┌──────┐   ┌──────┐   ┌──────┐
  │Stack │   │Stack │   │Stack │
  └──────┘   └──────┘   └──────┘
```

---

# 🚨 Punto importante

Como **todos los threads comparten el Heap**, puede ocurrir:

```text
Thread1 modifica objeto
Thread2 modifica el mismo objeto
```

Esto genera problemas de concurrencia como:

* Race Condition
* Deadlock
* Data Inconsistency

Por eso existen mecanismos como:

* `synchronized`
* `Locks`
* `Atomic`
* `volatile`

en **Java**.

---

# 🧵 Threads en Java

Los **Threads (hilos)** permiten ejecutar múltiples tareas **de manera concurrente** dentro de un mismo programa en **Java**.

Un **thread** es la unidad más pequeña de ejecución dentro de un proceso.

Esto permite que una aplicación:

* ejecute tareas en paralelo
* mejore el rendimiento
* aproveche múltiples núcleos de CPU

---

# 📊 Proceso vs Thread

```
Proceso
 ├── Thread 1
 ├── Thread 2
 └── Thread 3
```

Un **proceso** puede contener múltiples **threads**.

Ejemplo real:

```
Aplicación web
 ├── Thread petición usuario 1
 ├── Thread petición usuario 2
 └── Thread petición usuario 3
```

---

# 🧠 ¿Por qué usar Threads?

Permiten:

✔ ejecutar tareas simultáneamente
✔ mejorar rendimiento
✔ realizar operaciones asincrónicas

Ejemplo:

```
Descargar archivo
Leer base de datos
Procesar datos
```

Todas estas tareas pueden ejecutarse **al mismo tiempo**.

---

# 🚀 Crear Threads en Java

Existen varias formas.

---

# 1️⃣ Extender la clase `Thread`

```java
class MiHilo extends Thread {

    public void run() {
        System.out.println("Thread ejecutándose");
    }

}
```

Ejecutar el thread:

```java
MiHilo hilo = new MiHilo();
hilo.start();
```

Importante:

```
start() → inicia el thread
run() → contiene la lógica
```

---

# 2️⃣ Implementar `Runnable` (Forma recomendada)

```java
class MiTarea implements Runnable {

    public void run() {
        System.out.println("Ejecutando tarea");
    }

}
```

Ejecutar:

```java
Thread hilo = new Thread(new MiTarea());
hilo.start();
```

Ventaja:

✔ permite heredar de otras clases.

---

# 3️⃣ Usar Lambda

Desde **Java 8**:

```java
Thread hilo = new Thread(() -> {
    System.out.println("Thread con lambda");
});

hilo.start();
```

---

# 📚 Ciclo de vida de un Thread

```
NEW
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
BLOCKED / WAITING
 ↓
TERMINATED
```

Estados:

| estado     | descripción           |
| ---------- | --------------------- |
| NEW        | creado                |
| RUNNABLE   | listo para ejecutarse |
| RUNNING    | ejecutándose          |
| BLOCKED    | esperando recurso     |
| TERMINATED | finalizado            |

---

# ⚙️ Métodos importantes de Thread

| método      | descripción         |
| ----------- | ------------------- |
| start()     | inicia thread       |
| run()       | código del thread   |
| sleep()     | pausa thread        |
| join()      | esperar otro thread |
| interrupt() | interrumpir         |

---

## sleep()

Pausa un thread.

```java
Thread.sleep(2000);
```

Ejemplo:

```java
System.out.println("Inicio");

Thread.sleep(2000);

System.out.println("Fin");
```

---

## join()

Hace que un thread espere a otro.

```java
Thread hilo = new Thread(() -> {
    System.out.println("Thread ejecutando");
});

hilo.start();
hilo.join();
```

---

# ⚠️ Problema: Race Condition

Cuando **dos threads modifican el mismo recurso al mismo tiempo**.

Ejemplo:

```java
class Contador {

    int valor = 0;

    void incrementar() {
        valor++;
    }

}
```

Si dos threads llaman `incrementar()`:

```
valor puede quedar incorrecto
```

---

# 🔒 Solución: synchronized

Permite que **solo un thread acceda al recurso**.

```java
class Contador {

    int valor = 0;

    synchronized void incrementar() {
        valor++;
    }

}
```

---

# 🔐 Bloques synchronized

También se puede sincronizar un bloque.

```java
synchronized(this){
    valor++;
}
```

---

# 🧠 Locks (Control más avanzado)

Java ofrece **locks explícitos**.

Clase:

```java
java.util.concurrent.locks.ReentrantLock
```

Ejemplo:

```java
Lock lock = new ReentrantLock();

lock.lock();

try{
    valor++;
}
finally{
    lock.unlock();
}
```

---

# ⚡ Volatile

La palabra clave `volatile` asegura **visibilidad entre threads**.

```java
volatile boolean activo = true;
```

Sin `volatile`, otros threads podrían no ver cambios en memoria.

---

# ⚛️ Variables Atómicas

Clase:

```
java.util.concurrent.atomic
```

Ejemplo:

```java
AtomicInteger contador = new AtomicInteger(0);

contador.incrementAndGet();
```

Ventajas:

✔ thread-safe
✔ sin synchronized

---

# 🚀 ExecutorService (Manejo profesional de threads)

Crear threads manualmente no escala bien.

Java ofrece **Thread Pools**.

Clase:

```java
java.util.concurrent.ExecutorService
```

Ejemplo:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(3);

executor.submit(() -> {
    System.out.println("Ejecutando tarea");
});

executor.shutdown();
```

---

# 📊 Tipos de Thread Pools

| método                  | descripción            |
| ----------------------- | ---------------------- |
| newFixedThreadPool      | número fijo de threads |
| newCachedThreadPool     | dinámico               |
| newSingleThreadExecutor | un solo thread         |

---

# 🔥 Callable (Threads con retorno)

`Runnable` no devuelve resultados.

`Callable` sí.

```java
Callable<Integer> tarea = () -> {
    return 10;
};
```

Ejecutar:

```java
Future<Integer> resultado = executor.submit(tarea);

System.out.println(resultado.get());
```

---

# ⚠️ Deadlock

Ocurre cuando dos threads **esperan recursos entre sí**.

Ejemplo conceptual:

```
Thread1 espera recurso A
Thread2 espera recurso B

Thread1 quiere B
Thread2 quiere A
```

Resultado:

```
bloqueo permanente
```

---

# 🧠 Buenas prácticas

✔ usar `ExecutorService`
✔ evitar sincronización innecesaria
✔ usar estructuras concurrentes
✔ preferir `Atomic` sobre `synchronized`

---

# 🚀 Paquete importante

Java ofrece un paquete completo para concurrencia:

```
java.util.concurrent
```

Incluye:

* Thread pools
* Locks
* Atomic variables
* Concurrent collections

---

# 📊 Resumen

| concepto        | uso                    |
| --------------- | ---------------------- |
| Thread          | unidad de ejecución    |
| Runnable        | tarea ejecutable       |
| Callable        | tarea con retorno      |
| ExecutorService | pool de threads        |
| synchronized    | exclusión mutua        |
| Atomic          | operaciones seguras    |
| volatile        | visibilidad de memoria |

---

Muy buena pregunta. Esto es **parte del Java moderno para concurrencia**, especialmente desde **Java 8**.
Te lo explicaré **como profesor**, pero también en **formato que puedas usar en tu README.md**.

---

# 🔮 Future y CompletableFuture en Java

Cuando trabajamos con **threads**, muchas veces ejecutamos una tarea **en segundo plano** y queremos **obtener su resultado más tarde**.

Para eso existen:

* `Future`
* `CompletableFuture`

---

# 🧠 Problema que resuelven

Imagina que ejecutas una tarea que tarda 5 segundos:

```java
int resultado = calcularAlgoPesado();
```

El programa **se bloquea** hasta que termine.

Con concurrencia queremos:

```text
1 → ejecutar tarea
2 → seguir haciendo otras cosas
3 → obtener resultado cuando esté listo
```

Para eso existe **Future**.

---

# 🔮 ¿Qué es Future?

Un **Future** representa **el resultado de una tarea que se ejecutará en el futuro**.

Es básicamente una **promesa de resultado**.

Interfaz:

```java
java.util.concurrent.Future
```

---

# 📊 Flujo conceptual

```text
Thread principal
       │
       │ ejecuta tarea async
       ▼
   ExecutorService
       │
       ▼
    Thread Worker
       │
       ▼
   Resultado
       │
       ▼
      Future
```

---

# ⚙️ Ejemplo con Future

```java
import java.util.concurrent.*;

public class EjemploFuture {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000);
            return 10 + 20;
        });

        System.out.println("Haciendo otras cosas...");

        Integer resultado = future.get();

        System.out.println("Resultado: " + resultado);

        executor.shutdown();
    }

}
```

Salida:

```text
Haciendo otras cosas...
Resultado: 30
```

---

# 📌 Métodos importantes de Future

| método          | descripción          |
| --------------- | -------------------- |
| `get()`         | espera el resultado  |
| `isDone()`      | verifica si terminó  |
| `cancel()`      | cancela la tarea     |
| `isCancelled()` | verifica cancelación |

---

# 🚨 Problema de Future

El método:

```java
future.get()
```

**bloquea el thread** hasta que termine la tarea.

Esto **rompe la programación asincrónica real**.

Por eso se creó:

```
CompletableFuture
```

---

# ⚡ ¿Qué es CompletableFuture?

`CompletableFuture` es una versión **mucho más poderosa y moderna** de `Future`.

Clase:

```java
java.util.concurrent.CompletableFuture
```

Permite:

* programación **asíncrona**
* **encadenar tareas**
* **combinar resultados**
* **manejar errores**

---

# 📊 Flujo con CompletableFuture

```text
Tarea 1
   │
   ▼
thenApply()
   │
   ▼
Tarea 2
   │
   ▼
thenAccept()
   │
   ▼
Resultado final
```

Esto se llama:

```
Async Pipeline
```

---

# ⚙️ Ejemplo básico

```java
import java.util.concurrent.CompletableFuture;

public class Ejemplo {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    return 10 + 20;
                });

        future.thenAccept(resultado ->
                System.out.println("Resultado: " + resultado)
        );

    }

}
```

---

# 📌 Métodos importantes de CompletableFuture

| método            | función                   |
| ----------------- | ------------------------- |
| `supplyAsync()`   | ejecuta tarea con retorno |
| `runAsync()`      | ejecuta tarea sin retorno |
| `thenApply()`     | transforma resultado      |
| `thenAccept()`    | consume resultado         |
| `thenRun()`       | ejecuta tarea después     |
| `thenCombine()`   | combina dos tareas        |
| `exceptionally()` | manejar errores           |

---

# 🧪 Ejemplo de pipeline asincrónico

```java
CompletableFuture.supplyAsync(() -> 5)
        .thenApply(x -> x * 2)
        .thenApply(x -> x + 10)
        .thenAccept(System.out::println);
```

Flujo:

```text
5
 ↓
*2
 ↓
+10
 ↓
20
```

---

# ⚡ Ejecutar varias tareas en paralelo

```java
CompletableFuture<Integer> f1 =
        CompletableFuture.supplyAsync(() -> 10);

CompletableFuture<Integer> f2 =
        CompletableFuture.supplyAsync(() -> 20);

CompletableFuture<Integer> resultado =
        f1.thenCombine(f2, Integer::sum);

resultado.thenAccept(System.out::println);
```

Resultado:

```
30
```

---

# 🚀 Diferencias Future vs CompletableFuture

| característica         | Future   | CompletableFuture |
| ---------------------- | -------- | ----------------- |
| asincrónico            | limitado | completo          |
| encadenar tareas       | ❌        | ✅                 |
| manejo de errores      | ❌        | ✅                 |
| composición            | ❌        | ✅                 |
| programación funcional | ❌        | ✅                 |

---

# 🧠 Uso real en Backend

En aplicaciones modernas de **Java**:

* microservicios
* APIs
* sistemas distribuidos

`CompletableFuture` permite hacer llamadas concurrentes como:

```text
API usuarios
API pagos
API pedidos
```

Todas al mismo tiempo.

---

# 🧠 Ejemplo real conceptual

```text
Cliente solicita perfil
        │
        ▼
 ┌───────────────┐
 │ llamadas async │
 └───────────────┘
   │      │      │
   ▼      ▼      ▼
usuarios pagos pedidos
   │      │      │
   └─── combinar resultados ───┘
                │
                ▼
           respuesta final
```

---

# 🧠 Idea clave

`CompletableFuture` permite escribir **concurrencia declarativa**, similar a cómo funcionan:

* Promises en JavaScript
* Async/Await

pero dentro de **Java**.

---