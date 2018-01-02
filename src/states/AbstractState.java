package states;

import java.util.Set;

import context.Context;
import transition.AbstractTransition;

public abstract class AbstractState {
	
	protected static AbstractState INSTANCE = null;
	protected Set<AbstractTransition> anAbstractTransitionSet;
	
	public abstract AbstractState fire(Context context);
}