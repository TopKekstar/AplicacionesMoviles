package kekstar.fdi.nine11_pc;

import java.awt.Graphics.*;
import javax.imageio.*;
import javax.swing.JFrame;
import javax.swing.JFrame.*;
import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

public class GraphicsPC implements Graphics {


    public GraphicsPC(JFrame frame) {
        this._frame = frame;
        this._awtGraphics = _frame.getGraphics();
        this._frame.setSize(400, 400);
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._frame.setVisible(true);
    }

    @Override
    public void clear(int color) {

    }

    @Override
    public int getWidth() {
        return _frame.getWidth();
    }

    @Override
    public int getHeight() {
        return _frame.getHeight();
    }

    @Override
    public boolean drawImage(Image im, Rect dest, Rect source) {
        ImagePC temp = (ImagePC)im;
        _awtGraphics.drawImage(temp.get_AwtImage(),
                dest.get_x(), dest.get_y(), dest.get_x()+dest.get_width(), dest.get_y()+dest.get_height(),
                source.get_x(), source.get_y(), source.get_x()+source.get_width(), source.get_y()+source.get_height(),
                null);
        return true;
    }

    @Override
    public ImagePC newImage(String name) {
        ImagePC a;
        try {
            java.awt.Image temp = ImageIO.read(new java.io.File(name));
            return new ImagePC(temp);
        }
        catch(Exception e){
            System.out.print(e);
        }
        return null;
    }

    java.awt.Graphics _awtGraphics;
    JFrame _frame;
}
