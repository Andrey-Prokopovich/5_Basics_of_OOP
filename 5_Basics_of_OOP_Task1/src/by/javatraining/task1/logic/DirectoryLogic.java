package by.javatraining.task1.logic;

import java.util.List;

import by.javatraining.task1.entity.Directory;
import by.javatraining.task1.entity.File;
import by.javatraining.task1.entity.TextFile;
import by.javatraining.task1.exception.NameTakenException;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class DirectoryLogic {

	private final FileLogic fileLogic;

	private Directory directory;

	public DirectoryLogic() {
		fileLogic = new FileLogic();
	}

	public void setDirectory(Directory directory) {
		if (directory == null) {
			this.directory = new Directory();
		} else {
			this.directory = directory;
		}
	}
	
	public FileLogic getFileLogic() {
		return fileLogic;
	}

	public File findFileByNameType(String name, String type) {
		List<File> fileList = directory.getFileList();
		
		for (File file : fileList) {
			if (file.getName().equals(name) && file.getType().equals(type))
				return file;
		}

		return null;
	}

	public void createFile(String name, String type) throws NameTakenException {
		if (findFileByNameType(name, type) != null) {
			throw new NameTakenException("Файл " + name + "." + type + " уже существует.");
		}

		switch (type) {
		case "txt": {
			TextFile newFile = new TextFile(name);
			directory.getFileList().add(newFile);
			break;
		}
		default: {
			File newFile = new File(name, type);
			directory.getFileList().add(newFile);
			break;
		}
		}
	}

	public void createTextFile(String name) throws NameTakenException {
		createFile(name, "txt");
	}

	public void deleteFile(String name, String type) {
		File forRemoval;
		
		forRemoval = findFileByNameType(name, type);
		
		if (forRemoval != null) {
			directory.getFileList().remove(forRemoval);
		}
	}

	public String printFileList() {
		List<File> fileList;
		StringBuilder strFileList;
		
		fileList = directory.getFileList();
		strFileList = new StringBuilder();
		
		strFileList.append("Список файлов в директории " + directory.getPath() + ".\n");
		for (File file : fileList) {
			strFileList.append(file.getName() + "." + file.getType() + "\n");
		}
		
		return strFileList.toString();
	}
}
