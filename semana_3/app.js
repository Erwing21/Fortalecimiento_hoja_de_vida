
const producto = 'Portátil'; 
const precio = 25000; 
const cantidad = 2; 
 
function calcularTotal(precioUnitario, unidades) { 
  return precioUnitario * unidades; 
} 
 
function aplicarDescuento(total) { 
  if (total >= 30000) { 
    return total * 0.9; 
  } 
  return total; 
} 
 
const subtotal = calcularTotal(precio, cantidad); 
const totalFinal = aplicarDescuento(subtotal); 
 
document.getElementById('resultado').textContent = 
  `Producto: ${producto} | Subtotal: $${subtotal} | Total final: $${totalFinal}`; 
 
console.log({ producto, subtotal, totalFinal }); 