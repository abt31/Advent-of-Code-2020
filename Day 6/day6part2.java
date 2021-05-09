import java.io.*;
import java.util.*;

public class day6part2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int sum = 0;
		ArrayList<Character> current = new ArrayList<Character>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			boolean first = true;
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					sum += current.size();
					first = true;
					current.clear();
				}
				else {
					if(first) {
						first = false;
						for(int i = 0; i < line.length(); i++) {
							if(!current.contains(line.charAt(i))) {
								current.add(line.charAt(i));
							}
						}
					}
					else {
						if(current.size() > 0) {	
							ArrayList<Character> current_two = new ArrayList<Character>(0);
							for(int i = 0; i < line.length(); i++) {	
								if(!current_two.contains(line.charAt(i))) {	
									current_two.add(line.charAt(i));
								}
							}
							ArrayList<Character> temp = new ArrayList<Character>(current);
							for(int i = 0; i < current.size(); i++) {
								if(!current_two.contains(current.get(i))) {
									temp.remove(current.get(i));
								}
							}
							current = new ArrayList<Character>(temp);
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