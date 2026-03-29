# AGENTS.md — Instrucciones para agentes IA

## Descripción del proyecto

**LambdaPath** es un tutorial educativo bilingüe (español/inglés) que demuestra la
evolución del código Java desde clases tradicionales sin interfaz hasta expresiones lambda.

Cada etapa introduce un nuevo concepto:

| Etapa | Descripción |
|-------|-------------|
| 01 | Clases independientes sin interfaz |
| 02 | Implementación de interfaz funcional |
| 03 | Clases anónimas internas |
| 04 | Invocador con referencia genérica |
| 05 | Expresiones lambda |

---

## Estructura del repositorio

```
LambdaPath/                        ← raíz del repo = raíz del proyecto Maven
├── pom.xml                        ← build Maven (Java 17, JUnit 5)
├── src/
│   ├── main/java/poc/
│   │   ├── lambda/                ← tutorial stages 01-05
│   │   └── util/                  ← shared utilities (Printer, Timer, MessageType)
│   └── test/java/poc/
│       └── lambda/                ← JUnit 5 tests
├── .github/
│   └── workflows/ci.yml           ← CI: build + tests en push/PR
├── docs/                          ← (futuro) GitHub Pages / Jekyll
├── AGENTS.md                      ← este archivo
├── PLAN-MEJORA.md                 ← roadmap completo del proyecto
├── README.md / LEEME.md           ← documentación
└── _config.yml                    ← GitHub Pages (Jekyll)
```

---

## Build y tests

El proyecto usa **Maven** con Java 17.

```bash
# Compilar
mvn compile

# Ejecutar tests
mvn test

# Build completo
mvn clean verify

# Ejecutar el programa (EN)
mvn exec:java -Dexec.mainClass="poc.lambda.LambdaPathMain"

# Ejecutar el programa (ES)
mvn exec:java -Dexec.mainClass="poc.lambda.es.RutaLambdaMain"
```

---

## Convenciones de código

- **Java 17** — use `var` where it improves readability
- `ArithmeticCalculator.doOperation()` **returns `int`** (not void) — do not revert this
- Implementations **print the result AND return it**
- Tests go in `src/test/java/` mirroring the source package

---

## Branching

- `master` — always compiles, tests green
- Feature branches: `feature/<description>`
- Never push directly to `master`

---

## Roadmap

See `PLAN-MEJORA.md` for the full phased plan. Pending phases:

- **Phase 3**: Stages 06-09 (Method References, Streams, Functional Interfaces, benchmarks)
- **Phase 4**: GitHub Pages site in `docs/`
- **Phase 5**: CI/CD, SemVer, CHANGELOG
- **Phase 6**: Issue templates, multimedia

---

## Do NOT

- Revert `ArithmeticCalculator.doOperation()` to `void` (breaks tests)
- Commit compiled files (`*.class`, `bin/`, `target/`)
- Commit IDE files (`.classpath`, `.project`, `nbproject/`, `.idea/`)
