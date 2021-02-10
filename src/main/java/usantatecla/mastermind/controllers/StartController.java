package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class StartController extends Controller implements AceptorController {

	public StartController(Session session) {
		super(session);
	}
	
	public void start() {
		this.session.nextState();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
