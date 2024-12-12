import java.util.Scanner;

public class Problems {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          int number = sc.nextInt();
          // Problem 1: Count Digits in a number
          System.out.println("Digits in number -> " + number + " is " + countDigits(number));
        }
    }

    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count += 1;
            num /= 10;
        }
        return count;
    }
}
