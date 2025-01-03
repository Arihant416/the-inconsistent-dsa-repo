import java.util.Scanner;

class KokoEatingBananas {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      int totalTime = sc.nextInt();
      System.out.println("minEatingRequired -> " + findMinimumBananasToEatPerHour(A, N, totalTime));
    }
  }

  public static int findTimeTaken(int[] bananas, int K) {
    int totalTime = 0;
    for (int i : bananas) {
      totalTime += Math.ceil((float) i / (float) K);
    }
    return totalTime;
  }

  public static int findMinimumBananasToEatPerHour(int[] bananaPiles, int N, int totalTime) {
    int maxBananasPossible = 0;
    for (int i : bananaPiles) {
      maxBananasPossible = Math.max(maxBananasPossible, i);
    }
    int low = 1, high = maxBananasPossible;
    while (low <= high) {
      int bananas = low + (high - low) / 2;
      // System.out.println("Low " + low + ", High " + high + " CurrentBananas " + bananas);
      int timeToEat = findTimeTaken(bananaPiles, bananas);
      // System.out.println("TimeTo Eat " + timeToEat);
      if (timeToEat <= totalTime) {
        high = bananas - 1;
      } else {
        low = bananas + 1;
      }
    }
    return low;
  }
}