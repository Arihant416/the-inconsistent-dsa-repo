
import java.util.Scanner;

class NthRoot {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextInt();
    long M = sc.nextInt();
    System.out.println("Nth root of M is -> " + findNthRoot(N, M));
  }

  static long findPowerN(long mid, long N, long M) {
    long ans = 1;
    while (N > 0 && ans <= M) {
      ans *= mid;
      N--;
    }
    return ans;
  }

  static long findNthRoot(long N, long M) {
    if (M == 1)
      return 1;
    long low = 1, high = M;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      long midPowerN = findPowerN(mid, N, M);
      if (midPowerN > M) {
        high = mid - 1;
      } else if (midPowerN == M)
        return mid;
      else
        low = mid + 1;
    }
    return -1;
  }
}