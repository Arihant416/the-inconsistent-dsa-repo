
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProblemSet3 {
  public static void main(String[] args) {
    int[] A = new int[] { 2, 1 };
    int target = 2;
    // generateParanthesis(target);
    subsetSums(A);
    // printAllCombinationsLeadingToSumTarget(A, target);
    // combinationSum2(A, target);
  }

  static void recur(int N, String s, int openCount, int closeCount, List<String> res) {
    if (openCount > N || closeCount > N)
      return;
    if ((openCount + closeCount == 2 * N) && openCount == closeCount) {
      res.add(s);
      return;
    }
    if (openCount < N) {
      recur(N, s + '(', openCount + 1, closeCount, res);
    }
    if (closeCount < openCount) {
      recur(N, s + ")", openCount, closeCount + 1, res);
    }
  }

  static void generateParanthesis(int N) {
    if (N == 0) {
      System.out.println("N is 0 -> No Paranthesis generated");
    } else {
      String s = "";
      List<String> res = new ArrayList<>();
      recur(N, s, 0, 0, res);
      for (String d : res)
        System.out.println(d);
    }
  }

  static void printAllCombinations(int[] A, int target, List<Integer> temp, int index) {
    if (index == A.length) {
      if (target == 0)
        System.out.println(temp.toString());
      return;
    }
    if (A[index] <= target) {
      temp.add(A[index]);
      printAllCombinations(A, target - A[index], temp, index);
      temp.remove(temp.size() - 1);
    }
    printAllCombinations(A, target, temp, index + 1);
  }

  static void printAllCombinationsLeadingToSumTarget(int[] A, int target) {
    System.out.println("Combination Sum 1: All possible sums");
    List<Integer> temp = new ArrayList<>();
    printAllCombinations(A, target, temp, 0);
  }

  static void printAllCombinationsWithoutRepeat(int[] A, int target, List<Integer> temp, int index) {
    if (target == 0) {
      System.out.println(temp.toString());
      return;
    }
    if (index >= A.length || target < 0)
      return;
    for (int j = index; j < A.length; j++) {
      if (j > index && A[j] == A[j - 1]) {
        continue;
      }
      temp.add(A[j]);
      printAllCombinationsWithoutRepeat(A, target - A[j], temp, j + 1);
      temp.remove(temp.size() - 1);
    }
  }

  static void combinationSum2(int[] A, int target) {
    // Do not repeat any elements
    System.out.println("Combination Sum 2 -> Unique Sums ");
    List<Integer> temp = new ArrayList<>();
    Arrays.sort(A);
    printAllCombinationsWithoutRepeat(A, target, temp, 0);
  }

  static void recursivelyFindAllSubsetSums(int[] nums, int sum, int index, List<Integer> ds) {
    if (index == nums.length) {
      ds.add(sum);
      return;
    }
    recursivelyFindAllSubsetSums(nums, sum + nums[index], index + 1, ds);
    recursivelyFindAllSubsetSums(nums, sum, index + 1, ds);
  }

  static void subsetSums(int[] nums) {
    List<Integer> res = new ArrayList<>();
    recursivelyFindAllSubsetSums(nums, 0, 0, res);
    System.out.println("subsetSums -> " + res.toString());
  }
}