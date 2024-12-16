
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Intersection {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), M = sc.nextInt();
    int[] A = new int[N], B = new int[M];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }
    for (int i = 0; i < M; i++) {
      B[i] = sc.nextInt();
    }
    List<Integer> result = findIntersection(A, B, N, M);
    result.forEach(el -> System.out.print(el + " "));
  }

  private static List<Integer> findIntersection(int[] A, int[] B, int N, int M){
    List<Integer> result = new ArrayList<>();
    int i =0, j = 0;
    while(i < N && j < M){
      if(A[i] == B[j]){
        result.add(A[i]);
        i++;
        j++;
      }else if(A[i] < B[j]){
        i++;
      }else{
        j++;
      }
    }
    return result;
  }
}