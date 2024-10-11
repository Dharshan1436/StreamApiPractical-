package streamApi;

import java.util.stream.Collectors;

public class ReplaceCharactor {
    public static void main(String[] args) {
        String s = "java";
        String replaced = s.chars()
                           .mapToObj(c -> (char) c)
                           .map(c -> c == 'a' ? 'o' : c )
                           .map(String::valueOf)
                           .collect(Collectors.joining());
        System.out.println(replaced); 
    }
}
