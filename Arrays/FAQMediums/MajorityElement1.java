
import java.util.Scanner;

public class MajorityElement1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println("Majority Element is " + findMajorityElement(A, N));
  }

  static int findMajorityElement(int[] nums, int N) {
    int count = 1, num = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num)
        count++;
      else {
        count--;
        if (count <= 0) {
          num = nums[i];
          count = 1;
        }
      }
    }
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num)
        counter++;
    }
    if (counter > (nums.length / 2))
      return num;
    return -1;
  }
}
