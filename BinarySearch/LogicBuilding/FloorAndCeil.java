
import java.util.Scanner;

public class FloorAndCeil {
  // Class implementation will go here
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int X = sc.nextInt();
    int floor = findFloor(A, N, X);
    int ceil = findCeil(A, N, X);
    System.out.println("Floor is -> " + floor);
    System.out.println("Ceil is -> " + ceil);
  }

  static int findFloor(int[] A, int N, int X) {
    int low = 0, high = N - 1;
    if (A[0] > X)
      return -1;
    if (A[N - 1] < X)
      return A[N - 1];
    int ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == X) {
        return X;
      } else if (A[mid] > X) {
        high = mid - 1;
      } else {
        ans = A[mid];
        low = mid + 1;
      }
    }
    return ans;
  }

  static int findCeil(int[] A, int N, int X) {
    int low = 0, high = N - 1;
    if (X > A[N - 1])
      return -1;
    int ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == X)
        return X;
      else if (A[mid] > X) {
        ans = A[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }
}