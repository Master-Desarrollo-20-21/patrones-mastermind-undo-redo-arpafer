package usantatecla.mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.console.ColorView;
import usantatecla.utils.WithConsoleView;
import usantatecla.mastermind.views.MessageView;

class ProposedCombinationView extends WithConsoleView {

    private ProposalController proposalController;

    ProposedCombinationView(ProposalController proposalController) {
        this.proposalController = proposalController;
    }

    void write(int position) {
        for (Color color : this.proposalController.getColors(position)) {
            new ColorView(color).write();
        }
    }

    List<Color> read() {
        String message = MessageView.PROPOSED_COMBINATION.getMessage();
        String characters = this.console.readString(message);
        List<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < characters.length(); i++) {
            colors.add(ColorView.getInstance(characters.charAt(i)));
        }
        return colors;
    }

    void showResult() {
        console.writeln();
        new AttemptsView(this.proposalController).writeln();
        new SecretCombinationView(proposalController).writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController).write(i);
            new ResultView(proposalController).writeln(i);
        }
        if (proposalController.isWinner()) {
            console.writeln(MessageView.WINNER.getMessage());
        } else if (proposalController.isLooser()) {
            console.writeln(MessageView.LOOSER.getMessage());
        }
    }
}
