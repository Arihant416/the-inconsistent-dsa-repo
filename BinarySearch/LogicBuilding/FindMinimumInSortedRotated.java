import java.util.Scanner;

public class FindMinimumInSortedRotated {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
      }
      int minElement = findMin(array, n);
      System.out.println("Min element is -> " + minElement);
    }
  }

  public static int findMin(int[] A, int N) {
    int low = 0, high = N - 1;
    int ans = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[low] <= A[mid]) {
        ans = Math.min(A[low], ans);
        low = mid + 1;
      } else {
        ans = Math.min(A[mid], ans);
        high = mid - 1;
      }
    }
    return ans;
  }
}
