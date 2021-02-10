package usantatecla.mastermind.views.console;

import java.util.List;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;

public class PlayCommand extends Command {

    public PlayCommand(ProposalController proposalController) {
        super(MessageView.OPTION_PROPOSE_COMBINATION.getMessage(), proposalController);
    }

    @Override
    protected void execute() {
        Console console = new Console();
        usantatecla.mastermind.types.Error error;        
        do {
            List<Color> colors = new ProposedCombinationView(this.proposalController).read();
            error = this.proposalController.addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        new ProposedCombinationView(this.proposalController).showResult();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
