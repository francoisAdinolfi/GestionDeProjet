package perform;

import context.Context;
import event.Event;

public class Perform_57 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeRST();
		aContext.getaTCPServer().addEventInEventSet(new Event("NoEvt"));
	}

}
