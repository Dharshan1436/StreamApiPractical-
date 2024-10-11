package streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamVsParallelStream {
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
     
        long startTime = System.nanoTime();
        numbers.stream()
               .filter(num -> num % 2 == 0)
               .forEach(num -> System.out.println("Sequential Stream: " + num));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken by sequential stream: " + duration + " nanoseconds");
        
        
        startTime = System.nanoTime();
        numbers.parallelStream()
               .filter(num -> num % 2 == 0)
               .forEach(num -> System.out.println("Parallel Stream: " + num));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken by parallel stream: " + duration + " nanoseconds");
    }
}
