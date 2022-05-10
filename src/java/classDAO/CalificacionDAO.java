
package classDAO;

import conexion.ConexionesDB;
import interfaceClass.CalificacionInterfaceDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaClass.Asignatura;
import javaClass.Calificacion;
import javaClass.Estudiante;
import javax.naming.NamingException;

public class CalificacionDAO implements CalificacionInterfaceDao{

    @Override
    public void getCreate(Calificacion calificacion) throws SQLException, NamingException {
        String sql = "Insert into Calificaciones(idAsignatura, idEstudiante, numCalificacion, calificacion) values(?,?,?,?)";
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
                ){
            ps.setShort(1, calificacion.getAsignatura().getIdAsignatura());
            ps.setShort(2, calificacion.getEstudiante().getIdEstudiante());
            ps.setShort(3, calificacion.getNumCalificacion());
            ps.setDouble(4, calificacion.getNota());
            
            int filaIngresada = ps.executeUpdate();
        }
    }

    @Override
    public List<Calificacion> getList() throws SQLException, NamingException {
        
        try(
                Connection conexion = ConexionesDB.getConexion();
                Statement st = conexion.createStatement();
                
                ){
            List<Calificacion> listaCalificacion = new ArrayList<>();
            ResultSet rs = st.executeQuery("Select * from Calificaciones");
            while(rs.next()){
                short idAsignatura = rs.getShort("idAsignatura");
                String nomAsignatura = getAsignatura(idAsignatura);
                Asignatura asignatura = new Asignatura(idAsignatura, nomAsignatura);
                short idEstudiante = rs.getShort("idEstudiante");
                Estudiante estudiante = getEstudiante(idEstudiante);
                short numCalificacion = rs.getShort("numCalificacion");
                double nota = rs.getDouble("calificacion");
                
                Calificacion calificacion = new Calificacion(numCalificacion, nota, asignatura, estudiante);
                
                listaCalificacion.add(calificacion);
            }
            return listaCalificacion;
            
        }
    }
    
    private String getAsignatura(short idAsignatura) throws SQLException, NamingException{
        AsignaturaDAO asignaturaDAO = null;
        String nomAsignatura = null;
        List<Asignatura> listaAsignatura = asignaturaDAO.getList();
        for(Asignatura asignatura : listaAsignatura){
            if(asignatura.getIdAsignatura() == idAsignatura){
                nomAsignatura = asignatura.getNombreAsignatura();
                break;
            }
            
        }
        return nomAsignatura;
        
    }
    
    private Estudiante getEstudiante(short idEstudiante) throws SQLException, NamingException{
        EstudianteDAO estudianteDAO = null;
        
        Estudiante alumno = null;
        String rut = null;
        String apellido = null;       
        String nombre = null;
        char genero;
        String fono = null;
        
        List<Estudiante> listaEstudiante = estudianteDAO.getList();
        for(Estudiante estudiante : listaEstudiante){
            if(estudiante.getIdEstudiante() == idEstudiante){
   
            rut = estudiante.getRut();
            apellido = estudiante.getApellidoEstudiante();
            nombre = estudiante.getNombreEstudiante();
            genero = estudiante.getGenero();
            fono = estudiante.getFono();
            
            alumno = new Estudiante(idEstudiante, rut, apellido, nombre, genero, fono);
                break;
            }
            
        }
        return alumno;
        
    }

   
    public List<Calificacion> getSearch(short idAsignatura, short idEstudiante) throws SQLException, NamingException {
    
        List<Calificacion> listaNotas = new ArrayList<>();
        String sql = "Select * from Calificaciones where idAsignatura = ? && idEstudiante = ?";
        try(
                Connection conexion = ConexionesDB.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ){
            
            ps.setShort(1, idAsignatura);
            ps.setShort(2, idEstudiante);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                short numCalificacion = rs.getShort("numCalificacion");
                double nota = rs.getDouble("calificacion");
                Estudiante alumno = getEstudiante(idEstudiante);
                String  nomAsignatura = getAsignatura(idAsignatura);
                Asignatura asignatura = new Asignatura(idAsignatura, nomAsignatura);
                Calificacion calificacion = new Calificacion(numCalificacion, nota, asignatura, alumno);
                listaNotas.add(calificacion);
                
            }
            
            return listaNotas;
        }
        
    }
    

 
    public void getDelete(short idEstud, short idAsig, short numCalif) throws SQLException, NamingException {
        
        String sql = "Delete Calificaciones where idEstudiante = ? && idAsignatura = ? && numCalificacion = ?";
        
        try(
                Connection conexion = ConexionesDB.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                
                ){
            
            ps.setShort(1, idEstud);
            ps.setShort(2, idAsig);
            ps.setShort(3, numCalif);
            
            int filaEliminada = ps.executeUpdate();
        }
    }

    @Override
    public void getUpdate(Calificacion calificacion) throws SQLException, NamingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion getSearch(short id) throws SQLException, NamingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getDelete(short id) throws SQLException, NamingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
