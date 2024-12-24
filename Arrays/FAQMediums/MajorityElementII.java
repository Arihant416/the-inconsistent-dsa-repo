import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElementII {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    print(findMajorityElement2(A, N));
  }

  static void print(List<Integer> res) {
    for (int el : res) {
      System.out.print(el + " ");
    }
  }

  static List<Integer> findMajorityElement2(int[] nums, int N) {
    int countElement1 = 0, countElement2 = 0, element1 = Integer.MIN_VALUE, element2 = Integer.MAX_VALUE;
    for (int el : nums) {
      if (countElement1 == 0 && el != element2) {
        element1 = el;
        countElement1 = 1;
      } else if (countElement2 == 0 && element1 != el) {
        element2 = el;
        countElement2 = 1;
      } else if (el == element1)
        countElement1++;
      else if (el == element2)
        countElement2++;
      else {
        countElement1--;
        countElement2--;
      }
    }
    countElement1 = 0;
    countElement2 = 0;
    for (int el : nums) {
      if (el == element1)
        countElement1++;
      if (el == element2)
        countElement2++;
    }
    List<Integer> res = new ArrayList<>();
    if (countElement1 > (N / 3))
      res.add(element1);
    if (countElement2 > (N / 3))
      res.add(element2);
    return res;
  }
}
