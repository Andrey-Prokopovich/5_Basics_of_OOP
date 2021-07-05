package by.javatraining.task4.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

public class Cave implements Serializable {
	
	private static final long serialVersionUID = 3904361281002366543L;
	
	private List<Treasure> treasureHoard;
	
	public Cave() {
		treasureHoard = new LinkedList<Treasure>();
	}

	public List<Treasure> getTreasureHoard() {
		return treasureHoard;
	}

	public void setTreasureHoard(List<Treasure> treasureHoard) {
		this.treasureHoard = treasureHoard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((treasureHoard == null) ? 0 : treasureHoard.hashCode());
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
		Cave other = (Cave) obj;
		if (treasureHoard == null) {
			if (other.treasureHoard != null) {
				return false;
			}
		} else if (!treasureHoard.equals(other.treasureHoard)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cave [treasureHoard=" + treasureHoard + "]";
	}
}
