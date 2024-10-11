package streamApi;

import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String s = "javavnv";

        Character mostFrequent = s.chars()
                                  .mapToObj(c -> (char) c)
                                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                  .entrySet().stream()
                                  .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                                  .map(e -> e.getKey())
                                  .orElse(null);

        System.out.println(mostFrequent); 
    }
}
