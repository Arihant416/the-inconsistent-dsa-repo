
import java.util.Scanner;

class Problems {

    private void findSumOfArray(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        System.out.println("Sum of array is -> " + sum);
    }

    private void countOddNumbers(int[] array) {
        int count = 0;
        for (int el : array) {
            count += (el % 2 == 1 ? 1 : 0);
        }
        System.out.println("Array has" + count + " odd elements");
    }

    private void reverseArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Problems obj = new Problems();
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            // Problem 1: Find Sum of Array
            obj.findSumOfArray(array);

            // Problem 2: Count odd numbers in array
            obj.countOddNumbers(array);

            // Problem 3: Reverse an Array
            obj.reverseArray(array);
        }
    }
}
