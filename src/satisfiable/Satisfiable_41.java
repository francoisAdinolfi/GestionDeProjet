package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_41 implements Satisfiable<Context>{

	private static final String EVENT_RST_NAME = "RST" ;
	private final Event rstEvt = new Event(EVENT_RST_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(rstEvt);
	}
}
