package streamApi;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "avaj";
        boolean isAnagram = Arrays.equals(s1.chars().sorted().toArray(),
                                          s2.chars().sorted().toArray());
        System.out.println(isAnagram); 
    }
}
