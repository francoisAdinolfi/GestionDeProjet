package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State1 extends AbstractState {
	
	private State1(Set<AbstractTransition> anAbstractTransitionSet) {
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
			INSTANCE = State1.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_10());
		anAbstractTransitionSet.add(new Transition_12());
		return new State1(anAbstractTransitionSet);
	}
}
