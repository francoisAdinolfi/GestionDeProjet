package event;

public class Event {
	public String name;
	
	//liste des constantes de nom pour les events
	public static final String EVENT_OPEN_NAME = "Open" ;
	public static final String EVENT_CLOSE_NAME = "Close" ;
	public static final String EVENT_ABORT_NAME = "Abort" ;
	public static final String EVENT_RST_NAME = "RST" ;
	public static final String EVENT_TO_NAME = "TimeOver" ;
	public static final String EVENT_END_NAME = "END" ;
	public static final String EVENT_ACK_NAME = "ACK" ;
	public static final String EVENT_SYN_NAME = "SYN" ;
	
	public Event(String name) {
		this.name = name;
	}
	
	public boolean is(Event e) {
		if(this.name.compareTo(e.name) == 0)
			return true;
		return false;
	}
}
