package kekstar.fdi.gamepc;

import javax.swing.JFrame;
import kekstar.fdi.nine11_pc.*;
import kekstar.fdi.engine.*;
import kekstar.fdi.nine11_logic.*;

public class GamePC implements Game{
    public static void main (String [] args)
    {
        System.out.print("UH BABY BABY IT'S A WILD WORLD");

        GraphicsPC g = new GraphicsPC(new JFrame("Nine11"));


        ImagePC z = g.newImage("./Assets/debug.jpg");
        Rect src = new Rect(0, 0,387, 500);
        Rect dest = new Rect (100, 100, 150, 150);

        Sprite s = new Sprite(z, src);

    float temp = 0.01f;
        while(true) {
              g.clear( 0x00000000);
              dest.set_x(dest.get_x()+ (int)temp);
              if(temp > 1 )temp = 0;
              s.draw(g, src);
              g.present();
              temp+= 0.001;

        }
    }
    @Override
    public Graphics getGraphics(){
        return _graphics;
    }
    @Override
    public Input getInput() {
        return _input;
    }

    GraphicsPC _graphics;
    InputPC _input;

}
