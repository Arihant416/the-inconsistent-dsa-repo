import java.util.Scanner;

class BubbleSort{
    public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
          int size = sc.nextInt();
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
              array[i] = sc.nextInt();
          }
          bubbleSort(array, size);
          for (int element : array) {
              System.out.print(element + " ");
          } }
    }

    private static void bubbleSort(int[] nums, int size){
      for(int i = 0; i < size; i++){
        boolean isSwapped = false;
        for(int j = size-1; j >= i; j--){
          if(nums[i] >= nums[j]){
            isSwapped = true;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
          }
        }
        if(!isSwapped)break;
      }
    }
}