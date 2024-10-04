package array;

public class MaximumInArray {

    private int maxInArray(int[] arr) {
        int max = 0;
        for(int i : arr){
            if(max < i){
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumInArray obj = new MaximumInArray();

        int maximumNumber = obj.maxInArray(new int[]{10,23,45,20,19});

        System.out.println("Largest Number: "+maximumNumber);
    }


}
