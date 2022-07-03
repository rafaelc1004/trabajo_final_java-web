/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceClass;

import java.sql.SQLException;
import java.util.List;
import javaClass.Calificacion;
import javax.naming.NamingException;

/**
 *
 * @author Rafaelito
 */
public interface CalificacionInterfaceDao extends InterfaceDAO<Calificacion>{
    
    @Override
    public List<Calificacion> getList() throws SQLException, NamingException;
    public void getDelete(short idStudent, short idCourse)throws SQLException, NamingException;
    @Override
    public void getUpdate(Calificacion calificacion) throws SQLException, NamingException;
    
}
