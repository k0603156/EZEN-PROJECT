package com.myweb.util;

public class OptionID {
	// return 값
	// 오류 : -1
	// 사이즈, 온도 상관없음(food): 9
	public static int getOptionID(String opt_temp, String opt_size) {
		if(opt_temp.equals("hot")) {
			if(opt_size.equals("short")) return 1; 
			else if(opt_size.equals("tall")) return 2; 
			else if(opt_size.equals("grande")) return 3;
			else if(opt_size.equals("venti")) return 4;
			else return -1;
		}
		else if(opt_temp.equals("ice")) {
			if(opt_size.equals("short")) return 5; 
			else if(opt_size.equals("tall")) return 6; 
			else if(opt_size.equals("grande")) return 7;
			else if(opt_size.equals("venti")) return 8;
			else return -1;
		}
		else if(opt_temp.equals("none")) {
			return 9;
		}
		return -1;
	}
}
