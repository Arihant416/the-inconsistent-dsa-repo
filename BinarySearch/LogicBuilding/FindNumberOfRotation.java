
import java.util.Scanner;

public class FindNumberOfRotation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println("Number of rotation is -> " + countOfRotation(A, N));
  }

  static int countOfRotation(int[] A, int N) {
    int low = 0, high = N - 1;
    int ans = Integer.MAX_VALUE, index = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[low] <= A[mid]) {
        if (A[low] < ans) {
          index = low;
          ans = A[low];
        }
        low = mid + 1;
      } else {
        if (A[mid] < ans) {
          ans = A[mid];
          index = mid;
        }
      }
    }
    return index;
  }
}
