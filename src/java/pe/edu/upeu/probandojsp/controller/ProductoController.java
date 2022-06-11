/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.upeu.probandojsp.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.probandojsp.dao.ProductoDao;
import pe.edu.upeu.probandojsp.daoImpl.ProductoDaoImpl;
import pe.edu.upeu.probandojsp.dtos.ProductoDto;
import pe.edu.upeu.probandojsp.model.Producto;

/**
 *
 * @author HP
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {
private ProductoDao productoDao = new ProductoDaoImpl();
    private Gson gson = new Gson();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        switch (opcion) {

            case 1: //Listarout.println(gson.toJson(productoDao.listarProductos()));
                  out.println(gson.toJson(productoDao.listarProductos()));
                break;

            case 2: //Agregar

                String json = request.getParameter("productoNuevo");
                
                ProductoDto productoDto = gson.fromJson(json, ProductoDto.class);
                
                Producto productoNuevo = new Producto();
                
                //envindo datos del dto al objeto alumnoNuevo
                productoNuevo.setNombreProducto(productoDto.getNombreProductos());
                productoNuevo.setPrecio(productoDto.getPrecio());
                productoNuevo.setStock(productoDto.getStock());
                
                productoDao.crearProducto(productoNuevo, productoDto.getIdCategoria());

                break;
            case 3: //Actualizar  
                String  jsonProducto = request.getParameter("productoActualizado");
                
               ProductoDto productoDtoActualzar = gson.fromJson(jsonProducto, ProductoDto.class);
                
               productoDao.actualizarProducto(productoDtoActualzar);
                   
                break;
            case 4:
                int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                productoDao.eliminarProductoPorId(idProducto);
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
