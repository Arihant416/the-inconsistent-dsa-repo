import java.util.Scanner;

public class PeakElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    int peak = findPeakElement(A, N);
    if (peak == -1) {
      System.out.println("No Peak Found");
    } else {
      System.out.println("A peak element in the array is -> " + peak);
    }
  }

  public static int findPeakElement(int[] A, int N) {
    if (N == 1)
      return A[0];
    if (A[0] > A[1])
      return A[0];
    if (A[N - 1] > A[N - 2])
      return A[N - 1];
    int low = 1, high = N - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1])
        return A[mid];
      else if (A[mid] < A[mid - 1])
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }
}
