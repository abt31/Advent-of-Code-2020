import java.io.*;
import java.util.*;
import java.math.*;

public class day13part2 {

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
		
		String[] str = in.get(1).split(",");
		long step = Long.parseLong(str[0]);
		long time = step;
		long save = 0;
		int high = 1;
		while(true) {
			int index = 0;
			int amt = 0;
			long cur = time;
			save = cur;
			boolean done = true;
			while(true) {
				if(index == str.length) break;
				if(str[index].equals("x")) {
					index++;
					cur++;
					continue;
				}
				else {
					long id = Long.parseLong(str[index]);
					if(cur % id == 0) {
						index++;
						cur++;
						amt++;
						continue;
					}
					else {
						done = false;
						break;
					}
				}
			}
			if(done) break;
			else {
				if(amt > high) {
					high = amt;
					long temp = 1;
					int c = 0;
					for(int i = 0; i < str.length; i++) {
						if(!str[i].equals("x")) {
							temp *= Long.parseLong(str[i]);
							c++;
						}
						if(c == high) break;
					}
					step = temp;
				}
				time += step;
			}
		}
		
		System.out.println(save);
	}
}