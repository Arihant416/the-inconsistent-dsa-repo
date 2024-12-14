import java.util.Scanner;

class QuickSort {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int size = sc.nextInt();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = sc.nextInt();
      }
      quickSort(array, 0, size - 1);
      for (int element : array) {
        System.out.print(element + " ");
      }
    }
  }

  private static void quickSort(int[] nums, int st, int end) {
    if (st < end) {
      int partitionIndex = findPartitionIndex(nums, st, end);
      quickSort(nums, st, partitionIndex - 1);
      quickSort(nums, partitionIndex + 1, end);
    }
  }

  private static int findPartitionIndex(int[] nums, int st, int end) {
    int pivot = nums[st];
    int low = st + 1;
    int high = end;

    while (low <= high) {
      while (low <= end && nums[low] <= pivot) {
        low++;
      }
      while (high >= st && nums[high] > pivot) {
        high--;
      }
      if (low < high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
      }
    }

    int temp = nums[st];
    nums[st] = nums[high];
    nums[high] = temp;
    return high;
  }
}
