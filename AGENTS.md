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
│   │   ├── lambda/                ← código EN (etapas 01-05)
│   │   ├── lambda/es/             ← código ES (etapas 01-05)
│   │   └── util/                  ← utilidades comunes (Impresor, Temporizador)
│   └── test/java/poc/
│       ├── lambda/                ← tests EN
│       └── lambda/es/             ← tests ES
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

- **Java 17** — usar `var` donde mejore la legibilidad, evitar sintaxis innecesariamente verbosa
- Los métodos de la interfaz `ArithmeticCalculator` / `CalculadoraAritmetica` **retornan `int`**
- Las implementaciones **imprimen el resultado Y lo retornan**
- Mantener paridad EN/ES: todo cambio en el paquete `poc.lambda` debe reflejarse en `poc.lambda.es`
- Tests van en `src/test/java/` con el mismo paquete que la clase bajo prueba

---

## Ramas y flujo de trabajo

- `master` — rama principal, siempre compilable y con tests verdes
- Desarrollar en ramas de feature: `feature/<descripción>`
- Nunca hacer push directo a `master`

---

## Plan de mejora

Ver `PLAN-MEJORA.md` para el roadmap completo por fases.

Fases pendientes principales:
- **Fase 3**: Etapas 06-09 (Method References, Streams, Functional Interfaces, benchmarks)
- **Fase 4**: Sitio web con Jekyll en `docs/`
- **Fase 5**: CI/CD completo, SemVer, CHANGELOG
- **Fase 6**: Templates de issues, multimedia, i18n del sitio

---

## Qué NO hacer

- No eliminar la paridad EN/ES del código
- No cambiar la interfaz `ArithmeticCalculator` a `void` (rompe los tests)
- No commitear archivos compilados (`*.class`, `bin/`, `target/`)
- No commitear archivos de IDE (`.classpath`, `.project`, `nbproject/`, `.idea/`)
