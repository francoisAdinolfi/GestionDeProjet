package sequensor;

import context.Context;
import event.Event;
import server.TCPServer;
import states.*;

public final class Sequensor {
	
	private Context context;

	// Constructor section
	public Sequensor(TCPServer aTCPServer) {
		this.context = new Context(State0.getInstance() ,aTCPServer);
	}
	
	// Functional section
	public void tryy(Event e){
		this.context.setLastEvent(e);
		this.context.setCurrentState(this.context.getCurrentState().fire(context));
		this.context.getaTCPServer().aBasicTimer.stop();
	}
	
	
}
