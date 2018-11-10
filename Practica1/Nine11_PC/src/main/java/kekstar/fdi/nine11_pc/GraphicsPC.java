package kekstar.fdi.nine11_pc;

import java.awt.Color;
import java.awt.image.BufferStrategy;


import javax.imageio.*;
import javax.swing.JFrame;
import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Image;
import kekstar.fdi.engine.Rect;

public class GraphicsPC implements Graphics {


    public GraphicsPC(JFrame frame) {
        this._frame = frame;
        this._frame.setSize(400, 400);
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._frame.setVisible(true);
        _frame.createBufferStrategy(2);
        this._strategy = _frame.getBufferStrategy();
        this._awtGraphics = _frame.getBufferStrategy().getDrawGraphics();

    }

    @Override
    public void clear(int color) {
            _frame.getBufferStrategy().getDrawGraphics();
            _awtGraphics.setColor(new Color(color));
            _awtGraphics.fillRect(0,0,_frame.getWidth(), _frame.getHeight());
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

        _frame.getBufferStrategy().getDrawGraphics().drawImage(temp.get_AwtImage(),
                dest.get_x(), dest.get_y(), dest.get_x()+dest.get_width(), dest.get_y()+dest.get_height(),
                source.get_x(), source.get_y(), source.get_x()+source.get_width(), source.get_y()+source.get_height(),
                null);
        return true;
    }
    @Override
    public ImagePC newImage(String name) {
        try {
            java.awt.Image temp = ImageIO.read(new java.io.File(name));
            return new ImagePC(temp);
        }
        catch(Exception e){
            System.out.print(e);
        }
        return null;
    }

    public void present(){
        do {
            do {
                _awtGraphics.dispose();
            } while (_strategy.contentsRestored());
            // We show the buffer we had stored
            _strategy.show();
            //And then change the pointer to the new buffer in which the program will draw
            _awtGraphics = _strategy.getDrawGraphics();
        }while(_strategy.contentsLost());
    }

    java.awt.Graphics _awtGraphics;
    BufferStrategy _strategy;
    JFrame _frame;
}
