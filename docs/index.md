---
layout: default
title: LambdaPath — Tutorial Java
---

# LambdaPath

Tutorial educativo que muestra la evolución del código Java desde clases independientes hasta expresiones lambda, referencias a métodos y Streams, en nueve etapas progresivas.

---

## ¿Qué aprenderás?

### Etapas 01–05: del diseño clásico a las lambdas

| Etapa | Enfoque | Concepto clave |
|-------|---------|----------------|
| [01 — Sin interfaz]({{ '/etapas/01-sin-interfaz' | relative_url }}) | Clases independientes | Sin contrato común |
| [02 — Con interfaz]({{ '/etapas/02-con-interfaz' | relative_url }}) | Interfaz funcional | `@FunctionalInterface` |
| [03 — Clase anónima]({{ '/etapas/03-clase-anonima' | relative_url }}) | Implementación inline | Clase anónima interna |
| [04 — Invocador]({{ '/etapas/04-invocador' | relative_url }}) | Referencia genérica | Pasar comportamiento como parámetro |
| [05 — Lambda]({{ '/etapas/05-lambda' | relative_url }}) | Expresión lambda | Sintaxis concisa Java 8+ |

### Etapas 06–09: Java funcional moderno

| Etapa | Enfoque | Concepto clave |
|-------|---------|----------------|
| [06 — Method References]({{ '/etapas/06-method-references' | relative_url }}) | Referencias a métodos | `Class::method`, `instance::method`, `Class::new` |
| [07 — Streams API]({{ '/etapas/07-streams' | relative_url }}) | Procesamiento de colecciones | `filter`, `map`, `reduce`, `collect` |
| [08 — Functional Interfaces]({{ '/etapas/08-functional-interfaces' | relative_url }}) | Interfaces estándar | `Predicate`, `Function`, `Consumer`, `Supplier`… |
| [09 — Rendimiento]({{ '/etapas/09-rendimiento' | relative_url }}) | Comparativa | Loop vs Stream vs ParallelStream |

---

## Recursos adicionales

- [Comparativas visuales]({{ '/comparativas' | relative_url }}) — diagrama de evolución y tablas de LOC/complejidad
- [Ejercicios prácticos]({{ '/ejercicios/' | relative_url }}) — 3 retos con soluciones
- [Casos de uso reales]({{ '/casos-de-uso' | relative_url }}) — filtrado, Comparator, threading, Optional

---

## Inicio rápido

**Requisitos:** JDK 17+, Maven 3.6+

```bash
git clone https://github.com/cazucito/LambdaPath.git
cd LambdaPath
mvn clean verify
mvn exec:java -Dexec.mainClass="poc.lambda.LambdaPathMain"
```

---

## Estructura del proyecto

```
src/main/java/poc/
├── lambda/          ← etapas 01-09 del tutorial
└── util/            ← Printer, Timer, MessageType

src/test/java/poc/
└── lambda/          ← 40+ tests JUnit 5

docs/                ← este sitio (GitHub Pages)
ejercicios/          ← retos con soluciones
```

---

[Ver en GitHub](https://github.com/cazucito/LambdaPath) · [Contribuir](https://github.com/cazucito/LambdaPath/blob/master/CONTRIBUTING.md){:target="_blank" rel="noopener"}
