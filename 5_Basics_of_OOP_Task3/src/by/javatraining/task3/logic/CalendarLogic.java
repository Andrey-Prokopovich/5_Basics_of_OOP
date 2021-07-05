package by.javatraining.task3.logic;

import java.util.List;

import by.javatraining.task3.entity.Calendar;
import by.javatraining.task3.entity.Calendar.Date;
import by.javatraining.task3.exception.InvalidValueException;

/*
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию
 * о выходных и праздничных днях.
 */

public class CalendarLogic {

	private Calendar calendar;

	public CalendarLogic() {
	}

	public void setCalendar(Calendar calendar) {
		if (calendar == null) {
			this.calendar = new Calendar();
		} else {
			this.calendar = calendar;
		}
	}

	public boolean dateCorrect(int day, int month, int year) {
		if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0)
			return false;

		if (month % 2 == 0)
			if ((month == 2 && day > 29) || (month != 2 && day > 30))
				return false;

		return true;
	}

	public void addDayOff(int day, int month, int year, boolean isHoliday) throws InvalidValueException {
		if (dateCorrect(day, month, year)) {
			Date date = calendar.new Date(day, month, year, isHoliday);
			calendar.getDates().add(date);
		} else {
			throw new InvalidValueException("Недопустимое значение даты.");
		}
	}

	public String printDaysOff() {
		List<Date> dates;
		StringBuilder strDates;

		dates = calendar.getDates();
		strDates = new StringBuilder();

		strDates.append("Список выходных дней:\n");
		for (Date date : dates) {
			strDates.append(date.getDay() + "." + date.getMonth() + "." + date.getYear()
					+ (date.isHoliday() ? " - Праздник" : "") + "\n");
		}
		
		return strDates.toString();
	}
}
