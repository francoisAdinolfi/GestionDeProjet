package states;

import context.Context;
import transitions.AbstractTransition;
import transitions.Transition_41;
import transitions.Transition_44;
import transitions.Transition_45;
import transitions.Transition_47;

public final class State4 extends AbstractState {
	
	private static AbstractState INSTANCE = null;
	
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
		this.anAbstractTransitionSet.add(new Transition_41());
		this.anAbstractTransitionSet.add(new Transition_44());
		this.anAbstractTransitionSet.add(new Transition_45());
		this.anAbstractTransitionSet.add(new Transition_47());
	}
	
	public static AbstractState getInstance() {
		if (INSTANCE == null){
			INSTANCE = new State4();	
		}
		return INSTANCE;
	}
	
	public String toString() {
		return "State 4";
	}
}