/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author claeo
 */
public class Controller implements ActionListener
{
    public View view; 
    public Model model;
    
  
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand(); 
        System.out.println("Action Command: " + command);
        
        switch (command){
            case "Log in":
            {
                // Login button 
                System.out.println("Log in button pressed");
                String username = this.view.unInput.getText(); 
                String password = this.view.pwInput.getText(); 
                {
                    try 
                    {
                        this.model.checkName(username, password); 
                    } 
                    catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            }
            break;
            
            case "EXIT":
            {
                System.out.println("The exit button works");
                this.model.checkFlag();
            }
            break;
            
            //This is just a button to enter the Course menu
            //It will change the Course flag to true to indicate to View 
            //to update the frame to new components 
            case "Choose your papers":
            {
                System.out.println("The Choose your papers button works");
                this.model.changeToCourse();
            }
            break;
            
            case "Remove your chosen papers":
            {
                System.out.println("The Remove your chosen papers button works");
            }
            break;
        }
    }
}
