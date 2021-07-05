package by.javatraining.task4.logic;

import java.util.Random;

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

public enum TreasureTypes {
	ARMOR_SET_DAMAGED("Набор брони, поврежденный"), SWORD_DAMAGED("Меч, поврежденный"),
	LANCE_DAMAGED("Копье, поврежденное"), SAPPHIRE("Сапфир"), RUBY("Рубин"), AMETHYST("Аметист"), DIAMOND("Алмаз"),
	TOPAZ("Топаз"), GOLD_BAR("Золотой слиток"), GOLD_COIN("Золотая монета");

	private final String label;

	TreasureTypes(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	private static Random random = new Random();

	public static TreasureTypes getRandom() {
		int index = random.nextInt(values().length);
		return values()[index];
	}
}
