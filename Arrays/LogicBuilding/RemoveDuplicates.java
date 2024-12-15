import java.util.Scanner;

class RemoveDuplicates {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] nums = new int[size];
    for (int i = 0; i < size; i++) {
      nums[i] = sc.nextInt();
    }
    removeDuplicates(nums, size);
    print(nums);
  }

  private static void print(int[] nums) {
    for (int el : nums)
      System.out.print(el + " ");
    System.out.println();
  }

  private static void removeDuplicates(int[] nums, int size) {
    int curEl = nums[0];
    int curIndex = 1;
    int i = 1;
    while (i < size) {
      while (i < size && nums[i] == curEl)
        i++;
      if (i < size) {
        nums[curIndex] = nums[i];
        curEl = nums[curIndex];
        curIndex++;
        i++;
      }
    }
  }
}