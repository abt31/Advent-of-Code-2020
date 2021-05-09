import java.io.*;
import java.util.*;

public class day12 {
	
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
		
		int x = 0;
		int y = 0;
		char dir = 'E';
		for(int i = 0; i < list.size(); i++) {
			char action_dir = list.get(i).charAt(0);
			int num = Integer.parseInt(list.get(i).substring(1));
			if(action_dir == 'N') y += num;
			else if(action_dir == 'S') y -= num;
			else if(action_dir == 'E') x += num;
			else if(action_dir == 'W') x -= num;
			else if(action_dir == 'F') {
				if(dir == 'N') y += num;
				else if(dir == 'S') y -= num;
				else if(dir == 'E') x += num;
				else if(dir == 'W') x -= num;
			}
			else if(action_dir == 'L') {
				if(num == 90) {
					if(dir == 'N') dir = 'W';
					else if(dir == 'S') dir = 'E';
					else if(dir == 'E') dir = 'N';
					else if(dir == 'W') dir = 'S';
				}
				else if(num == 180) {
					if(dir == 'N') dir = 'S';
					else if(dir == 'S') dir = 'N';
					else if(dir == 'E') dir = 'W';
					else if(dir == 'W') dir = 'E';
				}
				else if(num == 270) {
					if(dir == 'N') dir = 'E';
					else if(dir == 'S') dir = 'W';
					else if(dir == 'E') dir = 'S';
					else if(dir == 'W') dir = 'N';
				}
			}
			else {
				if(num == 90) {
					if(dir == 'N') dir = 'E';
					else if(dir == 'S') dir = 'W';
					else if(dir == 'E') dir = 'S';
					else if(dir == 'W') dir = 'N';
				}
				else if(num == 180) {
					if(dir == 'N') dir = 'S';
					else if(dir == 'S') dir = 'N';
					else if(dir == 'E') dir = 'W';
					else if(dir == 'W') dir = 'E';
				}
				else if(num == 270) {
					if(dir == 'N') dir = 'W';
					else if(dir == 'S') dir = 'E';
					else if(dir == 'E') dir = 'N';
					else if(dir == 'W') dir = 'S';
				}
			}
		}
		
		if(x < 0) x *= -1;
		if(y < 0) y *= -1;
		
		System.out.println(x+y);
	}
}