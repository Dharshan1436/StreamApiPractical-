package streamApi;

import java.util.stream.IntStream;

public class CheckSortedStream {
	 public static boolean isSorted(int[] array) {
	        return IntStream.range(0, array.length - 1)
	                        .allMatch(i -> array[i] <= array[i + 1]);
	    }

	    public static void main(String[] args) {
	        int[] array = {1, 2, 3, 4, 5};
	        System.out.println(isSorted(array));
	    }
}
