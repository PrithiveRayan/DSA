package binarySearch;

public class LowerBound {

    public int lowerBoundIndex(int[] arr, int k){
        int index = arr.length;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] >= k){
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
        LowerBound lb = new LowerBound();
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        System.out.println(lb.lowerBoundIndex(arr, 9));

    }
}
