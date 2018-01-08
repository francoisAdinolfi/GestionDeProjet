package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_37 implements Satisfiable<Context>{

	private final Event abortEvt = new Event(Event.EVENT_ABORT_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(abortEvt);
	}
}
