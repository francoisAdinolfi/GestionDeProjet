package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_332 implements Satisfiable<Context>{

	private static final String EVENT_ACK_NAME = "ACK" ;
	private final Event ackEvt = new Event(EVENT_ACK_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(ackEvt);
	}
}
