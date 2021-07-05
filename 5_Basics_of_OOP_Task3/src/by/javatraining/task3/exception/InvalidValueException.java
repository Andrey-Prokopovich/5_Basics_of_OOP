package by.javatraining.task3.exception;

/*
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию
 * о выходных и праздничных днях.
 */

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = -1287144417253994119L;

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
