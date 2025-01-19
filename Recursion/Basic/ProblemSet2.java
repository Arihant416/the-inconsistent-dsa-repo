import java.util.ArrayList;
import java.util.List;

class ProblemSet2 {

  public static void main(String[] args) {
    int[] A = new int[] { 1, 2, 3, 4 };
    int sum = 4;
    printAllSubsequences(A);
    printSubsequencesWhoseSumIsK(A, sum);
    printAnyOneSubsequenceWithSumK(A, sum);
  }

  static void printAllSubsequencesHelper(int[] A, List<Integer> curList, int index) {
    if (index >= A.length) {
      if (curList.isEmpty()) {
        System.out.println("{}");
      } else {
        for (Integer i : curList) {
          System.out.print(i + " ");
        }
      }
      System.out.println();
      return;
    }
    curList.add(A[index]);
    printAllSubsequencesHelper(A, curList, index + 1);
    curList.removeLast();
    printAllSubsequencesHelper(A, curList, index + 1);
  }

  static void printAllSubsequences(int[] A) {
    List<Integer> curList = new ArrayList<>();
    System.out.println("All Subsequences: ");
    printAllSubsequencesHelper(A, curList, 0);
  }

  static void subsequencesWithSumK(int[] A, int sum, List<Integer> curList, int curSum, int index) {
    if (index >= A.length) {
      if (curSum == sum) {
        for (Integer i : curList) {
          System.out.print(i + " ");
        }
        System.out.println();
      }
      return;
    }
    curSum += A[index];
    curList.add(A[index]);
    subsequencesWithSumK(A, sum, curList, curSum, index + 1);
    curSum -= A[index];
    curList.removeLast();
    subsequencesWithSumK(A, sum, curList, curSum, index + 1);
  }

  static void printSubsequencesWhoseSumIsK(int[] A, int sum) {
    List<Integer> curList = new ArrayList<>();
    System.out.println("Subsequences with sum K : ");
    subsequencesWithSumK(A, sum, curList, 0, 0);
  }

  static boolean anyOneSubsequenceWithSumK(int[] A, int sum, List<Integer> curList, int index) {
    if (index == A.length) {
      return sum == 0;
    }
    sum -= A[index];
    curList.add(A[index]);
    if (anyOneSubsequenceWithSumK(A, sum, curList, index + 1)) {
      return true;
    }
    curList.remove(curList.size() - 1);
    sum += A[index];
    return (anyOneSubsequenceWithSumK(A, sum, curList, index + 1));
  }

  static void printAnyOneSubsequenceWithSumK(int[] A, int sum) {
    List<Integer> curList = new ArrayList<>();
    if (anyOneSubsequenceWithSumK(A, sum, curList, 0))
      System.out.println("Found one subsequence " + curList.toString());
    else
      System.out.println("Not found any one subsequence with sum k");
  }
}