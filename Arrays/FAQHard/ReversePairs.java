import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int inversions = countReversePairs(A, N);
    System.out.println("Number of ReversePairs " + inversions);
  }

  public static int countReversePairs(int[] A, int N) {
    return mergeSort(A, 0, N - 1);
  }

  // static void print(int[] A, int low, int high) {
  //   // System.out.println("Printing from " + low + " to " + high);
  //   for (int i = low; i <= high; i++) {
  //     System.out.print(A[i] + " ");
  //   }
  //   System.out.println();
  // }

  public static int countPairs(int[] A, int low, int mid, int high) {
    int right = mid + 1;

    int count = 0;
    for (int i = low; i <= mid; i++) {
      while (right <= high && A[i] > 2 * A[right])
        right++;
      count += (right - (mid + 1));
    }
    return count;
  }

  public static int mergeSort(int[] A, int low, int high) {
    // print(A, low, high);
    int count = 0;
    if (low < high) {
      int mid = (low + (high - low) / 2);
      count += mergeSort(A, low, mid);
      count += mergeSort(A, mid + 1, high);
      count += countPairs(A, low, mid, high);
      merge(A, low, mid, high);
    }
    return count;
  }

  public static void merge(int[] A, int low, int mid, int high) {
    // System.out.print("Merge -> ");
    // print(A, low, high);
    int left = low, right = mid + 1;
    List<Integer> temp = new ArrayList<>();
    while (left <= mid && right <= high) {
      if (A[left] <= A[right]) {
        temp.add(A[left++]);
      } else {
        temp.add(A[right++]);
      }
    }
    while (left <= mid) {
      temp.add(A[left++]);
    }
    while (right <= high) {
      temp.add(A[right++]);
    }
    for (int i = low; i <= high; i++) {
      A[i] = temp.get(i - low);
    }
  }
}
