package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import context.Context;
import event.Event;
import satisfiable.*;

class Satisfiable_Test {

	Satisfiable<Context> satisfiable_01;
	Satisfiable<Context> satisfiable_41;
	Satisfiable<Context> satisfiable_47;
	Context aContext;
	
	@BeforeEach
	public void setUp() {
		satisfiable_01 = new Satisfiable_01();
		satisfiable_41 = new Satisfiable_41();
		satisfiable_47 = new Satisfiable_47();
		aContext = new Context(null, null);
	}
	
	@Test
	void firstSamplePositive() {
		aContext.setLastEvent(new Event("Open"));
		assertTrue(satisfiable_01.isSatisfied(aContext));
	}
	
	@Test
	void firstSampleNegative() {
		aContext.setLastEvent(new Event("Close"));
		assertFalse(satisfiable_01.isSatisfied(aContext));
	}
	
	@Test
	void secondSamplePositive() {
		aContext.setLastEvent(new Event("RST"));
		assertTrue(satisfiable_41.isSatisfied(aContext));
	}
	
	@Test
	void secondSampleNegative() {
		aContext.setLastEvent(new Event("Close"));
		assertFalse(satisfiable_41.isSatisfied(aContext));
	}
	
	@Test
	void thirdSamplePositive() {
		aContext.setLastEvent(new Event("Abort"));
		assertTrue(satisfiable_47.isSatisfied(aContext));
	}
	
	@Test
	void thirdSampleNegative() {
		aContext.setLastEvent(new Event("Close"));
		assertFalse(satisfiable_47.isSatisfied(aContext));
	}
}
