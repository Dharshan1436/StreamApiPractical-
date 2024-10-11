package streamApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemsOnStreamApi {

	public static void main(String[] args) {

		// 1.Find the largest/smallest number in an array using Stream API.
//		
		int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int max = Arrays.stream(ar).max().getAsInt();
		System.out.println(max);
		int min = Arrays.stream(ar).min().getAsInt();
		System.out.println(min);

		// Count occurrences of each character in a string using Stream API.
		
		String str = "javaPrograminglanguage";
		Map<Character, Long> counts = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(counts);

		// Find the first non-repeated character in a string using Stream API.
		Character s = str.chars().mapToObj(c -> (char) c).filter(c -> str.indexOf(c) == str.lastIndexOf(c)).findFirst()
				.orElse(null);
		System.out.println(s);

		// Check if two strings are anagrams using Stream API.
		String str1 = "java";
		String str2 = "avaj";
		Boolean isAnagram = Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
		System.out.println(isAnagram);

		// Reverse a string using Stream API.

		List<Character> reverseString = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		Collections.reverse(reverseString);

		String result = reverseString.stream().map(String::valueOf).collect(Collectors.joining());

		System.out.println(result);

		// Check if a string is a palindrome using Stream API.
		String st = "navana";
		boolean isPalindrome = IntStream.range(0, st.length() / 2)
				.allMatch(i -> st.charAt(i) == st.charAt(st.length() - i - 1));

		System.out.println(isPalindrome);

		// Find the second largest element in an array using Stream API.
		OptionalInt max1 = Arrays.stream(ar).max();
		if (max1.isPresent()) {
			int secondMax = Arrays.stream(ar).filter(n -> n < max1.getAsInt()).max().getAsInt();
			System.out.println(secondMax);
		}
		// Find all duplicate elements in an array using Stream API.
		Integer[] ar1 = { 1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 5 }; // Example array
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> duplicates = Arrays.stream(ar1).filter(x -> !set.add(x)).collect(Collectors.toList());
		System.out.println("Duplicate elements: " + duplicates);

		// Remove all occurrences of a specific element from an array using Stream API.

		int[] ar2 = { 1, 2, 3, 4, 5, 2, 6, 2, 7 }; 
		int elementToRemove = 2;

		int[] result1 = Arrays.stream(ar2).filter(n -> n != elementToRemove).toArray();
		System.out.println("Array after removing element " + elementToRemove + ": " + Arrays.toString(result1));
		// Merge two sorted arrays using Stream API.
		int[] array1 = { 1, 3, 5, 7 };
		int[] array2 = { 2, 5, 6, 8 };
		int[] array3 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().toArray();
		System.out.println(Arrays.toString(array3));

		// Find the intersection of two arrays using Stream API.
		List<Integer> list = Arrays.stream(array1).filter(n -> Arrays.stream(array2).anyMatch(i -> n == i)).distinct()
				.boxed().collect(Collectors.toList());
		System.out.println(list);
		// Find the union of two arrays using Stream API.
		int[] list1 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).distinct().toArray();
		System.out.println(Arrays.toString(list1));
		
		// Rotate an array by K positions using Stream API.
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int length = a.length;
		k = k % length;
		List<Integer> rotatedList = IntStream
				.concat(Arrays.stream(a, length - k, length), Arrays.stream(a, 0, length - k)).boxed()
				.collect(Collectors.toList());
		int[] rotatedArray = rotatedList.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(rotatedArray));

		// Find the most frequent element in an array using Stream API.
		int[] array = { 1, 3, 2, 1, 4, 3, 1, 5 };
		Integer mostFrequent = Arrays.stream(array).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		System.out.println(mostFrequent);
		// . Find the Sum of Elements in an Array:

		int sum = Arrays.stream(array).sum();
		System.out.println(sum);
	}

}
