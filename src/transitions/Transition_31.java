package transitions;

import context.Context;
import perform.Perform_31;
import satisfiable.Satisfiable_31;
import states.AbstractState;
import states.State1;

public class Transition_31 extends AbstractTransition{
	
	public Transition_31() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_31();
		this.aPerformable = new Perform_31();
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
