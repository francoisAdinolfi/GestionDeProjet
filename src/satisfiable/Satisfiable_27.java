package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_27 implements Satisfiable<Context>{

	private static final String EVENT_ABORT_NAME = "Abort" ;
	private final Event abortEvt = new Event(EVENT_ABORT_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(abortEvt);
	}
}
