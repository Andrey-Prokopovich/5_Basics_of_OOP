package by.javatraining.task5.model;

public enum WrappingType {
	GLASS_VASE("Стеклянная ваза"), 
	WOODEN_BASKET("Деревянная корзина"), 
	COLORED_PAPER("Цветная бумага"), 
	RIBBONS("Ленточки");
	
	private String name;
	
	WrappingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
