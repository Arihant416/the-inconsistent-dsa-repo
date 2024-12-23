import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSum {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] nums = new int[N];
      for (int i = 0; i < N; i++) {
        nums[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      findQuadrupletsSumToTarget(nums, N, target);
    }
  }

  static void print(List<List<Integer>> res) {
    for (List<Integer> li : res) {
      for (int i : li) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  static void findQuadrupletsSumToTarget(int[] nums, int N, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (N < 4) {
      print(res);
      return;
    }
    Arrays.sort(nums);
    for (int i = 0; i < N; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < N; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        int k = j + 1;
        int l = N - 1;
        while (k < l) {
          int sum = nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            while (k < l && nums[k] == nums[k + 1])
              k++;
            while (k < l && nums[l] == nums[l - 1])
              l--;
            k++;
            l--;
          } else if (sum > target) {
            l--;
          } else {
            k++;
          }
        }
      }
    }
    print(res);
  }
}
