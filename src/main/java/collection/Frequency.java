package collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency {
    public static void main(String[] args) {

        //frequency of elements in collection
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "apple", "guava", "apple", "mango", "mango", "guava");
        Map<String, Long> stringFrequency = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringFrequency);

        //frequency of characters in string
        String s= "Hello World";
        Map<Character, Long> charFrequency = s.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charFrequency);


    }
}
