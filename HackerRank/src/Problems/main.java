package Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		try {
			Problem5();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
