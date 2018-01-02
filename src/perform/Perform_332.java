package perform;

import context.Context;

public class Perform_332 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().inc_I();
		aContext.getaTCPServer().writeMsg();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
