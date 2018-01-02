package perform;

import context.Context;

public class Perform_611 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeACK();
		aContext.getaTCPServer().resetAll();
	}

}
