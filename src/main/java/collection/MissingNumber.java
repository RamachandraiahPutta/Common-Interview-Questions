package collection;

import java.util.List;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,7,8};
        System.out.println(missingNumber(numbers, 8));
    }

    public static int missingNumber(int[] numbers, int n){
        int sum = IntStream.of(numbers).sum();
        int actualSum = (n * (n+1)) / 2;
        return  actualSum - sum;
    }
}
