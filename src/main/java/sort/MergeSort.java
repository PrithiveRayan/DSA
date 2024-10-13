package sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr){
        if(arr.length == 1)
            return arr;

        int mid = arr.length/2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second){
        int[] merged = new int[first.length+second.length];

        int i=0, j = 0, k = 0;
        while(i<first.length && j<second.length){
                if(first[i] < second[j])
                    merged[k++] = first[i++];
                else
                    merged[k++] = second[j++];
        }

        while(i<first.length)
            merged[k++] = first[i++];
        while(j<second.length)
            merged[k++] = second[j++];

        return merged;
    }

    public static void sortInPlace(int[] arr, int start, int end){

            if (end - start == 1 ){
                return;
            }
            int mid = (start+end)/2;
            sortInPlace(arr, start, mid);
            sortInPlace(arr, mid , end);

            mergeInSort(arr, start, mid, end);

    }

    public static void mergeInSort(int[] arr, int start, int mid, int end){
        int[] merged = new int[end - start];

        int i=start, j = mid, k = 0;
        while(i<mid && j<end){
            if(arr[i] < arr[j])
                merged[k++] = arr[i++];
            else
                merged[k++] = arr[j++];
        }

        while(i<mid)
            merged[k++] = arr[i++];
        while(j<end)
            merged[k++] = arr[j++];

        for(k=0; k<merged.length; k++){
            arr[start+k] = merged[k];
        }
    }

    public static void main(String[] args) {

//        int[] merge = merge(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
//        System.out.println(Arrays.toString(merge));
        int[] arr = {14,7,3,12,9,11,6,2};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));

        sortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
