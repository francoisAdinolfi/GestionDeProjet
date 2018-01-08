package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_12 implements Satisfiable<Context>{

	private final Event synEvt = new Event(Event.EVENT_SYN_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(synEvt);
	}
}
