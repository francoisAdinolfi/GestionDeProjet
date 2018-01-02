package perform;

import context.Context;

public class Perform_34 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeFIN();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
