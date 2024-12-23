
import java.util.Scanner;

public class MoveZeros {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nums = new int[N];
    for(int i =0 ; i < N; i++){
      nums[i] = sc.nextInt();
    }
    moveZerosToEnd(nums, N);
    print(nums);
  }

  static void print(int[] nums){
    for(int i: nums){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  static void swap(int[] nums, int index1, int index2){
    int temp = nums[index1];
    nums[index1]=nums[index2];
    nums[index2] = temp;
  }
  static void moveZerosToEnd(int[] nums, int size){
    int currentNonZero = 0;
    for(int i = 0 ;i < size; i++){
      if(nums[i] != 0){
        swap(nums, currentNonZero, i);
        currentNonZero++;
      }
    }
  }
}
