package by.javatraining.task4.entity;

import java.io.Serializable;

import by.javatraining.task4.exception.InvalidValueException;

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

public class Treasure implements Serializable {

	private static final long serialVersionUID = 5648138360416955841L;

	private String name;
	private double value;

	public Treasure() {
	}

	public Treasure(String name, double value) throws InvalidValueException {
		setName(name);
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(double value) throws InvalidValueException {
		if (value < 0.0) {
			throw new InvalidValueException("Ценность сокровища не может быть отрицательной.");
		}

		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Treasure other = (Treasure) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [name=" + name + ", value=" + value + "]";
	}
}
