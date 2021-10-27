import java.util.Arrays;
public class MyQuickSort {

    private static int array[];

    private static void quickSort(int[] arr, int left, int right) {

        if (arr == null || arr.length == 0) {
            return;
        }
        array = arr;
        //start of the list
        int i = left;
        //end of the list
        int j = right;
        // find pivot number, we will take it as mid
        int pivot = array[left + (right - left) / 2];
        while (i <= j) {
            /* In each iteration, we will increment left until we find element greater than pivot
             * We will decrement right until we find element less than pivot*/
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);
    }

    public static void main(String a[]) {
        int[] input = {33, 21, 45, 64, 55, 34, 11, 8, 3, 5, 1, 666, 420};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(input));
        quickSort(input, 0, input.length-1);
        System.out.println("==================");
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(input));

    }
}
