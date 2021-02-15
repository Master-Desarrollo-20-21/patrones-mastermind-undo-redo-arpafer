package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(ProposalController proposalController) {
        Console console = new Console();
        console.writeln(MessageView.MENU_OPTIONS.getMessage());
        this.addCommand(new PlayCommand(proposalController));
        this.addCommand(new UndoCommand(proposalController));
        this.addCommand(new RedoCommand(proposalController));
        console.writeln();
    }    
}
