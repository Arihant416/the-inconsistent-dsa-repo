import java.util.Scanner;

class FirstAndLastOccurrance {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
      }
      int target = scanner.nextInt();
      int[] range = findRange(array, n, target);
      System.out.println("Range is -> " + range[0] + " " + range[1]);
    }
  }

  public static int[] findRange(int[] A, int N, int target) {
    int low = 0, high = N - 1;
    int start = -1, end = -1;
    // First find lower bound of target
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target) {
        start = mid;
        high = mid - 1;
      } else if (A[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    // Reset low and high to find upper bound (or create a separate function)
    low = 0;
    high = N - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target) {
        end = mid;
        low = mid + 1;
      } else if (A[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return new int[] { start, end };
  }
}