
import java.util.Scanner;

public class MaximumProductSubArray {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      System.out.println("Max Product SubArray " + maxProduct(A, N));
    }
  }

  static int maxProduct(int[] A, int N) {
    int prefix = 1;
    int suffix = 1;
    int maxProduct = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      if (prefix == 0)
        prefix = 1;
      if (suffix == 0)
        suffix = 1;
      prefix *= A[i];
      suffix *= A[N - i - 1];
      maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
    }
    return maxProduct;
  }
}
