---
layout: default
title: Casos de uso reales
---

# Casos de uso reales de lambdas y Streams

Los ejemplos del tutorial usan operaciones aritméticas para mantener el foco en la sintaxis. En proyectos reales, las lambdas y Streams aparecen en estos contextos cotidianos.

---

## 1. Filtrado y ordenación de colecciones

El caso más frecuente: procesar listas de objetos sin bucles explícitos.

```java
record Producto(String nombre, double precio, String categoria) {}

List<Producto> productos = List.of(
    new Producto("Laptop",  1200.0, "Electrónica"),
    new Producto("Teclado",   80.0, "Electrónica"),
    new Producto("Silla",    350.0, "Mobiliario"),
    new Producto("Monitor",  400.0, "Electrónica")
);

// Productos de Electrónica con precio > 100, ordenados de menor a mayor
List<Producto> resultado = productos.stream()
        .filter(p -> p.categoria().equals("Electrónica"))
        .filter(p -> p.precio() > 100)
        .sorted(Comparator.comparingDouble(Producto::precio))
        .collect(Collectors.toList());
// → [Monitor 400.0, Laptop 1200.0]

// Precio total de todos los productos
double total = productos.stream()
        .mapToDouble(Producto::precio)
        .sum();
// → 2030.0
```

---

## 2. Comparator moderno

Antes de Java 8, ordenar requería una clase anónima o una clase separada. Ahora:

```java
List<String> nombres = new ArrayList<>(List.of("Carlos", "Ana", "Beatriz", "David"));

// Orden alfabético (antes: new Comparator<String>() { ... })
nombres.sort(Comparator.naturalOrder());

// Orden por longitud, luego alfabético como desempate
nombres.sort(Comparator.comparingInt(String::length)
        .thenComparing(Comparator.naturalOrder()));
// → [Ana, Carlos, David, Beatriz]

// Orden inverso
nombres.sort(Comparator.reverseOrder());
```

---

## 3. Callbacks y manejo de eventos

Las lambdas reemplazan las clases anónimas en listeners y callbacks.

```java
// Antes (Java 7)
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic!");
    }
});

// Ahora (Java 8+)
button.addActionListener(e -> System.out.println("Clic!"));

// Runnable para tareas en hilo separado
Runnable tarea = () -> {
    System.out.println("Ejecutando en hilo: " + Thread.currentThread().getName());
};
new Thread(tarea).start();

// O directamente:
new Thread(() -> System.out.println("Hilo anónimo")).start();
```

---

## 4. Threading con lambdas

`ExecutorService` y `CompletableFuture` se benefician directamente de lambdas.

```java
ExecutorService executor = Executors.newFixedThreadPool(4);

// Enviar tareas como lambdas
executor.submit(() -> procesarLote(1, 250));
executor.submit(() -> procesarLote(251, 500));

// CompletableFuture — pipeline asíncrono
CompletableFuture.supplyAsync(() -> obtenerDatos())       // Supplier
        .thenApply(datos -> transformar(datos))            // Function
        .thenAccept(resultado -> guardar(resultado))       // Consumer
        .exceptionally(ex -> { log(ex); return null; });  // Function<Throwable,T>
```

---

## 5. Optional — evitar NullPointerException

`Optional` usa interfaces funcionales para manejar ausencia de valor de forma expresiva.

```java
Optional<String> nombre = Optional.ofNullable(obtenerNombreDeDB());

// Sin Optional (propenso a NPE)
if (nombre != null) {
    System.out.println(nombre.toUpperCase());
}

// Con Optional + lambda
nombre.map(String::toUpperCase)
      .ifPresent(System.out::println);

// Con valor por defecto
String resultado = nombre.orElse("Anónimo");

// Con transformación encadenada
String email = Optional.ofNullable(usuario)
        .map(Usuario::getEmail)
        .filter(e -> e.contains("@"))
        .orElse("sin-email@ejemplo.com");
```

---

## Resumen de patrones

| Patrón | Interfaz usada | Ejemplo |
|--------|---------------|---------|
| Filtrar colección | `Predicate<T>` | `stream().filter(...)` |
| Transformar elementos | `Function<T,R>` | `stream().map(...)` |
| Ordenar | `Comparator<T>` | `sorted(Comparator.comparing(...))` |
| Efecto secundario | `Consumer<T>` | `forEach(...)`, `ifPresent(...)` |
| Proveer valor | `Supplier<T>` | `orElseGet(...)`, `supplyAsync(...)` |
| Tarea asíncrona | `Runnable` | `new Thread(...)`, `executor.submit(...)` |
| Combinar dos valores | `BinaryOperator<T>` | `reduce(...)` |

---

[← Comparativas](comparativas) · [Ejercicios →](ejercicios/)
