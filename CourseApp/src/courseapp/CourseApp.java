/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseapp;

/**
 *
 * @author claeo
 */
import java.sql.SQLException;

public class CourseApp {

    public static void main(String[] args) throws SQLException 
    {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view); //Build connection between the view and the model
    }
}
