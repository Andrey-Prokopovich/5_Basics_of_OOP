package by.javatraining.task1.logic;

import by.javatraining.task1.entity.File;
import by.javatraining.task1.entity.TextFile;
import by.javatraining.task1.exception.DifferentClassException;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class FileLogic {

	private File file;

	public FileLogic() {
	}

	public void setFile(File file) {
		if (file == null) {
			this.file = new File();
		} else {
			this.file = file;
		}
	}

	protected File getFile() {
		return file;
	}

	public void changeName(String name) {
		file.setName(name);
	}

	public void changeType(String type) {
		file.setType(type);
	}

	public void append(String text) throws DifferentClassException {
		if (file.getClass() != TextFile.class) {
			throw new DifferentClassException("Файл " + file.getName() + "." + file.getType()
					+ " не является текстовым.\n" + "Невозможно дополнить.");
		}

		((TextFile) file).setText(((TextFile) file).getText() + text);
	}
}
