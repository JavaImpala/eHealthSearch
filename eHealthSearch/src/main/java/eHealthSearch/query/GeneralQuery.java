package eHealthSearch.query;

import java.util.Optional;

public class GeneralQuery {
	Optional<TimeConstraints> time;
	
	private GeneralQuery(Optional<TimeConstraints> time){
		this.time=time;
	}
	
	public static GeneralQuery get() {
		return new GeneralQuery(Optional.empty());
	}
	
	public static GeneralQuery get(TimeConstraints time) {
		return new GeneralQuery(Optional.of(time));
	}
	
	public Optional<TimeConstraints> getTime(){
		return time;
	}
}