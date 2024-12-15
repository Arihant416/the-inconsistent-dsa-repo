import java.util.Scanner;

class FindMissingNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] nums = new int[size];
    for (int i = 0; i < size; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println(findMissingNumberWay1(nums, size));
    System.out.println(findMissingNumberWay2(nums, size));
  }

  private static void print(int[] nums) {
    for (int el : nums)
      System.out.print(el + " ");
    System.out.println();
  }

  private static int findMissingNumberWay1(int[] nums, int N){
    // Way 1 is using Sum of N numbers technique
    int sumOfN = (N*(N+1))/2;
    int sumNums = 0;
    for(int el: nums){
      sumNums += el;
    }
    return sumOfN - sumNums;
  }

  private static int findMissingNumberWay2(int[] nums, int N){
    int xorOfN = 0;
    int xorOfNums = 0;
    for(int i = 0; i < N; i++){
      xorOfN ^= (i+1);
      xorOfNums ^= nums[i];
    }
    return xorOfNums ^ xorOfN;
  }
}
