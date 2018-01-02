package states;

import context.Context;
import transition.*;

public final class State7 extends AbstractState {
	
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
