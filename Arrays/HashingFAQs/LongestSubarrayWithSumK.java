
import java.util.Scanner;

public class LongestSubarrayWithSumK {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    System.out.println("Brute " + longestSubarrayWithSumKBrute(A, N));
    System.out.println("Slightly Better " + longestSubarrayWithSumKSlightlyBetter(A, N));
  }

  public static int longestSubarrayWithSumKBrute(int[] nums, int target) {
    // Method implementation here
    int longest = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += nums[k];
        }
        if (sum == target)
          longest = Math.max(longest, j - i + 1);
      }
    }
    return longest;
  }

  public static int longestSubarrayWithSumKSlightlyBetter(int[] nums, int target) {
    int longest = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == target) {
          longest = Math.max(longest, j - i + 1);
        }
      }
    }
    return longest;
  }
}