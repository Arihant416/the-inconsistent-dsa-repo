
class LargestOddNumber {

    public static void main(String[] args) {
        String s = "0032579";
        System.out.println("The largest odd number in string " + s + " is -> " + findLargestOddNumber(s));
    }

    private static String findLargestOddNumber(String s) {
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 != 0) {
                index = i;
                break;
            }
        }
        int start = 0;
        while(s.charAt(start) == '0')start++;
        return s.substring(start, index + 1);
    }
}
