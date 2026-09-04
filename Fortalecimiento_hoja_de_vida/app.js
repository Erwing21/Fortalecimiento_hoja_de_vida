const checks = document.querySelectorAll('.consejo-check');


const progreso = document.getElementById('progreso');


const total = checks.length;


function actualizarProgreso() {

  const aplicados = document.querySelectorAll('.consejo-check:checked').length;

 
  progreso.textContent = `Progreso: ${aplicados} de ${total} consejos aplicados`;

 
  if (aplicados === total) {
    progreso.textContent += ' — ¡Felicitaciones, aplicaste todos los consejos!';
  }
}


checks.forEach(function (check) {
  check.addEventListener('change', actualizarProgreso);
});


console.log('Sitio de hoja de vida cargado correctamente');


// Actualizacion de proyecto semana 4
class Habilidad {
  constructor(nombre, nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }

  resumen() {
    return `${this.nombre} — ${this.nivel}`;
  }
}

const habilidades = [];

const nombreHabilidadInput = document.getElementById('nombreHabilidad');
const nivelHabilidadSelect = document.getElementById('nivelHabilidad');
const botonAgregarHabilidad = document.getElementById('agregarHabilidad');
const botonLimpiarHabilidades = document.getElementById('limpiarHabilidades');
const listaHabilidades = document.getElementById('listaHabilidades');
const mensajeHabilidad = document.getElementById('mensajeHabilidad');

function listarHabilidades() {
  listaHabilidades.innerHTML = ''; 

  habilidades.forEach((habilidad, indice) => {
    const item = document.createElement('li');

   
    const texto = document.createElement('span');
    texto.textContent = habilidad.resumen();

   
    const botonQuitar = document.createElement('button');
    botonQuitar.textContent = 'Quitar';
    botonQuitar.className = 'quitar';
    botonQuitar.addEventListener('click', () => {
      habilidades.splice(indice, 1); 
      listarHabilidades();         
    });

    item.appendChild(texto);
    item.appendChild(botonQuitar);
    listaHabilidades.appendChild(item);
  });
}


botonAgregarHabilidad.addEventListener('click', () => {
  const nombre = nombreHabilidadInput.value.trim();
  const nivel = nivelHabilidadSelect.value;

  
  if (nombre === '') {
    mensajeHabilidad.textContent = 'Escribe el nombre de la habilidad antes de agregarla.';
    return;
  }

  mensajeHabilidad.textContent = '';


  const nuevaHabilidad = new Habilidad(nombre, nivel);
  habilidades.push(nuevaHabilidad);

  
  listarHabilidades();

  nombreHabilidadInput.value = '';
  nombreHabilidadInput.focus();
});

// Actualizacion semana 5 

function listarHabilidades() {
  listaHabilidades.innerHTML = '';

  const texto = buscarHabilidadInput.value.trim().toLowerCase();

  const habilidadesFiltradas = texto === ''
    ? habilidades
    : habilidades.filter((habilidad) => habilidad.nombre.toLowerCase().includes(texto));

  if (habilidades.length > 0 && habilidadesFiltradas.length === 0) {
    const vacio = document.createElement('li');
    vacio.className = 'lista-vacia';
    vacio.textContent = 'No se encontraron habilidades que coincidan con la búsqueda.';
    listaHabilidades.appendChild(vacio);
    return;
  }

  habilidadesFiltradas.forEach((habilidad) => {
    const indiceReal = habilidades.indexOf(habilidad);
    const item = document.createElement('li');

   
    const spanTexto = document.createElement('span');
    spanTexto.textContent = habilidad.resumen();

   
    const botonQuitar = document.createElement('button');
    botonQuitar.textContent = 'Quitar';
    botonQuitar.className = 'quitar';
    botonQuitar.addEventListener('click', () => {
      habilidades.splice(indiceReal, 1); 
      listarHabilidades();         
    });

    item.appendChild(spanTexto);
    item.appendChild(botonQuitar);
    listaHabilidades.appendChild(item);
  });
}

buscarHabilidadInput.addEventListener('input', listarHabilidades);

botonLimpiarHabilidades.addEventListener('click', () => {
  habilidades.length = 0; 
  listarHabilidades();
});


nombreHabilidadInput.addEventListener('keydown', (evento) => {
  if (evento.key === 'Enter') {
    botonAgregarHabilidad.click();
  }
});