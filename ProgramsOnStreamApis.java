package streamApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgramsOnStreamApis {

	public static void main(String[] args) {
		int[] ar1 = { 1, 2, 3, 4, 68, 98, 54, 2, 25, 5, 25, 4, 5, 5, 55, 1 };
		//  Find the Sum of Elements in an Array:
		int sum = Arrays.stream(ar1).sum();
		System.out.println("Sum of array :" + sum);

		//  Find the Maximum Element in an Array:
		int max = Arrays.stream(ar1).max().orElse(-1);
		System.out.println("Max value of array :" + max);

		//  Find the Minimum Element in an Array:
		int min = Arrays.stream(ar1).min().orElse(-1);
		System.out.println("Max value of array :" + min);

		//  Count the Even and Odd Numbers:
		long even = Arrays.stream(ar1).filter(x -> x % 2 == 0).count();
		long odd = ar1.length - even;
		System.out.println("even numbers :" + even + " And Odd numbers :" + odd);

		//  Calculate the Average of Elements:
		double avg = Arrays.stream(ar1).average().orElse(-1);
		System.out.println("avg value of array :" + avg);

		//  Remove Duplicates from an Array:
		int[] removeDuplicates = Arrays.stream(ar1).distinct().toArray();
		System.out.println("after Remove Duplicates:" + Arrays.toString(removeDuplicates));

		// Reverse an Array:
		int[] list = IntStream.range(0, ar1.length).map(i -> ar1[ar1.length - 1 - i]).toArray();

		System.out.println(Arrays.toString(list));

		//  Rotate an Array by K Positions:
		int k = 5;
		k = k % ar1.length;
		IntStream.concat(Arrays.stream(ar1, k, ar1.length - 1), Arrays.stream(ar1, 0, k))
				.forEach(x -> System.out.print(x + " "));
		System.out.println();

		//  Find the Second Largest Element:
		int secondLargest = Arrays.stream(ar1).boxed().sorted((x, y) -> y - x).skip(1).findFirst().get();
		System.out.println(secondLargest);
		//  Check if an Array is Sorted:
		boolean sortedArray = IntStream.range(0, ar1.length).allMatch(x -> ar1[x] >= ar1[x + 1]);
		System.out.println(sortedArray);
		//  Merge Two Arrays:
		int array1[] = { 1, 2, 3, 4, 5, 7, 9 };
		int array2[] = { 6, 7, 8, 9, 10, 2, 1 };
		int[] array3 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
		System.out.println(Arrays.toString(array3));

		//  Find the Intersection of Two Arrays:
		List<Integer> interction = Arrays.stream(array1).filter(i -> Arrays.stream(array2).anyMatch(n -> i == n))
				.distinct().boxed().collect(Collectors.toList());

		System.out.println(interction);

		//  Find the Union of Two Arrays:
		int[] union = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).distinct().toArray();
		System.out.println(Arrays.toString(union));

		//  Count the Frequency of Each Element:
		int[] array4 = { 1, 2, 3, 1, 56, 4, 8, 5, 24, 6 };
		Map<Integer, Long> map = Arrays.stream(array4).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		//  Find the Most Frequent Element:
		int mostFrequent = Arrays.stream(array4).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).map(x -> x.getKey()).orElse(-1);
		System.out.println(mostFrequent);


		//  Find Common Elements in Multiple Arrays:
		int[] array11 = { 1, 2, 3, 4, 5 };
		int[] array22 = { 3, 4, 5, 6, 7 };
		int[] array33 = { 0, 2, 3, 4, 8 };
		List<Integer> commonElements = Arrays.stream(array11).filter(x -> Arrays.stream(array22).anyMatch(y -> y == x))
				.filter(x -> Arrays.stream(array33).anyMatch(z -> z == x)).boxed().collect(Collectors.toList());

		System.out.println(commonElements);
		//  Create a New Array from Existing Array with Conditions:

		//  Find the Kth Smallest/Largest Element:
		int[] array = { 7, 10, 4, 3, 20, 15 };
		int k1 = 3;
		int kthSmallest = Arrays.stream(array).sorted().skip(k1 - 1).findFirst().orElse(-1);
		System.out.println(kthSmallest);
		int kthLargest = Arrays.stream(array).boxed().sorted((x, y) -> (y - x)).skip(k1 - 1).findFirst().orElse(-1);
		System.out.println(kthLargest);

		//  Check for Pairs that Sum to a Target Value:
		Integer[] array5 = { 2, 4, 3, 7, 5, 9, 10 };
		int target = 9;
		Arrays.stream(array5).flatMap(
				a -> Arrays.stream(array5).filter(b -> a + b == target && a < b).map(b -> new Integer[] { a, b }))
				.distinct().forEach(pair -> System.out.println("Pair found: (" + pair[0] + ", " + pair[1] + ")"));

		// Check if Two Arrays are Equal:
		int a1[] = { 1, 2, 3 };
		int a2[] = { 1, 2, 3 };
		boolean Equals = Arrays.equals(a1, a2);
		System.out.println(Equals);

		

		// String Questions
		//  Count the Number of Vowels in a String:
		String s = "ijava";
		long counts = s.chars().mapToObj(c -> (char) c).filter(x -> "aeiou".indexOf(x) != -1).count();
		System.out.println(counts);

		//  Check if a String is a Palindrome:
		String s1 = "radar";
		boolean palindrome = IntStream.range(0, s.length() / 2)
				.allMatch(x -> s1.charAt(x) == s1.charAt(s1.length() - 1 - x));
		System.out.println(palindrome);
		

		//  Find the First Non-Repeated Character:
		String s3 = "radamr";
		Character firstNonRepeated = s3.chars().mapToObj(c -> (char) c).filter(x -> s3.indexOf(x) == s3.lastIndexOf(x))
				.findFirst().orElse(null);
		System.out.println(firstNonRepeated);
		//  Find the Length of Each Word in a Sentence:
		String sentence = "Find the length of each word in a sentence";
		List<Integer> worldLength = Arrays.stream(sentence.split(" ")).map(String::length).collect(Collectors.toList());
		System.out.println(worldLength);
		
		
		// Remove All Spaces from a String:
		String str = "Remove all spaces from this string.";
		String removeSpaces = str.chars().filter(c -> c != ' ').mapToObj(c -> (char) c).map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println(removeSpaces);

		
		//  Count the Frequency of Each Character:
		String str1 = "Frequency";
		Map<Character, Long> map1 = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		map1.forEach((character, count) -> System.out.print(character + ":" + count + " "));
		
		// Check if Two Strings are Anagrams:
		String str2 = "listen";
		String str3 = "silent";

		boolean areAnagrams = Arrays.equals(str2.chars().sorted().toArray(), str3.chars().sorted().toArray());
		System.out.println();
		System.out.println("Are the strings anagrams? " + areAnagrams);

		// Capitalize the First Letter of Each Word:
		String sentence1 = "this is a java stream example";

		String capitalized = Arrays.stream(sentence1.split("\\s+"))
				.map(word -> word.substring(0, 1).toUpperCase() + word.substring(1)).collect(Collectors.joining(" "));

		System.out.println(capitalized);

		// Find the First Repeated Character:

		String str4 = "Repeated";

		Set<Character> seen = new HashSet<>();
		Character firstRepeated = str4.chars().mapToObj(c -> (char) c).filter(c -> !seen.add(c)).findFirst()
				.orElse(null);

		System.out.println(firstRepeated);
		// Find the Repeated Character:
		String str5 = "repeatedr";

		Set<Character> seen1 = new HashSet<>();
		Set<Character> duplicates = str5.chars().mapToObj(c -> (char) c).filter(c -> !seen1.add(c))
				.collect(Collectors.toSet());
		System.out.println(duplicates);

		// Combined Array and String Questions

		// Find the Maximum Length of Words in an Array of Strings:
		String[] words1 = { "apple", "banana", "kiwi", "strawberry", "pear" };
		int maxLength = Arrays.stream(words1).mapToInt(String::length).max().orElse(0);

		System.out.println("Maximum length of words: " + maxLength);

		// Remove Empty Strings from an Array:
		String[] word2 = { "apple", "", "banana", "kiwi", "", "pear" };

		String[] filteredWords = Arrays.stream(word2).filter(word -> !word.isEmpty()).toArray(String[]::new);

		System.out.println(Arrays.toString(filteredWords));

		// Sort an Array of Strings by Length:
		String[] words = { "apple", "banana", "kiwi", "strawberry", "pear" };

		String[] sortedWords = Arrays.stream(words).sorted((a, b) -> Integer.compare(a.length(), b.length()))
				.toArray(String[]::new);

		System.out.println(Arrays.toString(sortedWords));

	}
}
