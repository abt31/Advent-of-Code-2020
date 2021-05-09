import java.io.*;
import java.util.*;

public class day9 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<Long> list = new ArrayList<Long>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				list.add(Long.parseLong(line));
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		int index = 0;
		while(true) {
			long check = list.get(index+25);
			boolean found = false;
			for(int i = index; i < index + 24; i++) {
				for(int j = index + 1; j < index + 25; j++) {
					long sum = list.get(i) + list.get(j);
					if(sum == check) {
						found = true;
						break;
					}
				}
				if(found) break;
			}
			if(found) index++;
			else break;
		}
		
		System.out.println(list.get(index+25));
		
		long val = list.get(index+25);
		
		index = 0;
		int index_inner = -1;
		while(true) {
			long sum = 0;
			index_inner = index;
			boolean found = false;
			while(true) {
				sum += list.get(index_inner);
				if(sum == val) {
					found = true;
					break;
				}
				else if(sum > val) break;
				else index_inner++;
			}
			if(found) break;
			else index++;
		}
		
		long min = list.get(index);
		long max = list.get(index);
		
		for(int i = index+1; i < index_inner; i++) {
			if(list.get(i) < min) min = list.get(i);
			else if(list.get(i) > max) max = list.get(i);
		}
		
		System.out.println(min+max);
	}
}