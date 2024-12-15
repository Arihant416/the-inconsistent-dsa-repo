import java.util.Scanner;

class Rotate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    leftRotateByOne(nums, N);
  }

  private static void reverse(int[] nums, int startIndex, int endIndex) {
    while (startIndex < endIndex) {
      int temp = nums[startIndex];
      nums[startIndex] = nums[endIndex];
      nums[endIndex] = temp;
      startIndex++;
      endIndex--;
    }
  }

  private static void print(int[] nums) {
    for (int el : nums)
      System.out.print(el + " ");
  }

  private static void leftRotateByOne(int[] nums, int N) {
    int[] nums1 = nums.clone();
    System.out.println("Before Reverse ");
    print(nums1);
    reverse(nums1, 0, N - 1);
    reverse(nums1, 0, N - 2);
    System.out.println("\nAfter Reverse ");
    print(nums1);
  }

  private static void leftRotateByK(int[] nums, int N) {
  }

  private static void rightRotateByOne(int[] nums, int N) {

  }

  private static void rightRotateByK(int[] nums, int N) {
  }
}