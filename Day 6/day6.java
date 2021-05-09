import java.io.*;
import java.util.*;

public class day6 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int sum = 0;
		ArrayList<Character> current = new ArrayList<Character>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					sum += current.size();
					current.clear();
				}
				else {
					for(int i = 0; i < line.length(); i++) {	
						if(!current.contains(line.charAt(i))) {
							current.add(line.charAt(i));
						}
					}
				}
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		sum += current.size();
		System.out.println(sum);
	}
}