package kekstar.fdi.nine11_logic;

import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

public class Sprite{
    public Sprite(Image a, Rect src) {
        this._img = a;
        this._src = src;
    }
    public Sprite(String path, Rect src, Graphics g){
        this._img = g.newImage(path);
        this._src = src;
    }

    public Rect getSrcRect() {
        return _src;
    }

    public void draw(Graphics g, Rect dest){
        g.drawImage(_img,dest, _src);
    }
    Image _img;
    Rect _src;
}
