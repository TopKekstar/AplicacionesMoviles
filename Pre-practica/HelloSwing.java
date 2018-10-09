import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;



public class HelloSwing extends JFrame
{   
    static class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(HH);
        }

    };
    public static void main(String[] args)
    {
        HelloSwing ventana;
        ventana = new HelloSwing("Hola Mundo");
        ventana.init();
        ventana.setVisible(true);
        


        System.out.println("Acabose el main");
        
        
    } //main

    public void init()
    {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Pulsame");
        add(boton);
        boton.addActionListener(new MyActionListener());
    }
    public HelloSwing(String title)
    {
        super(title);

    }

    private static final String HH = "HEIL HITLER";

}//class helloswing