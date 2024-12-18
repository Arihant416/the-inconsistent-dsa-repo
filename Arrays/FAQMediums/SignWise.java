
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SignWise{
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] nums = new int[N];
      for(int i=0; i < N; i++){
        nums[i] = sc.nextInt();
      }
      rearrange(nums, N);
    }
  }

  public static void print(int[] nums){
    for(int i: nums){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void rearrange(int[] nums, int N){
    List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
    for(int i : nums){
      if(i > 0)pos.add(i);
      else neg.add(i);
    }
    int i = 0, p = 0, n = 0;
    while(i < N){
      nums[i] = pos.get(p++);
      nums[i+1] = neg.get(n++);
      i+=2;
    }
    print(nums);
  }
}