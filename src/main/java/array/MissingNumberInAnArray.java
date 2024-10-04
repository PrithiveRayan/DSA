package array;

public class MissingNumberInAnArray {

    public static void missingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n*(n+1)/2;

        for(int i : arr){
            sum = sum - i;
        }

        System.out.println("Missing Number is "+sum);
    }

    public static void main(String[] args) {

        missingNumber(new int[]{1,2,3,4,6,7,8});

    }
}
