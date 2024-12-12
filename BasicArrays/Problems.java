
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

    private void isSorted(Scanner sc) {
		// This algo will only check one way!! (Better question is check if array is sortedEitherWay)
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        boolean result = true;
        for(int i = 0; i < n-1; i++){
			if(array[i] > array[i+1]){
				result= false;
				break;
			}
		}
        if (!result) {
            System.out.println("\nNot Sorted");
        } else {
            System.out.println("\nSorted");
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

        // Problem 4: Check if an array is sorted
        obj.isSorted(scanner);
    }
}
}
