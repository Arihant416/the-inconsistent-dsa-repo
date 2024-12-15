
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Union {
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
    List<Integer> result = findUnion(A, B, N, M);
    result.forEach(el -> System.out.print(el + " "));
  }

  private static List<Integer> findUnion(int[] A, int[] B, int N, int M) {
    List<Integer> res = new ArrayList<>();
    int i = 0, j = 0;
    while( i < N && j < M){
      if(A[i] <= B[j]){
        if(res.isEmpty() || res.get(res.size()-1) != A[i]){
          res.add(A[i]);
        }
        i++;
      }else{
        if(res.isEmpty() || res.get(res.size() - 1) != B[j]){
          res.add(B[j]);
        }
        j++;
      }
    }
    while(i < N){
      if (res.isEmpty() || res.get(res.size() - 1) != A[i]) {
        res.add(A[i]);
      }
      i++;
    }
    while(j < M){
      if (res.isEmpty() || res.get(res.size() - 1) != B[j]) {
        res.add(B[j]);
      }
      j++;
    }
    return res;
  }

}