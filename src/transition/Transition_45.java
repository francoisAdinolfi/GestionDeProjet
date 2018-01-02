package transition;

import context.Context;
import perform.Perform_45;
import satisfiable.Satisfiable_45;
import states.AbstractState;
import states.State5;

public class Transition_45 extends AbstractTransition{
	
	public Transition_45() {
		this.nextState = State5.getInstance();
		this.aSatisfiable = new Satisfiable_45();
		this.aPerformable = new Perform_45();
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
