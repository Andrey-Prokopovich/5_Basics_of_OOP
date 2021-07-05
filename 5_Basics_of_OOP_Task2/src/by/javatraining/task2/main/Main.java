package by.javatraining.task2.main;

import by.javatraining.task2.exception.InvalidValueException;
import by.javatraining.task2.logic.PaymentLogic;

/*
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать
 * покупку из нескольких товаров.
 */

public class Main {

	public static void main(String[] args) {
		PaymentLogic paymentLogic = new PaymentLogic();

		paymentLogic.setPayment(null);

		System.out.println(paymentLogic.printItemsInCart());

		System.out.println();

		try {
			paymentLogic.addItemToCart("Напиток \"Coca-Cola\" 1.5л", 1.59);
			paymentLogic.addItemToCart("Пицца\"Пепперони блюз\" классическая 30см", 20.57);
			paymentLogic.addItemToCart("Пышки с коррицей", 2.13);
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(paymentLogic.printItemsInCart());

		System.out.println("Итоговая стоимость: " + paymentLogic.calculateTotal());
	}
}
