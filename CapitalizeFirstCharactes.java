package streamApi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalizeFirstCharactes {
    public static void main(String[] args) {
        String sentence = "java stream api";
        String capitalized = Arrays.stream(sentence.split(" "))
                                   .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                                   .collect(Collectors.joining(" "));
        System.out.println(capitalized); 
    }
}
