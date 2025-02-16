/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    public JButton PaperButton = new JButton("Choose your papers");
    public JButton RemovePaperButton = new JButton("Remove your chosen papers");
    private JPanel MainMenuPanel = new JPanel();
    public JTextArea MainMenuInfo = new JTextArea();
    
    //For Course page
    private JPanel CoursePanel = new JPanel();
    private JLabel check = new JLabel("This page works"); 
    
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
        //Changing the size and location of the GUI
        this.setLocation(500,300);
        this.setSize(800, 400); 
        
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        
        PaperButton.setBounds(100, 100, 150, 100); //(x, y, x,y)
        
        RemovePaperButton.setBounds(300, 100, 200, 100);
        
        MainMenuInfo.setBounds(580, 10, 200, 330);
        MainMenuInfo.setText("Will add a variable later");
        MainMenuInfo.setEditable(false);
        
        MainMenuPanel.add(MainMenuInfo);
        MainMenuPanel.add(ExitButton);
        MainMenuPanel.add(PaperButton);
        MainMenuPanel.add(RemovePaperButton);
        
        MainMenuPanel.setBackground(Color.GRAY);
        MainMenuPanel.setLayout(null);
        
        this.getContentPane().removeAll();
        this.add(MainMenuPanel);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void CourseMenu()
    {
        CoursePanel.add(check);
        ExitButton.setBounds(0, 0, 100, 50);
        ExitButton.setBackground(Color.RED);
        CoursePanel.add(ExitButton);
        CoursePanel.setBackground(Color.GRAY);
        CoursePanel.setLayout(null);
        
        this.getContentPane().removeAll();
        this.add(CoursePanel);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
  
    public void addActionListener(ActionListener listener)
    {
        this.RemovePaperButton.addActionListener(listener);
        this.PaperButton.addActionListener(listener);
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
        
        if (data.loginFlag)
        {
           this.mainMenu();
        }
        
        if (data.CourseFlag)
        {
            this.CourseMenu();
        }
        
        if (!data.CourseFlag)
        {
            this.mainMenu();
        }
    }
}

