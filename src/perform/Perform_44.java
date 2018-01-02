package perform;

import context.Context;

public class Perform_44 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeFIN();
		aContext.getaTCPServer().aBasicTimer.start();
	}

}
