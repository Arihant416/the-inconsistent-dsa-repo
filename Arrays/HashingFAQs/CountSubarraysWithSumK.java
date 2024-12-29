
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountSubarraysWithSumK {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    System.out.println("Count using Brute " + findCountUsingBruteForce(A, N, target));
    System.out.println("Count using optimal approach " + findCountOptimal1(A, N, target));
  }

  static int findCountUsingBruteForce(int[] A, int N, int target) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      int sum = 0;
      for (int j = i; j < N; j++) {
        sum += A[j];
        if (sum == target)
          count++;
      }
    }
    return count;
  }

  static void printHashMap(HashMap<Integer, List<Integer>> mp) {
    for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
      Integer key = entry.getKey();
      List<Integer> val = entry.getValue();
      System.out.print("Key is -> " + key + ", Values are -> ");
      for (Integer i : val) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static int findCountOptimal1(int[] A, int N, int target) {
    HashMap<Integer, List<Integer>> mp = new HashMap<>();
    int count = 0;
    int curSum = 0;
    for (int i = 0; i < N; i++) {
      // printHashMap(mp);
      curSum += A[i];
      if (curSum == target)
        count++;
      int rem = curSum - target;
      if (mp.containsKey(rem)) {
        int numberOfOccurrances = mp.get(rem).size();
        count += numberOfOccurrances;
      }
      if (mp.containsKey(curSum)) {
        List<Integer> res = mp.get(curSum);
        res.add(i);
        mp.put(curSum, res);
      } else {
        mp.put(curSum, new ArrayList<>(List.of(i)));
      }
    }
    return count;
  }
}
