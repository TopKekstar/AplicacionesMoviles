package kekstar.fdi.nine11_logic;
import kekstar.fdi.engine.Game;

public class DificultyState extends GameState {

    public DificultyState(Game g, Logic logic){
        this._game = g;
        this._logic = logic;
    }


    @Override
    void tick() {
        pollEvents();

    }

    @Override
    void init() {
        screen = new Screen(_game, _logic);
        screen.init(25,45);
        
        screen.print("Elija un nivel: 0 (AS) - 5 (principiante)", 0, (screen.get_rows()/2)-1, color.RED);

    }

    @Override
    void deinit() {

    }

    @Override
    void pollEvents() {

    }
}
