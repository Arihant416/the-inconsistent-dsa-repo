
import java.util.Scanner;

public class Sqrt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextInt();
    System.out.println("SQRT using Binary Search -> " + findSQRT(N));
  }

  static long findSQRT(long N) {
    if (N <= 1)
      return N;
    long low = 1, high = N;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (mid * mid > N) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }
}
