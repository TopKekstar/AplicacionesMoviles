package kekstar.fdi.nine11_pc;

import javax.swing.JFrame;

import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Rect;

public class Nine11_PC {
    public static void main (String [] args)
    {
        System.out.print("UH BABY BABY IT'S A WILD WORLD");

        GraphicsPC g = new GraphicsPC(new JFrame("Nine11"));

        ImagePC z = g.newImage("debug.jpg");
        Rect src = new Rect(0, 0,150, 150);
        Rect dest = new Rect (100, 100, 150, 150);

        g.drawImage(z,dest, src);


    }

}
