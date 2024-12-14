
import java.util.Scanner;

class IsomorphicString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.print("isIsomorphic " + isIsomorphic(s1, s2));
    }

    private static boolean isIsomorphic(String s1, String s2) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (m1[s1.charAt(i)] != m2[s2.charAt(i)]) {
                return false;
            }
            m1[s1.charAt(i)] = i + 1;
            m2[s2.charAt(i)] = i + 1;
        }
        return true;
    }
}
