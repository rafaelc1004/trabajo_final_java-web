
package classDAO;

import conexion.ConexionesDB;
import interfaceClass.AsignaturaInterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaClass.Asignatura;
import javax.naming.NamingException;

public class AsignaturaDAO implements AsignaturaInterfaceDAO{

    @Override
    public void getCreate(Asignatura asignatura) throws SQLException, NamingException {

        String sql = "Insert into Asignaturas (nombreAsignatura) values(?)";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setString(1, asignatura.getNombreAsignatura());
            int filasInsertadas = ps.executeUpdate();

        }
    }

    @Override
    public List<Asignatura> getList() throws SQLException, NamingException {
        try (
                Connection conexion = ConexionesDB.getConexion();  
                Statement st = conexion.createStatement();
            ) {
                 
            ResultSet rs = st.executeQuery("Select * from Asignaturas");
            List<Asignatura> listaAsignatura = new ArrayList<>();

            while (rs.next()) {

                short id = rs.getShort("idAsignatura");
                String nombre = rs.getString("nombreAsignatura");

                Asignatura asignatura = new Asignatura(id, nombre);
                listaAsignatura.add(asignatura);
            }
            return listaAsignatura;
        }
    }

    @Override
    public Asignatura getSearch(short id) throws SQLException, NamingException {
       String sql = "Select * from Asignaturas where idAsignatura = ?";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setShort(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                short idAsignatura = rs.getShort("idAsignatura");
                String nombreAsignatura = rs.getString("nombreAsignatura");
                
                return new Asignatura(idAsignatura, nombreAsignatura);
            }else{
                return null;
            }
            
            

        }
    }

    @Override
    public void getDelete(short id) throws SQLException, NamingException {
        String sql = "Delete Asignaturas where idAsignatura = ?";
        try (
                Connection conexion = ConexionesDB.getConexion();  
                PreparedStatement ps = conexion.prepareStatement(sql);
                
            ) {

            ps.setShort(1, id);
            int filaEliminada = ps.executeUpdate();

        }
    }

    @Override
    public void getUpdate(Asignatura asignatura) throws SQLException, NamingException {
        
        String sql = "Update Cursos set nombreCurso = ? where idCurso = ?";
        try(
            Connection conexion = ConexionesDB.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setShort(1, asignatura.getIdAsignatura());
            ps.setString(2, asignatura.getNombreAsignatura());
            ps.executeUpdate();
        }
    }


}
