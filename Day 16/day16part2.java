import java.io.*;
import java.util.*;

public class day16part2 {
	
	public static void main(String[] args) {
		String line = null;
		String filename = "input.txt";
		ArrayList<String> rules = new ArrayList<String>(0);
		ArrayList<String> tickets = new ArrayList<String>(0);
		int blank = 0;
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line = br.readLine()) != null) {
				if(line.equals("")) blank++;
				else if(blank == 0) rules.add(line);
				else if(blank == 2 && Character.isDigit(line.charAt(0))) tickets.add(line);
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}
		
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>(0);
		for(int i = 0; i < rules.size(); i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>(0);
			String[] arr = rules.get(i).split(":");
			String[] arr2 = arr[1].split("-");
			String one = arr2[0].substring(1);
			cur.add(Integer.parseInt(one));
			String two = "";
			for(int j = 0; j < arr2[1].length(); j++) {
				if(arr2[1].charAt(j) == ' ') break;
				else two += arr2[1].charAt(j);
			}
			cur.add(Integer.parseInt(two));
			String[] arr3 = arr2[1].split(" ");
			String three = arr3[2];
			cur.add(Integer.parseInt(three));
			String four = arr2[2];
			cur.add(Integer.parseInt(four));
			r.add(cur);
		}
		
		for(int i = 0; i < tickets.size(); i++) {
			String[] nums = tickets.get(i).split(",");
			for(int j = 0; j < nums.length; j++) {
				int num = Integer.parseInt(nums[j]);
				boolean valid = false;
				for(int k = 0; k < r.size(); k++) {
					int min = r.get(k).get(0);
					int max = r.get(k).get(1);
					if(num > min && num < max) {
						valid = true;
						break;
					}
					min = r.get(k).get(2);
					max = r.get(k).get(3);
					if(num > min && num < max) {
						valid = true;
						break;
					}
				}
				if(!valid) {
					tickets.remove(i);
					i--;
					break;
				}
			}
		}
		
		String[] indexes = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19"};
		ArrayList<ArrayList<String>> fits = new ArrayList<ArrayList<String>>(0);
		for(int i = 0; i < 20; i++) { //20 rules
			ArrayList<String> fit = new ArrayList<String>(0);
			Collections.addAll(fit, indexes);
			for(int j = 0; j < tickets.size(); j++) {
				String[] nums = tickets.get(j).split(",");
				int num = Integer.parseInt(nums[i]);
				for(int k = 0; k < r.size(); k++) {
					int min = r.get(k).get(0);
					int max = r.get(k).get(1);
					if(num > min && num < max) continue;
					min = r.get(k).get(2);
					max = r.get(k).get(3);
					if(num < min || num > max) fit.remove(String.valueOf(k));
				}
			}
			fits.add(fit);
		}
		
		while(true) {
			boolean execute = false;
			for(int i = 0; i < fits.size(); i++) {
				if(fits.get(i).size() == 1) {
					execute = true;
					String only = fits.get(i).get(0);
					System.out.println("col " + i + " is for rule " + only);
					for(int j = 0; j < fits.size(); j++) {
						fits.get(j).remove(only);
					}
				}
			}
			if(!execute) break;
		}
	}
}