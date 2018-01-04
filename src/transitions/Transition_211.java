package transitions;

import context.Context;
import perform.Perform_211;
import satisfiable.Satisfiable_211;
import states.AbstractState;
import states.State1;

public class Transition_211 extends AbstractTransition{
	
	public Transition_211() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_211();
		this.aPerformable = new Perform_211();
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
