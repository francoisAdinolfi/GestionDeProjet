package perform;

import context.Context;

public class Perform_10 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().resetAll();
	}

}
