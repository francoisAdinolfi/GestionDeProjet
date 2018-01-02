package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State3 extends AbstractState {
	
	public State3(Set<AbstractTransition> anAbstractTransitionSet) {
		this.anAbstractTransitionSet.addAll(anAbstractTransitionSet);
	}
	
	// Fire section
	public AbstractState fire(Context context) {
		for(AbstractTransition t : anAbstractTransitionSet)
			if(t.isFirable(context))
				return t.fire(context);
		
		return this;
	}

	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = State3.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_31());
		anAbstractTransitionSet.add(new Transition_331());
		anAbstractTransitionSet.add(new Transition_332());
		anAbstractTransitionSet.add(new Transition_34());
		anAbstractTransitionSet.add(new Transition_37());
		return new State3(anAbstractTransitionSet);
	}
}
