package kekstar.fdi.nine11_logic;



enum gameState {
    LoadScene,
    IniScene,
    DifScene,
    GameScene,
    EndScene
}
public abstract class GameState {
    abstract void tick();
    void draw()
    {
        screen.draw();
    }
    abstract void init();
    abstract void deinit();

    Screen screen;
}


//El estado de juego, además, tenddrá subestados como "Game", "Grash" (cambiar el sprite por la explosion)
//"Landing".


