package transitions;

import context.Context;
import perform.Perform_41;
import satisfiable.Satisfiable_41;
import states.AbstractState;
import states.State1;

public class Transition_41 extends AbstractTransition{
	
	public Transition_41() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_41();
		this.aPerformable = new Perform_41();
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
