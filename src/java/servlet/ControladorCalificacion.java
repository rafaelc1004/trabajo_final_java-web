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
import javaClass.Calificacion;
import javaClass.Estudiante;
import javax.naming.NamingException;

public class ControladorCalificacion extends HttpServlet {

    private static final long serialVersiomUID = 1L;

    private  Estudiante estudiante;
    private  EstudianteDAO estudianteDao;
    private  CalificacionDAO calificacionDao;
    private List<Calificacion> listaAsignaturaCalificacion;
    private AsignaturaDAO asignaturaDao;

    public ControladorCalificacion(){
        super();
    }
    
    
    public void init() throws ServletException {
        super.init();

        this.asignaturaDao = new AsignaturaDAO();
        this.estudianteDao = new EstudianteDAO();
        this.calificacionDao = new CalificacionDAO();
        this.listaAsignaturaCalificacion = new ArrayList<>();
        this.calificacionDao = new CalificacionDAO(this.estudianteDao, this.asignaturaDao);

    }
    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String vistaJSP = "";
        PrintWriter pr = response.getWriter();
        
        switch (accion) {
            case "edit":
                vistaJSP = "/WEB-INF/jsp/calificacion/add-calificacion.jsp";
                request.getRequestDispatcher(vistaJSP).forward(request, response);
                break;
                
                // se buscan todas las asignaturas en la que esta asociado el alumno y sus calificaciones
                // y se envia a la siguiente pagina para que sean mostradas
            case "list":
                try {
                    short id = Short.parseShort(request.getParameter("id"));
                    listaAsignaturaCalificacion = calificacionDao.getListCoursesStudent(id);
                    request.setAttribute("idAlumno", id);
                    request.setAttribute("asignaturas", listaAsignaturaCalificacion);
                    vistaJSP = "/WEB-INF/jsp/calificacion/list-calificaciones-alumno.jsp";
                    request.getRequestDispatcher(vistaJSP).forward(request, response);
   
                } catch (SQLException | NamingException sqle) {
                    response.sendError(500);
                }
                break;

            default:
                response.sendError(404);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
