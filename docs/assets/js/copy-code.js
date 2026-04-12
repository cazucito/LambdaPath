/**
 * LambdaPath - Copy to Clipboard functionality
 * Enables copy buttons on code blocks
 */

document.addEventListener('DOMContentLoaded', function() {
  // Find all code blocks
  const codeBlocks = document.querySelectorAll('.highlight pre');
  
  codeBlocks.forEach(function(block) {
    // Create copy button
    const button = document.createElement('button');
    button.className = 'copy-button';
    button.setAttribute('aria-label', 'Copiar código al portapapeles');
    button.setAttribute('title', 'Copiar código');
    button.innerHTML = `
      <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
        <rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect>
        <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
      </svg>
      <span class="copy-text">Copiar</span>
    `;
    
    // Add button to code block
    block.parentElement.appendChild(button);
    
    // Copy functionality
    button.addEventListener('click', async function() {
      const code = block.textContent;
      
      try {
        await navigator.clipboard.writeText(code);
        
        // Visual feedback
        button.classList.add('copied');
        button.innerHTML = `
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
            <polyline points="20 6 9 17 4 12"></polyline>
          </svg>
          <span class="copy-text">¡Copiado!</span>
        `;
        
        // Reset after 2 seconds
        setTimeout(function() {
          button.classList.remove('copied');
          button.innerHTML = `
            <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
              <rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect>
              <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
            </svg>
            <span class="copy-text">Copiar</span>
          `;
        }, 2000);
        
      } catch (err) {
        console.error('Error al copiar:', err);
        button.innerHTML = `
          <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
            <circle cx="12" cy="12" r="10"></circle>
            <line x1="15" y1="9" x2="9" y2="15"></line>
            <line x1="9" y1="9" x2="15" y2="15"></line>
          </svg>
          <span class="copy-text">Error</span>
        `;
        
        setTimeout(function() {
          button.innerHTML = `
            <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" aria-hidden="true">
              <rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect>
              <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
            </svg>
            <span class="copy-text">Copiar</span>
          `;
        }, 2000);
      }
    });
  });
});