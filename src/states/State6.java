package states;

import context.Context;
import transitions.AbstractTransition;
import transitions.Transition_611;
import transitions.Transition_612;
import transitions.Transition_67;

public final class State6 extends AbstractState {
	
	private static AbstractState INSTANCE = null;
	
	// Fire section
	public AbstractState fire(Context context) {
		if(this.anAbstractTransitionSet.isEmpty())
			addTransitions();
		for(AbstractTransition t : anAbstractTransitionSet)
			if(t.isFirable(context))
				return t.fire(context);
		
		return this;
	}

	public void addTransitions() {
		this.anAbstractTransitionSet.add(new Transition_611());
		this.anAbstractTransitionSet.add(new Transition_612());
		this.anAbstractTransitionSet.add(new Transition_67());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State6();	
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 6";
	}
}