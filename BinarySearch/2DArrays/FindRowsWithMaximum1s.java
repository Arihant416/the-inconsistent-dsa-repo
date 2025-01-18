
import java.util.Scanner;

public class FindRowsWithMaximum1s {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), M = sc.nextInt();
    int[][] matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    System.out.println("Row index with Max ones is -> " + findRowsWithMaximum1s(matrix, N, M));
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
}
