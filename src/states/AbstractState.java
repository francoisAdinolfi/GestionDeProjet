package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transitions.AbstractTransition;

public abstract class AbstractState {
	
	protected Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
	
	public abstract AbstractState fire(Context context);
}