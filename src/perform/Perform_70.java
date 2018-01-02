package perform;

import context.Context;

public class Perform_70 implements Performable<Context> {

	@Override
	public void perform(Context aContext) {
		aContext.getaTCPServer().resetAll();
	}

}
