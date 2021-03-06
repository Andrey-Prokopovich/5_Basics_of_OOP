package by.javatraining.task5.main;
import by.javatraining.task5.service.FlowerCompositionApp;

/*
 * Создать консольное приложение, удовлетворяющее слудующим требованиям:
 *  * Корректно спроектируйте и реализуйте предметную область задачи.
 *  * Для создания объектов из иерархии классов продумайте возможность 
 *    использования порождающих шаблонов проектирования.
 *  * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 *  * Для проверки корректности переданных данных можно применить регулярные выражения.
 *  * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 *  * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
 *  
 *  Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
 *  (объект, представляющий собой цветочную композицию). Состовляющими цветочной композиции
 *  являются цветы и упаковка.
 */

public class Main {

	public static void main(String[] args) {
		new FlowerCompositionApp().runApp();
	}
}
