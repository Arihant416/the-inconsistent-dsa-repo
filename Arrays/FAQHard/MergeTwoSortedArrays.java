
import java.util.Scanner;

public class MergeTwoSortedArrays {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt(), M = sc.nextInt();
      int[] A = new int[N], B = new int[M];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      for (int j = 0; j < M; j++) {
        B[j] = sc.nextInt();
      }
      int[] res = mergeTwoSortedArrays(A, B, N, M);
      for (int i : res) {
        System.out.print(i + " ");
      }
    }
  }

  public static int[] mergeTwoSortedArrays(int[] A, int[] B, int N, int M) {
    int[] res = new int[N + M];
    int len = N + M - 1, i = N - 1, j = M - 1;
    while (i >= 0 && j >= 0) {
      if (A[i] >= B[j]) {
        res[len--] = A[i--];
      } else {
        res[len--] = B[j--];
      }
    }
    while (i >= 0) {
      res[len--] = A[i--];
    }
    while (j >= 0) {
      res[len--] = B[j--];
    }
    return res;
  }
}
