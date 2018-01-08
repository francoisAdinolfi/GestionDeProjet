package states;

import context.Context;
import transitions.AbstractTransition;
import transitions.Transition_31;
import transitions.Transition_331;
import transitions.Transition_332;
import transitions.Transition_34;
import transitions.Transition_37;

public final class State3 extends AbstractState {
	
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
