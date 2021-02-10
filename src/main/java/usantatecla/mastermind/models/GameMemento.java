package usantatecla.mastermind.models;

import java.util.List;

public class GameMemento {

    private int attempts;
    private ProposedCombination proposedCombination;

    public GameMemento(int attempts, ProposedCombination proposedCombination) {
        this.attempts = attempts;
        this.proposedCombination = new ProposedCombination();
        this.proposedCombination.copy(proposedCombination);
    }
    
    public int getAttempts() {
        return this.attempts;
    }
    
    public ProposedCombination getProposedCombination() {
        return this.proposedCombination;
    }
}
