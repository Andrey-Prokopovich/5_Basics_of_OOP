package by.javatraining.task4.logic;

import by.javatraining.task4.entity.Treasure;
import by.javatraining.task4.exception.InvalidValueException;
import by.javatraining.task4.input.UserInput;
import by.javatraining.task4.view.TreasureInfo;

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

public class ApplicationLogic {

	CaveLogic caveLogic;
	UserInput userInput;

	public ApplicationLogic() {
		caveLogic = new CaveLogic();
		userInput = new UserInput();
	}

	// null - выйти
	// "текст выполнения" - продолжать
	// ERROR - неизвестная опция
	private String runOption(int actionIndex) {
		if (actionIndex == MenuOptions.EXIT.ordinal()) {
			return null;
		}
		if (actionIndex == MenuOptions.SHOW_ALL.ordinal()) {
			return caveLogic.printAllTreasures();
		}
		if (actionIndex == MenuOptions.GET_MOST_EXPENSIVE.ordinal()) {
			Treasure treasureTaken;
			String result;

			treasureTaken = caveLogic.getMostExpensive();
			result = "Самое дорогое сокровище:\n" + TreasureInfo.formTreasureInfo(treasureTaken) + ".";

			caveLogic.removeTreasure(treasureTaken);

			return result;
		}
		if (actionIndex == MenuOptions.GET_FOR_AMOUNT.ordinal()) {
			return caveLogic.getTreasuresAmountingTo(userInput.getAmountFromUser());
		}

		return "ERROR";
	}

	public void runApp() {
		try {
			caveLogic.makeRandomHoard();
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}

		int optionChoosen;
		String runningState;

		do {
			System.out.println(Menu.printMenuOptions());

			optionChoosen = userInput.getMenuInput();

			runningState = runOption(optionChoosen);

			System.out.println(runningState);
			System.out.println();
		} while (runningState != null);
	}
}
