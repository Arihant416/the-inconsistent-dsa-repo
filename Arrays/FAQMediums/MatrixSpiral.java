import java.util.Scanner;

class MatrixSpiral {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    printSpiral(matrix, N, M);
  }

  static void printSpiral(int[][] matrix, int N, int M) {
    int top = 0, left = 0, right = M - 1, bottom = N - 1;
    while (top <= bottom && left <= right) {
      for (int i = left; i <= right; i++) {
        System.out.print(matrix[top][i] + " ");
      }
      top++;
      System.out.println();
      for (int i = top; i <= bottom; i++) {
        System.out.print(matrix[i][right] + " ");
      }
      right--;
      if (top <= bottom) {
        System.out.println();
        for (int i = right; i >= left; i--) {
          System.out.print(matrix[bottom][i] + " ");
        }
        bottom--;
      }
      if (left <= right) {
        System.out.println();
        for (int i = bottom; i >= top; i--) {
          System.out.print(matrix[i][left] + " ");
        }
        left++;
      }
    }
  }
}