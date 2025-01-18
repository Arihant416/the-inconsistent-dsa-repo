
import java.util.Scanner;

public class BinarySearchOn2DArrays {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), M = sc.nextInt();
    int[][] matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    int target = sc.nextInt();
    System.out.println("Has Element ? -> " + searchInA2DMatrix(matrix, N, M, target));
  }

  static int findRowsWithMaximum1s(int[][] matrix, int N, int M) {
    int maxOnes = 0;
    int maxAt = 0;
    for (int i = 0; i < N; i++) {
      int ans = 0;
      int low = 0, high = M - 1;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (matrix[i][mid] == 1) {
          // Found 1 this could be a potential answer
          ans = mid;
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      int count = M - ans;
      System.out.println("Count for " + i + " , " + count);
      if (count > maxOnes) {
        maxOnes = count;
        maxAt = i;
      }
    }
    return maxAt;
  }

  static boolean searchInA2DMatrix(int[][] matrix, int N, int M, int target) {
    // 2D Matrix is such that rows are sorted and first element of next row is
    // greater than prev one
    int low = 0, high = N - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (matrix[mid][0] == target || matrix[mid][M - 1] == target)
        return true;
      if (matrix[mid][0] > target)
        high = mid - 1;
      else if (matrix[mid][M - 1] < target)
        low = mid + 1;
      else if (matrix[mid][0] <= target && matrix[mid][M - 1] >= target) {
        int l = 0, h = M - 1;
        while (l <= h) {
          int m = (l + h) / 2;
          if (matrix[mid][m] == target)
            return true;
          else if (matrix[mid][m] > target)
            h = m - 1;
          else
            l = m + 1;
        }
        return false;
      }
    }
    return false;
  }
}
