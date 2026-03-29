# Guía de contribución — LambdaPath

¡Gracias por tu interés en contribuir! Este documento describe cómo colaborar en el proyecto.

---

## Código de conducta

Este proyecto se rige por el [Código de conducta](CODE_OF_CONDUCT.md). Al participar, aceptas respetarlo.

---

## ¿Cómo contribuir?

### Reportar un error

1. Abre un [Issue](https://github.com/cazucito/LambdaPath/issues/new) en GitHub.
2. Describe el problema con claridad: qué esperabas, qué ocurrió, pasos para reproducirlo.
3. Incluye la versión de Java y Maven que usas.

### Proponer una mejora

1. Abre un Issue describiendo la propuesta antes de escribir código.
2. Espera retroalimentación antes de hacer una PR.

### Enviar un Pull Request

1. Haz un fork del repositorio.
2. Crea una rama desde `master`:
   ```bash
   git checkout -b feature/mi-mejora
   ```
3. Realiza tus cambios respetando las convenciones del proyecto.
4. Asegúrate de que los tests pasen:
   ```bash
   mvn clean verify
   ```
5. Haz commit con un mensaje descriptivo en español.
6. Abre un Pull Request contra `master`.

---

## Convenciones

| Elemento | Regla |
|----------|-------|
| Identificadores (clases, métodos, variables) | **inglés** |
| Javadoc y comentarios | **español** |
| Java | versión 17 |
| Tests | JUnit 5, un test por comportamiento |
| Commits | mensaje en español, imperativo, conciso |

### Ramas

- `master` — siempre compilable, tests en verde
- `feature/<descripcion>` — nuevas funcionalidades
- `fix/<descripcion>` — correcciones de errores
- `docs/<descripcion>` — cambios solo de documentación

---

## Build local

```bash
# Compilar
mvn compile

# Ejecutar tests
mvn test

# Build completo
mvn clean verify
```

---

## Preguntas

Abre un Issue con la etiqueta `question` y con gusto te respondemos.
