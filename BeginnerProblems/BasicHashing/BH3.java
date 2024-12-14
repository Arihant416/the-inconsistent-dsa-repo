
import java.util.HashMap;
import java.util.Scanner;

class BH3 {

    public static void main(String[] args) {
        // Problem: Given an array find highest occurring element in it
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Sum of Highest Occurring element and lowest frequency element in array is " + findSum(nums));
    }

    private static Integer findSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            int count = map.getOrDefault(el, 0);
            map.put(el, count + 1);
        }
        int maxCount = 0, minCount = Integer.MAX_VALUE;
        for (HashMap.Entry<Integer, Integer> it : map.entrySet()) {
            int val = it.getValue();
            maxCount = Math.max(val, maxCount);
            minCount = Math.min(minCount, val);
        }
        return maxCount + minCount;
    }
}
