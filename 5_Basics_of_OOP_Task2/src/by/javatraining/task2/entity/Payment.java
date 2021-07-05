package by.javatraining.task2.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать
 * покупку из нескольких товаров.
 */

public class Payment implements Serializable {

	private static final long serialVersionUID = -8178780652202441262L;

	private List<Item> shoppingCart;

	public Payment() {
		shoppingCart = new LinkedList<Item>();
	}

	public class Item implements Serializable {

		private static final long serialVersionUID = -716521115661446752L;

		private String name;
		private double price;

		public Item(String name, double price) {
			setName(name);
			setPrice(price);
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Item other = (Item) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
				return false;
			}
			return true;
		}

		// используется equals
		private Payment getEnclosingInstance() {
			return Payment.this;
		}

		@Override
		public String toString() {
			return "Item [name=" + name + ", price=" + price + "]";
		}
	}

	public List<Item> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<Item> shopingCart) {
		this.shoppingCart = shopingCart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shoppingCart == null) ? 0 : shoppingCart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Payment other = (Payment) obj;
		if (shoppingCart == null) {
			if (other.shoppingCart != null) {
				return false;
			}
		} else if (!shoppingCart.equals(other.shoppingCart)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Payment [shoppingCart=" + shoppingCart + "]";
	}
}
