/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author claeo
 */
public class MainMenuPanel extends JPanel 
{
    private JButton ExitButton = new JButton("EXIT");
    
    public MainMenuPanel(JFrame frame)
    {
        this.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setPreferredSize(new Dimension(1000,100));
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setPreferredSize(new Dimension(120,100));
        
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        
        panel2.add(this.add(ExitButton));
    }

}
