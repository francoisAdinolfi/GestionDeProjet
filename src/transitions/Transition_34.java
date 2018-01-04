package transitions;

import context.Context;
import perform.Perform_34;
import satisfiable.Satisfiable_34;
import states.AbstractState;
import states.State4;

public class Transition_34 extends AbstractTransition{
	
	public Transition_34() {
		this.nextState = State4.getInstance();
		this.aSatisfiable = new Satisfiable_34();
		this.aPerformable = new Perform_34();
	}
	
	@Override
	public boolean isFirable(Context context) {
		return this.aSatisfiable.isSatisfied(context);
	}

	@Override
	public AbstractState fire(Context context) {
		aPerformable.perform(context);
		return this.nextState;
	}

}
