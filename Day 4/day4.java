import java.io.*;
import java.util.*;

public class day4 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		int valid = 0;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int count = 0;
			boolean cid = false;
			while((line = br.readLine()) != null) {
				if(line.equals("")) {
					if(count == 8 || (count == 7 && cid == false)) {
						valid++;
					}
					count = 0;
					cid = false;
					continue;
				}
				String[] split = line.split(" ");
				for(int i = 0; i < split.length; i++) {
					if(split[i].substring(0, 3).equals("cid")) {
						cid = true;
						count++;
					}
					else if(split[i].substring(0, 3).equals("byr")) {
						String[] split_two = split[i].split(":");
						int year = Integer.parseInt(split_two[1]);
						if(split_two[1].length() == 4 && year >= 1920 && year <= 2002) {
							count++;
						}
						else continue;
					}
					else if(split[i].substring(0, 3).equals("iyr")) {
						String[] split_two = split[i].split(":");
						int year = Integer.parseInt(split_two[1]);
						if(split_two[1].length() == 4 && year >= 2010 && year <= 2020) {
							count++;
						}
						else continue;
					}
					else if(split[i].substring(0, 3).equals("eyr")) {
						String[] split_two = split[i].split(":");
						int year = Integer.parseInt(split_two[1]);
						if(split_two[1].length() == 4 && year >= 2020 && year <= 2030) {
							count++;
						}
						else continue;
					}
					else if(split[i].substring(0, 3).equals("hgt")) {
						String measure = split[i].substring(split[i].length()-2);
						if(measure.equals("cm") || measure.equals("in")) {
							String[] split_two = split[i].split(":");
							int num = 0;
							String n = "";
							for(int j = 0; j < split_two[1].length(); j++) {
								if(Character.isDigit(split_two[1].charAt(j))) {
									n += split_two[1].charAt(j);
								}
								else break;
							}
							num = Integer.parseInt(n);
							if((measure.equals("cm") && num >= 150 && num <= 193) || (measure.equals("in") && num >= 59 && num <= 76)) {
								count++;
							}
							else continue;
						}
					}
					else if(split[i].substring(0, 3).equals("hcl")) {
						String[] split_two = split[i].split(":");
						String hex = split_two[1].substring(1);
						if(split_two[1].substring(0,1).equals("#") && hex.matches("-?[0-9a-fA-F]+")) {
							count++;
						}
						else continue;
					}
					else if(split[i].substring(0, 3).equals("ecl")) {
						String[] split_two = split[i].split(":");
						String ecl = split_two[1];
						if(ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") ||
						   ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth")) {
							count++;   
						}
						else continue;
					}
					else if(split[i].substring(0, 3).equals("pid")) {
						String[] split_two = split[i].split(":");
						if(split_two[1].length() == 9) {
							count++;
						}
						else continue;
					}
				}
			}
			br.close();
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		System.out.println(valid);
	}
}