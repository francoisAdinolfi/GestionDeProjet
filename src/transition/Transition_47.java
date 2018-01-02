package transition;

import context.Context;
import perform.Perform_47;
import satisfiable.Satisfiable_47;
import states.AbstractState;
import states.State7;

public class Transition_47 extends AbstractTransition{
	
	public Transition_47() {
		this.nextState = State7.getInstance();
		this.aSatisfiable = new Satisfiable_47();
		this.aPerformable = new Perform_47();
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
