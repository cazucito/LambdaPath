---
layout: default
title: LambdaPath — Tutorial Java
---

# LambdaPath

Tutorial educativo que muestra la evolución del código Java desde clases independientes hasta expresiones lambda, en cinco etapas progresivas.

---

## ¿Qué aprenderás?

Cómo el mismo problema (ejecutar una operación aritmética) se puede resolver de formas cada vez más concisas y flexibles en Java:

| Etapa | Enfoque | Concepto clave |
|-------|---------|----------------|
| [01 — Sin interfaz](etapas/01-sin-interfaz) | Clases independientes | Clases concretas sin contrato común |
| [02 — Con interfaz](etapas/02-con-interfaz) | Interfaz funcional | `@FunctionalInterface` |
| [03 — Clase anónima](etapas/03-clase-anonima) | Implementación inline | Clase anónima interna |
| [04 — Invocador](etapas/04-invocador) | Referencia genérica | Pasar comportamiento como parámetro |
| [05 — Lambda](etapas/05-lambda) | Expresión lambda | Sintaxis concisa de Java 8+ |

---

## Inicio rápido

**Requisitos:** JDK 17+, Maven 3.6+

```bash
# Clonar el repositorio
git clone https://github.com/cazucito/LambdaPath.git
cd LambdaPath

# Compilar y ejecutar tests
mvn clean verify

# Ejecutar el tutorial
mvn exec:java -Dexec.mainClass="poc.lambda.LambdaPathMain"
```

---

## Estructura del proyecto

```
src/main/java/poc/
├── lambda/          ← etapas 01-05 del tutorial
└── util/            ← utilidades compartidas (Printer, Timer, MessageType)

src/test/java/poc/
└── lambda/          ← 14 tests JUnit 5
```

---

[Ver en GitHub](https://github.com/cazucito/LambdaPath) · [Contribuir](../CONTRIBUTING)
