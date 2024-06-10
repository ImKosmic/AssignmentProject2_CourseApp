/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    
    //For MainPage
    public JButton ExitButton = new JButton("EXIT");
    private JPanel MainMenuPanel = new JPanel();
    
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
        this.setLayout(new BorderLayout());
        this.MainMenuPanel.add(ExitButton);
        this.MainMenuPanel.setBackground(Color.LIGHT_GRAY);
        this.MainMenuPanel.setPreferredSize(new Dimension(1000,100));
        
        
        this.setLocation(500,300);
        this.setSize(800, 400); 
        this.getContentPane().removeAll();
        this.setVisible(true);
        this.add(MainMenuPanel);
        this.revalidate();
        this.repaint();
    }
    
  
    public void addActionListener(ActionListener listener)
    {
        this.ExitButton.addActionListener(listener);
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
        
        else if (data.loginFlag)
        {
           this.mainMenu();
           this.started = true;
        }
    }
}

