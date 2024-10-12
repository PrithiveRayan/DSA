package sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] arr){

        for(int i=1; i<arr.length; i++){
            boolean swapped = false;
            for(int j=0; j<arr.length-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped){
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {4,9,2,6,8,1,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
