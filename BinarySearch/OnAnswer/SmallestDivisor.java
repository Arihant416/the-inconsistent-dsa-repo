
import java.util.Scanner;

public class SmallestDivisor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    int limit = sc.nextInt();
    System.out.println(" Smallest Divisor is -> " + findSmallestDivisor(A, N, limit));
  }

  static int findDivisionSum(int[] A, int divider) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += Math.ceil((double) A[i] / (double) divider);
    }
    return sum;
  }

  public static int findSmallestDivisor(int[] A, int N, int limit) {
    int maxRange = Integer.MIN_VALUE;
    for (int i : A)
      maxRange = Math.max(maxRange, i);
    int low = 1, high = maxRange;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int result = findDivisionSum(A, mid);
      if (result <= limit) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
