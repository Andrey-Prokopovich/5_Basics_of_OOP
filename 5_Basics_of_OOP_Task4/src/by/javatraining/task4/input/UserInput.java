package by.javatraining.task4.input;

import java.util.Scanner;

import by.javatraining.task4.logic.Menu;

/*
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * * Приложение должно быть объектно-, а не процедурно-ориентированным.
 * * Каждый класс должен иметь отражающее смысл название и информативный состав.
 * * Наследование должно применяться только тогда, когда это имеет смысл.
 * * При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * * Классы должны быть грамотно разложены по пакетам.
 * * Консольное меню должно быть минимальным.
 * * Для хранения данных можно использоваеть файл.
 * 
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах
 * в пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости
 * сокровища и выбора сокровищ на заданную сумму.
 */

public class UserInput {

	Scanner scanner;
	
	public UserInput() {
		scanner = new Scanner(System.in);
	}
	
	public int getMenuInput() {
		do {
			if (scanner.hasNextInt()) {
				int scannerInput = scanner.nextInt();
				if (Menu.isMenuOption(scannerInput)) {
					return scannerInput;
				}
			}
		} while (true);
	}
	
	public double getAmountFromUser() {
		System.out.println("Введите желаемую сумму:");

		double userInput;

		do {
			if (scanner.hasNextDouble()) {
				userInput = scanner.nextDouble();
				break;
			}
		} while (true);

		return userInput;
	}
}
