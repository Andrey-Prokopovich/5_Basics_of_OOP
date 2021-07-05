package by.javatraining.task4.logic;

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

public class Menu {

	public static String printMenuOptions() {
		StringBuilder strMenuOptions = new StringBuilder();

		strMenuOptions.append("Выберите действие:\n");

		for (MenuOptions mOption : MenuOptions.values()) {
			strMenuOptions.append(mOption.ordinal() + ". " + mOption.getLabel() + ".\n");
		}

		return strMenuOptions.toString();
	}

	public static boolean isMenuOption(int optionNumber) {
		return ((0 <= optionNumber) && (optionNumber < MenuOptions.values().length));
	}
}
