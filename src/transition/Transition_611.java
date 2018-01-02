package transition;

import context.Context;
import perform.Perform_611;
import satisfiable.Satisfiable_611;
import states.AbstractState;
import states.State1;

public class Transition_611 extends AbstractTransition{
	
	public Transition_611() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_611();
		this.aPerformable = new Perform_611();
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
