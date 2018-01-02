package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_12 implements Satisfiable<Context>{

	private static final String EVENT_SYN_NAME = "SYN" ;
	private final Event synEvt = new Event(EVENT_SYN_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(synEvt);
	}
}
