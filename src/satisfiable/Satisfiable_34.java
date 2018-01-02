package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_34 implements Satisfiable<Context>{

	private static final String EVENT_CLOSE_NAME = "Close" ;
	private final Event closeEvt = new Event(EVENT_CLOSE_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(closeEvt);
	}
}
