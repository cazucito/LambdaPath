---
layout: default
title: "Ejercicios prácticos"
description: "3 ejercicios prácticos para reforzar los conceptos de lambdas, method references y Streams en Java."
---

# Ejercicios prácticos

Estos ejercicios refuerzan los conceptos del tutorial. Cada uno incluye un enunciado y una solución.

---

## Lista de ejercicios

<div class="exercises-list">

<a href="01-division" class="exercise-card">
  <div class="exercise-meta">
    <span class="exercise-number">01</span>
    <span class="difficulty">⭐</span>
  </div>
  <h3>División segura</h3>
  <p>Implementa una interfaz funcional para división con manejo de división por cero.</p>
  <div class="exercise-tags">
    <span class="tag">Interfaz funcional</span>
    <span class="tag">Lambda</span>
  </div>
</a>

<a href="02-cadena-de-operaciones" class="exercise-card">
  <div class="exercise-meta">
    <span class="exercise-number">02</span>
    <span class="difficulty">⭐⭐</span>
  </div>
  <h3>Cadena de operaciones</h3>
  <p>Composición de múltiples lambdas para transformar datos.</p>
  <div class="exercise-tags">
    <span class="tag">Composición</span>
    <span class="tag">Function</span>
  </div>
</a>

<a href="03-filtro-stream" class="exercise-card">
  <div class="exercise-meta">
    <span class="exercise-number">03</span>
    <span class="difficulty">⭐⭐</span>
  </div>
  <h3>Filtro con Streams</h3>
  <p>Filtra y transforma colecciones usando la API de Streams.</p>
  <div class="exercise-tags">
    <span class="tag">Streams</span>
    <span class="tag">Filter</span>
    <span class="tag">Map</span>
  </div>
</a>

</div>

---

## Cómo trabajar los ejercicios

1. Lee el enunciado del ejercicio
2. Intenta resolverlo **sin ver la solución**
3. Implementa tu solución en `src/main/java/poc/lambda/ejercicios/`
4. Compila y ejecuta con Maven
5. Compara con la solución en `soluciones/`

### Compilar y ejecutar

```bash
# Compilar todo el proyecto
mvn compile

# Ejecutar tu solución
mvn exec:java -Dexec.mainClass="poc.lambda.ejercicios.Ejercicio01"
```

---

## Recursos adicionales

- [Ver todas las etapas]({{ '/etapas/' | relative_url }})
- [Casos de uso reales]({{ '/casos-de-uso' | relative_url }})
- [Comparativas visuales]({{ '/comparativas' | relative_url }})

<style>
.exercises-list {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  margin: 2rem 0;
}

.exercise-card {
  display: block;
  background: white;
  border: 1px solid #e1e4e8;
  border-radius: 8px;
  padding: 1.5rem;
  text-decoration: none;
  color: inherit;
  transition: all 0.25s ease;
}

.exercise-card:hover {
  transform: translateX(8px);
  border-color: #e76f00;
  box-shadow: 0 4px 12px rgba(231, 111, 0, 0.1);
}

.exercise-meta {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 0.75rem;
}

.exercise-number {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 32px;
  height: 32px;
  background: linear-gradient(135deg, #e76f00, #5382a1);
  color: white;
  font-weight: 700;
  font-size: 0.9rem;
  border-radius: 6px;
}

.difficulty {
  font-size: 1rem;
}

.exercise-card h3 {
  margin: 0 0 0.5rem;
  color: #24292e;
  font-size: 1.25rem;
}

.exercise-card p {
  margin: 0 0 1rem;
  color: #586069;
}

.exercise-tags {
  display: flex;
  gap: 0.5rem;
  flex-wrap: wrap;
}

.tag {
  background: #f6f8fa;
  color: #586069;
  padding: 0.25rem 0.75rem;
  border-radius: 12px;
  font-size: 0.8rem;
  font-weight: 500;
}
</style>