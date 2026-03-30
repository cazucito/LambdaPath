# Ejercicio 02 — Cadena de operaciones

**Concepto:** composición de lambdas con `Function.andThen`
**Dificultad:** ⭐⭐

## Enunciado

Usando las interfaces funcionales estándar de `java.util.function`, implementa una tubería que:

1. Reciba un número entero.
2. Lo **duplique** (`UnaryOperator<Integer>`).
3. Lo **sume con 10** (`UnaryOperator<Integer>`).
4. Lo **convierta a String** con formato `"Resultado: <valor>"` (`Function<Integer, String>`).
5. Encadene los tres pasos con `andThen` en una sola expresión.

## Código de partida

```java
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CadenaOperaciones {

    public static String aplicar(int numero) {
        UnaryOperator<Integer> duplicar = // TODO
        UnaryOperator<Integer> sumarDiez = // TODO
        Function<Integer, String> aTexto = // TODO

        // TODO: encadenar con andThen y aplicar sobre numero
        return null;
    }
}
```

## Pistas

- `UnaryOperator<T>` extiende `Function<T,T>`, por lo que admite `andThen`.
- La cadena completa: `duplicar.andThen(sumarDiez).andThen(aTexto).apply(numero)`.
- Para `numero = 5`: duplicar → 10, sumar 10 → 20, texto → `"Resultado: 20"`.

## Criterio de aceptación

- `aplicar(5)` devuelve `"Resultado: 20"`.
- `aplicar(0)` devuelve `"Resultado: 10"`.

---

[Ver solución](soluciones/02-cadena-de-operaciones.md) · [← Ejercicios](README.md)
