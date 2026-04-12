---
layout: default
title: "Etapas del Tutorial"
description: "Navega por las 9 etapas del tutorial LambdaPath, desde clases tradicionales hasta expresiones lambda, method references y Streams."
---

# Etapas del Tutorial

Explora las **9 etapas** que te llevarán desde el diseño clásico de clases en Java hasta la programación funcional moderna.

---

## Etapas 01-05: Fundamentos

<div class="stages-grid">

<a href="01-sin-interfaz" class="stage-card">
  <div class="stage-number">01</div>
  <h3>Sin interfaz</h3>
  <p>Clases independientes sin contrato común. El punto de partida tradicional.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="02-con-interfaz" class="stage-card">
  <div class="stage-number">02</div>
  <h3>Con interfaz</h3>
  <p>Introducción a <code>@FunctionalInterface</code> y contratos comunes.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="03-clase-anonima" class="stage-card">
  <div class="stage-number">03</div>
  <h3>Clase anónima</h3>
  <p>Implementación inline sin necesidad de archivos separados.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="04-invocador" class="stage-card">
  <div class="stage-number">04</div>
  <h3>Invocador</h3>
  <p>Patrón Strategy: pasar comportamiento como parámetro.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="05-lambda" class="stage-card">
  <div class="stage-number">05</div>
  <h3>Lambda</h3>
  <p>Sintaxis concisa con expresiones lambda — Java 8+.</p>
  <span class="stage-link">Comenzar →</span>
</a>

</div>

---

## Etapas 06-09: Programación Funcional Moderna

<div class="stages-grid">

<a href="06-method-references" class="stage-card">
  <div class="stage-number">06</div>
  <h3>Method References</h3>
  <p>Sintaxis aún más concisa: <code>Class::method</code>, <code>instance::method</code>, <code>Class::new</code>.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="07-streams" class="stage-card">
  <div class="stage-number">07</div>
  <h3>Streams API</h3>
  <p>Procesamiento declarativo de colecciones: <code>filter</code>, <code>map</code>, <code>reduce</code>, <code>collect</code>.</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="08-functional-interfaces" class="stage-card">
  <div class="stage-number">08</div>
  <h3>Functional Interfaces</h3>
  <p>Interfaces estándar: <code>Predicate</code>, <code>Function</code>, <code>Consumer</code>, <code>Supplier</code>...</p>
  <span class="stage-link">Comenzar →</span>
</a>

<a href="09-rendimiento" class="stage-card">
  <div class="stage-number">09</div>
  <h3>Rendimiento</h3>
  <p>Comparativa: loop vs Stream vs ParallelStream.</p>
  <span class="stage-link">Comenzar →</span>
</a>

</div>

---

## Recursos Adicionales

<div class="resources-grid">

<a href="../comparativas" class="resource-card">
  <div class="resource-icon">📊</div>
  <h4>Comparativas Visuales</h4>
  <p>Diagrama de evolución y tablas comparativas de LOC/complejidad.</p>
</a>

<a href="../ejercicios/" class="resource-card">
  <div class="resource-icon">💪</div>
  <h4>Ejercicios Prácticos</h4>
  <p>3 retos con soluciones para practicar lo aprendido.</p>
</a>

<a href="../casos-de-uso" class="resource-card">
  <div class="resource-icon">💼</div>
  <h4>Casos de Uso Reales</h4>
  <p>Aplicaciones prácticas: filtrado, Comparator, threading, Optional...</p>
</a>

</div>

<style>
.stages-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 1.5rem;
  margin: 2rem 0;
}

.stage-card {
  display: block;
  background: white;
  border: 1px solid #e1e4e8;
  border-radius: 8px;
  padding: 1.5rem;
  text-decoration: none;
  color: inherit;
  transition: all 0.25s ease;
  position: relative;
  overflow: hidden;
}

.stage-card::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 4px;
  height: 100%;
  background: linear-gradient(180deg, #e76f00, #5382a1);
  opacity: 0;
  transition: opacity 0.25s ease;
}

.stage-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 10px 20px rgba(0,0,0,0.1);
  border-color: #e76f00;
}

.stage-card:hover::before {
  opacity: 1;
}

.stage-number {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  background: linear-gradient(135deg, #e76f00, #5382a1);
  color: white;
  font-weight: 700;
  font-size: 1.1rem;
  border-radius: 8px;
  margin-bottom: 1rem;
}

.stage-card h3 {
  margin: 0 0 0.5rem;
  color: #24292e;
  font-size: 1.25rem;
}

.stage-card p {
  margin: 0 0 1rem;
  color: #586069;
  font-size: 0.95rem;
  line-height: 1.5;
}

.stage-link {
  display: inline-flex;
  align-items: center;
  color: #e76f00;
  font-weight: 600;
  font-size: 0.9rem;
}

.resources-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 1rem;
  margin: 2rem 0;
}

.resource-card {
  display: block;
  background: #f6f8fa;
  border-radius: 8px;
  padding: 1.25rem;
  text-decoration: none;
  color: inherit;
  transition: all 0.25s ease;
}

.resource-card:hover {
  background: #f0f2f5;
  transform: translateY(-2px);
}

.resource-icon {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}

.resource-card h4 {
  margin: 0 0 0.25rem;
  color: #24292e;
}

.resource-card p {
  margin: 0;
  color: #586069;
  font-size: 0.9rem;
}

@media (max-width: 640px) {
  .stages-grid,
  .resources-grid {
    grid-template-columns: 1fr;
  }
}
</style>