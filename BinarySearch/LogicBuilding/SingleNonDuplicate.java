
import java.util.Scanner;

class SingleNonDuplicate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println("Single element is -> " + findSingleNonDuplicate(A, N));
  }

  private static int findSingleNonDuplicate(int[] A, int N) {
    if (N == 1)
      return A[0];
    if (A[0] != A[1])
      return A[0];
    if (A[N - 1] != A[N - 2])
      return A[N - 1];
    int low = 1, high = N - 2;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] != A[mid + 1] && A[mid] != A[mid - 1])
        return A[mid];
      if ((mid % 2 == 1 && A[mid] == A[mid - 1]) || (mid % 2 == 0 && A[mid] == A[mid + 1])) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}