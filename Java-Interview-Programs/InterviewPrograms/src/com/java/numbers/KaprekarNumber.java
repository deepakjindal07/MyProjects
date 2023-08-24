package com.java.numbers;

import java.util.Scanner;

/*
 * Kaprekar Number
 * 
 * A Kaprekar number is a number whose square 
 * when divided into two parts and such that 
 * sum of parts is equal to the original number 
 * and none of the parts has value 0.
 * 
 * for example n = 45
 * square of 45 is = 2025
 * 2025 = 20 + 25 = 45
 * 
 * n	  Square	2 parts sum 
 * 9       81        8 + 1
 * 45      2025      20 + 25
 * 55      3025      30 + 25
 * 99      9801      98 + 01
 * 297     88209     88 + 209
 * 703     494209    494 + 209
 * 999     998001    998 + 001
 *       
 */
public class KaprekarNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any positive number :: ");
		int num = Integer.parseInt(scanner.nextLine().trim());
		if(isKaprekarNumber(num) == true )
			System.out.println("Given number "+num+" is a Kaprekar Number.");
		else
			System.out.println("Given number "+num+" is NOT a Kaprekar Number.");
		scanner.close();
	}
	
	public static boolean isKaprekarNumber(int num){
		long square = num * num;
		String str = Long.toString(square);
		for(int i=1;i<str.length();i++){
			String part1 = str.substring(0,i);
			String part2 = str.substring(i,str.length());
			long l1 = Long.valueOf(part1);
			long l2 = Long.valueOf(part2);
			if(l1 > 0 && l2 > 0 && l1+l2 == num)
				return true;
		}
		return false;
	}
}
/*
	OUTPUT
	
	Enter any positive number :: 45
	Given number 45 is a Kaprekar Number.
	
	Enter any positive number :: 20
	Given number 20 is NOT a Kaprekar Number.
*/
