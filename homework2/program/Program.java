package Homework2.Program;

import java.util.Scanner;
import java.io.*;

public class Program {

    // Печатаем сообщение
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Получаем данные с клавиатуры
    static double[] getabFromKeyboard(Scanner input) {
        double[] userInput = new double[2];
        printMessage("Введите основание степени: ");
        userInput[0] = input.nextInt();
        input.nextLine(); // Поскольку nextInt оставляет после себя перевод строки, "убираем его"
        printMessage("Введите показатель степени: ");
        userInput[1] = input.nextInt();
        input.nextLine();
        return userInput;
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

    public static void main(String[] args) throws Exception {

        Scanner uinput = new Scanner(System.in);
        int userChoice = 0;
        double a = 0;
        double b = 0;
        do {
            printMessage("Выберите источник данных (1 - консоль, 2 - файл)");
            userChoice = uinput.nextInt();
            uinput.nextLine();
            if (userChoice == 1) {
                double[] data = getabFromKeyboard(uinput);
                a = data[0];
                b = data[1];
            } else if (userChoice == 2) {
                printMessage("Делаем ввод из файла");
                File inpFile = new File("./homework2/program/input.txt");
                Scanner fScan = new Scanner(inpFile);
                while (fScan.hasNextLine()) {
                    String[] str = fScan.nextLine().split(" ");
                    if (str[0].equals("a")) {
                        a = Integer.parseInt(str[1]);
                    }
                    if (str[0].equals("b")) {
                        b = Integer.parseInt(str[1]);
                    }
                }
                fScan.close();
            } else {
                printMessage("Неверный ввод!");
            }
        } while (userChoice > 2 || userChoice < 1);
        uinput.close();
        // поскольку функция pow возвращает 0^0=0, что не соответствует условию задачи,
        // обработаем этот случай явно.
        double result = 0;
        if (a == 0 && b == 0) {
            printMessage("не определено");
        } else {
            // если степень отрицательная, то результат равен 1/a^b
            if (b < 0) {
                result = 1 / pow(a, -b);
            } else {
                result = pow(a, b);
            }
            printMessage("Результат: " + result);
        }
        if (userChoice == 2) {
            File outFile = new File("./homework2/program/output.txt");
            try (FileWriter writer = new FileWriter(outFile, false);) {
                writer.write(Double.toString(result));
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

        }
    }
}
