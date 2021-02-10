package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.AceptorController;
import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public void interact(AceptorController controller) {
		controller.accept(this);
	}

}
