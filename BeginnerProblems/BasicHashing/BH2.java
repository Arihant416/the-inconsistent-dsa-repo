
import java.util.HashMap;
import java.util.Scanner;

class BH2 {

    public static void main(String[] args) {
        // Problem: Given an array find highest occurring element in it
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Second Highest Occurring element in array is " + findSecondHighestOccurringElement(nums));
    }

    private static Integer findSecondHighestOccurringElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            int count = map.getOrDefault(el, 0);
            map.put(el, count + 1);
        }
        int maxCount = 0, secondMaxCount = 0, secondMaxElement = -1, maxElement = -1;
        for (HashMap.Entry<Integer, Integer> it : map.entrySet()) {
            int el = it.getKey();
            int freq = it.getValue();

            if (freq > maxCount) {
                secondMaxCount = maxCount;
                secondMaxElement = maxElement;
                maxCount = freq;
                maxElement = el;
            } else if (freq == maxCount) {
                maxElement = Math.min(el, maxElement);
            } else if (freq > secondMaxCount) {
                secondMaxCount = freq;
                secondMaxElement = el;
            } else if (freq == secondMaxCount) {
                secondMaxElement = Math.min(secondMaxElement, el);
            }
        }
        return secondMaxElement;
    }
}
