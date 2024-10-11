package streamApi;


public class CountCase {
    public static void main(String[] args) {
        String s = "Java Is Great";
        long upperCaseCount = s.chars().filter(Character::isUpperCase).count();
        long lowerCaseCount = s.chars().filter(Character::isLowerCase).count();
        
        System.out.println("Uppercase Count: " + upperCaseCount); 
        System.out.println("Lowercase Count: " + lowerCaseCount); 
    }
}
