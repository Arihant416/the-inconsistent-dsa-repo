
import java.util.Scanner;

class MoreProblemsBasic {

  public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
          String str = sc.nextLine();
          System.out.println("String Reversed is " + reverse(str));
          
          int number = sc.nextInt();
          System.out.println("IS Prime ? " + number + " -> " + isPrime(number));
          
          System.out.println("Sum of digits in a given number " + sumUntilNumLessThan10(number));
          
          System.out.println("Nth fibonacci number is -> " + findNthFibonacci(number));
      }

  }

  private static String recurHelper(StringBuilder str, int start, int end) {
    if (start >= end) {
      return str.toString();
    }
    char temp = str.charAt(start);
    str.setCharAt(start, str.charAt(end));
    str.setCharAt(end, temp);
    return recurHelper(str, start + 1, end - 1);
  }

  private static String reverse(String str) {
    return recurHelper(new StringBuilder(str), 0, str.length() - 1);
  }

  private static boolean isPrimeRecurHelper(int n, int p) {
    if (p > Math.sqrt(n))
      return true;
    if (n % p == 0)
      return false;
    return isPrimeRecurHelper(n, p + 1);
  }

  private static boolean isPrime(int n) {
    if (n <= 1)
      return false;
    return isPrimeRecurHelper(n, 2);
  }

  private static int sumUntilNumLessThan10(int num) {
    if (num < 10)
      return num;
    int sum = 0;
    while (num > 0) {
      sum += (num % 10);
      num /= 10;
    }
    return sumUntilNumLessThan10(sum);
  }

  private static int findNthFibonacci(int num) {
    if (num <= 1)
      return num;
    return findNthFibonacci(num - 1) + findNthFibonacci(num - 2);
  }
}
