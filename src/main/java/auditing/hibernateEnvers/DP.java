package auditing.hibernateEnvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class DP {
	public static void main(String[] args) {

		String palmetto = "CFW|THY|JUK";

		List<String> resortCodes = Arrays.stream(palmetto.split("\\|")).collect(Collectors.toList());

		String a = "CFW";

		if (resortCodes.contains(a)) {
			System.out.println("1");
		}
	}

}
