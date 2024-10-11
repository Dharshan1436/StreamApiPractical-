package streamApi;

import java.util.stream.Collectors;

public class PrintVowels {
    public static void main(String[] args) {
        String s = "java is programing language";
        String vowels = s.chars() 
                         .mapToObj(c -> (char) c) 
                         .filter(c -> "aeiou".indexOf(c) != -1)
                         .map(String::valueOf) 
                         .collect(Collectors.joining());
        System.out.println(vowels); 
    }
}
