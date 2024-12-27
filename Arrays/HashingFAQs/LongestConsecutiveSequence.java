
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = sc.nextInt();
    }
    int longestConsecutiveSequenceLength = findLongestConsecutiveSequence(nums, N);
    System.out.println(longestConsecutiveSequenceLength);
  }

  static int findLongestConsecutiveSequence(int[] A, int N) {
    int maxLength = 1;
    Set<Integer> linkedSet = new LinkedHashSet<>();
    for (int i : A) {
      linkedSet.add(i);
    }
    for (int i : linkedSet) {
      if (!linkedSet.contains(i - 1)) {
        int count = 1;
        int x = i;
        while (linkedSet.contains(x + 1)) {
          x = x + 1;
          count += 1;
        }
        maxLength = Math.max(maxLength, count);
      }
    }
    return maxLength;
  }

}