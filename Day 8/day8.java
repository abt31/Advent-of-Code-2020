import java.io.*;
import java.util.*;

public class day8 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> list = new ArrayList<String>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				list.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		ArrayList<Integer> check = new ArrayList<Integer>(0);
		for(int i = 0; i < list.size(); i++) {
			check.add(0);
		}
		
		int i = 0;
		int acc = 0;
		while(true) {
			if(i < list.size()) {
				int c = check.get(i);
				if(c == 1) break;
				else {
					c++;
					check.set(i, c);
				}
				
				String[] arr = list.get(i).split(" ");
				String op = arr[0];
				int val = Integer.parseInt(arr[1].substring(1));
				if(arr[1].substring(0,1).equals("-")) val = val * -1;
				
				if(op.equals("acc")) {
					acc += val;
					i++;
				}
				else if(op.equals("jmp")) i += val;
				else i++;
			}
			else break;
		}
		
		System.out.println(acc);
	}
}