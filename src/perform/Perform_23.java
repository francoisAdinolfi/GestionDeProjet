package perform;

import context.Context;

public class Perform_23 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeMsg();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}