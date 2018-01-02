package states;

import context.Context;
import transition.*;

public final class State1 extends AbstractState {
	
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
		this.anAbstractTransitionSet.add(new Transition_10());
		this.anAbstractTransitionSet.add(new Transition_12());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State1();
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 1";
	}
}
