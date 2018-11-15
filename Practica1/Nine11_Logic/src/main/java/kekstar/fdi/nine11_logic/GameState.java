package kekstar.fdi.nine11_logic;



public interface GameState {
    void tick();
    void draw();
    void init();
    void deinit();

}


//El estado de juego, además, tenddrá subestados como "Game", "Grash" (cambiar el sprite por la explosion)
//"Landing".


