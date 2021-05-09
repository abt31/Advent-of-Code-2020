import java.io.*;
import java.util.*;

public class day2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int count = 0;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				int min = -1;
				int max = -1;
				char letter = 0;
				String pass = "";
				String buf = "";
				int index = 0;
				
				String[] arr = line.split("-");
				min = Integer.parseInt(arr[0]);
				index += arr[0].length();
				
				String[] arr2 = arr[1].split(" ");
				max = Integer.parseInt(arr2[0]);
				index += arr2[0].length() + 2;
				
				letter = line.charAt(index);
				int lc = 0;
				
				for(int i = index+3; i < line.length(); i++) {
					if(line.charAt(i) == letter) {
						lc++;
					}
				}
				
				if(lc >= min && lc <= max) {
					count++;
				}
			}
			br.close();
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		
		System.out.println(count);
	}
}