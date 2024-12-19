
import java.util.HashMap;
import java.util.Scanner;

class TwoSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    int targetSum = sc.nextInt();
    print(twoSum(arr, N, targetSum));
  }

  static void print(int[] nums) {
    // for (ArrayList<Integer> i : nums) {
      for (int j : nums) {
        System.out.print(j + " ");
      }
      System.out.println();
    // }
  }

  static int[] twoSum(int[] nums, int N, int target){
    HashMap<Integer, Integer> mp = new HashMap<>();
    for(int i = 0 ; i < N; i++){
      int diff = target - nums[i];
      if(mp.containsKey(diff)){
        return new int[]{mp.get(diff), i};
      }
      mp.put(nums[i], i);
    }
    return new int[0];
  }
}