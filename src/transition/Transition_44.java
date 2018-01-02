package transition;

import context.Context;
import perform.Perform_44;
import satisfiable.Satisfiable_44;
import states.AbstractState;
import states.State4;

public class Transition_44 extends AbstractTransition{
	
	public Transition_44() {
		this.nextState = State4.getInstance();
		this.aSatisfiable = new Satisfiable_44();
		this.aPerformable = new Perform_44();
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
