
import java.util.Scanner;

public class Sort012 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    sort012(nums, N);
    print(nums);
  }

  static void print(int[] nums) {
    for (int el : nums) {
      System.out.print(el + " ");
    }
  }

  static void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  static void sort012(int[] nums, int N) {
    int low = 0, high = N - 1, mid = 0;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0 -> {
          swap(nums, low, mid);
          low++;
          mid++;
        }
        case 1 -> mid++;
        case 2 -> {
          swap(nums, mid, high);
          high--;
        }
      }
    }
  }
}