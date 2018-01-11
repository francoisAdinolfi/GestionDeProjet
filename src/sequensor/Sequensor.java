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
		System.out.println("Etat de départ : " + aContext.getCurrentState().toString());
		System.out.println("Event : " + e.name);
		this.aContext.setLastEvent(e);
		this.aContext.setCurrentState(this.aContext.getCurrentState().fire(aContext));
		System.out.println("Etat d'arrivé : " + aContext.getCurrentState().toString() + "\n");
	}
	
	public static Sequensor getSequensor(TCPServer aTCPServer) {
		if(aTCPServer != null)
			return new Sequensor(aTCPServer);
		return null;
	}
}
