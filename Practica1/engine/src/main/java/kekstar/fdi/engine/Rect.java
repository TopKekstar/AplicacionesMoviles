package kekstar.fdi.engine;

public class Rect {
    public Rect(int _x, int _y, int _width, int _height) {
        this._x = _x;
        this._y = _y;
        this._width = _width;
        this._height = _height;
    }


    public int get_width() {
        return _width;
    }

    public void set_width(int _width) {
        this._width = _width;
    }
    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public int get_height() {
        return _height;
    }

    public void set_height(int _height) {
        this._height = _height;
    }
    int _x;
    int _y;
    int _width;
    int _height;
}
