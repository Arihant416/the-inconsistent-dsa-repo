
import java.util.Scanner;

class RotateString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String goal = sc.nextLine();

        System.out.println("Can be rotated ?" + isPossibleToForm(s, goal));
    }

    private static boolean isPossibleToForm(String s, String goal) {
        String d = s + s;
        return d.contains(goal);
    }

}
