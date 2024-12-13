
class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] list = {"flowers", "fly", "flow", "flight"};

        System.out.println("Longest Common Prefix is " + findLCP(list));
    }

    private static String findLCP(String[] list) {
        StringBuilder s = new StringBuilder(list[0]);
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i < list.length; i++) {
            String s1 = list[i];
            int index = 0;
            while (index < Math.min(s.length(), s1.length())) {
                if (s1.charAt(index) != s.charAt(index)) {
                    break;
                } else {
                    result.append(s.charAt(index));
                    index++;
                }
            }
            if(result.length() == 0) return "";
            s = result;
            result = new StringBuilder();
        }
        return s.toString();
    }
}
