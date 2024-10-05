package stack;

class StackImplementation<T>{

    private int[] stackArray;
    private int peek = 0;

    public StackImplementation(){
        stackArray = new int[5];
    }

    public void push(int data){
        if(peek == stackArray.length-1){
            stackArray = resizeArray(stackArray, stackArray.length*2);
        }
        stackArray[peek] = data;
        peek++;
    }

    public int pop(){
        int popped = stackArray[peek];
        int[] temp = new int[stackArray.length-1];
        for(int i = 0; i<stackArray.length-2; i++){
            temp[i] = stackArray[i];
        }
        stackArray = temp;
        peek--;
        return popped;
    }

    public int peek(){
        return stackArray[peek-1];
    }

    public void show(){
        for(int i = peek-1; i>=0; i--){
            System.out.println(" |  "+stackArray[i]+"  | ");
        }
        System.out.println("--------");
    }

    public int[] resizeArray(int[] originalArray, int size){
        int[] resizedArray = new int[size];
        int start = 0;
        int end = originalArray.length-1;
        while(start < end){
            resizedArray[start] = originalArray[start];
            start++;
        }
        return resizedArray;
    }


}

public class stackUsingArray {

    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.show();
        System.out.println("Top element: "+stack.peek());
        stack.pop();
        stack.show();

        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.show();

    }

}
