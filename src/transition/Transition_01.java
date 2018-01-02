package transition;

import context.Context;
import perform.Perform_01;
import satisfiable.Satisfiable_01;
import states.AbstractState;
import states.State1;

public class Transition_01 extends AbstractTransition{
	
	public Transition_01() {
		this.nextState = State1.getInstance();
		this.aSatisfiable = new Satisfiable_01();
		this.aPerformable = new Perform_01();
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
