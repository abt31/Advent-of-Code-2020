import java.io.*;
import java.util.*;
import java.lang.*;

public class day8part2 {
	
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
		ArrayList<String> temp = new ArrayList<String>(list);
		int change_i = 0;
		
		while(true) {
			boolean terminate = true;
			for(int j = change_i; j < list.size(); j++) {
				if(list.get(j).substring(0,3).equals("nop")) {
					StringBuilder edit = new StringBuilder(list.get(j));
					edit.replace(0,3,"jmp");
					list.set(j, edit.toString());
					change_i = j + 1;
					break;
				}
				else if(list.get(j).substring(0,3).equals("jmp")) {
					StringBuilder edit = new StringBuilder(list.get(j));
					edit.replace(0,3,"nop");
					list.set(j, edit.toString());
					change_i = j + 1;
					break;
				}
			}
			while(true) {
				if(i < list.size()) {
					int c = check.get(i);
					if(c == 1) {
						terminate = false;
						break;
					}
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
			if(terminate) break;
			else {
				for(int j = 0; j < check.size(); j++) {
					check.set(j, 0);
				}
				list = new ArrayList<String>(temp);
				i = 0;
				acc = 0;
			}
		}
		
		System.out.println(acc);
	}
}