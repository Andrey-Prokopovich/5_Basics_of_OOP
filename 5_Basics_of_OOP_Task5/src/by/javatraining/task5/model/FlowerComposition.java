package by.javatraining.task5.model;

import java.util.LinkedList;

public class FlowerComposition {
	private Wrapping wrapping;
	private LinkedList<Flower> flowers = new LinkedList<>();
	
	public Wrapping getWrapping() {
		return wrapping;
	}
	
	public void setWrapping(Wrapping wrapping) {
		this.wrapping = wrapping;
	}
	
	public LinkedList<Flower> getFlowers() {
		return flowers;
	}
}
