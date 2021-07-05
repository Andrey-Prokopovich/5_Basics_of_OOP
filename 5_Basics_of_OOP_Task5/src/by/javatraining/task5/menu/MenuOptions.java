package by.javatraining.task5.menu;

public enum MenuOptions {
	ADD_FLOWERS("Добавить цветы"),
	ADD_WRAPPING("Добавить упаковку"),
	SHOW_COMPOSITION("Показать цветочную композицию"),
	EXIT("Выход");
	
	private final String label;

	MenuOptions(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
