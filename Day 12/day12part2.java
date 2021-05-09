import java.io.*;
import java.util.*;

public class day12part2 {
	
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
		
		int ship_x = 0;
		int ship_y = 0;
		int way_x = 10;
		int way_y = 1;
		for(int i = 0; i < list.size(); i++) {
			char action_dir = list.get(i).charAt(0);
			int num = Integer.parseInt(list.get(i).substring(1));
			if(action_dir == 'N') way_y += num;
			else if(action_dir == 'S') way_y -= num;
			else if(action_dir == 'E') way_x += num;
			else if(action_dir == 'W') way_x -= num;
			else if(action_dir == 'F') {
				for(int j = 0; j < num; j++) {
					ship_x += way_x;
					ship_y += way_y;
				}
			}
			else if(action_dir == 'R') {
				if(num == 90) {
					int temp = way_x;
					way_x = way_y;
					way_y = temp * -1;
				}
				else if(num == 180) {
					way_x *= -1;
					way_y *= -1;
				}
				else {
					int temp = way_x;
					way_x = way_y * -1;
					way_y = temp;
				}
			}
			else {
				if(num == 90) {
					int temp = way_x;
					way_x = way_y * -1;
					way_y = temp;
				}
				else if(num == 180) {
					way_x *= -1;
					way_y *= -1;
				}
				else {
					int temp = way_x;
					way_x = way_y;
					way_y = temp * -1;
				}
			}
		}
		
		if(ship_x < 0) ship_x *= -1;
		if(ship_y < 0) ship_y *= -1;
		
		System.out.println(ship_x + ship_y);
	}
}