package sort;

import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int[] arr){

        for(int i = 1; i<arr.length; i++){
            for(int j=i; j>0 ; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else
                    break;
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
