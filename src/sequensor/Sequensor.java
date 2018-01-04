package sequensor;

import context.Context;
import event.Event;
import server.TCPServer;
import states.*;

public final class Sequensor {
	
	private Context aContext;

	// Constructor section
	public Sequensor(TCPServer aTCPServer) {
		this.aContext = new Context(State0.getInstance() ,aTCPServer);
	}
	
	// Functional section
	public void tryy(Event e){
		System.out.println(aContext.getCurrentState().toString());
		this.aContext.setLastEvent(e);
		this.aContext.setCurrentState(this.aContext.getCurrentState().fire(aContext));
		System.out.println(aContext.getCurrentState().toString());
		//this.aContext.getaTCPServer().aBasicTimer.stop();
	}
	
	public static Sequensor getSequensor(TCPServer aTCPServer) {
		return new Sequensor(aTCPServer);
	}
}
