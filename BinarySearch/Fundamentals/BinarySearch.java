import java.util.Scanner;

class BinarySearch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    System.out.println("Index Iterative Binary Search -> " + findUsingIteration(A, N, target));
    System.out.println("Index Recursive Binary Search -> " + findUsingRecursion(A, N, target));
  }

  static int findUsingIteration(int[] A, int N, int target) {
    int low = 0, high = N - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target)
        return mid;
      else if (A[mid] > target)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  static int binarySearchRecursion(int[] A, int low, int high, int target) {
    if (low > high)
      return -1;
    int mid = low + (high - low) / 2;
    if (A[mid] == target)
      return mid;
    else if (A[mid] > target)
      return binarySearchRecursion(A, low, mid - 1, target);
    else
      return binarySearchRecursion(A, mid + 1, high, target);
  }

  static int findUsingRecursion(int[] A, int N, int target) {
    return binarySearchRecursion(A, 0, N - 1, target);
  }
}