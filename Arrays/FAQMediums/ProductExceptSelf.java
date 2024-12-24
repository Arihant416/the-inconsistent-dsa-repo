
import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] nums = new int[N];
      for (int i = 0; i < N; i++) {
        nums[i] = sc.nextInt();
      }
      int[] res = findProductExceptSelf(nums, N);
      for (int el : res) {
        System.out.print(el + " ");
      }
      int[] res2 = findProductExceptSelfOptimised(nums, N);
      for(int el: res2){
        System.out.print(el + " ");
      }
    }
  }

  static int[] findProductExceptSelf(int[] nums, int N) {
    int[] res = new int[N];
    // This method is using prefix and suffix arrays
    int[] prefix = new int[N];
    int[] suffix = new int[N];
    prefix[0] = nums[0];
    suffix[N - 1] = nums[N - 1];
    for (int i = 1; i < N; i++) {
      prefix[i] = prefix[i - 1] * nums[i];
    }
    for (int i = N - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i];
    }
    res[0] = suffix[1];
    res[N - 1] = prefix[N - 2];
    for (int i = 1; i < N - 1; i++) {
      res[i] = prefix[i - 1] * suffix[i + 1];
    }
    return res;
  }

  static int[] findProductExceptSelfOptimised(int[] nums, int N){
    int[] res = new int[N];
    Arrays.fill(res, 1);
    int curr = 1;
    for(int i = 0 ; i < N; i++){
      res[i] *= curr;
      curr*= nums[i];
    }

    curr = 1;
    for(int i = N-1; i>= 0; i--){
      res[i] *= curr;
      curr *= nums[i]; 
    }
    return res;
  }
}
