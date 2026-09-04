const productos = [
  { producto: "Audifonos Inalambricos", precio: 89000 },
  { producto: "Mouse Gamer", precio: 65000 },
  { producto: "Teclado Mecanico", precio: 150000 },
  { producto: "Monitor 24''", precio: 620000 },
  { producto: "Silla Ergonomica", precio: 850000 }
];


const LIMITE_DESCUENTO = 300000;

const PORCENTAJE_DESCUENTO = 0.10;


const formatoCOP = new Intl.NumberFormat("es-CO", {
  style: "currency",
  currency: "COP",
  minimumFractionDigits: 0,
  maximumFractionDigits: 0
});


const selectProducto = document.getElementById("producto");
const inputCantidad = document.getElementById("cantidad");
const btnCalcular = document.getElementById("btnCalcular");
const divResultado = document.getElementById("resultado");


productos.forEach((item, index) => {
  const option = document.createElement("option");
  option.value = index;
  option.textContent = `${item.producto} - ${formatoCOP.format(item.precio)}`;
  selectProducto.appendChild(option);
});


function calcularTotal(precio, cantidad) {
  return precio * cantidad;
}


function procesarCompra() {
  const item = productos[selectProducto.value];
  const producto = item.producto;
  const precio = item.precio;
  const cantidad = parseInt(inputCantidad.value);


  if (isNaN(cantidad) || cantidad <= 0) {
    alert("Por favor ingresa una cantidad válida (mayor a 0).");
    return;
  }

 
  const subtotal = calcularTotal(precio, cantidad);


  let totalFinal;
  let tieneDescuento = false;

  if (subtotal > LIMITE_DESCUENTO) {
    totalFinal = subtotal - (subtotal * PORCENTAJE_DESCUENTO);
    tieneDescuento = true;
  } else {
    totalFinal = subtotal;
  }

 
  document.getElementById("outProducto").textContent = producto;
  document.getElementById("outPrecio").textContent = formatoCOP.format(precio);
  document.getElementById("outCantidad").textContent = cantidad;
  document.getElementById("outSubtotal").textContent = formatoCOP.format(subtotal);
  document.getElementById("outTotalFinal").textContent = formatoCOP.format(totalFinal);

  const avisoDescuento = document.getElementById("avisoDescuento");
  if (tieneDescuento) {
    avisoDescuento.textContent = `¡Descuento del ${PORCENTAJE_DESCUENTO * 100}% aplicado por superar ${formatoCOP.format(LIMITE_DESCUENTO)}!`;
  } else {
    avisoDescuento.textContent = `Sin descuento (el subtotal no supera ${formatoCOP.format(LIMITE_DESCUENTO)})`;
  }

  divResultado.hidden = false;


  const resultadoCompra = {
    producto: producto,
    subtotal: subtotal,
    totalFinal: Math.round(totalFinal)
  };

  console.log("Resumen de la compra (COP):", resultadoCompra);
}


btnCalcular.addEventListener("click", procesarCompra);


procesarCompra();