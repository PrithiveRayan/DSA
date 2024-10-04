package array;

public class ResizeArray {

    public static int[] resize(int[] originalArray, int size){
        int[] resizedArray = new int[size];
        for(int i=0; i<originalArray.length; i++){
            resizedArray[i] = originalArray[i];
        }
        return resizedArray;
    }

    public static void main(String[] args) {

        int[] original = {1,2,3,4,5};

        original = resize(original, original.length*2);

        System.out.println("The size of an Array: "+original.length);




    }
}
