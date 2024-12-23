import java.util.Scanner;

public class RotateMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] matrix = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    rotateClockWise90Degree(matrix, N);
    print(matrix, N);
  }

  static void print(int[][] matrix, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void transpose(int[][] matrix, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i > j) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }
  }

  static void rotateClockWise90Degree(int[][] matrix, int N) {
    transpose(matrix, N);
    for (int i = 0; i < N; i++) {
      int from = 0, to = N - 1;
      while (from < to) {
        int temp = matrix[i][from];
        matrix[i][from] = matrix[i][to];
        matrix[i][to] = temp;
        from++;
        to--;
      }
    }
  }
}
