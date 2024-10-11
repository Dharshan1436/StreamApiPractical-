package streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StramOperations {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ankit", "Vijay", "Ravi", "Rohan");
		List<String> names1 = names.stream().filter(x -> x.startsWith("R")).collect(Collectors.toList());
		System.out.println(names1);
		List<String> names2 = names.stream().map(String::toUpperCase).toList();
		System.out.println(names2);

		names.stream().forEach(System.out::println);
		long count = names.stream().count();
		System.out.println(count);
		Optional<String> firstName = names.stream().findFirst();

		System.out.println(firstName.get());
		int sum = Arrays.asList(1, 2, 3, 4).stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4).stream().distinct()
				.collect(Collectors.toList());
		System.out.println(distinctNumbers);
	}

}
