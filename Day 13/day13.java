import java.io.*;
import java.util.*;

public class day13 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> in = new ArrayList<String>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				in.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		int ts = Integer.parseInt(in.get(0));
		String[] arr = in.get(1).split(",");
		
		int id = -1;
		int wait = 99999;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("x")) continue;
			
			int cur = Integer.parseInt(arr[i]);
			int sum = cur;
			while(sum < ts) {
				sum += cur;
			}
			
			int cur_w = sum - ts;
			if(cur_w < wait) {
				wait = cur_w;
				id = cur;
			}
		}
		
		System.out.print(id * wait);
	}
}