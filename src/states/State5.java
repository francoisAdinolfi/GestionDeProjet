package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State5 extends AbstractState {
	
	public State5(Set<AbstractTransition> anAbstractTransitionSet) {
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
			INSTANCE = State5.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_51());
		anAbstractTransitionSet.add(new Transition_56());
		anAbstractTransitionSet.add(new Transition_57());
		return new State5(anAbstractTransitionSet);
	}
}
