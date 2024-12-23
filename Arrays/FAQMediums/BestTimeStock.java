
import java.util.Scanner;

public class BestTimeStock {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] prices = new int[N];
      for (int i = 0; i < N; i++) {
        prices[i] = sc.nextInt();
      }

      System.out.println(
          "Max Profit With Single Transaction " + findMaxProfitWithOneTransaction(prices, N));
    }
  }

  static int findMaxProfitWithOneTransaction(int[] prices, int N) {
    int minBuy = prices[0];
    int maxProfit = 0;
    for (int i = 0; i < N; i++) {
      if (prices[i] < minBuy) {
        minBuy = prices[i];
      } else {
        maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      }
    }
    return maxProfit;
  }
}
