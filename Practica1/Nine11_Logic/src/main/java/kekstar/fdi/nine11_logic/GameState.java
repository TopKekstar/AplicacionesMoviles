package kekstar.fdi.nine11_logic;


import kekstar.fdi.engine.Game;

public abstract class GameState {
    abstract void tick();
    void draw()
    {
        screen.clear(0x00000000);
        screen.draw();
    }
    abstract void init();
    abstract void deinit();
    abstract void pollEvents();

    Screen screen;
    Game _game;
    Logic _logic;
}


//El estado de juego, además, tenddrá subestados como "Game", "Grash" (cambiar el sprite por la explosion)
//"Landing".


