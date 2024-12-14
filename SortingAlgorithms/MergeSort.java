import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MergeSort {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int size = sc.nextInt();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = sc.nextInt();
      }
      mergeSort(array, 0, size - 1);
      for (int element : array) {
        System.out.print(element + " ");
      }
    }
  }

  // Very very important Sorting Algorithm
  private static void mergeSort(int[] nums, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;
      mergeSort(nums, start, mid);
      mergeSort(nums, mid + 1, end);
      merge(nums, start, mid, end);
    }
  }

  private static void merge(int[] nums, int low, int mid, int high) {
    List<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left++]);
      } else {
        temp.add(nums[right++]);
      }
    }
    while (left <= mid) {
      temp.add(nums[left++]);
    }
    while (right <= high) {
      temp.add(nums[right++]);
    }
    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i-low);
    }
  }
}