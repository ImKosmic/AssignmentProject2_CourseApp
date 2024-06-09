/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

/**
 *
 * @author claeo
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDatabase 
{
    Connection conn = null;
    String url = "jdbc:derby:StudentDB;create=true"; 
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    /**
     * Step 3: Create the method for initializing the connection between the 
     * program and the database.Go to Controller.java for Step 4 
     *
     * @throws java.sql.SQLException
     */
    public void dbsetup() throws SQLException
    {
        try
        {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "StudentTable";
            
            if (!checkTableExisitng(tableName))
            {
                statement.executeUpdate("CREATE TABLE " + tableName + "(studentid VARCHAR(12), password VARCHAR(12), paper VARCHAR(100))");
            }
            statement.close();
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    

    public Data checkName(String username, String password) throws SQLException
    {
        Data data = new Data(); // Initialize an instance of Data
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT studentid, password, paper FROM StudentTable "
                    + "WHERE studentid = '" + username + "'");
            if (rs.next())
            {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");

                if (password.compareTo(pass) == 0)
                {
                    data.loginFlag = true;
                }
                else
                {
                    data.loginFlag = false;
                }
            }
            else
            {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO StudentTable (studentid, password, paper) "
                        + "VALUES('" + username + "', '" + password + "', '')");
                data.loginFlag = true;
            }
            rs.close(); // close the ResultSet
            statement.close(); // close the Statement
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return data;
    }

    
    private boolean checkTableExisitng(String newTableName) throws SQLException
    {
        boolean flag = false;
        try
        {
            System.out.println("check existing tables....");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null); //types
            //Statement dropStatement=null;
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0)
                {
                    System.out.println(tableName + " is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null)
            {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return flag;
    }
}
