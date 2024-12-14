import java.util.Scanner;

class InsertionSort {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int size = sc.nextInt();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = sc.nextInt();
      }
      insertionSort(array, size);
      for (int element : array) {
        System.out.print(element + " ");
      }
    }
  }

  private static void insertionSort(int[] nums, int n) {
    /*
     * All About insertion sort, it's like a shuffling algorithm
     * Pick a key and put it in its right place just like ordering a deck of cards
     * Run outer loop from second element
     * Inner loop all it does is shift the previous larger element to the right
     * making one space for the key to be inserted
     */
    for (int i = 1; i < n; i++) {
      int key = nums[i];
      int j = i - 1;
      while (j >= 0 && nums[j] > key) {
        nums[j + 1] = nums[j];
        j -= 1;
      }
      nums[j + 1] = key;
    }
  }
}