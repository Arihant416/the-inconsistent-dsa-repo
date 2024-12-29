import java.util.HashMap;
import java.util.Scanner;

public class CountSubarraysWithXorK {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    System.out.println("Using Brute Force -> " + subArrayCountBrute(A, N, target));
    System.out.println("Using hashing -> " + subArrayCountOptimal(A, N, target));
  }

  static int subArrayCountBrute(int[] A, int N, int target) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      int xor = 0;
      for (int j = i; j < N; j++) {
        xor ^= A[j];
        if (xor == target) {
          System.out.println("From " + i + " to " + j);
          count++;
        }
      }
    }
    return count;
  }

  static int subArrayCountOptimal(int[] A, int N, int target) {
    HashMap<Integer, Integer> mp = new HashMap<>();
    int count = 0;
    int xor = 0;
    for (int i = 0; i < N; i++) {
      xor ^= A[i];
      if (xor == target)
        count++;
      int rem = xor ^ target;
      if (mp.containsKey(rem)) {
        count += mp.get(rem);
      }
      mp.put(xor, mp.getOrDefault(xor, 0) + 1);
    }
    return count;
  }
}
