import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] nums = new int[N];
      for(int i = 0; i < N; i++){
        nums[i] = sc.nextInt();
      }
      findTripletsSumTo0(nums, N);
    }
  }

  static void findTripletsSumTo0(int[] nums, int N) {
    if (N < 3) {
      System.out.println("No Items to print");
      return;
    }
    Arrays.sort(nums);
    for (int i = 0; i < N; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int j = i + 1, k = N - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
          while (j < k && nums[j] == nums[j + 1])
            j++;
          while (j < k && nums[k] == nums[k - 1])
            k--;
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
  }
}
