/**
 * LambdaPath - Navigation functionality
 * Mobile menu toggle and sidebar management
 */

document.addEventListener('DOMContentLoaded', function() {
  // Mobile menu toggle
  const menuToggle = document.querySelector('.menu-toggle');
  const siteNav = document.querySelector('.site-nav');
  
  if (menuToggle && siteNav) {
    menuToggle.addEventListener('click', function() {
      const isExpanded = menuToggle.getAttribute('aria-expanded') === 'true';
      menuToggle.setAttribute('aria-expanded', !isExpanded);
      siteNav.classList.toggle('open');
      
      // Animate hamburger
      menuToggle.classList.toggle('active');
    });
  }
  
  // Mobile submenu toggles
  const hasSubmenuItems = document.querySelectorAll('.nav-item.has-submenu');
  
  hasSubmenuItems.forEach(function(item) {
    const link = item.querySelector('.nav-link');
    
    link.addEventListener('click', function(e) {
      // Only on mobile (check if submenu is visible by default)
      const submenu = item.querySelector('.submenu');
      const isDesktop = window.getComputedStyle(submenu).position === 'absolute';
      
      if (!isDesktop) {
        e.preventDefault();
        item.classList.toggle('open');
      }
    });
  });
  
  // Close mobile menu when clicking outside
  document.addEventListener('click', function(e) {
    if (!e.target.closest('.site-header') && siteNav.classList.contains('open')) {
      siteNav.classList.remove('open');
      menuToggle.setAttribute('aria-expanded', 'false');
      menuToggle.classList.remove('active');
    }
  });
  
  // Active state for current page
  const currentPath = window.location.pathname;
  const navLinks = document.querySelectorAll('.nav-link');
  
  navLinks.forEach(function(link) {
    const linkPath = link.getAttribute('href');
    if (linkPath && currentPath.includes(linkPath.replace(/\/$/, ''))) {
      link.classList.add('active');
    }
  });
});