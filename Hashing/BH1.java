
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
}
