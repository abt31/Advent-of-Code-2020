import java.io.*;
import java.util.*;

public class day15 {
	
	public static void main(String[] args) { //input: 9, 12, 1, 4, 17, 0, 18
		int part = Integer.parseInt(args[0]);
		int len = 0;
		if(part == 1) len = 2019;
		else len = 29999999;
		
		int[] input = {9,12,1,4,17,0,18};
		ArrayList<Integer> turns = new ArrayList<Integer>(0);
		Map<Integer, Integer> last = new HashMap<>();
		for(int i = 0; i < input.length; i++) {
			turns.add(input[i]);
			last.put(input[i],i);
		}
		
		int count = 6;
		
		while(count < len) {
			int cur = turns.get(count);
			if(!last.containsKey(cur)) turns.add(0);
			else turns.add(count - last.get(cur));
			last.put(cur, count);
			count++;
		}
		
		System.out.println(turns.get(turns.size()-1));
	}
}