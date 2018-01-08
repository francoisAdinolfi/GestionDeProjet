package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_611 implements Satisfiable<Context>{

	private final Event endEvt = new Event(Event.EVENT_END_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(endEvt);
	}
}
