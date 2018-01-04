package transitions;

import context.Context;
import perform.Perform_212;
import satisfiable.Satisfiable_212;
import states.AbstractState;
import states.State1;

public class Transition_212 extends AbstractTransition{
	
	public Transition_212() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_212();
		this.aPerformable = new Perform_212();
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
