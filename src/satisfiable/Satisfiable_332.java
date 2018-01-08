package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_332 implements Satisfiable<Context>{

	private final Event ackEvt = new Event(Event.EVENT_ACK_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(ackEvt);
	}
}
