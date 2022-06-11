$(document).ready(()=> {
    listarCategoria();
});

var categorias = [];
const listarCategoria = () => {
    console.table("categorias");
    $('#tblCategoria tbody tr').remove();
    $.get('CategoriaController', {opcion: 1}, (data) => {


        categorias = JSON.parse(data);
        console.table(categorias);
        categorias.forEach(
                (categoria, id) => {
            $('#tblCategoria tbody').append(`
                    <tr>
                        <td>${id + 1}</td>
                        <td>${categoria.nombreCategoria}</td>
                        <td><a href='#' onclick='empezarCategoria(${categoria.idCategoria})'><i class='fa-solid fa-pen-to-square color1'></i></a>
                        <a href='#' onclick='eliminarCategoria(${categoria.idCategoria})''><i class='fa-solid fa-trash-can color2'></i></a></td>   
                    </tr>
                `);
            }
        );
    });
};

/*<td><button class='btn btn-danger' onclick='eliminarCategoria(${categoria.idCategoria})'>eliminar</button>
                        <button class='btn btn-warning' onclick='empezarCategoria(${categoria.idCategoria})'>editar</button></td>*/