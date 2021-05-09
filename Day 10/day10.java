import java.io.*;
import java.util.*;

public class day10 {
	
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
		
		int one_count = 0;
		int three_count = 1;
		int current = 0;
		while(true) {
			int diff = 4;
			int val_index = -1;
			for(int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				if(current+3 >= num && num - current < diff) {
					diff = num - current;
					val_index = i;
				}
			}
			current = list.get(val_index);
			if(diff == 1) one_count++;
			else if(diff == 3) three_count++;
			list.remove(val_index);
			if(list.size() == 0) break;
		}
		
		System.out.println(one_count * three_count);
		
	}
}