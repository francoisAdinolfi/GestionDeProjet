package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transitions.AbstractTransition;
import transitions.Transition_01;

public final class State0 extends AbstractState {
	
	protected static AbstractState INSTANCE = null;
	protected Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
	
	// Fire section
	public AbstractState fire(Context context) {
		if(this.anAbstractTransitionSet.isEmpty())
			addTransitions();
		for(AbstractTransition t : anAbstractTransitionSet)
			if(t.isFirable(context))
				return t.fire(context);
		
		return this;
	}

	private void addTransitions() {
		this.anAbstractTransitionSet.add(new Transition_01());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State0();
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 0";
	}
}