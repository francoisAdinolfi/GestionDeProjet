package states;

import context.Context;
import transition.AbstractTransition;
import transition.Transition_01;

public final class State0 extends AbstractState {
	
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