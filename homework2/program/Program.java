package Homework2.Program;

import java.util.Scanner;

public class Program {

    // Печатаем сообщение
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Вычисление степени

    public static double pow(double base, double exponent) {
        double result = 1.0;
        if (base == 0) {
            return 0;
        }
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
                exponent--;
            }
            base *= base;
            exponent /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        // Я не смог разобраться, как заставить Scanner читать ввод более одного раза,
        // поэтому решил проблему "в лоб"
        printMessage("Введите основание степени: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        input.nextLine(); // Поскольку nextInt оставляет после себя перевод строки, "убираем его"
        printMessage("Введите показатель степени: ");
        int b = input.nextInt();
        input.nextLine();
        input.close();
        // поскольку функция pow возвращает 0^0=0, что не соответствует условию задачи,
        // обработаем этот случай явно.
        if (a == 0 && b == 0) {
            printMessage("не определено");
        } else {
            // если степень отрицательная, то результат равен 1/a^b
            double result = 0;
            if (b < 0) {
                result = 1 / pow(a, -b);
            } else {
                result = pow(a, b);
            }
            printMessage("Результат: " + result);
        }
    }
}
