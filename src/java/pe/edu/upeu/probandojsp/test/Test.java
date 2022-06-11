/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.probandojsp.test;

import com.google.gson.Gson;
import pe.edu.upeu.probandojsp.dao.CategoriaDao;
import pe.edu.upeu.probandojsp.dao.ProductoDao;
import pe.edu.upeu.probandojsp.daoImpl.CategoriaDaoImpl;
import pe.edu.upeu.probandojsp.daoImpl.ProductoDaoImpl;

/**
 *
 * @author HP
 */
public class Test {

    static Gson gson = new Gson();
    static ProductoDao productoDao = new ProductoDaoImpl();
    static CategoriaDao categoriaDao = new CategoriaDaoImpl();

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(gson.toJson(productoDao.listarProductos()));
        System.out.println(gson.toJson(categoriaDao.listarCategoria()));

        /*if(Conexion.getConexion()!=null){
            System.out.println("si");
        }else{
            System.out.println("no");
        }*/
        //System.out.println(g.toJson(pd.readAll()));
    }
}
