package transitions;

import context.Context;
import perform.Perform_331;
import satisfiable.Satisfiable_331;
import states.AbstractState;
import states.State3;

public class Transition_331 extends AbstractTransition{
	
	public Transition_331() {
		this.nextState = State3.getInstance();
		this.aSatisfiable = new Satisfiable_331();
		this.aPerformable = new Perform_331();
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
