package code.geeksforgeek.practice;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map;
import java.util.Map.Entry;

public class SherlockAndValidString {

	static String isValid(String s){
		Map<Character, Integer> buffer = new HashMap<>();
		Map<Integer, Integer> buffer2 = new HashMap<>();
		for(Character c: s.toCharArray()) {
			int count = 0;
			if(buffer.containsKey(c)) {
				count =buffer.get(c);
				count+=1;
				buffer.put(c,count);
			}else {
				count=1;
				buffer.put(c,count);
			}
		}
		List<Integer> values = new ArrayList<>(buffer.values());
		Collections.sort(values);
		int min = values.get(0);
		int max = values.get(values.size()-1);
		if(max-min > 1 && min!=1) {
			return "NO";
		}
		for(Integer a:values) {
			if(buffer2.containsKey(a)) {
				int count =0;
				count =buffer2.get(a);
				count+=1;
				buffer2.put(a,count);
			}else {
				buffer2.put(a,1);
			}
		}

		List<Integer> values2 = new ArrayList<>(buffer2.values());
		Collections.sort(values2);
		int max1 = values2.get(values2.size()-1);
		int numberCounter =0;
		for(Entry<Integer, Integer> entrysets : buffer2.entrySet()) {
			if(entrysets.getValue()==max1 ) {
				max1=entrysets.getKey();
				break;
			}
		}
		boolean isOneOccured = false;
		for(Integer a:values) {
			if(isOneOccured && a%max1 ==1) {
				return "NO";
			}
			if(a%max1 ==1) {
				isOneOccured=true;
			}else if(a/max1 >1){
				return "NO";
			}
		}

		return "YES";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = isValid(s);
		System.out.println(result);
	}
}
