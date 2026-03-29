# LambdaPath

[![CI](https://github.com/cazucito/LambdaPath/actions/workflows/ci.yml/badge.svg)](https://github.com/cazucito/LambdaPath/actions/workflows/ci.yml)
[![Java 17](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://openjdk.org/projects/jdk/17/)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

Tutorial educativo que demuestra la evolución del código Java desde clases independientes sin interfaz hasta expresiones lambda, en cinco etapas progresivas.

> **Convención:** identificadores en inglés · documentación y comentarios en español.

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

| # | Etapa | Concepto |
|---|-------|---------|
| 01 | Clases independientes sin interfaz | Clases concretas sin contrato común |
| 02 | Implementación de interfaz funcional | `@FunctionalInterface` |
| 03 | Clases anónimas internas | Implementación inline sin archivo separado |
| 04 | Invocador con referencia genérica | Pasar comportamiento como parámetro (Strategy) |
| 05 | Expresiones lambda | Sintaxis concisa — Java 8+ |

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
│   │   ├── lambda/                  ← etapas 01-05 del tutorial
│   │   └── util/                    ← Printer, Timer, MessageType
│   └── test/java/poc/lambda/        ← 14 tests JUnit 5
├── docs/                            ← sitio GitHub Pages (Jekyll)
│   ├── index.md
│   └── etapas/                      ← una página por etapa
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
```

---

## Tests

14 tests unitarios con JUnit 5, organizados por clase:

```bash
mvn test
```

Los reportes de Surefire quedan en `target/surefire-reports/`.

---

## Contribuir

Ver [CONTRIBUTING.md](CONTRIBUTING.md) para guía de contribución.

---

## Autor

**Pedro Cazu** — [@cazucito](https://github.com/cazucito/)

---

## Licencia

Distribuido bajo licencia [GNU GPL v3.0](LICENSE).
