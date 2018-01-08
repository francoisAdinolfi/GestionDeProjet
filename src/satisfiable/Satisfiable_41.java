package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_41 implements Satisfiable<Context>{

	private final Event rstEvt = new Event(Event.EVENT_RST_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(rstEvt);
	}
}
