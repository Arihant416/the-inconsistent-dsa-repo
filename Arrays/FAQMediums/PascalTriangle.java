import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PascalTriangle {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      printPascalRows(N);
    }
  }

  public static void print(List<List<Integer>> nums) {
    for (List<Integer> i : nums) {
      for (int j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  static void printPascalRows(int N) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      List<Integer> row = new ArrayList<>();
      for(int j = 0; j <= i; j++){
        if(j == 0 || j == i)row.add(1);
        else{
          int e1 = res.get(i-1).get(j-1);
          int e2 = res.get(i-1).get(j);
          row.add(e1+e2);
        }
      }
      res.add(row);
    }
    print(res);
  }
}