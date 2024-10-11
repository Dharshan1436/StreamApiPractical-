package streamApi;
public class CountCharactor {
    public static void main(String[] args) {
        String s = "java";
        long count = s.chars()
                      .filter(c -> c == 'a')
                      .count();
        System.out.println(count); 
    }
}
