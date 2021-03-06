package testsUnitaires;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import context.Context;
import event.Event;
import server.TCPServer;
import transitions.*;

class Transition_Test {

	AbstractTransition transition;
	Context aContext;
	
	@BeforeEach
	public void setUp() {
		transition = new Transition_45();
		aContext = new Context(null, TCPServer.getTCPServer());
	}
	
	@Test
	void testIsFirablePositiveEvent() {
		aContext.setLastEvent(new Event(Event.EVENT_ACK_NAME));
		assertTrue(transition.isFirable(aContext));
	}
	
	@Test
	void testIsFirableNegativeEvent() {
		aContext.setLastEvent(new Event(Event.EVENT_OPEN_NAME));
		assertFalse(transition.isFirable(aContext));
	}
	
	@Test
	void testFire() {
		if(!transition.fire(aContext).toString().equals("State 5"))
			fail();
	}
}

