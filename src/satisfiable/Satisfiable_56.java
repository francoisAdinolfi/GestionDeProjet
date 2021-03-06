package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_56 implements Satisfiable<Context>{

	private final Event toEvt = new Event(Event.EVENT_TO_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(toEvt);
	}
}
