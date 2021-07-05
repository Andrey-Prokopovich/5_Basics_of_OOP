package by.javatraining.task3.main;

import by.javatraining.task3.exception.InvalidValueException;
import by.javatraining.task3.logic.CalendarLogic;

/*
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию
 * о выходных и праздничных днях.
 */

public class Main {

	public static void main(String[] args) {
		CalendarLogic calendarLogic = new CalendarLogic();

		calendarLogic.setCalendar(null);

		try {
			calendarLogic.addDayOff(25, 12, 1991, true);
			calendarLogic.addDayOff(7, 4, 1978, true);
			calendarLogic.addDayOff(11, 9, 2000, false);
			calendarLogic.addDayOff(19, 7, 2011, false);
			calendarLogic.addDayOff(4, 6, 2020, false);
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(calendarLogic.printDaysOff());
	}
}
