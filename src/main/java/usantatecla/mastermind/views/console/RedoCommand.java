package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.MessageView;

public class RedoCommand extends Command {

    public RedoCommand(ProposalController proposalController) {
        super(MessageView.OPTION_REDO.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
       this.proposalController.redo();
       new ProposedCombinationView(this.proposalController).showResult();
    }

    @Override
    protected boolean isActive() {
        return this.proposalController.redoable();
    }
    
}
