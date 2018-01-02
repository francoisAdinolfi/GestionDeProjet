package transition;

import context.Context;
import perform.Perform_12;
import satisfiable.Satisfiable_12;
import states.AbstractState;
import states.State2;

public class Transition_12 extends AbstractTransition{
	
	public Transition_12() {
		this.nextState = State2.getInstance();
		this.aSatisfiable = new Satisfiable_12();
		this.aPerformable = new Perform_12();
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
