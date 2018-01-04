package transitions;

import context.Context;
import perform.Perform_332;
import satisfiable.Satisfiable_332;
import states.AbstractState;
import states.State3;

public class Transition_332 extends AbstractTransition{
	
	public Transition_332() {
		this.nextState = State3.getInstance();
		this.aSatisfiable = new Satisfiable_332();
		this.aPerformable = new Perform_332();
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
