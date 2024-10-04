package array;

import java.util.Arrays;

public class ReverseArray {

//    // using for loop
//    public void reverseArray(int[] arr){
//        for(int i=arr.length-1; i>=0; i--){
//            System.out.print(arr[i]+" ");
//        }
//    }

    // using while loop
    public void reverseArray(int[] arr){

        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        ReverseArray obj = new ReverseArray();
        obj.reverseArray(new int[]{1,2,3,4,5});

    }
}
