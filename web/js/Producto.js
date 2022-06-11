$(document).ready(() => {
    listarProductos();
    listarCategoria();
});
var productos = [];
const listarProductos = () => {

    $('#tblProductos tbody tr').remove();
    $.get('ProductoController', {opcion: 1}, (data) => {

        productos = JSON.parse(data);
        console.table(productos);
        productos.forEach(
                (producto, index) => {
            $('#tblProductos tbody').append(`
                    <tr>
                        <td>${index + 1}</td>
                        <td>${producto.nombreCategoria}</td>
                        <td>${producto.nombreProductos}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.stock}</td>
                        <td><a href='#' onclick='empezarEdicion(${producto.idProducto})'><i class='fa-solid fa-pen-to-square color1'></i></a>
                        <a href='#' onclick='eliminarProducto(${producto.idProducto})''><i class='fa-solid fa-trash-can color2'></i></a></td>   
                        </tr>
                `);
        }
        );
    });
};
/*<td><button class='btn btn-danger' onclick='eliminarProducto(${producto.idProducto})'>eliminar</button></td>
                        <td><button class='btn btn-warning' onclick='empezarEdicion(${producto.idProducto})'>editar</button></td>
                    */

const crearProducto = () => {

    const nombreProductos = $('#txtNombreProducto').val();
    const precio = $('#numberPrecioProducto').val();
    const stock = $('#numberStockProducto').val();
    const idCategoria = $('#selectCategoria').val();

    const productoNuevo = {
        nombreProductos,
        idCategoria,
        precio,
        stock
    };

    const producto = JSON.stringify({...productoNuevo});
    console.log(producto);
    $.post('ProductoController', {opcion: 2, productoNuevo: producto}, () => {

        alert('Producto registrado correctamente');
        // formatear el formulario
        $('#txtNombreProducto').val('');
        $('#numberPrecioProducto').val('');
        $('#numberStockProducto').val('');
        $('#selectCategoria').val('');
        listarProductos();

    });
};
const edtitarProducto = () => {
    const nombreProductos = $('#txtNombreProducto').val();
    const precio = $('#numberPrecioProducto').val();
    const stock = $('#numberStockProducto').val();
    const idCategoria = $('#selectCategoria').val();
    const IdProducto = $('#txtIdProducto').val();

    const productoEditado = {
        IdProducto,
        nombreProductos,
        idCategoria,
        precio,
        stock
    };
    //Esta convirtiendo el objeto alumnoEditado a formato JSON;
    const productoActualizado = JSON.stringify({...productoEditado});

    $.post('ProductoController', {opcion: 3, productoActualizado}, () => {
        console.log('Producto Editado');
        $('#txtNombreProducto').val('');
        $('#numberPrecioProducto').val('');
        $('#numberStockProducto').val('');
        $('#selectCategoria').val('');
        $('#txtIdProducto').val('');
        listarProductos();
    });
    alert("Producto Editado");
};

const empezarEdicion = (idProducto) => {
    console.log(idProducto);
    const productoEncontrado = productos.find((producto) => producto.idProducto === idProducto);

    $('#txtNombreProducto').val(productoEncontrado.nombreProductos);
    $('#numberPrecioProducto').val(productoEncontrado.precio);
    $('#numberStockProducto').val(productoEncontrado.stock);
    $('#selectCategoria').val(productoEncontrado.idCategoria);
    $('#txtIdProducto').val(productoEncontrado.idProducto);
};

const guardarCambios = () => {
    const idProducto = $('#txtIdProducto').val();

    if (idProducto === '') {
        crearProducto();
    } else {
        edtitarProducto();
    }
};

const eliminarProducto = (idProducto) => {
    $.post('ProductoController', {opcion: 4, idProducto}, () => {
        listarProductos();
    });
    alert("Producto Eliminado");
};

const listarCategoria = () => {

    $('#selectCategoria option').remove();
    $.get('CategoriaController', {opcion: 1}, (data) => {
        const categorias = JSON.parse(data);
        console.table(categorias);
        $('#selectCategoria').append(`  <option value="o" disabled selected>Categoria: </option>`);
        categorias.forEach(
                (categoria) => {
            $('#selectCategoria').append(`
              <option value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>
                `);
            }
        );
    });
};

/*
 
 
 */