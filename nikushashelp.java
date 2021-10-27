public class nikushashelp {

    public static Integer maxOnlyInarr(Integer[] arr, Integer[] feld){
        if (arr.length == 0){
            return null;
        }
        Integer currentMax = arr[0];
        boolean arelistsequal = true;
        for (int i =0; i<arr.length; i++){
            boolean wasfound = false;
            for (int j=0; j< feld.length; j++){
                if (arr[i].equals(feld[j])){
                    wasfound= true;
                    break;
                }
            }
            if (!wasfound && currentMax < arr[i]){
                currentMax = arr[i];
            }
            if (!wasfound){
                arelistsequal = false;
            }
        }
        if (arelistsequal){
            return null;
        }
        return currentMax;
    }
    public static void main(String[] args){
        Integer[] arr1 = {1,2,666,9};
        Integer[] arr2 = {2,128,666,512};
        System.out.print(maxOnlyInarr(arr1,arr2));
    }
}
