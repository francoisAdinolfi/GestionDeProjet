package transitions;

import context.Context;
import perform.Perform_37;
import satisfiable.Satisfiable_37;
import states.AbstractState;
import states.State7;

public class Transition_37 extends AbstractTransition{
	
	public Transition_37() {
		this.nextState = State7.getInstance();
		this.aSatisfiable = new Satisfiable_37();
		this.aPerformable = new Perform_37();
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
