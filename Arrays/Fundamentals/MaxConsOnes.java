import java.util.Scanner;

class MaxConsOnes {
  // Problem to find MaxConsecutiveOnes
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Max Consecutive ones length is " + findLengthOfMaxConsOnes(nums));
  }

  private static int findLengthOfMaxConsOnes(int[] nums) {
    int sum = 0, result = 0;
    for (int i : nums) {
      if (i == 0) {
        result = Math.max(sum, result);
        sum = 0;
      } else {
        sum += 1;
      }
    }
    return Math.max(sum, result);
  }
}