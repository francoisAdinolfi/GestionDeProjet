package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public class State2 extends AbstractState {
	
	private State2(Set<AbstractTransition> anAbstractTransitionSet) {
		this.anAbstractTransitionSet = anAbstractTransitionSet;
	}
	
	// Fire section
	public AbstractState fire(Context context) {
		for(AbstractTransition anAbstractTransition : anAbstractTransitionSet)
			if(anAbstractTransition.isFirable(context))
				return anAbstractTransition.fire(context);
		
		return this;
	}

	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = State2.getState();	
		}
		return INSTANCE;
	}
	
	private static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_211());
		anAbstractTransitionSet.add(new Transition_212());
		anAbstractTransitionSet.add(new Transition_23());
		anAbstractTransitionSet.add(new Transition_27());
		return new State2(anAbstractTransitionSet);
	}
}
