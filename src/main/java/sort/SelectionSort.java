package sort;

import java.util.Arrays;

public class SelectionSort {

    public static int[] sort(int[] arr){

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int min = arr[i];
                if(arr[j]< min){
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {4,9,2,6,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
