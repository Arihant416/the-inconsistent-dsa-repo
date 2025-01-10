
import java.util.PriorityQueue;
import java.util.Scanner;

class MinimizeMaxDistanceToGasStation {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++)
        A[i] = sc.nextInt();
      int k = sc.nextInt();
      System.out.println("Using Brute Force -> " + solveUsingBruteForce(A.clone(), N, k));
      System.out.println("Using Priority Queue -> " + solveUsingPriorityQueue(A.clone(), N, k));
    }
  }

  public static String solveUsingBruteForce(int[] A, int N, int K) {
    int[] placed = new int[N - 1];
    for (int gs = 1; gs <= K; gs++) {
      int maxAt = -1;
      double maxVal = Integer.MIN_VALUE;
      for (int i = 0; i < N - 1; i++) {
        double diff = (double) (A[i + 1] - A[i]);
        double sectionLength = diff / (double) (placed[i] + 1);
        if (maxVal < sectionLength) {
          maxVal = sectionLength;
          maxAt = i;
        }
      }
      placed[maxAt]++;
    }
    double ans = -1;
    for (int i = 0; i < N - 1; i++) {
      double diff = (double) (A[i + 1] - A[i]);
      double section = diff / (double) (placed[i] + 1);
      ans = Math.max(ans, section);
    }
    return Double.toString(ans);
  }

  public static double solveUsingPriorityQueue(int[] A, int N, int K) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> Double.compare(b.sectionLength, a.sectionLength));
    int[] placed = new int[N - 1];
    // Place current difference in pq
    for (int i = 0; i < N - 1; i++) {
      pq.add(new Pair(A[i + 1] - A[i], i));
    }
    for (int gs = 1; gs <= K; gs++) {
      Pair p = pq.poll();
      int index = p.index;
      placed[index]++;
      double initialLength = (double) (A[index + 1] - A[index]);
      double newSectionLength = initialLength / (double) (placed[index] + 1);
      pq.add(new Pair(newSectionLength, index));
    }
    return pq.peek().sectionLength;
  }

  private static class Pair {
    double sectionLength;
    int index;

    Pair(double sectionLength, int index) {
      this.sectionLength = sectionLength;
      this.index = index;
    }
  }
}