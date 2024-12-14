
import java.util.HashMap;
import java.util.Scanner;

class BH1 {

    public static void main(String[] args) {
        // Problem: Given an array find highest occurring element in it
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Largest element in the array is " + findLargestElement(nums));
        System.out.println("Highest Occurring element in array is " + findHighestOccurringElement(nums));
    }

    private static int findLargestElement(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for (int element : nums) {
            if (maxNum < element) {
                maxNum = element;
            }
        }
        return maxNum;
    }

    private static Integer findHighestOccurringElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            int count = map.getOrDefault(el, 0);
            map.put(el, count + 1);
        }
        int maxCount = 0, element = 0;
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            if (val > maxCount) {
                maxCount = val;
                element = key;
            }
        }
        return element;
    }
}
