package kekstar.fdi.nine11_logic;



import java.util.ArrayList;
import java.util.Vector;

import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;
//TODO: Implementar Lógica y su bucle de juego.

public class Logic {

    public Logic(Game game)
    {
        this._game = game;
    }

    public void initLogic()
    {
        sprites = new ArrayList<>();

        dest = new Rect (100, 100, 150, 150);
        temp = 0f;
        Sprite a = new Sprite("./Assets/debug.log", new Rect(0,0,150, 150), _game.getGraphics());
        sprites.add(a);

    }
    public void run()
    {
        _game.getGraphics().clear(0x00000000);
        dest.set_x(dest.get_x()+ (int)temp);
        if(temp > 1 )temp = 0;

        for(Sprite s: sprites){
            s.draw(_game.getGraphics(),dest);

        }
        _game.getGraphics().present();
    }

    Game _game;
    Rect dest;
    float temp;
    ArrayList<Sprite> sprites;

}

