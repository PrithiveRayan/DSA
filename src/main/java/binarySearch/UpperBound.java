package binarySearch;

public class UpperBound {
    public int upperBoundIndex(int[] arr, int k){
        int index = arr.length;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] > k){
                index = mid;
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        UpperBound up = new UpperBound();
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        System.out.println(up.upperBoundIndex(arr,9));

    }
}
