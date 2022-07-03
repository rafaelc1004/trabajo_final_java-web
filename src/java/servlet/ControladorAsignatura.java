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
import javaClass.Asignatura;
import javaClass.Calificacion;
import javaClass.Estudiante;
import javax.naming.NamingException;


/**
 *
 * @author Rafaelito
 */
public class ControladorAsignatura extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private AsignaturaDAO asignaturaDao;
    private EstudianteDAO estudianteDao;
    private CalificacionDAO calificacionDao;
    private Estudiante estudiante;
    private Calificacion calificacion;
    private Asignatura asignatura;
    
    public ControladorAsignatura(){
        super();
    }
    
    
    public void init() throws ServletException {
        super.init();

        this.estudianteDao = new EstudianteDAO();
        this.calificacionDao = new CalificacionDAO();
        this.asignaturaDao = new AsignaturaDAO();
        this.estudiante = new Estudiante();
        this.calificacion = new Calificacion();
        this.asignatura = new Asignatura();
        this.calificacionDao = new CalificacionDAO(this.estudianteDao, this.asignaturaDao);

    }
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String vistaJSP = "";
        List<Asignatura> listaAsignaturas = new ArrayList<>();
       PrintWriter pr = response.getWriter();
        short id = Short.parseShort(request.getParameter("id"));
        // envia a la plantilla para agregar un nuevo ramo al estudiante
        // envia el id del estudiante elegido en la lista de estudiantes
        // envia un objeto con la lista de ramos
        if(accion.equalsIgnoreCase("addCourse")){
            try {
                vistaJSP ="/WEB-INF/jsp/asignatura/add-asignatura.jsp";

                estudiante = estudianteDao.getSearch(id);
                listaAsignaturas = asignaturaDao.getList();
                request.setAttribute("asignaturas", listaAsignaturas);
                request.setAttribute("estudiante", estudiante);
                
                
            }catch (SQLException | NamingException e) {
                e.printStackTrace();
                pr.print("errorrrr");
            }

            
            request.getRequestDispatcher(vistaJSP).forward(request, response);  
        }
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vista = "";
        String opcion = "";
        opcion = request.getParameter("form");
               PrintWriter pr = response.getWriter();

        if(opcion.equalsIgnoreCase("addRamoStudent")){
            vista = "/index.jsp";
            
            try {
                short idStudent = Short.parseShort(request.getParameter("id"));
                estudiante = estudianteDao.getSearch(idStudent);
                short idAsignatura = Short.parseShort(request.getParameter("idAsignatura"));
                asignatura = asignaturaDao.getSearch(idAsignatura);
                calificacion = new Calificacion(estudiante, asignatura);
                calificacionDao.getAddAsignatura(idStudent, idAsignatura);
               
                
            } catch (NamingException | SQLException ex) {

                ex.printStackTrace();
            }
            
            request.getRequestDispatcher(vista).forward(request, response);
            
        }
   
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
