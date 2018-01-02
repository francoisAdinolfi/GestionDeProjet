package perform;

import context.Context;

public class Perform_56 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
