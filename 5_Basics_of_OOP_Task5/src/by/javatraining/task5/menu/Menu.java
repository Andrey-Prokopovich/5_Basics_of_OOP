package by.javatraining.task5.menu;

public class Menu {
	public static void printMenuOptions() {
		System.out.println("Выберите действие:");
		
		for(MenuOptions mOption : MenuOptions.values()) {
			System.out.println(mOption.ordinal() + ". " + mOption.getLabel() + ".");
		}
		
		System.out.println();
	}
	
	public static boolean isMenuOption(int optionNumber) {
		return ((0 <= optionNumber) && (optionNumber < MenuOptions.values().length));
	}
}
