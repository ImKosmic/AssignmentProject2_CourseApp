/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author claeo
 */
public class View extends JFrame implements Observer
{
    //For user page
    private JPanel userPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or password!");
    private JButton loginButton = new JButton("Log in");
    public JLabel message = new JLabel("Welcome!", JLabel.CENTER);
    
    //For mainMenu page
    private JPanel mainMenuPanel = new JPanel();
    private JLabel workingText = new JLabel("This is the new page");
    
    
    private boolean started = false; 
    
    //Constructor 
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null); //Make the frame located at the absolute center of the screen
        this.userPanel.add(uName);
        this.userPanel.add(unInput);
        this.userPanel.add(pWord);
        this.userPanel.add(pwInput);
        this.userPanel.add(loginButton);
        this.add(this.message, BorderLayout.SOUTH);
        this.add(userPanel);
        this.setVisible(true);
    }
    
    public void mainMenu()
    {
        this.setSize(600,600);
        this.mainMenuPanel.add(workingText);
        
        this.getContentPane().removeAll();
        mainMenuPanel.setVisible(true);
        this.add(mainMenuPanel);
        this.revalidate();
        this.repaint();
    }
    
  
    public void addActionListener(ActionListener listener)
    {
        this.loginButton.addActionListener(listener);
    }
    

    @Override
    public void update(Observable o, Object arg)
    {
        Data data = (Data) arg; 
        if (!data.loginFlag)
        {
            this.unInput.setText("");
            this.pwInput.setText("");
            this.message.setText("Invalid username or password.");
        }
        
        else 
        {
           this.mainMenu();
           this.started = true;
        }
        
       
    }
}

