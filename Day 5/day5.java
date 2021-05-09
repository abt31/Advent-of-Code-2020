import java.io.*;
import java.util.*;

public class day5 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int max = 0;
		ArrayList<Integer> seats = new ArrayList<Integer>(0);
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int row_min = 0;
			int row_max = 127;
			int col_min = 0;
			int col_max = 7;
			while((line = br.readLine()) != null) {
				for(int i = 0; i < 6; i++) {
					if(line.charAt(i) == 'F') {
						row_max = row_min + ((row_max - row_min) / 2);
					}
					else if(line.charAt(i) == 'B') {
						row_min = row_min + ((row_max - row_min) / 2);
						if(row_min % 2 == 1) row_min++;
					}
				}
				int row = 0;
				char last = line.charAt(6);
				if(last == 'F') row = row_min;
				else row = row_max;
				
				for(int i = 7; i < line.length()-1; i++) {
					if(line.charAt(i) == 'L') {
						col_max = col_min + ((col_max - col_min) / 2);
					}
					else if(line.charAt(i) == 'R') {
						col_min = col_min + ((col_max - col_min) / 2);
						if(col_min % 2 == 1) col_min++;
					}
				}
				int col = 0;
				last = line.charAt(9);
				if(last == 'L') col = col_min;
				else col = col_max;
				int id = (row * 8) + col;
				seats.add(id);
				if(id > max) {
					max = id;
				}
				row_min = 0;
				row_max = 127;
				col_min = 0;
				col_max = 7;
			}
			br.close();
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		System.out.println(max);
		Collections.sort(seats);
		int min_seat = seats.get(0);
		for(int i = 1; i < seats.size(); i++) {
			min_seat++;
			if(seats.get(i) != min_seat) {
				System.out.println(min_seat);
				break;
			}
		}
	}
}