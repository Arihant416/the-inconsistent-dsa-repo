import java.util.Scanner;

public class LowerBound {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    int target = sc.nextInt();
    System.out.println("Lower bound is -> " + findLowerBound(A, N, target));
  }

  static int findLowerBound(int[] A, int N, int target) {
    int low = 0, high = N-1;
    while(low <= high){
      int mid = low + (high-low)/2;
      if(A[mid] >= target){
        high = mid-1;
      }else{
        low = mid+1;
      }
    }
    return low;
  }
}
