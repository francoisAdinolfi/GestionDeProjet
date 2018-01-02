package transition;

import context.Context;
import perform.Perform_70;
import satisfiable.Satisfiable_70;
import states.AbstractState;
import states.State0;

public class Transition_70 extends AbstractTransition{
	
	public Transition_70() {
		this.nextState = State0.getInstance();
		this.aSatisfiable = new Satisfiable_70();
		this.aPerformable = new Perform_70();
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
