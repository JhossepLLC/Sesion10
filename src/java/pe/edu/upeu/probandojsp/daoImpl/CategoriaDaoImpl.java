/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.probandojsp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.probandojsp.config.Conexion;
import pe.edu.upeu.probandojsp.dao.CategoriaDao;
import pe.edu.upeu.probandojsp.model.Categoria;

/**
 *
 * @author HP
 */
public class CategoriaDaoImpl implements CategoriaDao{
    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<Categoria> listarCategoria() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String query = "SELECT * FROM categoria";

        List<Categoria> categorias = new ArrayList<Categoria>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultset.getInt("idCategoria"));
                categoria.setNombreCategoria(resultset.getString("nombreCategoria"));
                categorias.add(categoria);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return categorias;
    }
}
