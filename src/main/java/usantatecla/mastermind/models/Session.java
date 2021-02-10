package usantatecla.mastermind.models;

import java.util.List;
import usantatecla.mastermind.types.Color;

public class Session {
    private Game game;
    private State state;
    private GameRegistry registry;
    
    public Session() {
        this.game = new Game();
        this.state = new State();
        this.registry = new GameRegistry(this.game);
    }
    
    public void undo() {
        this.registry.undo();
    }
    
    public boolean undoable() {
        return this.registry.isUndoable();
    }
    
    public void redo() {
        this.registry.redo();
    }
    
    public boolean redoable() {
        return this.registry.isRedoable();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public int getGameWidth() {
        return this.game.getWidth();
    }

    public void nextState() {
        this.state.next();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
        this.registry.register();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public void clearGame() {
        this.game.clear();
        this.registry.clear();
    }

    public void resetState() {
        this.state.reset();
        this.registry.register();
    }
}
