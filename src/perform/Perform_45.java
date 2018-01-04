package perform;

import context.Context;

public class Perform_45 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().aBasicTimer.stop();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
