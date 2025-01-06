
import java.util.Scanner;

class BookAllocation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    int students = sc.nextInt();
    System.out.println("Max Min Allocation -> " + minAllocation(A, N, students));
  }

  public static int findStudentsAllocated(int[] A, int pageCount) {
    int count = 1;
    int pages = 0;
    for (int i = 0; i < A.length; i++) {
      if (pages + A[i] <= pageCount) {
        pages += A[i];
      } else {
        count++;
        pages = A[i];
      }
    }
    return count;
  }

  public static int minAllocation(int[] A, int N, int students) {
    if (N < students)
      return -1;
    int low = Integer.MIN_VALUE;
    int high = 0;
    for (int i : A) {
      low = Math.max(low, i);
      high += i;
    }

    while (low <= high) {
      int mid = (low + (high - low) / 2);
      int allocatedCount = findStudentsAllocated(A, mid);
      if (allocatedCount > students) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }
}