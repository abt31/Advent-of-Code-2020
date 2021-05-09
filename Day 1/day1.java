import java.io.*;
import java.util.*;

public class day1 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<Integer> nums = new ArrayList<Integer>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				nums.add(Integer.parseInt(line));
			}
			br.close();
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		boolean done = false;
		
		for(int i = 0; i < nums.size(); i++) {
			for(int j = i+1; j < nums.size(); j++) {
				if((nums.get(i) + nums.get(j)) == 2020) {
					System.out.println(nums.get(i) * nums.get(j));
					done = true;
					break;
				}
			}
			if(done) {break;}
		}
		
		done = false;
		
		for(int i = 0; i < nums.size(); i++) {
			for(int j = i+1; j < nums.size(); j++) {
				for(int k = i+2; k < nums.size(); k++) {
					if((nums.get(i) + nums.get(j) + nums.get(k)) == 2020) {
						System.out.println(nums.get(i) * nums.get(j) * nums.get(k));
						done = true;
						break;
					}
				}
				if(done) {break;}
			}
			if(done) {break;}
		}
	}
}