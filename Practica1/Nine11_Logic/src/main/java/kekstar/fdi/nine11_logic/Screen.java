package kekstar.fdi.nine11_logic;


import kekstar.fdi.engine.Game;
import kekstar.fdi.engine.Rect;

enum color {
    BLACK (0),
    GREEN(1),
    RED(2),
    PURPLE(3),
    DARKGREEN(4),
    ORANGE(5),
    DARKBLUE(6),
    YELLOW(7),
    PINK(8),
    WHITE(9),
    BLUEGREEN(10),
    LIGHTBLUE(11),
    KHAKI(12),
    LIGHTORANGE(13),
    BLUE(14),
    LIGHTGREEN(15);

    private int value;
    private color(int val){value = val;}
    public int getValue(){
        return value;
    }
}

public  class Screen {
    Game _game;
    Logic _logic;
    int _cols;
    int _rows;
    char[][] grid;
    int[][] _colors;
    int _sWidth;
    int _sHeight;
    int _tileX;
    int _tileY;
    int _marginX;
    int _marginY;


    public Screen(Game game, Logic l) {

        _logic = l;
        _game = game;
        _sHeight = game.getGraphics().getHeight();
        _sWidth = game.getGraphics().getWidth();
        _marginX = 0;
        _marginY = 0;

    }
    public void init (int rows, int cols){
        _rows = rows;
        _cols = cols;

        grid = new char[rows][cols];
        for(int i = 0; i < rows; i++)grid [i] = new char[cols];
        _colors = new int [rows][cols];
        for(int i = 0; i < rows; i++)_colors [i] = new int[cols];

        calculateTileSize();
    }

    public void clear(int color) {
        _game.getGraphics().clear(color);
    }
    //TODO: Metodo que imprime una serie de caracteres comenzando en una posición
    public void print(String toPrint, int xStart, int yStart, color color) {
        //TODO: Comprobar si la cadena de texto es más grande de lo que soporta la pantalla

        int n = 0;
        for (int i = yStart; i < _rows; i++) {
            for (int j = xStart; j < _cols; j++) {
                if(n >= toPrint.length())
                    return;
                else if(toPrint.charAt(n) == '\n'){
                    n++;
                    break;
                }
                grid[i][j] = toPrint.charAt(n);
                _colors[i][j] = color.getValue();
                n++;
            }
        }


    }

    public void draw()
    {

        //_logic.getSprite(2,'A').draw(_game.getGraphics(), new Rect(0,0,16,16));

        for(int i = 0; i < _rows; i++)
        {
            for(int j = 0; j < _cols; j++)
            {
                Rect dest = new Rect (
                        _marginX/2+(j*_tileX),
                        _marginY/2+(i*_tileY),
                        _tileX,
                        _tileY );

                _logic.getSprite(_colors[i][j], grid [i][j]).draw(_game.getGraphics(),dest);
            }
        }
    }

    public void calculateTileSize()
    {
        _sWidth = _game.getGraphics().getWidth();
        _sHeight = _game.getGraphics().getHeight();

        _tileY = _sHeight/_rows;
        _tileX = _sWidth/_cols;
        /*
        _marginX = _sHeight-(_tileX*_cols);
        _marginY = _sHeight -(_tileY*_rows);
*/
        float tileAR = (float)_tileX/(float)_tileY;
        if(tileAR > 1.7f){
            _tileX = (int)(Math.floor((1.7f*_tileY)));
            _marginX = _sWidth-(_tileX*_cols);
        }
        else if (tileAR < 0.8f){
            _tileY = (int)(Math.floor((_tileX/1.f)));
            _marginY = _sHeight -(_tileY*_rows);
        }

    }
    //TODO: Implementar metodo que devuelva el tile pulsado en la pantalla
    public Pair getGridCoords(int pixelX, int pixelY){
        int tempx, tempy;

        tempx = (pixelX - _marginX)/_tileX;
        tempy = (pixelY - _marginY)/_tileY;

        return new Pair(tempx, tempy);
    }

    public int getTileWidth(){
        return _tileX;
    }
    public int get_tileHeight(){
        return _tileY;
    }


};
