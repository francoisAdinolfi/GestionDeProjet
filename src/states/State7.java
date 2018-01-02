package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State7 extends AbstractState {
	
	public State7(Set<AbstractTransition> anAbstractTransitionSet) {
		this.anAbstractTransitionSet = anAbstractTransitionSet;
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
			INSTANCE = State7.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_70());
		return new State7(anAbstractTransitionSet);
	}
}
