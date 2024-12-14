
class BS1 {

    public static void main(String[] args) {
        // String Class is immutable 
        // Use StringBuilder or StringBuffer
        String s = "racecar";

        // Problem Reverse this string
        System.out.println("Reversed String is " + reverseString(s));
        System.out.println("Is Palindrome ? " + s + " " + isPalindrome(s));
    }

    private static StringBuilder reverseString(String s) {
        StringBuilder scopy = new StringBuilder(s);
        for (int i = 0; i < s.length() / 2; i++) {
            char a = scopy.charAt(i);
            scopy.setCharAt(i, scopy.charAt(scopy.length() - 1 - i));
            scopy.setCharAt(scopy.length() - i - 1, a);
        }
        return scopy;
    }

    private static boolean isPalindrome(String s){
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) != s.charAt(s.length()-1-i))return false;
      }
      return true;
    }
}
