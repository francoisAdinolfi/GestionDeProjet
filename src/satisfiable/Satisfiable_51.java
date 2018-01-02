package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_51 implements Satisfiable<Context>{

	private static final String EVENT_END_NAME = "END" ;
	private final Event endEvt = new Event(EVENT_END_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(endEvt);
	}
}
