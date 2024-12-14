
class Anagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("IsAnagram ? " + isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        int[] mp = new int[256];
        for (char c : s.toCharArray()) {
            mp[c]++;
        }
        for (char c : t.toCharArray()) {
            if (mp[c] == 0) {
                return false;
            }
            mp[c]--;
        }
        int sum = 0;
        for (int i : mp) {
            sum += i;
        }
        return sum == 0;
    }
}
