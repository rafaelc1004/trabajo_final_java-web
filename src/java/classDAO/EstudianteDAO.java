/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classDAO;

import conexion.ConexionesDB;
import interfaceClass.EstudianteInterfaceDAO;
import interfaceClass.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaClass.Estudiante;
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public class EstudianteDAO implements EstudianteInterfaceDAO {
   

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
                Estudiante estudiante ;
                estudiante = new Estudiante(id, rut, apellidos, nombres, genero, fono);
                
                listaEstudiante.add(estudiante);

            }
            
            return listaEstudiante;

        }
    }

    @Override
    public void getCreate(Estudiante estudiante) throws NamingException, SQLException {
        String sql = "insert into estudiante(rut, apellidosEstudiante, nombresEstudiante, genero, fono) values (?,?,?,?,?)";
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
                
        ){
            
           ps.setString(1, estudiante.getRut());
           ps.setString(2, estudiante.getApellidoEstudiante());
           ps.setString(3, estudiante.getNombreEstudiante());
           ps.setString(4, String.valueOf(estudiante.getGenero()));
           ps.setString(5, estudiante.getFono());


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
                Estudiante estudiante ;
                estudiante = new Estudiante(idEstudiante, rut, apellidos, nombres, genero, fono);
                
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
            
            int filaActualizada = ps.executeUpdate();
        }
        
    }


    @Override
    public void getDelete(short id) throws SQLException, NamingException {
        
        String sql = "Delete Estudiantes where idEstudiante = ?";
        try(
                Connection conexion = ConexionesDB.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ){
            
            ps.setInt(1, id);
            int filaEliminada = ps.executeUpdate();
        }
    }

}
