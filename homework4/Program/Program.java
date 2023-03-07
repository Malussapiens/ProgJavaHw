package Homework4.Program;

import java.util.Arrays;

public class Program {
    // Возвращает массив длиной arrLength, заполненный случайными целыми
    // числами из диапазона [beginRng, endRng]
    static int[] getRandomArrayInt(int arrLength, int beginRng, int endRng) {
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = (int) (Math.random() * (endRng - (beginRng - 1))) + beginRng;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arrLen = 20;
        int[] arr = getRandomArrayInt(arrLen, 1, 100);
        System.out.println(Arrays.toString(arr));
        
        HeapSort hs = new HeapSort();
        hs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
