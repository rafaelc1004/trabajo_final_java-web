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

public class CalificacionDAO implements CalificacionInterfaceDao {

    private AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
    private EstudianteDAO estudianteDAO = new EstudianteDAO();

    public CalificacionDAO(EstudianteDAO estudianteDAO, AsignaturaDAO asignaturaDAO) {
        this.asignaturaDAO = asignaturaDAO;
        this.estudianteDAO = estudianteDAO;
    }

    public CalificacionDAO() {

    }

    public void getAddAsignatura(short idStudent, short idCourse) throws NamingException, SQLException {
        String sql = "insert into calificaciones(idEstudiante, idAsignatura) values(?,?)";
        try (
            Connection conexion = ConexionesDB.getConexion();  PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setShort(1, idStudent);
            ps.setShort(2, idCourse);

            int filaIngresada = ps.executeUpdate();
        }
    }

    @Override
    public List<Calificacion> getList() throws SQLException, NamingException {

        try (
                 Connection conexion = ConexionesDB.getConexion();  Statement st = conexion.createStatement();) {
            List<Calificacion> listaCalificacion = new ArrayList<>();
            ResultSet rs = st.executeQuery("Select * from Calificaciones");
            while (rs.next()) {
                short idAsignatura = rs.getShort("idAsignatura");
                Asignatura asignatura = asignaturaDAO.getSearch(idAsignatura);
                short idEstudiante = rs.getShort("idEstudiante");
                Estudiante estudiante = estudianteDAO.getSearch(idEstudiante);
                double nota1 = rs.getDouble("nota1");
                double nota2 = rs.getDouble("nota2");
                double nota3 = rs.getDouble("nota3");
                double nota4 = rs.getDouble("nota4");
                double nota5 = rs.getDouble("nota5");
                double promedio = rs.getDouble("promedio");

                Calificacion calificacion = new Calificacion(estudiante, asignatura, nota1, nota2, nota3, nota4, nota5, promedio);

                listaCalificacion.add(calificacion);
            }
            return listaCalificacion;

        }
    }

    @Override
    public void getDelete(short idEstud, short idAsig) throws SQLException, NamingException {

        String sql = "Delete Calificaciones where idEstudiante = ? && idAsignatura = ?";

        try (
                 Connection conexion = ConexionesDB.getConexion();  PreparedStatement ps = conexion.prepareStatement(sql);) {

            ps.setShort(1, idEstud);
            ps.setShort(2, idAsig);

            int filaEliminada = ps.executeUpdate();
        }
    }

    @Override
    public void getUpdate(Calificacion calificacion) throws SQLException, NamingException {

        String sql = "Update Calificaciones set nota1 = ?, nota2=?, nota3=?, nota4=?, nota5=? where idEstudiante = ?  && idAsignatura = ? ";
        try (
                 Connection conexion = ConexionesDB.getConexion();  PreparedStatement ps = conexion.prepareStatement(sql);) {

            ps.setDouble(1, calificacion.getNota1());
            ps.setDouble(2, calificacion.getNota2());
            ps.setDouble(3, calificacion.getNota3());
            ps.setDouble(4, calificacion.getNota4());
            ps.setDouble(4, calificacion.getNota5());
            ps.setShort(4, calificacion.getEstudiante().getIdEstudiante());
            ps.setShort(4, calificacion.getAsignatura().getIdAsignatura());

            int filaActualizada = ps.executeUpdate();
        }

    }
    
    //Recupera la lista de asignaturas y calificaciones que tiene el alumno seleccionado en la pagina anterior  
    public List<Calificacion> getListCoursesStudent(short id) throws NamingException, SQLException{
        String sql = "select * from calificaciones where idEstudiante =?";
        List<Calificacion> listaCalificacion = new ArrayList<>();
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setShort(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                short idAsignatura = rs.getShort("idAsignatura");
                Asignatura asignatura = asignaturaDAO.getSearch(idAsignatura);
                short idEstudiante = rs.getShort("idEstudiante");
                Estudiante estudiante = estudianteDAO.getSearch(idEstudiante);
                double nota1 = rs.getDouble("nota1");
                double nota2 = rs.getDouble("nota2");
                double nota3 = rs.getDouble("nota3");
                double nota4 = rs.getDouble("nota4");
                double nota5 = rs.getDouble("nota5");
                double promedio = rs.getDouble("promedio");
  
                Calificacion calificacion = new Calificacion(estudiante, asignatura, nota1, nota2, nota3, nota4, nota5, promedio);
                
                listaCalificacion.add(calificacion);
            }
            return listaCalificacion;
        }
    }
    
    public Calificacion getCalificacionStudent(short idStudent, short idCourse) throws SQLException, NamingException {
        String sql = "Select * from calificaciones where idEstudiante = ? and idAsignatura=?";
        Calificacion calificacion = new Calificacion();
        try (
                 Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                ) {
            
            ps.setShort(1, idStudent);
            ps.setShort(2, idCourse);
    
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                short idAsignatura = rs.getShort("idAsignatura");
                Asignatura asignatura = asignaturaDAO.getSearch(idAsignatura);
                short idEstudiante = rs.getShort("idEstudiante");
                Estudiante estudiante = estudianteDAO.getSearch(idEstudiante);
                double nota1 = rs.getDouble("nota1");
                double nota2 = rs.getDouble("nota2");
                double nota3 = rs.getDouble("nota3");
                double nota4 = rs.getDouble("nota4");
                double nota5 = rs.getDouble("nota5");
                double promedio = rs.getDouble("promedio");

                calificacion = new Calificacion(estudiante, asignatura, nota1, nota2, nota3, nota4, nota5, promedio);

                
            }
            return calificacion;

        }
    }
    
    public void getUpdateCalificacion(Calificacion calificacion) throws SQLException, NamingException {
        String sql = "update Calificaciones set nota1 = ?, nota2 = ?, nota3 =?, nota4 = ?, nota5 =? where idEstudiante = ? and idAsignatura = ?";
        
        try (
                 Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                ) {
            
            ps.setDouble(1, calificacion.getNota1());
            ps.setDouble(2, calificacion.getNota2());
            ps.setDouble(3, calificacion.getNota3());
            ps.setDouble(4, calificacion.getNota4());
            ps.setDouble(5, calificacion.getNota5());
            ps.setShort(6, calificacion.getEstudiante().getIdEstudiante());
            ps.setShort(7, calificacion.getAsignatura().getIdAsignatura());
    
            ResultSet rs = ps.executeQuery();
           

        }
    }

}
