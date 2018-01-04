package transitions;

import context.Context;
import perform.Perform_57;
import satisfiable.Satisfiable_57;
import states.AbstractState;
import states.State7;

public class Transition_57 extends AbstractTransition{
	
	public Transition_57() {
		this.nextState = State7.getInstance();
		this.aSatisfiable = new Satisfiable_57();
		this.aPerformable = new Perform_57();
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
