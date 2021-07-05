package by.javatraining.task5.model;

public enum FlowerType {
	ROSE("Роза"),
	ORCHID("Орхидея"),
	LILY("Лилия"),
	CHRYSANTHEMUM("Хризантема"),
	GLADIOLUS("Гладиолус"),
	GERANIUM("Герань"),
	LAVENDER("Лаванда");
	
	private String name;
	
	FlowerType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
