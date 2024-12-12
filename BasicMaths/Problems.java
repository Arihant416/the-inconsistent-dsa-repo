
import java.util.Scanner;

public class Problems {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int number = sc.nextInt();
            // Problem 1: Count Digits in a number
            System.out.println("Digits in number -> " + number + " is " + countDigits(number));

            // Problem 2: Count Number of odd digits in a number
            System.out.println("Odd Digits in number -> " + number + " is " + countOddDigits(number));

            // Problem 3: Reverse a number
            System.out.println("Reverse of a number -> " + number + " is " + reverseOf(number));

            // Problem 4: Palindrome Number
            System.out.println("Is palindrome -> " + number + "? " + isPalindrome(number));

            // Problem 5: largest digit in a number
            System.out.println("Largest Digit in number -> " + number + " is " + findLargestDigitInNumber(number));

            // Problem 6: Factorial of a number
            System.out.println("Factorial of number " + number + " is " + findFactorial(number));

            // Problem 7: Check if a number is Armstrong
            System.out.println("IsArmstrong ? " + number + " ? " + isArmstrong(number));

            // Problem 8: Check if a number is Perfect
            System.out.println("IsPerfect ? " + number + " ? " + isPerfectNumber(number));

            // Problem 9: Check if a number is prime
            System.out.println("isPrime ? " + number + " ? " + isPrime(number));

            // Problem 10: Count of primes till N
            System.out.println("primeCount ? " + number + " ? " + findPrimeTilLN(number));

            // Problem 11: GCD of two numbers 
            greatestCommonDivisor(sc);

            // Problem 12: LCM of two numbers
            lowestCommonMultiple(sc);

            // Problem 13: Divisors of number
            printDivisorsOfANumber(number);

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

    public static int countOddDigits(int num) {
        int count = 0;
        while (num > 0) {
            int rem = num % 10;
            if (rem % 2 != 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static int reverseOf(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int num) {
        return reverseOf(num) == num;
    }

    public static int findLargestDigitInNumber(int num) {
        int digit = 0;
        while (num > 0) {
            int rem = num % 10;
            if (digit < rem) {
                digit = rem;
            }
            num /= 10;
        }
        return digit;
    }

    public static int findFactorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    public static boolean isArmstrong(int num) {
        // Armstrong number is one who sum of digits raised to power number of digits is equal to the number itself
        int digitCount = countDigits(num);
        int sum = 0;
        int numcopy = num;
        while (num > 0) {
            sum += Math.pow(num % 10, digitCount);
            num /= 10;
        }
        return sum == numcopy;
    }

    public static boolean isPerfectNumber(int num) {
        int divSum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                divSum += i;
            }
        }
        return divSum == num;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3 || num == 5 || num == 7) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findPrimeTilLN(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count += (isPrime(i) ? 1 : 0);
        }
        return count;
    }

    public static int gcdRecur(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcdRecur(b % a, a);
    }

    public static void greatestCommonDivisor(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("GCD of " + a + " & " + b + " is " + gcdRecur(a, b));
    }

    public static void lowestCommonMultiple(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcdRecur(a, b);
        System.out.println("LCD of " + a + " & " + b + " is " + (a * b) / gcd);
    }

    public static void printDivisorsOfANumber(int number) {
        System.out.print("Divisors of number " + number + " : ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + ", ");
            }
        }
    }
}
