package org.ntnu.torbjoto.eHealthSearch.query;

import java.time.LocalDate;

public class TimeConstraints {
	private final LocalDate start,stop;

	private TimeConstraints(LocalDate start, LocalDate stop) {
		this.start = start;
		this.stop = stop;
	}
	
	public static TimeConstraints get() {
		return new TimeConstraints(
				LocalDate.now(),
				LocalDate.now().minusMonths(1));
	}
	
	public static TimeConstraints get(LocalDate start, LocalDate stop) {
		return new TimeConstraints(
				start,
				stop);
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getStop() {
		return stop;
	}
}
