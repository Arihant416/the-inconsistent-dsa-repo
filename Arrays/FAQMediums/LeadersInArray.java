
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class LeadersInArray {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int[] nums = new int[size];
    for(int i = 0 ; i < size; i++)nums[i] = scanner.nextInt();
    int[] res = findLeaders(nums, size);
    printArr(res);
  }

  public static void printArr(int[] nums){
    for(int el: nums){
      System.out.print(el + " ");
    }
    System.out.println();
  }

  private static int[] findLeaders(int[] nums, int N){
    List<Integer> res = new ArrayList<>();
    int curLeader = nums[N-1];
    res.add(curLeader);
    for(int i = N-2; i >=0 ; i--){
      if(nums[i] > curLeader){
        res.add(nums[i]);
        curLeader = nums[i];
      }
    }
    Collections.reverse(res);
    int[] resFinal = new int[res.size()];
    for(int i = 0; i < res.size(); i++){
      resFinal[i] = res.get(i);
    }
    return resFinal;
  }
}