import java.util.Scanner;
public class Guests {

    public static int numberOfPerson;

    public static void addGuest () {
        Scanner scanner = new Scanner(System.in);
        while (true) {                                     // Запускаем бесконечный цикл
            System.out.println("Введите количество гостей");
            if (scanner.hasNextInt()) {
                numberOfPerson = scanner.nextInt();       // получаем значение от пользователя
                if (numberOfPerson > 1) {
                    Calculator.addProduct();            //вызываем метод добавления и подсчёта товаров из класса Сalculator
                    Calculator.sumOutput();            //вызываем метод вывода результата из класса Сalculator
                    break;
                }
                if (numberOfPerson == 1) {
                    System.out.println("Счёт делить не с кем");
                    break;
                }
                System.out.println("Введите корректное количество гостей, значение должно быть больше 1");
            }
            else {
                System.out.println("Введено неверное значение, введите целое число больше 1");
                scanner.next();

            }
        }
    }
}