package Homework1.Program;

import java.util.Scanner;

class program {
    // Печатаем сообщение
    public static void PrintMessage(String message) {
        System.out.println(message);
    }
    
    // Получаем ввод от пользователя
    public static int GetUserInt() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.close();
        return num;
    }

    // Считаем результат Тn = ((1+n)/*n)/2
    public static int CalcTriangleNumber(int n) {
        return ((1+n)*n)/2;
    }

    public static void main(String[] args) {
        PrintMessage("Программа вычисляет n-е треугольное число (сумму от 1 до n)");
        PrintMessage("Введите число n: ");
        int num = GetUserInt();
        PrintMessage("Результат: " + CalcTriangleNumber(num));  // Выводим результат
    }



    
}
