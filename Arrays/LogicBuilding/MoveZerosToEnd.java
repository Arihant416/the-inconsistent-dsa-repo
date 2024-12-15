import java.util.Scanner;

class MoveZerosToEnd {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] nums = new int[size];
    for (int i = 0; i < size; i++) {
      nums[i] = sc.nextInt();
    }
    moveZerosToEnd(nums, size);
    print(nums);
  }

  private static void print(int[] nums) {
    for (int el : nums)
      System.out.print(el + " ");
    System.out.println();
  }

  private static void moveZerosToEnd(int[] nums, int size) {
    // This needs to be done in one pass and in-place
    int lastZeroIndex = 0;
    for (int i = 0; i < size; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[lastZeroIndex];
        nums[lastZeroIndex] = temp;
        lastZeroIndex++;
      }
    }
  }
}