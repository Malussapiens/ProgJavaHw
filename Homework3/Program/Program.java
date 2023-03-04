import java.util.Arrays;

public class Program {
    // Возвращает массив длиной arrLength, заполненный случайными целыми
    // числами из диапазона [beginRng, endRng]
    static int[] getRandomArrayInt(int arrLength, int beginRng, int endRng){
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = (int) (Math.random() * (endRng - (beginRng - 1))) + beginRng;
        }
        return arr;
    }

        // функция слияния отсортированных массивов
        static int[] mergeArrays(int[] arr1, int[] arr2) {
            int begin1 = 0;
            int begin2 = 0;
            int[] merged = new int[arr1.length + arr2.length];
            for (int i = 0; i < merged.length; i++) {
                if (begin1 < arr1.length && begin2 < arr2.length) {
                    if (arr1[begin1] < arr2[begin2]) {
                        merged[i] = arr1[begin1++];
                    } else {
                        merged[i] = arr2[begin2++];
                    }
                } else {
                    if (begin1 < arr1.length) {
                        merged[i] = arr1[begin1++];
                    } else {
                        merged[i] = arr2[begin2++];
                    }
                }
            }
            return merged;
        }

    public static void main(String[] args) {
        int arrLen = 20;
        int[] arr = getRandomArrayInt(arrLen, 1, 100);
        
        System.out.println(Arrays.toString(arr));
    }
}
