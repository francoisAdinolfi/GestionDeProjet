package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_01 implements Satisfiable<Context>{

	private static final String EVENT_OPEN_NAME = "Open" ;
	private final Event openEvt = new Event(EVENT_OPEN_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(openEvt);
	}
}
