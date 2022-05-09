/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceClass;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;



public interface InterfaceDAO<T>{
    
 
    public void getCreate(T value) throws SQLException, NamingException;
    public List<T> getList() throws SQLException, NamingException;
    public T getSearch(short id) throws SQLException, NamingException;
    public void getDelete(short id)throws SQLException, NamingException;
    public void getUpdate(T value) throws SQLException, NamingException;
}
