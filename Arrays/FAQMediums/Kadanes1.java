import java.util.Scanner;

class Kadanes1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println(findMaxSumOfSubArray(A, N));
  }

  static int findMaxSumOfSubArray(int[] A, int N) {
    int sum = Integer.MIN_VALUE;
    int curMaxSum = 0;
    for (int i = 0; i < A.length; i++) {
      curMaxSum = Math.max(A[i], curMaxSum + A[i]);
      sum = Math.max(sum, curMaxSum);
    }
    return sum;
  }
}