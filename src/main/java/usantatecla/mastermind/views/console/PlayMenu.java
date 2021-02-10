package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(ProposalController proposalController) {
        
        this.addCommand(new PlayCommand(proposalController));
        this.addCommand(new UndoCommand(proposalController));
        this.addCommand(new RedoCommand(proposalController));
    }    
}
