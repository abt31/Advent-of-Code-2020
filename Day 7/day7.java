import java.io.*;
import java.util.*;

public class day7 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> list = new ArrayList<String>(0);
		ArrayList<String> counted = new ArrayList<String>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				list.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		ArrayList<String> direct = new ArrayList<String>(0);
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split("contain");
			if(arr[1].contains("shiny gold bag")) {
				direct.add(arr[0].substring(0, arr[0].length()-2));
				counted.add(arr[0].substring(0, arr[0].length()-2));
				count++;
			}
		}
		
		ArrayList<String> current = new ArrayList<String>(0);
		ArrayList<String> temp;
		for(int i = 0; i < list.size(); i++) {
			String[] arr = list.get(i).split("contain");
			for(int j = 0; j < direct.size(); j++) {
				if(arr[1].contains(direct.get(j)) && !counted.contains(arr[0].substring(0, arr[0].length()-2))) {
					current.add(arr[0].substring(0, arr[0].length()-2));
					counted.add(arr[0].substring(0, arr[0].length()-2));
					count++;
					break;
				}
			}
		}
		
		if(current.size() != 0) {
			while(true) {
				temp = new ArrayList<String>(current);
				current.clear();
				for(int i = 0; i < list.size(); i++) {
					String[] arr = list.get(i).split("contain");
					for(int j = 0; j < temp.size(); j++) {
						if(arr[1].contains(temp.get(j)) && !counted.contains(arr[0].substring(0, arr[0].length()-2))) {
							current.add(arr[0].substring(0, arr[0].length()-2));
							counted.add(arr[0].substring(0, arr[0].length()-2));
							count++;
							break;
						}
					}
				}
				if(current.size() == 0) {
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}