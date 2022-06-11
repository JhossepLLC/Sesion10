/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.probandojsp.dao;

import java.util.List;
import pe.edu.upeu.probandojsp.dtos.ProductoDto;
import pe.edu.upeu.probandojsp.model.Producto;

/**
 *
 * @author HP
 */
public interface ProductoDao {

    int crearProducto(Producto producto, int idCategoria);

    int actualizarProducto(ProductoDto producto);

    int eliminarProductoPorId(Integer idProducto);

    Producto buscarProducto(Integer idProducto);

    List< ProductoDto> listarProductos();
}
