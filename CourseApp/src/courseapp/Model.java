/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

/**
 *
 * @author claeo
 */
import java.sql.SQLException;
import java.util.Observable;

public class Model extends Observable 
{
    public UserDatabase db;
    public Data data;
    public String username; 
    
 
    //Constructor 
    public Model() throws SQLException
    {
        this.db = new UserDatabase();
        this.db.dbsetup();
    }
    
    public void checkName(String username, String password) throws SQLException
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.setChanged(); //Essential. To mark this observable instance has been modified.
        this.notifyObservers(this.data);
    }
    
    
    
  

    
}
