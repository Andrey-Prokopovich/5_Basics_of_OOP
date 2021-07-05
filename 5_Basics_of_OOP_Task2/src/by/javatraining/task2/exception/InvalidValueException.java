package by.javatraining.task2.exception;

/*
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать
 * покупку из нескольких товаров.
 */

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = -4459520213006902996L;

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
