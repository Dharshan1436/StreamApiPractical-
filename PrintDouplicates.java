package streamApi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDouplicates {

	public static void main(String[] args) {

		String str = "ABCDABC";
		List<Character> ch = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Set<Character> s = new HashSet<Character>();
		List<Character> list = ch.stream().filter(x -> !s.add(x)).distinct().collect(Collectors.toList());
		System.out.println(list);
	}

}
