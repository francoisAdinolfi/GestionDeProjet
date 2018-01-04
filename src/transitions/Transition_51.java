package transitions;

import context.Context;
import perform.Perform_51;
import satisfiable.Satisfiable_51;
import states.AbstractState;
import states.State1;

public class Transition_51 extends AbstractTransition{
	
	public Transition_51() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_51();
		this.aPerformable = new Perform_51();
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
