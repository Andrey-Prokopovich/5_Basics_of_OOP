package by.javatraining.task5.model;

public class Flower {
	private FlowerType flowerType;
	private int amount;
	
	public FlowerType getFlowerType() {
		return flowerType;
	}
	
	protected void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	protected void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return amount + " " + flowerType.getName();
	}
}
