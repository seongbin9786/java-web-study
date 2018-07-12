package sb.study;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecificPayday implements PayDay {

	private DayOfWeek payday;
	
	public SpecificPayday(DayOfWeek payday) {
		this.payday = payday;
	}
	
	@Override
	public boolean isPayday() {
		return payday == LocalDate.now().getDayOfWeek();
	}
}
