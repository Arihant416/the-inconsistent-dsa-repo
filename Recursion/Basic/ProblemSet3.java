
import java.util.ArrayList;
import java.util.List;

class ProblemSet3 {
  public static void main(String[] args) {
    int[] A = new int[] { 2, 3, 6, 7, 4, 1 };
    int target = 7;

    printAllCombinationsLeadingToSumTarget(A, target);
    combinationSum2(A, target);
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
    printAllCombinationsWithoutRepeat(A, target, temp, 0);
  }
}