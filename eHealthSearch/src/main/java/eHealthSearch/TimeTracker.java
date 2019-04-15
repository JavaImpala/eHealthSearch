package eHealthSearch;

public class TimeTracker {
	private final long startTime;
	private long last;
	private int counter=0;
	
	public TimeTracker() {
		this.startTime=System.currentTimeMillis();
		this.last=startTime;
	}
	
	public void time(String identifier) {
		long currentTime=System.currentTimeMillis();
		double timeSinceLast=currentTime-last;
		this.last=currentTime;
		
		
		System.out.println(identifier+" : millisec siden forrige gang:"+timeSinceLast+" : millisec fra start"+(last-startTime));
	}
	
	public void time() {
		time(Integer.valueOf(counter++).toString());
	}
	
	
}
