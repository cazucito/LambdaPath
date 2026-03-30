# Solución — Ejercicio 02: Cadena de operaciones

```java
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CadenaOperaciones {

    public static String aplicar(int numero) {
        UnaryOperator<Integer> duplicar   = n -> n * 2;
        UnaryOperator<Integer> sumarDiez  = n -> n + 10;
        Function<Integer, String> aTexto  = n -> "Resultado: " + n;

        return duplicar
                .andThen(sumarDiez)
                .andThen(aTexto)
                .apply(numero);
    }
}
```

## Traza de ejecución para `aplicar(5)`

| Paso | Operación | Valor |
|------|-----------|-------|
| Entrada | — | `5` |
| `duplicar` | `5 * 2` | `10` |
| `sumarDiez` | `10 + 10` | `20` |
| `aTexto` | `"Resultado: " + 20` | `"Resultado: 20"` |

## Puntos clave

- `UnaryOperator<T>` extiende `Function<T,T>`, por lo que se puede encadenar con `andThen`.
- `andThen` crea una nueva función compuesta; no evalúa nada hasta llamar a `.apply()`.
- Esto es el patrón **pipeline funcional**: cada paso transforma el resultado del anterior.
