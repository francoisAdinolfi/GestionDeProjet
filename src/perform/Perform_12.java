package perform;

import context.Context;

public class Perform_12 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeSYNACK();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
