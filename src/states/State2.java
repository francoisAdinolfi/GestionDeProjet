package states;

import context.Context;
import transition.*;

public class State2 extends AbstractState {
	
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
		this.anAbstractTransitionSet.add(new Transition_211());
		this.anAbstractTransitionSet.add(new Transition_212());
		this.anAbstractTransitionSet.add(new Transition_23());
		this.anAbstractTransitionSet.add(new Transition_27());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State2();	
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 2";
	}
}
