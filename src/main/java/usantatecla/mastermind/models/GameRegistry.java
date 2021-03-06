package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private List<GameMemento> mementos;
    private Game game;
    private int firstPrevious;

    public GameRegistry(Game game) {
        this.game = game;
        this.clear();                
    }

    public void clear() {
        this.mementos = new ArrayList<GameMemento>();
        this.firstPrevious = 0;            
    }

    void register() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.mementos.remove(0);
            this.firstPrevious--;
        }
        this.mementos.add(this.firstPrevious, this.game.createMemento());       
    }

    void undo() {                        
        this.firstPrevious++;
        this.game.set(this.mementos.get(this.firstPrevious));                        
    }

    boolean isUndoable() {
        return this.firstPrevious <= this.mementos.size() - 1;
    }

    void redo() {
        this.firstPrevious--;
        this.game.set(this.mementos.get(this.firstPrevious));
    }

    boolean isRedoable() {
        return this.firstPrevious >= 1;
    }
}
