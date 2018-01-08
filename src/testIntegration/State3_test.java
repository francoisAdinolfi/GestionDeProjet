package testIntegration;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;

import context.Context;
import event.Event;
import server.TCPServer;
import states.AbstractState;
import states.State3;

public class State3_test {
	private AbstractState currentState;
	private Event anEvent;
	private Context aContext;
	
	@BeforeEach
	public void setUp() {
		currentState = State3.getInstance();
		aContext = new Context(currentState, TCPServer.getTCPServer());
		aContext.getaTCPServer().aBasicTimer.start();
		System.out.println("");
		System.out.println("______________________");
		System.out.println("");
	}
	
	@AfterEach
	public void endIt() {
		aContext.getaTCPServer().aBasicTimer.stop();
	}
	
	//test transition 31
	//event : EVENT_RST_NAME
	@Test
	public void firstPositiveEvent() {
		System.out.println("debut event rst 31");
		//anEvent = new Event(EVENT_RST_NAME);
		anEvent = new Event("RST");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 1"));
		System.out.println("fin event rst 31");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test transition 331
	//event : EVENT_TO_NAME
	@Test
	public void secondPositiveEvent() {
		System.out.println("debut event timeOver 331");
		//anEvent = new Event(EVENT_TO_NAME);
		anEvent = new Event("TimeOver");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin event timeOver 331");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test transition 332
	//event : EVENT_ACK_NAME
	@Test
	public void thirdPositiveEvent() {
		System.out.println("debut event ack 332");
		//anEvent = new Event(EVENT_ACK_NAME);
		anEvent = new Event("ACK");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin event ack 332");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test transition 34
	//event : EVENT_CLOSE_NAME
	@Test
	public void fourthPositiveEvent() {
		System.out.println("debut event close 34");
		//anEvent = new Event(EVENT_CLOSE_NAME);
		anEvent = new Event("Close");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 4"));
		System.out.println("fin event close 34");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test transition 37
	//event : EVENT_ABORT_NAME
	@Test
	public void fifthPositiveEvent() {
		System.out.println("debut event abort 37");
		//anEvent = new Event(EVENT_ABORT_NAME);
		anEvent = new Event("Abort");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 7"));
		System.out.println("fin event abort 37");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test negative event EVENT_OPEN_NAME 
	@Test
	public void firstNegativeEvent() {
		System.out.println("debut event open");
		//anEvent = new Event(EVENT_OPEN_NAME);
		anEvent = new Event("Open");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin event open");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test negative event EVENT_SYN_NAME 
	@Test
	public void secondNegativeEvent() {
		System.out.println("debut event syn");
		//anEvent = new Event(EVENT_SYN_NAME);
		anEvent = new Event("SYN");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin event syn");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
		
	//test negative event EVENT_END_NAME
	@Test
	public void thirdNegativeEvent() {
		System.out.println("debut event end");
		//anEvent = new Event(EVENT_END_NAME);
		anEvent = new Event("END");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin event end");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
	
	//test negative event "NoEvent"
	@Test
	public void fourthNegativeEvent() {
		System.out.println("debut noEvent");
		anEvent = new Event("NoEvent");
		aContext.setLastEvent(anEvent);
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		assertTrue(aContext.getLastEvent().is(anEvent));
		
		aContext.setCurrentState(currentState.fire(aContext));
		
		assertTrue(aContext.getCurrentState().toString().equals("State 3"));
		System.out.println("fin noEvent");
		System.out.println("");
		System.out.println("==================");
		System.out.println("");
	}
}
