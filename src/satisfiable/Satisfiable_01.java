package satisfiable;

import context.Context;
import event.Event;

public class Satisfiable_01 implements Satisfiable<Context>{

	private final Event openEvt = new Event(Event.EVENT_OPEN_NAME);
	
	@Override
	public boolean isSatisfied(Context aContext) {
		return aContext.getLastEvent().is(openEvt);
	}
}
