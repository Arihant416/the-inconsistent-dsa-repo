import java.util.Scanner;

class LargestElementInArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Largest in array " + findLargest(nums));
  }

  private static int findLargest(int[] nums) {
    int maxNum = Integer.MIN_VALUE;
    for (int el : nums) {
      if (el > maxNum) {
        maxNum = el;
      }
    }
    return maxNum;
  }
}