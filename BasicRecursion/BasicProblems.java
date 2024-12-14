
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
}
