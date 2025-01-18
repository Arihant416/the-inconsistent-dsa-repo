
import java.util.Scanner;

public class ProblemSet1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // printNameNTimes(N);
    // print1ToN(N);
    // printNTo1(N);
    System.out.println("Sum of N terms " + findSumOfNTerms(N));
    System.out.println("Factorial of N " + findFactorial(N));
    System.out.println("Fibo  N " + findNthFibo(N));
    StringBuilder s = new StringBuilder(sc.next());
    System.out.println("Reverse of s " + reverseString(s, 0, s.length() - 1));
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

  static int findSumOfNTerms(int N) {
    if (N == 0)
      return 0;
    return N + findSumOfNTerms(N - 1);
  }

  static int findFactorial(int N) {
    if (N <= 1)
      return 1;
    return N * findFactorial(--N); // Note --N works and N-- fails because of usage and precedence.
  }

  static StringBuilder reverseString(StringBuilder s, int start, int end) {
    if (start >= end)
      return s;
    char temp = s.charAt(start);
    s.setCharAt(start, s.charAt(end));
    s.setCharAt(end, temp);
    return reverseString(s, start + 1, end - 1);
  }

  static int findNthFibo(int N) {
    if (N == 0 || N == 1)
      return N;
    return findNthFibo(N - 1) + findNthFibo(N - 2);
  }
}
