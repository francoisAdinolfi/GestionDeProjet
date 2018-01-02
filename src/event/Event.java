package event;

public class Event {
	public String name;
	
	public Event(String name) {
		this.name = name;
	}
	
	public boolean is(Event e) {
		if(this.name.compareTo(e.name) == 0)
			return true;
		return false;
	}
}
