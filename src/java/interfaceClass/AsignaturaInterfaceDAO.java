/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceClass;

import java.sql.SQLException;
import java.util.List;
import javaClass.Asignatura;
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public interface AsignaturaInterfaceDAO {
    
    public void getCreate(Asignatura asignatura) throws SQLException, NamingException;
    public List<Asignatura> getList() throws SQLException, NamingException;
    public Asignatura getSearch(short id) throws SQLException, NamingException;
    public void getDelete(short id)throws SQLException, NamingException;
    public void getUpdate(Asignatura asignatura) throws SQLException, NamingException;
}
