package states;

import context.Context;
import transition.*;

public final class State4 extends AbstractState {
	
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