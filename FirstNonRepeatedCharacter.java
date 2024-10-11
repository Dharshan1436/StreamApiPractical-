package streamApi;


public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String s = "avavjj";

        Character firstNonRepeated = s.chars()
                                      .mapToObj(c -> (char) c)
                                      .filter(c -> s.indexOf(c) != s.lastIndexOf(c)).skip(1)
                                      .findFirst()
                                      .orElse(null);

        System.out.println(firstNonRepeated);
    }
}
