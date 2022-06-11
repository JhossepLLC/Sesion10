/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.probandojsp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.probandojsp.config.Conexion;
import pe.edu.upeu.probandojsp.dao.ProductoDao;
import pe.edu.upeu.probandojsp.dtos.ProductoDto;
import pe.edu.upeu.probandojsp.model.Producto;

/**
 *
 * @author HP
 */
public class ProductoDaoImpl implements ProductoDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public int crearProducto(Producto producto, int idCategoria) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int resultado = 0;          
        String query = "insert into producto(nombreProducto, precio, stock, idCategoria) values(?,?,?,?)";
        
        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, producto.getNombreProducto());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getStock());
            preparedStatement.setInt(4, idCategoria);

            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public int actualizarProducto(ProductoDto producto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "update producto set nombreProducto=?, precio=?, stock=?, idCategoria=? where idProducto=?";
        int resultado = 0;
        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, producto.getNombreCategoria());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setInt(3, producto.getStock());
            preparedStatement.setInt(4, producto.getIdCategoria());
            preparedStatement.setInt(5, producto.getIdProducto());

            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public int eliminarProductoPorId(Integer idProducto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "delete from producto where idProducto = ?";
        
        int resultado = 0;
        
        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, idProducto);
            resultado = preparedStatement.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error" + e);

        }

        return resultado;
    }

    @Override
    public Producto buscarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDto> listarProductos() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "SELECT * FROM producto p, categoria c WHERE p.idCategoria = c.idCategoria";
        
        List<ProductoDto> productos = new ArrayList<ProductoDto>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                ProductoDto producto =  new ProductoDto();
                producto.setIdProducto(resultset.getInt("idProducto"));
                producto.setNombreProductos(resultset.getString("nombreProducto"));
                producto.setPrecio(resultset.getInt("precio"));
                producto.setStock(resultset.getInt("stock"));
                producto.setIdCategoria(resultset.getInt("idCategoria"));
                producto.setNombreCategoria(resultset.getString("nombreCategoria"));
                productos.add(producto);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return productos;
    }

}
