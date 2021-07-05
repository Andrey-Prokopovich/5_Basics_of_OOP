package by.javatraining.task2.logic;

import java.util.List;

import by.javatraining.task2.entity.Payment;
import by.javatraining.task2.entity.Payment.Item;
import by.javatraining.task2.exception.InvalidValueException;

/*
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать
 * покупку из нескольких товаров.
 */

public class PaymentLogic {

	private Payment payment;

	public PaymentLogic() {
	}

	public void setPayment(Payment payment) {
		if (payment == null) {
			this.payment = new Payment();
		} else {
			this.payment = payment;
		}
	}

	public void addItemToCart(String name, double price) throws InvalidValueException {
		if (price < 0) {
			throw new InvalidValueException("Цена не может быть отрицательной.");
		} else {
			Item item = payment.new Item(name, price);
			payment.getShoppingCart().add(item);
		}
	}

	public double calculateTotal() {
		List<Item> shoppingCart;
		double total;

		shoppingCart = payment.getShoppingCart();
		total = 0.0;

		for (Item item : shoppingCart) {
			total += item.getPrice();
		}

		return total;
	}

	public String printItemsInCart() {
		List<Item> shoppingCart = payment.getShoppingCart();

		if (shoppingCart.isEmpty()) {
			return "Ваша тележка пуста.";
		} else {
			StringBuilder strItemList = new StringBuilder();

			strItemList.append("Список товаров в тележке:\n");
			for (Item item : shoppingCart) {
				strItemList.append("Товар: " + item.getName() + ". Цена: " + item.getPrice() + "\n");
			}

			return strItemList.toString();
		}
	}
}
