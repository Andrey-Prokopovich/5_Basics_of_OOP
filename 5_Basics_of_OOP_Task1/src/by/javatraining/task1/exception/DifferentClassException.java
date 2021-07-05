package by.javatraining.task1.exception;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class DifferentClassException extends Exception {

	private static final long serialVersionUID = -1040320920235875495L;

	public DifferentClassException(String message) {
		super(message);
	}

	public DifferentClassException(String message, Throwable cause) {
		super(message, cause);
	}
}
