package transition;

import context.Context;
import perform.Performable;
import satisfiable.Satisfiable;
import states.AbstractState;

public abstract class AbstractTransition {
	protected AbstractState nextState;
	protected Satisfiable<Context> aSatisfiable;
	protected Performable<Context> aPerformable;
	
	public abstract boolean isFirable(Context context);
	public abstract AbstractState fire(Context context);
}
