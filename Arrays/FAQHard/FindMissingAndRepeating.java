import java.util.Scanner;

public class FindMissingAndRepeating {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {

      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      int[] res = findMissingAndRepeating(A, N);
      System.out.println(res[0] + " " + res[1]);
    }
  }

  private static int[] findMissingAndRepeating(int[] A, int N) {
    int repeating = -1, missing = -1;
    for (int i = 0; i < N; i++) {
      int index = Math.abs(A[i]) - 1;
      if (A[index] < 0) {
        repeating = index + 1;
      }
      A[index] = -1 * A[index];
    }
    for (int i = 0; i < N; i++) {
      if (A[i] > 0 && A[i] != repeating) {
        missing = i + 1;
      }
    }
    return new int[] { repeating, missing };
  }
}
