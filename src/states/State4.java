package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transition.*;

public final class State4 extends AbstractState {

	public State4(Set<AbstractTransition> anAbstractTransitionSet) {
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
			INSTANCE = State4.getState();	
		}
		return INSTANCE;
	}
	
	public static AbstractState getState() {
		final Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
		anAbstractTransitionSet.add(new Transition_41());
		anAbstractTransitionSet.add(new Transition_44());
		anAbstractTransitionSet.add(new Transition_45());
		anAbstractTransitionSet.add(new Transition_47());
		return new State4(anAbstractTransitionSet);
	}
}