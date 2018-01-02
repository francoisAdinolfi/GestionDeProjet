package states;

import context.Context;
import transition.*;

public final class State6 extends AbstractState {
	
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