package by.javatraining.task5.model;

public class FlowerBuilder {
	private Flower flower = new Flower();
	
	public FlowerBuilder addFlowerType(int number) {
		if(0 <= number && number < FlowerType.values().length) {
			flower.setFlowerType(FlowerType.values()[number]);
		}
		else {
			System.out.println("Нет цветка с таким номером.");
		}
		return this;
	}
	
	public FlowerBuilder addFlowersAmount(int amount) {
		flower.setAmount(amount);
		return this;
	}
	
	public Flower build() {
		return flower;
	}
}
