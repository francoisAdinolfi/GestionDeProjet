package testsUnitaires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import context.Context;
import perform.*;
import server.TCPServer;

class Perform_Test {

	Performable<Context> perform_34;
	Context aContext;
	
	@BeforeEach
	public void setUp() {
		perform_34 = new Perform_34();
		aContext = new Context(null, TCPServer.getTCPServer());
		aContext.getaTCPServer().aBasicTimer.start();
		System.out.println("début du test");
	}
	
	@Test
	void test() {
		perform_34.perform(aContext);
	}

}

