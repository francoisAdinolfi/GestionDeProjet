package transitions;

import context.Context;
import perform.Perform_23;
import satisfiable.Satisfiable_23;
import states.AbstractState;
import states.State3;

public class Transition_23 extends AbstractTransition{
	
	public Transition_23() {
		this.nextState = State3.getInstance();
		this.aSatisfiable = new Satisfiable_23();
		this.aPerformable = new Perform_23();
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
