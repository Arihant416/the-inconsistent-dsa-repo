
import java.util.Scanner;

class BasicProblems {

    public static void main(String[] args) {
        // Write n times without loop
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long stTR = System.currentTimeMillis();
        tailRecursion(n);
        long duration = System.currentTimeMillis() - stTR;
        System.out.println("Tail Recursion took " + duration);
        long stHR = System.currentTimeMillis();
        headRecursion(n);
        duration = System.currentTimeMillis() - stHR;
        System.out.println("Head Recursion took " + duration);
        print1ToN(n);
        printNTo1(n);
        System.out.println("Factorial of " + n + " is " + findFactorial(n));
        System.out.println("Sum till " + n + " is " + findSumTillN(n));

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Sum of array is -> " + findSumOfArrayElements(array, n));
    }

    // This is a case for tail recursion
    private static void tailRecursion(int n) {
        if (n == 0) {
            return;
        }
        // System.out.println("Tail Recursion " + n);
        for (int i = 1; i < 1000; i++) {
        }
        tailRecursion(n - 1);
    }

    // This is a case for head recursion
    private static void headRecursion(int n) {
        if (n > 0) {
            headRecursion(n - 1);
        }
        for (int i = 1; i < 1000; i++) {
        }
        // System.out.println("Head Recursion " + n);
    }

    private static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.println(n);
    }

    private static void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNTo1(n - 1);
    }

    private static int findFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }

    private static int findSumTillN(int n) {
        if (n <= 1) {
            return n;
        }
        return n + findSumTillN(n - 1);
    }

    private static int arraySumRecurHelper(int[] nums, int n, int index) {
        if (index == n) {
            return 0;
        }
        return nums[index] + arraySumRecurHelper(nums, n, index + 1);
    }

    private static int findSumOfArrayElements(int[] array, int size) {
        return arraySumRecurHelper(array, size, 0);
    }
}
