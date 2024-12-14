import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
          int size = sc.nextInt();
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
              array[i] = sc.nextInt();
          }
          selectionSort(array, size);
          for (int element : array) {
              System.out.print(element + " ");
          } }
  }

  private static void selectionSort(int[] nums, int size) {
    for (int i = 0; i < size; i++) {
      int currentMinIndex = i;
      int j = i + 1;
      while (j < size) {
        if (nums[j] < nums[currentMinIndex]) {
          currentMinIndex = j;
        }
        j++;
      }
      int temp = nums[i];
      nums[i] = nums[currentMinIndex];
      nums[currentMinIndex] = temp;
    }
  }
}
