package kekstar.fdi.nine11_logic;

import java.util.List;

import kekstar.fdi.engine.Graphics;
import kekstar.fdi.engine.Rect;

//TODO: Implementar clase escena. Clase genérica de la que heredarán el resto de escenas.
public class Scene {
    public Scene(String name, int sceneIndex, List<Sprite> sprites, int columns, int rowss)
    {
       if(_sprites == null) _sprites = sprites;
       _name = name;
        _sceneIndex = sceneIndex;
       rows = rowss;
       cols = columns;
       map = new int [rows*cols];

       for(int i = 0; i < map.length; i++){
           map[i] = (i%255);
       }

    }
    public void tick()
    {

    }

    public void draw(Graphics g)
    {
        g.clear(0x00000000);

        calculateTileSize(g.getWidth(), g.getHeight());
        int i = 0;
        int j = 0;
        for (int a : map){
            Rect dest = new Rect((i*_tileX)+(marginS), (j*_tileY)+(marginT), _tileX, _tileY);
            _sprites.get(a).draw(g, dest);
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
        marginS = 0;
        marginT= 0;
        float aspectR = (float)_sWidth /(float)_sHeight;

        if(aspectR < 1.33f){
            _sHeight = (int)(_sWidth / 1.33f);
            marginT = realScreenY-_sHeight;
        }
        else if (aspectR > 1.33f){
            _sWidth = (int)(1.33f * (float)_sHeight);
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


    String _name;
    int _sceneIndex;
    int [] map;
    int _sHeight;
    int _sWidth;
    int rows;
    int cols;
    int _tileX;
    int _tileY;
    int marginT;
    int marginS;
    static List<Sprite> _sprites;

}
