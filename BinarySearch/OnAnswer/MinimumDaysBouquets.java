import java.util.Scanner;

class MinimumDaysBouquets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int roses = sc.nextInt();
    int[] nums = new int[roses];
    for (int i = 0; i < roses; i++) {
      nums[i] = sc.nextInt();
    }
    int M = sc.nextInt();
    int K = sc.nextInt();
    System.out.println("Minimum Days to make at least m bouquets each with k roses " + findMinDays(nums, roses, M, K));
  }

  static int findMinDays(int[] A, int N, int M, int K) {
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for (int i : A) {
      low = Math.min(i, low);
      high = Math.max(i, high);
    }
    if (K * M > N)
      return -1;
    int ans = -1;
    while (low <= high) {
      int days = low + (high - low) / 2;
      int bouquets = findNumberOfDaysForX(A, days, K);
      if (bouquets >= M) {
        ans = days;
        high = days - 1;
      } else {
        low = days + 1;
      }
    }
    return ans;
  }

  private static int findNumberOfDaysForX(int[] A, int days, int K) {
    int count = 0;
    int cur = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] <= days) {
        cur += 1;
      } else {
        count += (cur / K);
        cur = 0;
      }
      // System.out.println("For i " + i + " A[i] " + A[i] + " cur -> " + cur);
    }
    count += (cur / K);
    return count;
  }
}