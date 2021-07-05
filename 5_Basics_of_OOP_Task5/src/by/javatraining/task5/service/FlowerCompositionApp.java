package by.javatraining.task5.service;

import java.util.Scanner;

import by.javatraining.task5.menu.Menu;
import by.javatraining.task5.menu.MenuOptions;
import by.javatraining.task5.model.FlowerComposition;

public class FlowerCompositionApp {
	private static Scanner scanner = new Scanner(System.in);
	private static FlowerComposition flowerComposition = new FlowerComposition();
	private static FlowerCompositionService flowerCompositionService = new FlowerCompositionService();
    
    // 0 - выйти
 	// 1 - продолжать
 	// 13 - неизвестная опция
	private int runOption(int actionIndex) {
		if(actionIndex == MenuOptions.EXIT.ordinal()) {
			return 0;
		}
		if(actionIndex == MenuOptions.SHOW_COMPOSITION.ordinal()) {
			System.out.println("Композиция сейчас:");
			flowerCompositionService.showComposition(flowerComposition);
			
			return 1;
		}
 		if(actionIndex == MenuOptions.ADD_FLOWERS.ordinal()) {
 			flowerCompositionService.addFlower(flowerComposition);
 			
 			return 1;
 		}
 		if(actionIndex == MenuOptions.ADD_WRAPPING.ordinal()) {
 			flowerCompositionService.addWrapping(flowerComposition);
 			
 			return 1;
 		}
 		
 		return 13;
 	}

    public void runApp() {
    	int userInput;
    	int runningState;
		
    	System.out.println("Приступим к составлению композиции.");
    	do {
    		Menu.printMenuOptions();
			
    		do {
    			if(scanner.hasNextInt()) {
    				int scannerInput = scanner.nextInt();
    				if(Menu.isMenuOption(scannerInput)) {
    					userInput = scannerInput;
    					break;
    				}
    			}
    		} while(true);
    		runningState = runOption(userInput);
			
    		System.out.println();
    	} while(runningState > 0);
    }
}
