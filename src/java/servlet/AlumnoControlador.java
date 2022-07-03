/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import classDAO.AsignaturaDAO;
import classDAO.CalificacionDAO;
import classDAO.EstudianteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaClass.Estudiante;
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public class AlumnoControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CalificacionDAO calificacionDao;
    private EstudianteDAO estudianteDao;
    private AsignaturaDAO asignaturaDao;
    

    public AlumnoControlador() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();

        this.asignaturaDao = new AsignaturaDAO();
        this.estudianteDao = new EstudianteDAO();

        this.calificacionDao = new CalificacionDAO(this.estudianteDao, this.asignaturaDao);

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
        String accion = request.getParameter("accion");
        String vistaJSP = "";
        List<Estudiante> listaEstudiante = new ArrayList<>();
        switch (accion) {
            case "add":
                vistaJSP = "/WEB-INF/jsp/estudiante/form-student.jsp";
                request.getRequestDispatcher(vistaJSP).forward(request, response);
                break;
            case "list":
                vistaJSP = "/WEB-INF/jsp/estudiante/list-student.jsp";

                try {
                    listaEstudiante = estudianteDao.getList();

                } catch (SQLException | NamingException e) {
                    e.printStackTrace();

                }
                request.setAttribute("estudiantes", listaEstudiante);
                request.getRequestDispatcher(vistaJSP).forward(request, response);
                break;
            default:
                response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vistaJSP = "";
        String opcion = "";
        
        opcion = request.getParameter("form");
        if (opcion.equalsIgnoreCase("createAlumno")) {
            vistaJSP = "/index.jsp";
            
            String rut = request.getParameter("txtRut");
            String apellido = request.getParameter("txtApellido");
            String nombre = request.getParameter("txtNombre");
            char genero = (request.getParameter("txtGenero")).charAt(0);
            String fono = request.getParameter("txtFono");
       
            Estudiante estudiante = new Estudiante(rut, apellido, nombre, genero, fono);
            
            
            try {
                estudianteDao.getCreate(estudiante);
            } catch (SQLException | NamingException e) {
                e.printStackTrace();

            }
            request.getRequestDispatcher(vistaJSP).forward(request, response);
        
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
