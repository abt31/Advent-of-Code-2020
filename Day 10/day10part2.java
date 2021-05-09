import java.io.*;
import java.util.*;

public class day10part2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<Integer> list = new ArrayList<Integer>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				list.add(Integer.parseInt(line));
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		list.add(0);
		list.add(Collections.max(list)+3);
		Collections.sort(list);
		long[] count = new long[list.size()];
		count[0] = 1;
		int start = 0;
		for(int i = 1; i < count.length; i++) {
			if(i > 3) start = i-3;
			for(int j = start; j < i; j++) {
				if(list.get(i) - list.get(j) <= 3) count[i] += count[j];
			}
		}
		System.out.println(count[count.length-1]);
	}
}