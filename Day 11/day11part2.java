import java.io.*;
import java.util.*;

public class day11part2 {
	
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
						for(int k = j-1; k >= 0; k--) { //left
							if(layout.get(i).charAt(k) == '#') {
								adj++;
								break;
							}
							else if(layout.get(i).charAt(k) == 'L') break;
						}
						for(int k = j+1; k < layout.get(i).length(); k++) { //right
							if(layout.get(i).charAt(k) == '#') {
								adj++;
								break;
							}
							else if(layout.get(i).charAt(k) == 'L') break;
						}
						for(int k = i-1; k >= 0; k--) { //up
							if(layout.get(k).charAt(j) == '#') {
								adj++;
								break;
							}
							else if(layout.get(k).charAt(j) == 'L') break;
						}
						for(int k = i+1; k < layout.size(); k++) { //down
							if(layout.get(k).charAt(j) == '#') {
								adj++;
								break;
							}
							else if(layout.get(k).charAt(j) == 'L') break;
						}
						int k = i-1;
						int l = j-1;
						while(k >= 0 && l >= 0) {
							if(layout.get(k).charAt(l) == '#') { //up-left
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k--;
								l--;
							}
						}
						k = i-1;
						l = j+1;
						while(k >= 0 && l < layout.get(i).length()) {
							if(layout.get(k).charAt(l) == '#') { //up-right
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k--;
								l++;
							}
						}
						k = i+1;
						l = j-1;
						while(k < layout.size() && l >= 0) {
							if(layout.get(k).charAt(l) == '#') { //down-left
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k++;
								l--;
							}
						}
						k = i+1;
						l = j+1;
						while(k < layout.size() && l < layout.get(i).length()) {
							if(layout.get(k).charAt(l) == '#') { //down-right
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k++;
								l++;
							}
						}
						
						if(adj == 0) {
							StringBuilder str = new StringBuilder(temp.get(i));
							str.replace(j, j+1, "#");
							temp.set(i, str.toString());
							count++;
						}
					}
					else if(current == '#') {
						for(int k = j-1; k >= 0; k--) { //left
							if(layout.get(i).charAt(k) == '#') {
								adj++;
								break;
							}
							else if(layout.get(i).charAt(k) == 'L') break;
						}
						for(int k = j+1; k < layout.get(i).length(); k++) { //right
							if(layout.get(i).charAt(k) == '#') {
								adj++;
								break;
							}
							else if(layout.get(i).charAt(k) == 'L') break;
						}
						for(int k = i-1; k >= 0; k--) { //up
							if(layout.get(k).charAt(j) == '#') {
								adj++;
								break;
							}
							else if(layout.get(k).charAt(j) == 'L') break;
						}
						for(int k = i+1; k < layout.size(); k++) { //down
							if(layout.get(k).charAt(j) == '#') {
								adj++;
								break;
							}
							else if(layout.get(k).charAt(j) == 'L') break;
						}
						int k = i-1;
						int l = j-1;
						while(k >= 0 && l >= 0) {
							if(layout.get(k).charAt(l) == '#') { //up-left
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k--;
								l--;
							}
						}
						k = i-1;
						l = j+1;
						while(k >= 0 && l < layout.get(i).length()) {
							if(layout.get(k).charAt(l) == '#') { //up-right
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k--;
								l++;
							}
						}
						k = i+1;
						l = j-1;
						while(k < layout.size() && l >= 0) {
							if(layout.get(k).charAt(l) == '#') { //down-left
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k++;
								l--;
							}
						}
						k = i+1;
						l = j+1;
						while(k < layout.size() && l < layout.get(i).length()) {
							if(layout.get(k).charAt(l) == '#') { //down-right
								adj++;
								break;
							}
							else if(layout.get(k).charAt(l) == 'L') break;
							else {
								k++;
								l++;
							}
						}
						
						if(adj > 4) {
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