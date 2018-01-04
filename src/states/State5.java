package states;

import java.util.HashSet;
import java.util.Set;

import context.Context;
import transitions.*;

public final class State5 extends AbstractState {
	
	protected static AbstractState INSTANCE = null;
	protected Set<AbstractTransition> anAbstractTransitionSet = new HashSet<AbstractTransition>();
	
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
		this.anAbstractTransitionSet.add(new Transition_51());
		this.anAbstractTransitionSet.add(new Transition_56());
		this.anAbstractTransitionSet.add(new Transition_57());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State5();	
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 5";
	}
}
