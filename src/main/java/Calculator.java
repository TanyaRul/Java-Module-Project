import java.util.Scanner;

public class Calculator {

    public static String option;
    public static String listOfProducts = "";
    public static double totalCost = 0;
    public static double price;

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Запускаем бесконечный цикл для добавления товаров
                System.out.println("Введите название товара");
                Product productName = new Product(scanner.next()); // создаем объект класса Product и сохраняем в нем введённое пользователем значение
            while (true) { // Запускаем бесконечный цикл для проверки цены
                System.out.println("Введите стоимость товара в формате 'рубли.копейки' [10.45, 11.40]");
                if (scanner.hasNextDouble()) {  // проверка на число
                    price = scanner.nextDouble();
                    if (price > 0) {  // проверка на положительное число
                        break;
                    }
                    else {
                        System.out.println("Цена товара не может быть отрицательной, введите положительное число в формате '10.45'");
                    }
                }
                else {
                    System.out.println("Введено неверное значение, цена товара должна быть положительным числом в формате '10.45'");
                    scanner.next(); // очистка ввода
                }
            }
            System.out.println("Товар успешно добавлен");
            listOfProducts += productName.name + " - " + price; // добавляем новый товар в список
            totalCost += price; // считаем текущую общую сумму
            System.out.println(String.format("Текущая общая сумма: %.2f \n", totalCost));
            System.out.println("Для завершения процесса добавления товаров введите команду \"Завершить\" или любое другое значение для добавления ещё одного товара");
            option = scanner.next();
                if (option.equalsIgnoreCase("завершить")) {
                    System.out.println("Добавленные товары:\n" + listOfProducts + "\n" + String.format("Итого: %.2f", totalCost));
                    break;
                }
            listOfProducts += "\n";
        }
    }

    public static void sumOutput() {                        // вывод итоговой суммы на каждого гостя
        double amountPerGuest = totalCost / Guests.numberOfPerson;    // считаем итоговую сумму на каждого гостя
        int amountRound = (int)(Math.floor(amountPerGuest));    // округляем и приводим к целому числу
        int lastDigit = amountRound % 10;                       // вычисляем последнюю цифру числа
        if (amountRound > 10 && amountRound < 20) {
            System.out.println(String.format("Каждый гость должен заплатить %.2f", amountPerGuest) + " рублей");
        }
        else if (lastDigit > 1 && lastDigit < 5) {
            System.out.println(String.format("Каждый гость должен заплатить %.2f", amountPerGuest) + " рубля");
        }
        else if (lastDigit == 1) {
            System.out.println(String.format("Каждый гость должен заплатить %.2f", amountPerGuest) + " рубль");
        }
        else {
            System.out.println(String.format("Каждый гость должен заплатить %.2f", amountPerGuest) + " рублей");
        }
    }

}



