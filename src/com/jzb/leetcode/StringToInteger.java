package com.jzb.leetcode;

public class StringToInteger {
	
	public static int myAtoi(String str) {
        boolean numEnd = false;
        char mark = '+';
        int result = 0;
        int temp;
        
        for (char c : str.toCharArray()) {
            if (c == ' ') {
            	if (!numEnd) {
            		continue;
            	} else {
            		break;
            	}
            }
            
            if (c >= 48 && c <= 57) {
                numEnd = true;
                
                if (!numEnd) {
                    if (mark == 'i') {
                    	result = -(c - 48);
                    } else {
                    	result = c - 48;
                    }
                } else {
                    temp = result;
                    result = result * 10 + (c - 48);
                    if ((result - (c - 48)) / 10 != temp) {
                        if (mark == '-') {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
                
            } else if (!numEnd && (c == '+' || c == '-')) {
                mark = c;
            } else {
                break;
            }
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-123"));
	}

}
