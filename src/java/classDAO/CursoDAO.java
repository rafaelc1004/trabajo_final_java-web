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
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public class CursoDAO implements InterfaceDAO<Curso> {

    @Override
    public void getCreate(Curso curso) throws SQLException, NamingException {

        String sql = "Insert into Cursos (nombreCurso) values(?)";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setString(1, curso.getNombreCurso());
            int filasInsertadas = ps.executeUpdate();

        }
    }

    @Override
    public List<Curso> getList() throws SQLException, NamingException {
        try (
                Connection conexion = ConexionesDB.getConexion();  
                Statement st = conexion.createStatement();
            ) {
                 
            ResultSet rs = st.executeQuery("Select * from Cursos");
            List<Curso> listaCurso = new ArrayList<>();

            while (rs.next()) {

                short id = rs.getShort("idCurso");
                String nombre = rs.getString("nombreCurso");

                Curso curso = new Curso(id, nombre);
                listaCurso.add(curso);
            }
            return listaCurso;
        }
    }

    @Override
    public Curso getSearch(short id) throws SQLException, NamingException {
       String sql = "Select * from Cursos where idCurso = ?";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setShort(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                short idCurso = rs.getShort("idCurso");
                String nombreCurso = rs.getString("nombreCurso");
                
                return new Curso(idCurso, nombreCurso);
            }else{
                return null;
            }
            
            

        }
    }

    @Override
    public void getDelete(short id) throws SQLException, NamingException {
        String sql = "Delete Cursos where idCurso = ?";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setShort(1, id);
            int filaEliminada = ps.executeUpdate();

        }
    }

    @Override
    public void getUpdate(Curso curso) throws SQLException, NamingException {
        
        String sql = "Update Cursos set nombreCurso = ? where idCurso = ?";
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setShort(1, curso.getIdCurso());
            ps.setString(2, curso.getNombreCurso());
            ps.executeUpdate();
        }
    }

}
