package kekstar.fdi.nine11_logic;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Rect;

//TODO: Implementar clase escena. Clase genérica de la que heredarán el resto de escenas.


/*
public class Scene {
    public Scene(String name, int sceneIndex, ArrayList<ArrayList<Sprite>> sprites, int columns, int rowss, Logic logic)
    {
       if(_sprites == null) _sprites = sprites;
       _name = name;
        _sceneIndex = sceneIndex;
       rows = rowss;
       cols = columns;
       map = new int [rows*cols];
       loop = 0;
       for(int i = 0; i < map.length; i++){
          map[i] = Integer.toString(i).charAt(0);
       }
       pastTime = System.nanoTime();
       currentTime = pastTime;
    }
    public boolean tick()
    {
        loop++;
        currentTime = System.nanoTime();
        if(currentTime - pastTime >= 1*10e8){

            for(int i = 0; i < Integer.toString(loop*10).length(); i++){

               // map [(i+1)] = Integer.toString(loop*10).charAt(i);
                //System.out.println(loop);
            }

            loop = 0;
            pastTime = currentTime;
        }
        return true;
    }
    public void onClick(MouseEvent evt)
    {}
    public void draw(Graphics g)
    {
        g.clear(0x00000000);

        calculateTileSize(g.getWidth(), g.getHeight());


        int i = 0;
        int j = 0;
        for (int a : map){
            Rect dest = new Rect(((i*(int)_tileX)+(int)(marginS/2)), (j*(int)_tileY)+(int)(marginT/2), (int)_tileX, (int)_tileY);
            _sprites.get(a%16).get(a).draw(g, dest);
            i++;

            if(i > cols)
            {
                j++;
                i = 0;
            }
        }
    }
    void calculateTileSize(int realScreenX, int realScreenY){
        _sWidth = realScreenX;
        _sHeight = realScreenY;

        //Variables para guardar el ancho a mantener con los lados o el TOP/BOT
        marginS = 16;
        marginT= 16;
        float aspectR = _sWidth /_sHeight;

        if(aspectR < 1.33f){
            _sHeight = (_sWidth / 1.33f);
            marginT = realScreenY-_sHeight;
        }
        else if (aspectR > 1.33f){
            _sWidth = (1.33f * (float)_sHeight);
            marginS = realScreenX-_sWidth;
        }

        _tileX = _sWidth /cols;
        _tileY = _sHeight /rows;
    }

    public String get_name() {
        return _name;
    }

    public int get_sceneIndex() {
        return _sceneIndex;
    }
    int loop;
    long pastTime;
    long currentTime;
    String _name;
    int _sceneIndex;
    int [] map;
    int rows;
    int cols;
    float _sHeight;
    float _sWidth;
    float _tileX;
    float _tileY;
    float marginT;
    float marginS;
    static ArrayList<ArrayList<Sprite>> _sprites;
    Logic l;

}*/
