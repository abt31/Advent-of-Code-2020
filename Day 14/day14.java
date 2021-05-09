import java.io.*;
import java.util.*;

public class day14 {
	
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
		
		int max = 0;
		for(int i = 0; i < in.size(); i++) {
			if(in.get(i).substring(0,3).equals("mem")) {
				String[] arr = in.get(i).split("]");
				int num = Integer.parseInt(arr[0].substring(4));
				if(num > max) max = num;
			}
		}
		
		long[] mem = new long[max+1];
		String mask = "";
		for(int i = 0; i < in.size(); i++) {
			if(in.get(i).substring(0,4).equals("mask")) {
				String[] arr = in.get(i).split("=");
				mask = arr[1].substring(1);
			}
			else {
				String[] arr = in.get(i).split("]");
				String str = arr[0].substring(4);
				int index = Integer.parseInt(str);
				String val = Long.toBinaryString(Long.parseLong(arr[1].substring(3)));
				while(val.length() < 36) val = "0" + val;
				String result = "";
				for(int j = 0; j < val.length(); j++) {
					if(mask.charAt(j) == 'X') result += val.charAt(j);
					else result += mask.charAt(j);
				}
				long r = Long.parseLong(result, 2);
				mem[index] = r;
			}
		}
		
		long sum = 0;
		for(int i = 0; i < mem.length; i++) {
			sum += mem[i];
		}
		System.out.println(sum);
	}
}