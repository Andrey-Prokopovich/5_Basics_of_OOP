package by.javatraining.task5.service;

import java.util.ListIterator;
import java.util.Scanner;

import by.javatraining.task5.model.*;

public class FlowerCompositionService {
	private Scanner scanner = new Scanner(System.in);
	
	private int getInteger() {
		while(!scanner.hasNextInt()) {
			scanner.next();
		}
    	
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}
	
	private void showFlowers() {
		for(FlowerType flowerType : FlowerType.values())
			System.out.println(flowerType.ordinal() + ". " + flowerType.getName());
	}
	
	private void addFlower(FlowerComposition flowerComposition, int number, int amount) {
		Flower flower = new FlowerBuilder().addFlowerType(number).addFlowersAmount(amount).build();
		flowerComposition.getFlowers().add(flower);
	}
	
	public void addFlower(FlowerComposition flowerComposition) {
		System.out.println("Выберите цветок:");
		showFlowers();
		int number = getInteger();
		
		System.out.println("Укажите количество:");
		int amount = getInteger();
		addFlower(flowerComposition, number, amount);
	}
	
	private void showWrapping() {
		for(WrappingType wrappingType : WrappingType.values())
			System.out.println(wrappingType.ordinal() + ". " + wrappingType.getName());
	}
	
	private void addWrapping(FlowerComposition flowerComposition, int number) {
		if(flowerComposition.getFlowers().isEmpty())
			System.out.println("Сначала добавьте цветы.");
		else {
			Wrapping wrapping = new WrappingBuilder().addWrappingType(number).build();
			flowerComposition.setWrapping(wrapping);
		}
	}
	
	public void addWrapping(FlowerComposition flowerComposition) {
		System.out.println("Выберите упаковку:");
		showWrapping();
    	
		int number = getInteger();
		addWrapping(flowerComposition, number);
	}
	
	public void showComposition(FlowerComposition flowerComposition) {
		ListIterator<Flower> flowerIterator = flowerComposition.getFlowers().listIterator();
		
		if(flowerComposition.getFlowers().isEmpty())
			System.out.println("Композиция не имеет цветов.");
		else {
			while(flowerIterator.hasNext()) {
				System.out.print(flowerIterator.next());
				if(flowerIterator.hasNext())
					System.out.print(", ");
				else
					System.out.print(" ");
			}
            
			if(flowerComposition.getWrapping() != null)
				System.out.println("упаковано в " + flowerComposition.getWrapping().getWrappingType().getName());
		}
	}
}
