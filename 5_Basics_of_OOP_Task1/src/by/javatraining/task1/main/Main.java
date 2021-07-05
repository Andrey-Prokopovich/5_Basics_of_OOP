package by.javatraining.task1.main;

import by.javatraining.task1.entity.Directory;
import by.javatraining.task1.entity.TextFile;
import by.javatraining.task1.exception.DifferentClassException;
import by.javatraining.task1.exception.NameTakenException;
import by.javatraining.task1.logic.DirectoryLogic;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class Main {

	public static void main(String[] args) {
		DirectoryLogic directoryLogic = new DirectoryLogic();
		
		directoryLogic.setDirectory(new Directory("C:\\\\\\Desktop\\Project"));
		
		System.out.println("Создаем текстовый файл");
		try {
			directoryLogic.createTextFile("ReadMe");
		} catch (NameTakenException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(directoryLogic.printFileList());
		
		System.out.println();
		
		directoryLogic.getFileLogic().setFile(directoryLogic.findFileByNameType("ReadMe", "txt"));
		System.out.println("Дополняем текстовый файл");
		try {
			directoryLogic.getFileLogic().append("Test text file text line");
		} catch (DifferentClassException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(((TextFile) directoryLogic.findFileByNameType("ReadMe", "txt")).getText());
		
		System.out.println("Дополняем текстовый файл");
		try {
			directoryLogic.getFileLogic().append("\nanother test line");
		} catch (DifferentClassException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(((TextFile) directoryLogic.findFileByNameType("ReadMe", "txt")).getText());
		
		System.out.println();
		
		System.out.println("Переименование файла");
		directoryLogic.getFileLogic().changeName("InfoHere");
		System.out.println(directoryLogic.printFileList());
		
		System.out.println();
		
		System.out.println("Удаление файла");
		directoryLogic.deleteFile("InfoHere", "txt");
		System.out.println(directoryLogic.printFileList());
	}
}
