package testsUnitaires;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import context.Context;
import perform.*;
import server.TCPServer;

class Perform_Test {

	Performable<Context> perform_01;
	Context aContext;
	
	@BeforeEach
	public void setUp() {
		perform_01 = new Perform_01();
		aContext = new Context(null, TCPServer.getTCPServer());
	}
	
	@Test
	void test() {
		perform_01.perform(aContext);
	}

}

