package transitions;

import context.Context;
import perform.Perform_10;
import satisfiable.Satisfiable_10;
import states.AbstractState;
import states.State0;

public class Transition_10 extends AbstractTransition{
	
	public Transition_10() {
		this.nextState = State0.getInstance();
		this.aSatisfiable = new Satisfiable_10();
		this.aPerformable = new Perform_10();
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
