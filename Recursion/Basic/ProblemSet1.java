
import java.util.Scanner;

public class ProblemSet1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    printNameNTimes(N);
    print1ToN(N);
    printNTo1(N);
  }
  
  static void printNameNTimes(int N) {
    if (N == 0)
      return;
    System.out.println("Arihant " + N);
    printNameNTimes(N - 1);
  }

  static void print1ToN(int N) {
    if (N == 0)
      return;
    print1ToN(N - 1);
    System.out.println(N);
  }

  static void printNTo1(int N) {
    if (N == 0)
      return;
    System.out.println(N);
    printNTo1(N - 1);
  }
}
