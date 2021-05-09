import java.io.*;
import java.util.*;

public class day3 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> input = new ArrayList<String>(0);
		int len = 0;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				input.add(line);
				len++;
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		int x = 0;
		int y = 0;
		
		int count_one = calc(1, 1, input, len);
		int count_two = calc(3, 1, input, len);
		int count_three = calc(5, 1, input, len);
		int count_four = calc(7, 1, input, len);
		int count_five = calc(1, 2, input, len);
		
		System.out.println(count_one + " " + count_two + " " + count_three + " " + count_four + " " + count_five);
	}
	
	public static int calc(int x_step, int y_step, ArrayList<String> input, int len) {
		int x = 0;
		int y = 0;
		int count = 0;
		while(true) {
			x = (x + x_step) % 31;
			y += y_step;
			char cur = input.get(y).charAt(x);
			if(cur == '#') count++;
			if(y >= len-1) break;
		}
		return count;
	}
}