package kekstar.fdi.nine11_logic;

import kekstar.fdi.engine.Game;

public class InstructionsState implements GameState{
    char [][] grid;
    int [][] color;
    Game game;

    @Override
    public void tick() {

    }

    @Override
    public void draw() {
        for(int i = 0; i < 25; ++i){
            for(int j = 0; i < 25; j++)
            {

            }
        }

    }

    @Override
    public void init() {

        String instrucciones = "Usted esta conduciendo bla bla bla";
        grid = new char [25][40];

        //Copiamos de color a
    }

    @Override
    public void deinit() {

    }

}
