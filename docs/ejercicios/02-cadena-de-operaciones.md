---
layout: default
title: "Ejercicio 02 — Cadena de operaciones"
description: "Composición de múltiples lambdas para transformar datos."
---

# Ejercicio 02 — Cadena de operaciones

**Dificultad:** ⭐⭐ (Medio)  
**Conceptos:** Function, Composición, andThen

---

## Enunciado

Crea una cadena de transformaciones para procesar precios:

1. Aplicar descuento del 10%
2. Agregar IVA del 16%
3. Redondear a 2 decimales

Usa `Function<Double, Double>` y composición con `andThen`.

## Código esperado

```java
Function<Double, Double> applyDiscount = price -> /* 10% off */;
Function<Double, Double> addVAT = price -> /* +16% */;
Function<Double, Double> round = price -> /* 2 decimals */;

// Componer las funciones
Function<Double, Double> finalPrice = /* composición */;

// Uso
double result = finalPrice.apply(100.0);  // Aprox: 104.40
```

## Pistas

- Descuento: `price * 0.9`
- IVA: `price * 1.16`
- Redondeo: `Math.round(price * 100.0) / 100.0`
- Composición: `f1.andThen(f2).andThen(f3)`

## Solución

<p class="solution-header">🔍 Haz clic para ver la solución:</p>

<details class="solution-box">
<summary>Ver solución</summary>

```java
import java.util.function.Function;

public class Ejercicio02 {
    public static void main(String[] args) {
        Function<Double, Double> applyDiscount = price -> price * 0.9;
        Function<Double, Double> addVAT = price -> price * 1.16;
        Function<Double, Double> round = price -> 
            Math.round(price * 100.0) / 100.0;
        
        Function<Double, Double> finalPrice = applyDiscount
            .andThen(addVAT)
            .andThen(round);
        
        System.out.println(finalPrice.apply(100.0));  // 104.4
        System.out.println(finalPrice.apply(250.0));  // 261.0
        System.out.println(finalPrice.apply(99.99));  // 104.39
    }
}
```
</details>

---

<p><a href="{{ '/ejercicios/' | relative_url }}">← Volver a ejercicios</a></p>