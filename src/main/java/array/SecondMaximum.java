package array;

public class SecondMaximum {

    public static int getSecondMaximum(int[] arr){
        int max = 0;
        int secondMax = 0;
        for(int i : arr){
            if(i > max){
                secondMax = max;
                max = i;
            }
            else if( i > secondMax && i != max){
                secondMax = i;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {

        int secondMaximum = getSecondMaximum(new int[]{10, 15, 27, 29, 27, 29, 30});

        System.out.println("The Second maximum number is "+secondMaximum);

    }
}
