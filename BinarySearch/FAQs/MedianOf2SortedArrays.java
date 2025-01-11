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
    System.out.println("Median of two sorted Arrays using Binary Search " + findMedianUsingBinarySearch(A, B, N, M));
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

  public static double findMedianUsingBinarySearch(int[] A, int[] B, int N, int M) {
    if (N < M) {
      return findMedianUsingBinarySearch(B, A, M, N);
    }
    int total = N + M;
    int low = 0, high = N;
    int left = (total + 1) / 2;
    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = left - mid1;
      int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
      int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
      if (mid1 < N)
        r1 = A[mid1];
      if (mid2 < M)
        r2 = B[mid2];
      if (mid1 - 1 >= 0)
        l1 = A[mid1 - 1];
      if (mid2 - 1 >= 0)
        l2 = B[mid2 - 1];
      if (l1 <= r2 && l2 <= r1) {
        if (total % 2 == 1)
          return Math.max(l1, l2);
        return ((double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
      } else if (l1 > r2)
        high = mid1 - 1;
      else
        low = mid1 + 1;
    }
    return 0;
  }
}
