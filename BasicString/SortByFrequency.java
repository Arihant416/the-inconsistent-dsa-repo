
import java.util.*;

class SortByFrequency {

    public static void main(String[] args) {
        String s = "raaajj";
        String d = "bbccddaaa";
        String f = "tree";
        sortByFrequency(s);
		System.out.println();
        sortByFrequency(d);
		System.out.println();
        sortByFrequency(f);
    }

    public static void sortByFrequency(String s) {
        Pair[] frequencies = new Pair[26];
        for (int i = 0; i < 26; i++) {
            frequencies[i] = new Pair(0, (char) (i + 'a'));
        }
        for (char c : s.toCharArray()) {
            frequencies[c - 'a'].freq++;
        }
        Arrays.sort(frequencies, (f1, f2) -> {
            if (f1.freq != f2.freq) {
                return f2.freq - f1.freq;
            }
            return f1.c - f2.c;
        });
        for (Pair p : frequencies) {
            if (p.freq > 0) {
                System.out.print(p.c + ", ");
            }
        }
    }

    static class Pair {

        int freq;
        char c;

        Pair(int f, char c) {
            this.freq = f;
            this.c = c;
        }
    }
}
