import java.io.*;
import java.util.*;
import java.math.*;

public class day14part2 {
	
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
		
		ArrayList<String> mem = new ArrayList<String>(0);
		String mask = "";
		for(int i = 0; i < in.size(); i++) {
			if(in.get(i).substring(0,4).equals("mask")) {
				String[] arr = in.get(i).split("=");
				mask = arr[1].substring(1);
			}
			else {
				String[] arr = in.get(i).split("]");
				String num = arr[1].substring(3);
				String ind = Long.toBinaryString(Long.parseLong(arr[0].substring(4)));
				String result = "";
				while(ind.length() < 36) ind = "0" + ind;
				int count = 0;
				for(int j = 0; j < ind.length(); j++) {
					if(mask.charAt(j) == 'X') {
						result += "X";
						count++;
					}
					else if(mask.charAt(j) == '1') result += "1";
					else result += ind.charAt(j);
				}
				long end = (long)Math.pow(2.0, (double)count);
				String binary = "";
				for(int j = 0; j < count; j++) {
					binary = "0" + binary;
				}
				count = 0;
				for(long j = 0; j < end; j++) {
					StringBuilder current = new StringBuilder(result);
					for(int k = 0; k < current.length(); k++) {
						if(current.charAt(k) == 'X') {
							char replace = binary.charAt(count);
							if(replace == '0') current.replace(k, k+1, "0");
							else current.replace(k, k+1, "1");
							count++;
						}
					}
					String cur = current.toString();
					long index = Long.parseLong(cur, 2);
					cur = String.valueOf(index);
					boolean found = false;
					for(int k = 0; k < mem.size(); k++) {
						String[] arr2 = mem.get(k).split(" ");
						if(cur.equals(arr2[0])) {
							mem.set(k, cur + " " + num);
							found = true;
							break;
						}
					}
					if(!found) {
						mem.add(cur + " " + num);
					}
					long b = Long.parseLong(binary, 2);
					b++;
					binary = Long.toBinaryString(b);
					while(binary.length() < count) binary = "0" + binary;
					count = 0;
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < mem.size(); i++) {
			String[] arr3 = mem.get(i).split(" ");
			sum += Long.parseLong(arr3[1]);
		}
		System.out.println(sum);
	}
}