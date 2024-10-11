package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("apple", "banana"),
            Arrays.asList("cherry", "date"),
            Arrays.asList("elderberry", "fig")
        );
        
        
        List<String> flatList = nestedList.stream().flatMap(x->x.stream()).map(x->x.toUpperCase()).
                                          collect(Collectors.toList());

        System.out.println(flatList);  
        
    }
}
