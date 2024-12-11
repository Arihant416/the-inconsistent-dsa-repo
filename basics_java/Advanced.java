
import java.util.Scanner;

class Advanced {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(arr[1]);

        // Conditionals
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int percentage = sc.nextInt();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int dayNum = sc.nextInt();
        String category = isAdult(age);
        char grade = findGrade(percentage);
        System.out.println(category);
        System.out.println(grade);
        System.out.println("Largest among three is" + findLargestOf3(num1, num2, num3));
        System.out.println("Current Day is " + findDay(dayNum));
        formAndPrintAnArray(sc);
        sc.close();
    }

    public static void formAndPrintAnArray(Scanner sc) {
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static char findGrade(int percentage) {
        if (percentage >= 85) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 50) {
            return 'C';
        } else if (percentage >= 35) {
            return 'D';
        } else {
            return 'E';
        }
    }

    public static String isAdult(int age) {
        if (age >= 18) {
            return "Adult";
        } else {
            return "Teen";
        }
    }

    public static int findGreater(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int findLargestOf3(int num1, int num2, int num3) {
        return findGreater(findGreater(num1, num2), num3);
    }

    public static String findDay(int day) {
        String result;
        switch (day) {
            case 1 ->
                result = "Monday";
            case 2 ->
                result = "Tuesday";
            case 3 ->
                result = "Wednesday";
            case 4 ->
                result = "Thursday";
            case 5 ->
                result = "Friday";
            case 6 ->
                result = "Saturday";
            case 7 ->
                result = "Sunday";
            default ->
                result = "Invalid";
        }
        return result;
    }
}
