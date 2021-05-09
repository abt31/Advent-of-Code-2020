import java.io.*;
import java.util.*;

public class day2part2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int count = 0;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				int first = -1;
				int second = -1;
				char letter = 0;
				String pass = "";
				String buf = "";
				int index = 0;
				
				String[] arr = line.split("-");
				first = Integer.parseInt(arr[0]);
				index += arr[0].length();
				
				String[] arr2 = arr[1].split(" ");
				second = Integer.parseInt(arr2[0]);
				index += arr2[0].length() + 2;
				
				letter = line.charAt(index);
				int lc = 0;
				
				if(line.charAt(index+3+(first-1)) == letter) {
					lc++;
				}
				if(line.charAt(index+3+(second-1)) == letter) {
					lc++;
				}
				
				if(lc == 1) count++;
			}
			br.close();
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		
		System.out.println(count);
	}
}