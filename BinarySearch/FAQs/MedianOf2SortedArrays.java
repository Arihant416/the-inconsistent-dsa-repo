import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianOf2SortedArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N], B = new int[M];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    for (int j = 0; j < M; j++)
      B[j] = sc.nextInt();
    System.out.println("Median of Two Sorted Arrays " + findMedianBruteForce(A.clone(), B.clone(), N, M));

  }

  public static double findMedianBruteForce(int[] A, int[] B, int N, int M) {
    List<Integer> C = new ArrayList<>();
    int i = 0, j = 0;
    while (i < N && j < M) {
      if (A[i] <= B[j]) {
        C.add(A[i++]);
      } else {
        C.add(B[j++]);
      }
    }
    while (i < N)
      C.add(A[i++]);
    while (j < M)
      C.add(B[j++]);
    int total = N + M;
    double median;
    if (total % 2 == 0) {
      median = (double) (C.get(total / 2) + C.get((total / 2) - 1)) / 2.0;
    } else {
      median = (double) (C.get(total / 2));
    }
    return median;
  }
}
