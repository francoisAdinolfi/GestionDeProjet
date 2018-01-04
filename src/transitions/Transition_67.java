package transitions;

import context.Context;
import perform.Perform_67;
import satisfiable.Satisfiable_67;
import states.AbstractState;
import states.State7;

public class Transition_67 extends AbstractTransition{
	
	public Transition_67() {
		this.nextState = State7.getInstance();
		this.aSatisfiable = new Satisfiable_67();
		this.aPerformable = new Perform_67();
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
