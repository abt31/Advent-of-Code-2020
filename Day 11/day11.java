import java.io.*;
import java.util.*;

public class day11 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> layout = new ArrayList<String>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				layout.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		ArrayList<String> temp = new ArrayList<String>(layout);
		int count = 0;
		while(true) {
			for(int i = 0; i < layout.size(); i++) {
				for(int j = 0; j < layout.get(i).length(); j++) {
					char current = layout.get(i).charAt(j);
					int adj = 0;
					if(current == 'L') {
						if(j > 0 && layout.get(i).charAt(j-1) == '#') adj++; //left
						if(j < layout.get(i).length()-1 && layout.get(i).charAt(j+1) == '#') adj++; //right
						if(i > 0 && layout.get(i-1).charAt(j) == '#') adj++; //up
						if(i < layout.size()-1 && layout.get(i+1).charAt(j) == '#') adj++; //down
						if(j > 0 && i > 0 && layout.get(i-1).charAt(j-1) == '#') adj++; //up-left
						if(j < layout.get(i).length()-1 && i > 0 && layout.get(i-1).charAt(j+1) == '#') adj++; //up-right
						if(j > 0 && i < layout.size()-1 && layout.get(i+1).charAt(j-1) == '#') adj++; //down-left
						if(j < layout.get(i).length()-1 && i < layout.size()-1 && layout.get(i+1).charAt(j+1) == '#') adj++; //down-right
						
						if(adj == 0) {
							StringBuilder str = new StringBuilder(temp.get(i));
							str.replace(j, j+1, "#");
							temp.set(i, str.toString());
							count++;
						}
					}
					else if(current == '#') {
						if(j > 0 && layout.get(i).charAt(j-1) == '#') adj++; //left
						if(j < layout.get(i).length()-1 && layout.get(i).charAt(j+1) == '#') adj++; //right
						if(i > 0 && layout.get(i-1).charAt(j) == '#') adj++; //up
						if(i < layout.size()-1 && layout.get(i+1).charAt(j) == '#') adj++; //down
						if(j > 0 && i > 0 && layout.get(i-1).charAt(j-1) == '#') adj++; //up-left
						if(j < layout.get(i).length()-1 && i > 0 && layout.get(i-1).charAt(j+1) == '#') adj++; //up-right
						if(j > 0 && i < layout.size()-1 && layout.get(i+1).charAt(j-1) == '#') adj++; //down-left
						if(j < layout.get(i).length()-1 && i < layout.size()-1 && layout.get(i+1).charAt(j+1) == '#') adj++; //down-right
						
						if(adj > 3) {
							StringBuilder str = new StringBuilder(temp.get(i));
							str.replace(j, j+1, "L");
							temp.set(i, str.toString());
							count++;
						}
					}
				}
			}
			if(count == 0) break;
			else {
				count = 0;
				layout = new ArrayList<String>(temp);
			}
		}
		
		for(int i = 0; i < layout.size(); i++) {
			for(int j = 0; j < layout.get(i).length(); j++) {
				if(temp.get(i).charAt(j) == '#') count++;
			}
		}
		
		System.out.println(count);
	}
}