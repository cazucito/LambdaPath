---
layout: default
title: "Ejercicio 01 — División segura"
description: "Implementa una interfaz funcional para división con manejo de división por cero."
---

# Ejercicio 01 — División segura

**Dificultad:** ⭐ (Fácil)  
**Conceptos:** Interfaz funcional, Lambda, Optional

---

## Enunciado

Implementa una calculadora de división que:

1. Use una interfaz funcional `SafeDivider` con método `divide(int a, int b)`
2. Retorne `Optional<Integer>` para manejar división por cero
3. Use una lambda para implementar la operación

## Código esperado

```java
@FunctionalInterface
interface SafeDivider {
    Optional<Integer> divide(int dividend, int divisor);
}

// Tu implementación aquí
SafeDivider divider = (a, b) -> /* lambda */;

// Uso
Optional<Integer> result1 = divider.divide(10, 2);  // Optional[5]
Optional<Integer> result2 = divider.divide(10, 0);  // Optional.empty
```

## Pistas

- Usa `Optional.of(value)` cuando hay resultado válido
- Usa `Optional.empty()` cuando el divisor es 0
- La lambda debe verificar `divisor != 0` antes de dividir

## Solución

<p class="solution-header">🔍 Haz clic para ver la solución:</p>

<details class="solution-box">
  <summary>Ver solución</summary>

```java
@FunctionalInterface
interface SafeDivider {
    Optional<Integer> divide(int dividend, int divisor);
}

public class Ejercicio01 {
    public static void main(String[] args) {
        SafeDivider divider = (a, b) -> 
            b == 0 ? Optional.empty() : Optional.of(a / b);
        
        System.out.println(divider.divide(10, 2));  // Optional[5]
        System.out.println(divider.divide(10, 0));  // Optional.empty
        System.out.println(divider.divide(7, 3));   // Optional[2]
    }
}
```

</details>

---

[← Volver a ejercicios]({{ '/ejercicios/' | relative_url }})