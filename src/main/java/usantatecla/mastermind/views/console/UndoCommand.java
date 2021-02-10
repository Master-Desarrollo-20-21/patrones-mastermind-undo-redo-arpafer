package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.MessageView;

public class UndoCommand extends Command {

    public UndoCommand(ProposalController proposalController) {
        super(MessageView.OPTION_UNDO.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        this.proposalController.undo();
        new ProposedCombinationView(this.proposalController).showResult();
    }

    @Override
    protected boolean isActive() {
        return this.proposalController.undoable();
    }    
}
