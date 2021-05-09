import java.io.*;
import java.util.*;

public class day7part2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> list = new ArrayList<String>(0);
		String sgb = "";
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				if(line.substring(0,15).equals("shiny gold bags")) sgb = line;
				list.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		String[] arr = sgb.split("contain");
		arr[1] = arr[1].substring(1,arr[1].length()-1);
		String[] arr2 = arr[1].split(",");
		
		int count = 0;
		for(int i = 0; i < arr2.length; i++) {
			if(i > 0) arr2[i] = arr2[i].substring(1);
			count += search(list, Integer.parseInt(arr2[i].substring(0,1)), arr2[i].substring(2));
		}
		
		System.out.println(count);
	}
	
	public static int search(ArrayList<String> list, int num, String bag) {
		if(num > 1) bag = bag.substring(0, bag.length()-1);
		String line = "";
		boolean found = false;
		for(int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split("contain");
			arr[0] = arr[0].substring(0, arr[0].length()-2);
			if(arr[0].equals(bag)) {
				line = list.get(i);
				found = true;
				break;
			}
		}
		if(found) {
			String[] arr = line.split("contain");
			arr[1] = arr[1].substring(1,arr[1].length()-1);
			String[] arr2 = arr[1].split(",");
			int c = 0;
			
			for(int i = 0; i < arr2.length; i++) {
				if(i > 0) arr2[i] = arr2[i].substring(1);
				if(arr2[i].equals("no other bags")) {
					c++;
				}
				c += num * search(list, Integer.parseInt(arr2[i].substring(0,1)), arr2[i].substring(2));
			}
			return c;
		}
		return 0;
	}
}