import java.util.Arrays;
import java.util.Scanner;

class AggressiveCows {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] stalls = new int[N];
    for (int i = 0; i < N; i++) {
      stalls[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    System.out.println("Max Possible Minimum Distance -> " + findMinDistance(stalls, N, k));
  }

  public static boolean isValidDistance(int reach, int[] A, int N, int K) {
    int lastPlaced = A[0], count = 1;
    for (int i = 1; i < N; i++) {
      if (A[i] - lastPlaced >= reach) {
        count++;
        lastPlaced = A[i];
      }
      if (count >= K)
        return true;
    }
    return false;
  }

  public static int findMinDistance(int[] A, int N, int K) {
    Arrays.sort(A);
    int low = 1, high = A[N - 1] - A[0];
    while (low <= high) {
      int curDistance = low + (high - low) / 2;
      if (isValidDistance(curDistance, A, N, K)) {
        low = curDistance + 1;
      } else {
        high = curDistance - 1;
      }
    }
    return high;
  }
}