package by.javatraining.task5.model;

public class WrappingBuilder {
	private Wrapping wrapping = new Wrapping();
	
	public WrappingBuilder addWrappingType(int number) {
		if(0 <= number && number < WrappingType.values().length) {
			wrapping.setWrappingType(WrappingType.values()[number]);
		}
		else {
			System.out.println("Нет упаковки с таким номером.");
		}
		return this;
	}
	
	public Wrapping build() {
		return wrapping;
	}
}
