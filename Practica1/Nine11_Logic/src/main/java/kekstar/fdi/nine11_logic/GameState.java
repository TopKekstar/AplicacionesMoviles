package kekstar.fdi.nine11_logic;


public abstract class GameState {
    abstract void tick();
    void draw()
    {
        screen.clear(0x00000000);
        screen.draw();
    }
    abstract void init();
    abstract void deinit();

    Screen screen;
}


//El estado de juego, además, tenddrá subestados como "Game", "Grash" (cambiar el sprite por la explosion)
//"Landing".


