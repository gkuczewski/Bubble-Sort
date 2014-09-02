package bubblesort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static int[] bubbleIter(int[] numbers){
        for(int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }
    public static int[] bubbleRec(int[] numbers, int intital){
        if(intital == 0){
            return numbers;
        }
        else{
            for(int i = 0; i < intital-1; i++){
                if(numbers[i] > numbers[i+1]){
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
            return bubbleRec(numbers,intital-1);
        }
    }
    public static boolean checkedSorted(int[] numbers, int from, int to){
    boolean result = true;
    for(int i = from; i < to; i++){
        if(numbers[i] > numbers[i+1]){
           result = false;
           break;
        }
    }
    return result;
}
    public static void main(String[] args){
        int[] numbers = new int[100];
        Random random = new Random();
        int randNum = 0;
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = randNum;
            randNum = random.nextInt(500);
        }
            System.out.println("sorted by iterable:"+java.util.Arrays.toString
                    (bubbleIter(numbers)));
            System.out.println("sorted by recursion:"+java.util.Arrays.toString
                    (bubbleRec(numbers,
                    numbers.length)));
            System.out.println("checked for sort by iterable:"
                    +checkedSorted(bubbleIter(numbers),0,numbers.length-1));
            System.out.println("checked for sort by iterable:"
                    +checkedSorted(bubbleRec(numbers,numbers.length)
                        ,0,numbers.length-1));
    }

}
