package states;

import context.Context;
import transition.*;

public final class State3 extends AbstractState {
	
	// Fire section
	public AbstractState fire(Context context) {
		if(this.anAbstractTransitionSet.isEmpty())
			addTransitions();
		for(AbstractTransition t : anAbstractTransitionSet)
			if(t.isFirable(context))
				return t.fire(context);
		
		return this;
	}

	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State3();	
		}
		return INSTANCE;
	}
	
	public void addTransitions() {
		this.anAbstractTransitionSet.add(new Transition_31());
		this.anAbstractTransitionSet.add(new Transition_331());
		this.anAbstractTransitionSet.add(new Transition_332());
		this.anAbstractTransitionSet.add(new Transition_34());
		this.anAbstractTransitionSet.add(new Transition_37());
	}
	
	public String toString() {
		return "State 3";
	}
}
