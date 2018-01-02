package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State6 extends AbstractState {
	
	public State6(Set<AbstractTransition> anAbstractTransitionSet) {
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
			INSTANCE = State6.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_611());
		anAbstractTransitionSet.add(new Transition_612());
		anAbstractTransitionSet.add(new Transition_67());
		return new State6(anAbstractTransitionSet);
	}
}