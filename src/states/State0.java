package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.AbstractTransition;
import transition.Transition_01;

public final class State0 extends AbstractState {
	
	private State0(Set<AbstractTransition> anAbstractTransitionSet) {
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
			INSTANCE = State0.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_01());
		return new State0(anAbstractTransitionSet);
	}
}