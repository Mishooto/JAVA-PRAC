public class Sortingalgos {
    //ჩემი isSorted:
    public static boolean isSorted(int[] array){
        int control = 0;
        for (int m = 1;m<array.length;m++){
            if (array[m]>=array[m-1]){
                control++;
            }
        }
        if (control == array.length){
            return true;
        }
        return false;
    }
    //უნის isSorted:
    public static boolean isSortedTUD( int[] arr ) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) {
                return false;
            }
        }
        return true;
    }
        public static int[] bubbleSort(int arr[]){//create two running threads thru the array
        System.out.print("BUBBLY BUBBLY  °˖✧◝(⁰▿⁰)◜✧˖°\n");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1])
                { //swapping with the use of a temp
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //pizazz to show the process
            System.out.print("Iteration "+(i+1)+": ");
            printArray(arr);
        }
        return arr;
    }
    public static void printArray(int arr[])
    {
        for (int z = 0; z <arr.length; z++) {
            System.out.print(arr[z]+" ");
        }
        System.out.println();
    }
    public static int[] insertionSort(int arr[]) {
        System.out.print(" INSERTINGUU!!!   ୧((#Φ益Φ#))୨  \n");
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j;
            // If we get smaller value than valueToSort then , we stop at that index.
            for ( j = i; j > 0 && arr[j - 1] > valueToSort; j--) {
                arr[j] = arr[j - 1];
            }
            // We will put valueToSort at that index
            arr[j] = valueToSort;
            System.out.print("Iteration "+(i)+": ");
            printArray(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] mylist = {9,8,6,1,5,4,3,2,17};
        //bubbleSort(mylist);
        //insertionSort(mylist);
        int shesadarebeli=0;
        int sum = 0;
        for (int entry:mylist){
            if (entry>shesadarebeli){
                shesadarebeli =entry;
            }
        }
        for (int entree : mylist){
            if (entree ==shesadarebeli){
                sum++;
            }
        }
        System.out.print("maximum: "+shesadarebeli+" occured: "+sum+"\n");
        System.out.print("ჩემი ალგორითმით: "+isSorted(mylist)+"\n");
        System.out.print("უნის ალგორითმით: "+isSortedTUD(mylist)+"\n");
        System.out.print("ჩემი ალგორითმით: "+isSorted(bubbleSort(mylist))+"\n");
        System.out.print("უნის ალგორითმით: "+isSortedTUD(bubbleSort(mylist))+"\n");

    }
}

