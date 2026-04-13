# LambdaPath

[![CI](https://github.com/cazucito/LambdaPath/actions/workflows/ci.yml/badge.svg)](https://github.com/cazucito/LambdaPath/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://openjdk.org/projects/jdk/17/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

Tutorial educativo que demuestra la **evolución del código Java** desde clases tradicionales hasta expresiones lambda, method references y Streams API.

> **Convención:** identificadores en inglés · documentación y comentarios en español.
> 
> **🌐 Sitio web:** [cazucito.github.io/LambdaPath](https://cazucito.github.io/LambdaPath)

---

## Tabla de contenidos

- [Etapas del tutorial](#etapas-del-tutorial)
- [Inicio rápido](#inicio-rápido)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Ejecutar](#ejecutar)
- [Tests](#tests)
- [Contribuir](#contribuir)
- [Autor](#autor)
- [Licencia](#licencia)

---

## Etapas del tutorial

### Etapas 01-05: Del diseño clásico a las lambdas

| # | Etapa | Concepto |
|---|-------|---------|
| 01 | [Clases sin interfaz](https://cazucito.github.io/LambdaPath/etapas/01-sin-interfaz) | Clases concretas sin contrato común |
| 02 | [Con interfaz](https://cazucito.github.io/LambdaPath/etapas/02-con-interfaz) | `@FunctionalInterface` |
| 03 | [Clase anónima](https://cazucito.github.io/LambdaPath/etapas/03-clase-anonima) | Implementación inline sin archivo separado |
| 04 | [Invocador](https://cazucito.github.io/LambdaPath/etapas/04-invocador) | Pasar comportamiento como parámetro (Strategy) |
| 05 | [Lambda](https://cazucito.github.io/LambdaPath/etapas/05-lambda) | Sintaxis concisa — Java 8+ |

### Etapas 06-09: Java funcional moderno

| # | Etapa | Concepto |
|---|-------|---------|
| 06 | [Method References](https://cazucito.github.io/LambdaPath/etapas/06-method-references) | Referencias a métodos: `Class::method` |
| 07 | [Streams API](https://cazucito.github.io/LambdaPath/etapas/07-streams) | Procesamiento de colecciones: `filter`, `map`, `reduce` |
| 08 | [Functional Interfaces](https://cazucito.github.io/LambdaPath/etapas/08-functional-interfaces) | Interfaces estándar: `Predicate`, `Function`, `Consumer`... |
| 09 | [Rendimiento](https://cazucito.github.io/LambdaPath/etapas/09-rendimiento) | Loop vs Stream vs ParallelStream |

---

## Inicio rápido

**Requisitos:** JDK 17+ · Maven 3.6+

```bash
git clone https://github.com/cazucito/LambdaPath.git
cd LambdaPath
mvn clean verify
```

---

## Estructura del proyecto

```
LambdaPath/
├── pom.xml                          ← build Maven (Java 17, JUnit 5)
├── src/
│   ├── main/java/poc/
│   │   ├── lambda/                  ← etapas 01-09 del tutorial
│   │   └── util/                    ← Printer, Timer, MessageType
│   └── test/java/poc/lambda/        ← 40+ tests JUnit 5
├── docs/                            ← sitio GitHub Pages (Jekyll)
│   ├── index.md
│   ├── etapas/                      ← 9 páginas de etapas
│   ├── ejercicios/                  ← 3 ejercicios prácticos
│   └── assets/                      ← CSS, JS, imágenes
├── ejercicios/                      ← soluciones Java
├── .github/workflows/ci.yml         ← CI: build + tests
└── _config.yml                      ← configuración Jekyll
```

---

## Ejecutar

```bash
# Tutorial completo
mvn exec:java -Dexec.mainClass="poc.lambda.LambdaPathMain"

# Solo compilar
mvn compile

# Build completo con tests
mvn clean verify

# Ejecutar ejercicios
mvn exec:java -Dexec.mainClass="poc.lambda.ejercicios.Ejercicio01"
```

---

## Tests

40+ tests unitarios con JUnit 5:

```bash
mvn test
```

Los reportes de Surefire quedan en `target/surefire-reports/`.

---

## Recursos adicionales

- 🌐 [Sitio web del tutorial](https://cazucito.github.io/LambdaPath)
- 📊 [Comparativas visuales](https://cazucito.github.io/LambdaPath/comparativas)
- 💪 [Ejercicios prácticos](https://cazucito.github.io/LambdaPath/ejercicios/)
- 💼 [Casos de uso reales](https://cazucito.github.io/LambdaPath/casos-de-uso)

---

## Contribuir

Ver [CONTRIBUTING.md](CONTRIBUTING.md) para guía de contribución.

---

## Autor

**Pedro Cazu** — [@cazucito](https://github.com/cazucito/)

---

## Licencia

Distribuido bajo licencia [GNU GPL v3.0](LICENSE).