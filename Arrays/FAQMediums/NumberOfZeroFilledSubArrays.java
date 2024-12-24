import java.util.Scanner;

public class NumberOfZeroFilledSubArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("zeroFilledSubs " + zeroFilledSubarray(nums, N));
  }

  static long zeroFilledSubarray(int[] nums, int N) {
    long count = 0;
    long totalCount = 0;
    for (int el : nums) {
      if (el == 0) {
        count++;
      } else {
        totalCount += (count * (count + 1) / 2);
        count = 0;
      }
    }
    if (count != 0)
      totalCount += (count * (count + 1) / 2);
    return totalCount;
  }
}
