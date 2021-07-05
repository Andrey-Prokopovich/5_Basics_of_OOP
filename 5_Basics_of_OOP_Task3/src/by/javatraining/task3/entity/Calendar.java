package by.javatraining.task3.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию
 * о выходных и праздничных днях.
 */

public class Calendar implements Serializable {

	private static final long serialVersionUID = -4986436132674089086L;

	private List<Date> dates;

	public Calendar() {
		dates = new LinkedList<Date>();
	}

	public class Date implements Serializable {

		private static final long serialVersionUID = 1193321444922618861L;

		private int day;
		private int month;
		private int year;
		private boolean isHoliday;

		public Date() {
		}

		public Date(int day, int month, int year) {
			setDay(day);
			setMonth(month);
			setYear(year);
		}

		public Date(int day, int month, int year, boolean isHoliday) {
			setDay(day);
			setMonth(month);
			setYear(year);
			setHoliday(isHoliday);
		}

		public int getDay() {
			return day;
		}

		public int getMonth() {
			return month;
		}

		public int getYear() {
			return year;
		}

		public boolean isHoliday() {
			return isHoliday;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public void setHoliday(boolean isHoliday) {
			this.isHoliday = isHoliday;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + day;
			result = prime * result + (isHoliday ? 1231 : 1237);
			result = prime * result + month;
			result = prime * result + year;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Date other = (Date) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
				return false;
			}
			if (day != other.day) {
				return false;
			}
			if (isHoliday != other.isHoliday) {
				return false;
			}
			if (month != other.month) {
				return false;
			}
			if (year != other.year) {
				return false;
			}
			return true;
		}

		// используется equals
		private Calendar getEnclosingInstance() {
			return Calendar.this;
		}

		@Override
		public String toString() {
			return "Date [day=" + day + ", month=" + month + ", year=" + year + ", isHoliday=" + isHoliday + "]";
		}
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Calendar other = (Calendar) obj;
		if (dates == null) {
			if (other.dates != null) {
				return false;
			}
		} else if (!dates.equals(other.dates)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Calendar [dates=" + dates + "]";
	}
}
