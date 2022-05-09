/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classDAO;

import conexion.ConexionesDB;
import interfaceClass.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaClass.Curso;
import javaClass.Estudiante;
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public class EstudianteDAO implements InterfaceDAO<Estudiante> {

    @Override
    public List<Estudiante> getList() throws SQLException, NamingException {
        try (
                 Connection conexion = ConexionesDB.getConexion();  
                Statement st = conexion.createStatement();
            ) {
            ResultSet rs = st.executeQuery("Select * from Estudiante");
            List<Estudiante> listaEstudiante = new ArrayList<>();
            while (rs.next()) {
                short id = rs.getShort("idEstudiate");
                String rut = rs.getString("rut");
                String apellidos = rs.getString("apellidosEstudiante");
                String nombres = rs.getString("nombresEstudiante");
                char genero = (rs.getString("genero")).charAt(0);
                String fono = rs.getString("fono");
                short idCurso = rs.getShort("idCuso");
                String nomCurso = getCurso(idCurso);
                Curso curso = new Curso(idCurso, nomCurso);
                Estudiante estudiante ;
                estudiante = new Estudiante(id, rut, apellidos, nombres, genero, fono, curso);
                
                listaEstudiante.add(estudiante);

            }
            
            return listaEstudiante;

        }
    }
    
    private String getCurso(short idCurso) throws SQLException, NamingException{
        CursoDAO cursoDAO = null;
        String nomCurso = null;
        List<Curso> listaCurso = cursoDAO.getList();
        for(Curso curso : listaCurso){
            if(curso.getIdCurso() == idCurso){
                nomCurso = curso.getNombreCurso();
                break;
            }
            
        }
        return nomCurso;
        
    }

    @Override
    public void getCreate(Estudiante estudiante) throws NamingException, SQLException {
        String sql = "insert into estudiante(rut, apellidosEstudiante, nombresEstudiante, genero, fono, idCurso) values (?,?,?,?,?,?)";
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
                
        ){
            
           ps.setString(1, estudiante.getRut());
           ps.setString(2, estudiante.getApellidoEstudiante());
           ps.setString(3, estudiante.getNombreEstudiante());
           ps.setString(4, String.valueOf(estudiante.getGenero()));
           ps.setString(5, estudiante.getFono());
           ps.setShort(6, estudiante.getCurso().getIdCurso());

           int filaInsertada = ps.executeUpdate();
        }
    }

    public Estudiante getSearch(short id) throws NamingException, SQLException {
        String sql="select * from Estudiantes where idEstudiante = ? ";
        try(
                Connection conexion = ConexionesDB.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
            ){
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                short idEstudiante = rs.getShort("idAsignatura");
                String rut = rs.getString("rut");
                String apellidos = rs.getString("apellidosEstudiante");
                String nombres = rs.getString("nombresEstudiante");
                char genero = (rs.getString("genero")).charAt(0);
                String fono = rs.getString("fono");
                short idCurso = rs.getShort("idCurso");
                String nombreCurso = getCurso(idCurso);
                Curso curso = new Curso(idCurso, nombreCurso);
                Estudiante estudiante ;
                estudiante = new Estudiante(idEstudiante, rut, apellidos, nombres, genero, fono, curso);
                
                return estudiante;
            }else{
                
                return null;
            }
            
        }
    }


    @Override
    public void getUpdate(Estudiante estudiante) throws NamingException, SQLException {
        String sql ="update estudiantes set "
                + "rut = ?,"
                + "apellidosEstudiante = ?"
                + "nombresEstudiante = ?"
                + "genero = ?"
                + "fono = ?"
                + "idCurso = ?"
                + "Where idEstudiante = ?";
        try(
                Connection conexion = ConexionesDB.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
        
        
        ){
            ps.setString(1, estudiante.getRut());
            ps.setString(2, estudiante.getApellidoEstudiante());
            ps.setString(3, estudiante.getNombreEstudiante());
            ps.setString(4, String.valueOf(estudiante.getGenero()));
            ps.setString(5, estudiante.getFono());
            ps.setShort(6, estudiante.getCurso().getIdCurso());
            
            int filaActualizada = ps.executeUpdate();
        }
        
    }


    @Override
    public void getDelete(short s) throws SQLException, NamingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
