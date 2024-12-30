import java.util.Scanner;

public class SearchInSortedRotated2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    int target = sc.nextInt();
    System.out.println("Target exists ? " + findTarget(A, N, target));
  }

  static boolean findTarget(int[] A, int N, int target) {
    int low = 0, high = N - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target)
        return true;
      if (A[low] == target || A[high] == target)
        return true;
      if (A[mid] == A[low] && A[mid] == A[high]) {
        high--;
        low++;
        continue;
      }
      if (A[low] <= A[mid]) {
        if (A[low] <= target && target <= A[mid])
          high = mid - 1;
        else
          low = mid + 1;
      } else {
        if (A[mid] <= target && target <= A[high])
          low = mid + 1;
        else
          high = mid - 1;
      }
    }
    return false;
  }
}
