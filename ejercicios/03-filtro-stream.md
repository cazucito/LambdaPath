# Ejercicio 03 — Filtro con Streams

**Concepto:** Streams API — filter, map, collect, reduce
**Dificultad:** ⭐⭐

## Enunciado

Dada la lista `List.of(1, 7, 2, 9, 4, 6, 3, 8, 5, 10)`, implementa con Streams las siguientes operaciones **sin mutación** de la lista original:

1. **Filtrar** solo los números **impares**.
2. **Multiplicar** cada impar por sí mismo (elevar al cuadrado).
3. **Ordenar** de mayor a menor.
4. **Recolectar** en una nueva lista.
5. En una expresión separada, calcular la **suma** de esa lista final.

## Código de partida

```java
import java.util.List;
import java.util.stream.Collectors;

public class FiltroStream {

    public static List<Integer> imparesCuadradosDesc(List<Integer> numbers) {
        return numbers.stream()
                // TODO: filter
                // TODO: map (elevar al cuadrado)
                // TODO: sorted (descendente)
                .collect(Collectors.toList());
    }

    public static int sumaLista(List<Integer> list) {
        // TODO: reduce o mapToInt + sum
        return 0;
    }
}
```

## Pistas

- Para orden descendente: `.sorted((a, b) -> b - a)` o `.sorted(Comparator.reverseOrder())`.
- Elevar al cuadrado: `n -> n * n`.
- Los impares de la lista son: `1, 7, 9, 3, 5`.

## Criterio de aceptación

- `imparesCuadradosDesc(lista)` devuelve `[81, 49, 25, 9, 1]`.
- `sumaLista([81, 49, 25, 9, 1])` devuelve `165`.

---

[Ver solución](soluciones/03-filtro-stream.md) · [← Ejercicios](README.md)
