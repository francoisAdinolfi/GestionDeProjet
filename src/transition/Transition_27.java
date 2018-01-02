package transition;

import context.Context;
import perform.Perform_27;
import satisfiable.Satisfiable_27;
import states.AbstractState;
import states.State7;

public class Transition_27 extends AbstractTransition{
	
	public Transition_27() {
		this.nextState = State7.getInstance();
		this.aSatisfiable = new Satisfiable_27();
		this.aPerformable = new Perform_27();
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
