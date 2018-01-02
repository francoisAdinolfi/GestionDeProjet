package perform;

import context.Context;

public class Perform_51 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().writeACK();
		aContext.getaTCPServer().resetAll();
	}

}
