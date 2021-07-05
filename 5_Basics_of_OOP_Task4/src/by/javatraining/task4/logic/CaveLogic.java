package by.javatraining.task4.logic;

import java.util.List;
import java.util.Random;

import by.javatraining.task4.entity.Cave;
import by.javatraining.task4.entity.Treasure;
import by.javatraining.task4.exception.InvalidValueException;
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

public class CaveLogic {

	private Cave cave;

	public CaveLogic() {
	}

	public void setCave(Cave cave) {
		if (cave == null) {
			this.cave = new Cave();
		} else {
			this.cave = cave;
		}
	}

	public void addTreasure(Treasure treasure) {
		cave.getTreasureHoard().add(treasure);
	}

	public void removeTreasure(Treasure treasure) {
		cave.getTreasureHoard().remove(treasure);
	}

	public void removeHoard() {
		cave.getTreasureHoard().clear();
	}

	public void makeRandomHoard() throws InvalidValueException {
		List<Treasure> treasureHoard;
		Random random;

		treasureHoard = cave.getTreasureHoard();
		random = new Random();

		while (treasureHoard.size() < 100) {
			int randomTreasureType;
			Treasure newTreasure;

			randomTreasureType = TreasureTypes.getRandom().ordinal();
			newTreasure = new Treasure(TreasureTypes.values()[randomTreasureType].getLabel(),
					random.nextDouble() * 10 * (TreasureTypes.values()[randomTreasureType].ordinal() + 1));

			treasureHoard.add(newTreasure);
		}
	}

	public Treasure getMostExpensive() {
		List<Treasure> treasureHoard;
		Treasure mostExpensive;

		treasureHoard = cave.getTreasureHoard();
		mostExpensive = null;

		for (Treasure treasure : treasureHoard) {
			if (mostExpensive == null)
				mostExpensive = treasure;

			if (mostExpensive.getValue() < treasure.getValue())
				mostExpensive = treasure;
		}

		return mostExpensive;
	}

	private Treasure getLeastExpensive() {
		List<Treasure> treasureHoard;
		Treasure leastExpensive;

		treasureHoard = cave.getTreasureHoard();
		leastExpensive = null;

		for (Treasure treasure : treasureHoard) {
			if (leastExpensive == null)
				leastExpensive = treasure;

			if (leastExpensive.getValue() > treasure.getValue())
				leastExpensive = treasure;
		}

		return leastExpensive;
	}

	private boolean canTakeMore(double targetAmount, double takenAmount, double toTakeAmount) {
		return (!cave.getTreasureHoard().isEmpty() && takenAmount <= targetAmount
				&& toTakeAmount >= getLeastExpensive().getValue());
	}

	public String getTreasuresAmountingTo(double targetAmount) {
		List<Treasure> treasureHoard;
		StringBuilder strTreasureTaken;
		Random random = new Random();
		double takenAmount = 0.0;
		double toTakeAmount = targetAmount;

		treasureHoard = cave.getTreasureHoard();
		strTreasureTaken = new StringBuilder();
		random = new Random();
		takenAmount = 0.0;
		toTakeAmount = targetAmount;

		strTreasureTaken.append("Список сокровищ на сумму " + targetAmount + ":\n");

		while (canTakeMore(targetAmount, takenAmount, toTakeAmount)) {
			int index = random.nextInt(treasureHoard.size());

			if (toTakeAmount >= treasureHoard.get(index).getValue()) {
				takenAmount += treasureHoard.get(index).getValue();
				toTakeAmount = targetAmount - takenAmount;

				strTreasureTaken.append(treasureHoard.get(index).toString() + "\n");
				treasureHoard.remove(index);
			}
		}

		strTreasureTaken.append("Удалось собрать сокровищ на суму: " + String.format("%.2f", takenAmount) + "\n");

		return strTreasureTaken.toString();
	}

	public String printAllTreasures() {
		List<Treasure> treasureHoard;
		StringBuilder strHoard;

		treasureHoard = cave.getTreasureHoard();
		strHoard = new StringBuilder();

		strHoard.append("Список сокровищ в пещере дракона:\n");
		for (Treasure treasure : treasureHoard) {
			strHoard.append(TreasureInfo.formTreasureInfo(treasure) + "\n");
		}

		return strHoard.toString();
	}
}
