package Problems;

import java.io.BufferedReader;
import java.util.GregorianCalendar;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class main {

	public static void main(String[] args) {
		
		Problem17("welcometojava", 3);
	}
	
	static void Problem17(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        for(int i = 0; i < s.length() - k + 1; i++) {
        	String compare = s.substring(i, i + k);
    		if(compare.compareTo(smallest) < 0) smallest = compare;
    		if(compare.compareTo(largest) > 0) largest = s.substring(i, i + k);
        }
      
        System.out.println(smallest + "\n" + largest);
	}
	
	static void Problem16() {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        in.close();
        System.out.println(s.substring(start, end));
	}
	
	static void Problem15() {
		Scanner scan = new Scanner(System.in);
		
		String line1 = scan.next();
		String line2 = scan.next();
		
		line1 = line1.substring(0, 1).toUpperCase() + line1.substring(1);
		line2 = line2.substring(0, 1).toUpperCase() + line2.substring(1);
		
		System.out.println(line1.length() + line2.length() + "\n"
							+ (line1.compareTo(line2) > 0 ? "Yes" : "No") + "\n"
							+ line1 + " " + line2);
		scan.close();
	}
	
	static void Problem14() {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases > 0){
			String pattern = in.nextLine();
          	try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
            testCases--;
		}
		in.close();
	}
	
	static void Problem13() {
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        if(payment <= 0 || payment >= Math.pow(10, 9)) {
        	return;
        }

		Locale indiaLocale = new Locale("en", "IN");
		
		NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
		NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		        
		System.out.println("US: "     + us.format(payment));
		System.out.println("India: "  + india.format(payment));
		System.out.println("China: "  + china.format(payment));
		System.out.println("France: " + france.format(payment));

	}
	
	static String Problem12(int year, int month, int day) {
		Date date = new GregorianCalendar(year, month-1, day).getTime();
		DateFormat df = new SimpleDateFormat("EEEE");
		String dayOfWeek = df.format(date);
		return dayOfWeek.toUpperCase();
	}
	
	static void Problem11() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();		
		System.out.println(String.valueOf(n));
		
	}

	/**
	 * Problem 10: Static blocks
	 */
	/*
	static int H, B;
	static boolean flag;
	static {
	    Scanner scan = new Scanner(System.in);
		
	    H = scan.nextInt();
		scan.nextLine();
		
		B = scan.nextInt();
		scan.nextLine();
	    
		if(H <= 0 || B <= 0) {
	    	flag = false;
	    	System.out.println("java.lang.Exception: Breadth and height must be positive");
	    }else {
	    	flag = true;	
	    }
		scan.close();
	    
	}
	*/
	
	static void Problem9() {
		
	}
	
	static void Problem8() {
		Scanner scan = new Scanner(System.in);
        int ctr = 1;
		while (scan.hasNext()) {
            String line = scan.nextLine();
            System.out.println(ctr + " " + line);
            ctr++;
        }
		scan.close();
	}
	
	static void Problem7() {
	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++){
		
			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				if(x >= -128 && x <= 127) {
					System.out.println("* byte");
				}
				if(x == (short) x) {
					System.out.println("* short");
				}
				if(x == (int) x) {
					System.out.println("* int");
				}
				if(x == (long) x) {
					System.out.println("* long");
				}
				
			} catch(Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}
			
			sc.close();
		}
				
	}
		
	static void Problem6() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
		    int a = in.nextInt();
		    int b = in.nextInt();
		    int n = in.nextInt();
		    int s = a;
            for(int j = 0; j < n; j++) {
                s += Math.pow(2, j) * b;
                System.out.printf("%s " , s);
            }
            System.out.println();
		}
		in.close();
	}
	
	static void Problem5() throws NumberFormatException, IOException {
		
		// Given an integer, n, print its first 10 multiples. 
		// Each multiple n x i (where 1 <= i <= 10) should be printed on a new line in the
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        if(n >= 2 && n <= 20) {
        	for (int i = 1; i < 11; i++) {
        		System.out.println(String.valueOf(n) + " x " + String.valueOf(i) + " = " + i * n);
        	}
        }
        
        
        bufferedReader.close();
		
	}
	
	static void Problem4() {
		 Scanner sc = new Scanner(System.in);
         System.out.println("================================");
         for(int i = 0; i < 3; i++){
             String s1 = sc.next();
             int x = sc.nextInt();
             System.out.println(s1 + String.format("%1$" + (18 - s1.length()) + "s", 
            		 				String.format("%1$" + 3 + "s", x).replace(' ', '0')));
             
             
         }
         
         System.out.println("================================");
         
         sc.close();
	}
	
	static void Problem3() {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		Double d = scan.nextDouble();
		scan.nextLine();
		String s = scan.nextLine();
		
		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		scan.close();
	}
	
	static void Problem2() {
		
		/*
		 	Given an integer, n, perform the following conditional actions:

			If n is odd, print Weird
			If n is even and in the inclusive range of  to , print Not Weird
			If n is even and in the inclusive range of  to , print Weird
			If n is even and greater than , print Not Weird
		*/
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if(num <= 100 && num >= 1) {
			if(num % 2 == 0) {
				if((num >= 2 && num <= 5)) {
					System.out.println("Not Weird");
				}else if ( (num >= 6 && num <= 20)) {
					System.out.println("Weird");
				}else if(num > 20) {
					System.out.println("Not Weird");
				}	
			} else {
				System.out.println("Weird");
			}	
		}else {
			System.out.println("Invalid number.");
			
		}
		scanner.close();
	}
		
	static void Problem1() {
		Scanner scanner = new Scanner(System.in);
		Integer ints[] = new Integer[3];  
		
		for(int i = 0, j = 0; i < ints.length || j < ints.length;) {
		
			if(i < ints.length) {
				ints[i] = scanner.nextInt();
				i++;
			}
			
			if(i == ints.length) {
				System.out.println(ints[j]);
				j++;				
			}
		}
		
		scanner.close();
	}

}
