package com.mycom.spring.config;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.*;
public class TestMain {

	public static void main(String[] args) {
		
		err.println("RAHUL");

		String str = "adsaasd zzz Aldnsvlkdfkalsf bdskfsknfosdafokasdf Bslfknsdklflsadkfnlksfnlkksdnfakls clksnflkkanflkksnfl Cdsflsdnfsdlfknskdlf";
		String[] strings = str.toLowerCase().split(" ");
		List<String> strList = Arrays.asList(strings);
		strList.sort(Comparator.comparingDouble(String::length).thenComparing(Comparator.naturalOrder()));
		strList.set(0, strList.get(0).replaceFirst("["+strList.get(0).charAt(0)+"]", Character.toString(Character.toUpperCase(strList.get(0).charAt(0)))));
		System.out.println(strList);
		
		String str1 = "hello, how are you?";
		String str2 = str1.toLowerCase().replace(" ", "").replaceAll("[\\W_]", "");
		
		StringBuffer buffer = new StringBuffer(str1);
		System.out.println((buffer.reverse().toString()).equals(str1));
		
		boolean equal = true;
		for(int i=0;i<str2.length();i++){
			if(str2.charAt(i) != str2.charAt(str2.length()-1-i))
				equal = false;
		}
		System.out.println(equal);
		Character[] chsr;
		
		Set<Character> allItems = new HashSet<Character>();
		Stream<Character> chars = str2.chars().mapToObj(c -> (char) c);
		Set<Character> duplicates = chars.filter(c -> !allItems.add(c)).collect(Collectors.toSet());
		System.out.println(duplicates);
		
	}

}
