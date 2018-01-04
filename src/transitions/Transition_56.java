package transitions;

import context.Context;
import perform.Perform_56;
import satisfiable.Satisfiable_56;
import states.AbstractState;
import states.State6;

public class Transition_56 extends AbstractTransition{
	
	public Transition_56() {
		this.nextState = State6.getInstance();
		this.aSatisfiable = new Satisfiable_56();
		this.aPerformable = new Perform_56();
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
