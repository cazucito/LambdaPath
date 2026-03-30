# Solución — Ejercicio 03: Filtro con Streams

```java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroStream {

    public static List<Integer> imparesCuadradosDesc(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)          // solo impares
                .map(n -> n * n)                   // elevar al cuadrado
                .sorted(Comparator.reverseOrder()) // mayor a menor
                .collect(Collectors.toList());
    }

    public static int sumaLista(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
```

## Traza para `List.of(1, 7, 2, 9, 4, 6, 3, 8, 5, 10)`

| Paso | Operación | Resultado |
|------|-----------|-----------|
| Entrada | — | `[1, 7, 2, 9, 4, 6, 3, 8, 5, 10]` |
| `filter(impar)` | quita 2,4,6,8,10 | `[1, 7, 9, 3, 5]` |
| `map(n*n)` | eleva al cuadrado | `[1, 49, 81, 9, 25]` |
| `sorted(desc)` | ordena | `[81, 49, 25, 9, 1]` |

Suma: `81 + 49 + 25 + 9 + 1 = 165`

## Alternativa con `reduce`

```java
public static int sumaLista(List<Integer> list) {
    return list.stream().reduce(0, Integer::sum);
}
```

## Puntos clave

- `mapToInt(Integer::intValue)` evita el boxing/unboxing y usa `IntStream.sum()`.
- La tubería es **lazy**: el pipeline completo se ejecuta en un solo recorrido de la lista.
- `Comparator.reverseOrder()` es más legible que `(a, b) -> b - a`.
