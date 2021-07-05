package by.javatraining.task1.exception;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class NameTakenException extends Exception {

	private static final long serialVersionUID = -5879267221365974023L;

	public NameTakenException(String message) {
		super(message);
	}

	public NameTakenException(String message, Throwable cause) {
		super(message, cause);
	}
}
