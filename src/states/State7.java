package states;

import context.Context;
import transitions.AbstractTransition;
import transitions.Transition_70;

public final class State7 extends AbstractState {
	
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
		anAbstractTransitionSet.add(new Transition_70());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State7();	
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 7";
	}
}
