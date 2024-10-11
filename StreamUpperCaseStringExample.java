package streamApi;
import java.util.stream.Collectors;

public class StreamUpperCaseStringExample {
    public static void main(String[] args) {
        String s = "java";
        String upperCaseString = s.chars()
                                  .mapToObj(c -> (char) c)
                                  .map(Character::toUpperCase)
                                  .map(String::valueOf)
                                  .collect(Collectors.joining());
        System.out.println(upperCaseString); 
    }
}
