import java.util.Scanner;

class LinearSearch{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] nums = new int[N];
    for(int i = 0 ; i < N; i++){
      nums[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    System.out.println("Index of target " + findIndex(nums, N, target));
  }

  public static int findIndex(int[] nums, int N, int target){
    for(int i =0 ;i < N; i++){
      if(nums[i] == target)return i;
    }
    return -1;
  }
}