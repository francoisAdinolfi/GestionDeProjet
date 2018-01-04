package transitions;

import context.Context;
import perform.Perform_612;
import satisfiable.Satisfiable_612;
import states.AbstractState;
import states.State1;

public class Transition_612 extends AbstractTransition{
	
	public Transition_612() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_612();
		this.aPerformable = new Perform_612();
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
