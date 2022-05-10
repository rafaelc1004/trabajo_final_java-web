/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceClass;

import java.sql.SQLException;
import java.util.List;
import javaClass.Estudiante;
import javax.naming.NamingException;

public interface EstudianteInterfaceDAO extends InterfaceDAO<Estudiante> {
    
    public void getCreate(Estudiante estudiante) throws SQLException, NamingException;
    public List<Estudiante> getList() throws SQLException, NamingException;
    public Estudiante getSearch(short id) throws SQLException, NamingException;
    public void getDelete(short id)throws SQLException, NamingException;
    public void getUpdate(Estudiante estudiante) throws SQLException, NamingException;
}
