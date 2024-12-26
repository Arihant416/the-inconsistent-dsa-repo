import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountInversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int inversions = countInversion(A, N);
    System.out.println("Number of Inversions required " + inversions);
  }

  public static int countInversion(int[] A, int N) {
    return mergeSort(A, 0, N - 1);
  }

  static void print(int[] A, int low, int high) {
    System.out.println("Printing from " + low + " to " + high);
    for (int i=low; i <= high; i++) {
      System.out.print(A[i] + " ");
    }
    System.out.println();
  }

  public static int mergeSort(int[] A, int low, int high) {
    print(A, low, high);
    int count = 0;
    if (low < high) {
      int mid = (low + (high - low) / 2);
      count += mergeSort(A, low, mid);
      count += mergeSort(A, mid + 1, high);
      count += merge(A, low, mid, high);
    }
    return count;
  }

  public static int merge(int[] A, int low, int mid, int high) {
    System.out.print("Merge -> ");
    print(A, low, high);
    int count = 0;
    int left = low, right = mid + 1;
    List<Integer> temp = new ArrayList<>();
    while (left <= mid && right <= high) {
      if (A[left] <= A[right]) {
        temp.add(A[left++]);
      } else {
        count += (mid - left) + 1;
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
    return count;
  }
}
