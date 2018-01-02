package context;

import event.Event;
import server.TCPServer;
import states.AbstractState;

public class Context {
	private AbstractState currentState;
	private Event lastEvent;
	private TCPServer aTCPServer;
	
	public Context(AbstractState currentState, TCPServer aTCPServer) {
		this.currentState = currentState;
		this.lastEvent = null;
		this.setaTCPServer(aTCPServer);
	}

	public AbstractState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(AbstractState currentState) {
		this.currentState = currentState;
	}

	public Event getLastEvent() {
		return lastEvent;
	}

	public void setLastEvent(Event lastEvent) {
		this.lastEvent = lastEvent;
	}

	public TCPServer getaTCPServer() {
		return aTCPServer;
	}

	public void setaTCPServer(TCPServer aTCPServer) {
		this.aTCPServer = aTCPServer;
	}
}
