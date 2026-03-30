# Ejercicios prácticos — LambdaPath

Estos ejercicios refuerzan los conceptos del tutorial. Cada uno incluye un enunciado y una solución en `soluciones/`.

## Lista de ejercicios

| # | Título | Concepto | Dificultad |
|---|--------|---------|------------|
| [01](01-division.md) | División segura | Interfaz funcional + lambda | ⭐ |
| [02](02-cadena-de-operaciones.md) | Cadena de operaciones | Composición de lambdas | ⭐⭐ |
| [03](03-filtro-stream.md) | Filtro con Streams | Streams API | ⭐⭐ |

## Cómo trabajar los ejercicios

1. Lee el enunciado del ejercicio.
2. Intenta resolverlo **sin ver la solución**.
3. Compila y ejecuta tu solución con Maven.
4. Compara con la solución en `soluciones/`.

## Compilar y ejecutar

```bash
# Compilar todo el proyecto (incluyendo tus ejercicios)
mvn compile

# Ejecutar un ejercicio concreto
mvn exec:java -Dexec.mainClass="poc.lambda.ejercicios.EjercicioX"
```
