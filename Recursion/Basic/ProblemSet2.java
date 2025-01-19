import java.util.ArrayList;
import java.util.List;

class ProblemSet2 {
  public static void main(String[] args) {
    int[] A = new int[] { 3, 1, 2 };
    printAllSubsequences(A);
  }

  static void printAllSubsequencesHelper(int[] A, List<Integer> curList, int index) {
    if (index >= A.length) {
      for (Integer i : curList) {
        System.out.print(i + " ");
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
    printAllSubsequencesHelper(A, curList, 0);
  }
}