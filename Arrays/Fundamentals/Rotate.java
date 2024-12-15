import java.util.Scanner;

class Rotate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    int K = sc.nextInt();
    leftRotateByOne(nums, N);
    rightRotateByOne(nums, N);
    leftRotateByK(nums, N, K);
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
    System.out.println();
  }

  private static void leftRotateByOne(int[] nums, int N) {
    int[] nums1 = nums.clone();
    System.out.println("Left Rotation By One\nBefore Rotate ");
    print(nums1);
    reverse(nums1, 0, N - 1);
    reverse(nums1, 0, N - 2);
    System.out.println("After Rotate ");
    print(nums1);
  }

  private static void leftRotateByK(int[] nums, int N, int K) {
    int[] nums1 = nums.clone();
    K = K % N;
    System.out.println("Left Rotation By K\nBefore Rotate");
    print(nums1);
    reverse(nums1, 0, K - 1);
    reverse(nums1, K, N - 1);
    reverse(nums1, 0, N - 1);
    System.out.println("After Rotate ");
    print(nums1);
  }

  private static void rightRotateByOne(int[] nums, int N) {
    int[] nums1 = nums.clone();
    System.out.println("Right Rotation By One\nBefore Rotate ");
    print(nums1);
    reverse(nums1, 0, N - 1);
    reverse(nums1, 1, N - 1);
    System.out.println("After Rotate ");
    print(nums1);
  }

  private static void rightRotateByK(int[] nums, int N) {
  }
}