---
layout: default
title: "Ejercicio 03 — Filtro con Streams"
description: "Filtra y transforma colecciones usando la API de Streams."
---

# Ejercicio 03 — Filtro con Streams

**Dificultad:** ⭐⭐ (Medio)  
**Conceptos:** Streams, Filter, Map, Collect

---

## Enunciado

Dada una lista de productos, obtén los nombres de productos que:

1. Tengan precio mayor a $50
2. Estén en stock
3. Ordenados alfabéticamente

## Datos de ejemplo

```java
class Producto {
    String nombre;
    double precio;
    boolean enStock;
    // constructor, getters...
}

List<Producto> productos = Arrays.asList(
    new Producto("Laptop", 999.99, true),
    new Producto("Mouse", 25.50, true),
    new Producto("Teclado", 75.00, false),
    new Producto("Monitor", 299.99, true),
    new Producto("Cable", 10.00, true)
);
```

## Resultado esperado

```
["Laptop", "Monitor"]
```

## Pistas

- Usa `.filter()` para precio y stock
- Usa `.map()` para extraer el nombre
- Usa `.sorted()` para ordenar
- Usa `.collect(Collectors.toList())` para obtener resultado

## Solución

<p class="solution-header">🔍 Haz clic para ver la solución:</p>

<details class="solution-box">
  <summary>Ver solución</summary>

```java
import java.util.*;
import java.util.stream.Collectors;

class Producto {
    String nombre;
    double precio;
    boolean enStock;
    
    Producto(String nombre, double precio, boolean enStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.enStock = enStock;
    }
    
    String getNombre() { return nombre; }
    double getPrecio() { return precio; }
    boolean isEnStock() { return enStock; }
}

public class Ejercicio03 {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
            new Producto("Laptop", 999.99, true),
            new Producto("Mouse", 25.50, true),
            new Producto("Teclado", 75.00, false),
            new Producto("Monitor", 299.99, true),
            new Producto("Cable", 10.00, true)
        );
        
        List<String> resultado = productos.stream()
            .filter(p -> p.getPrecio() > 50)
            .filter(Producto::isEnStock)
            .map(Producto::getNombre)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println(resultado);  // [Laptop, Monitor]
    }
}
```

</details>

---

<div class="back-link">
  <a href="{{ '/ejercicios/' | relative_url }}">← Volver a ejercicios</a>
</div>