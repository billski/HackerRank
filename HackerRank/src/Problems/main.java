package Problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class main {
	
	
	public static void main(String[] args) {
		
		try {
			Problem36();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void Problem36() {
		/*
		 	n:	5
			List (n):
			SubList Size 5: 41 77 74 22 44
			SubList size 2: 1 12
			SubList size 4: 37 34 36 52
			SubList size 0:
			SubList size 3: 20 22 33
			
			d: 5
			List (n): 	4  
			Sublist 1:	3 4
			Sublist 2:	3 1
			Sublist 3:	4 3
			Sublist n:	5 5
		 */
		Scanner scanner = new Scanner(System.in);
		
		int n, d, q;
		
		// Number lists to be queried
		List<ArrayList<Integer>> numbersList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> numSubList = new ArrayList<Integer>();
		
		// Query Lists
		ArrayList<ArrayList<Integer>> queriesList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> queriesSubList = new ArrayList<Integer>();
		
		// Lines (sub lists)
		n = scanner.nextInt();
		
		// Get the numbers to be queried
		for(int row = 0; row < n; row++) {			
			d = scanner.nextInt();
			for(int j = 0; j < d; j++) {
				numSubList.add(scanner.nextInt());
			}
			numbersList.add(numSubList);
			numSubList = new ArrayList<Integer>();
		}
		
		// Amount of queries to get
		//System.out.println("Amount of queries: ");
		q = scanner.nextInt();
		
		// Add the x, y to the queries lists
		for(int i = 0; i < q; i++) {			
			queriesSubList.add(scanner.nextInt());
			queriesSubList.add(scanner.nextInt());
			queriesList.add(queriesSubList);
			queriesSubList = new ArrayList<Integer>();
		}
		
		
		// For each list in the master list
		// Start at the second position, stop at n
		for(ArrayList<Integer> i : queriesList) {

			int queryX = i.get(0) - 1;
			int queryY = i.get(1) - 1;
			int mainNumSize = numbersList.size();
			
			
			// Make sure x row exists 
			if(queryX < mainNumSize) {
				int numListSubListSize = numbersList.get(queryX).size();
				// Make sure Y column exists
				if(queryY < numListSubListSize) {
					int result = numbersList.get(queryX).get(queryY);
					
					System.out.println(result); // is i.get(1) < numbersList.get(0).size()		
				}else {
					System.out.println("ERROR!");
				}
			}else {
				System.out.println("ERROR!");
			}	
		}
		
		
	}
	
	static void Problem35() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		int size = scanner.nextInt();
		
		int maxSize = 100;
		int minSize = 1;
		int maxElementSize = (int) Math.pow(10, 4);
		int minElementSize = -((int) Math.pow(10, 4));
		int sum = 0;
		int count = 0;
		if(size > maxSize || size < minSize) {
			// Out of range
			return;
		}
		
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) 
			arr[i] = scanner.nextInt();
			
		for(int i = 0; i < size; i++) {
			for (int j = i; j <= size ; j++) {
				sum = 0;
            	for (int k = i; k < j; k++) {
                	if(arr[k] > maxElementSize || arr[k] < minElementSize) {
                		// Out of range
                		return;
                	}
                	sum += arr[k];
                }
                if(sum < 0)
                	count++;
             }
        }
		System.out.println(count);
	}
	
	static void Problem34() throws IOException {
		/*   
		 	 Hourglass
		 	1 1 1 0 0 0
			0 1 0 0 0 0
			1 1 1 0 0 0
			0 0 2 4 4 0
			0 0 0 2 0 0
			0 0 1 2 4 0
			
			1. Sum the hour glass
			2. Display largest			
		 */
				
		int arr[][] = new int[6][6]; 
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
	
		int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++) {
            	
            	// Reset for the next hourglass
            	sum = 0;
            	
            	// Top row
                sum += arr[i - 1 ][j - 1];
                sum += arr[i - 1][j];
                sum += arr[i - 1][j + 1];
                
                // Middle
                sum += arr[i][j];
                
                // Bottom row
                sum += arr[i + 1][j - 1];
                sum += arr[i + 1][j];
                sum += arr[i + 1][j + 1];
              
                if(max < sum) 
                	max = sum;      
            }
        }
        System.out.println(max);
		
	}
	
	static void Problem33() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		scan.close();
		
		int[] a = new int[n];
		
		for(int i =0; i < n; i++)
			a[i] = scan.nextInt();
		
		
		
		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
		    System.out.println(a[i]);
		}
	}
	
	static void Problem32() {
		Scanner sc = new Scanner(System.in);
        BigInteger num1 = new BigInteger(sc.next());
        BigInteger num2 = new BigInteger(sc.next());
        
        System.out.println(num1.add(num2) + "\n" + num1.multiply(num2));
	}
	
	/**
	 * Problem 31: Interfaces 
	 */
	interface AdvancedArithmetic {
		  int divisor_sum(int n);
	}
	class MyCalculator implements AdvancedArithmetic {
	    public int divisor_sum(int n) {
	            if (n <= 1) {
	                return n; 
	            }
	    
	            int res = n + 1;
	            
	            for (int i = 2; i < n; i++) {
	                if (n % i == 0) {
	                    res += i;
	                }
	            }
	    
	            return res;
	        }
	}
	
	/**
	 * Problem 30: Inheritance III
	 */
	abstract class Book{
		String title;
		abstract void setTitle(String s);
		String getTitle(){
			return title;
		}
		
	}
	class MyBook extends Book{
	    
	    void setTitle(String s){
	        super.title= s;    
	    }
	    
	}
	
	/**
	 * Problem 29: Inheritance II
	 */
	class Arithmetic{
	    
	}
	class Adder extends Arithmetic {
	    public int add(int a, int b){
	        return a + b;
	    }
	}
	
	/**
	 * Problem 28: Inheritance I
	 */
	class Animal{
		void walk() {
			System.out.println("I am walking");
		}
	}
	class Bird extends Animal{
		void fly(){
			System.out.println("I am flying");
		}
	    void sing(){
	        System.out.println("I am singing");
	    }
	}
	
	static void Problem27() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.reset();
        m.update(input.nextLine().getBytes());
        for (byte i : m.digest()) {
            System.out.print(String.format("%02x", i));
        }
        System.out.println();
        input.close();
    }
	
	static void Problem26() throws NoSuchAlgorithmException {
		Scanner sc= new Scanner(System.in);
        String input = sc.next();
        // MessageDigest instance for MD5
        
        MessageDigest md = null;
        try {
         md = MessageDigest.getInstance("MD5");   
        }catch(Exception e){
            
        }
        
        // Update MessageDigest with input text in bytes
        md.update(input.getBytes(StandardCharsets.UTF_8));
        
        // Get the hashbytes
        byte[] hashBytes = md.digest();
        
        //Convert hash bytes to hex format
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }

        // Print the hashed text
        System.out.println(sb.toString());
        
	}
	
	static void Problem25() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String n = reader.readLine();
		BigInteger num = new BigInteger(n);
		
		System.out.println(num.isProbablePrime(50) ? "prime" : "not prime");
	    
        reader.close();
	}
	
	static void Problem24() {
		//Input
		Scanner sc= new Scanner(System.in);
		
		int n=sc.nextInt();
		String []s=new String[n+2];
		for(int i=0;i<n;i++){
		    s[i]=sc.next();
		}
		
		sc.close();
		
		for(int i = 0;i < n; i++) {
            BigDecimal max=new BigDecimal(s[i]);
            int idx = i;
            for(int j= i + 1;j < n; j++) {
                BigDecimal curr=new BigDecimal(s[j]);
                if(curr.compareTo(max) == 1) {
                    max = curr;
                    idx = j;
                }
            }
            String temp = s[i];
            s[i] = s[idx];
            s[idx] = temp;
        }

		
		
		//Output
        for(int i=0;i<n;i++) {
            System.out.println(s[i]);
        }
		
	}
	
	static void Problem23() {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	boolean found = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                found = true;
            }
            if (!found) {
                System.out.println("None");
            }
			
			testCases--;
		}
		in.close();
	}
	
	static void Problem22() {
		String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
		Scanner scan = new Scanner(System.in);
	    
	    
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
        scan.close();
	    
	}
	
	static void Problem21() {
		String input = "Goodbye bye bye world world world\n";
		String pattern = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
		String result = input.replaceAll(pattern, "");
	}
	
	static void Problem20(String str) {
		if (str.trim().length() == 0 || str.trim().length() > 400000) {
			System.out.println(0);
			return;
		}
		str = str.trim(); 
		String[] strSplit = str.split("[!,?._'@\\s]+");
		System.out.println(strSplit.length);
		for(int i = 0; i < strSplit.length; i++) {
			System.out.println(strSplit[i].trim());
		}
		
		
		
	}
	
	static void Problem19(String a, String b) {
		
		boolean isAnagram = false; 
		
		if(a.length() != b.length()) {
			isAnagram = false;
			return;	
		}
		
		String tempA = a;
		
		for(int i = 0; i < a.length(); i++) {
			String toCheck = String.valueOf(a.charAt(i)).toLowerCase();
			if(b.toLowerCase().contains(toCheck)) {
				
				b = b.replaceFirst(toCheck, "");
				tempA = a.replaceFirst(toCheck, "");
				
			}else {
				isAnagram = false;
				break;
			}
			isAnagram = true;
		}
		System.out.println(isAnagram);
	}
	
	static void Problem18(String str) {
		
		int len = str.length();
		String isPali = "No";
	
		if(len == 1) {
			isPali = "Yes";
		} else {
			for(int i = 0, j = len - 1; i < (len - 1) / 2; i++, j--) {
				
				if(str.charAt(i) == str.charAt(j)) {
					isPali = "Yes";
				}else {
					isPali = "No";
					break;
				}	
			}	
		}
		
		System.out.println(isPali);
		
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
	
	static void Problem12(int year, int month, int day) {
		Date date = new GregorianCalendar(year, month-1, day).getTime();
		DateFormat df = new SimpleDateFormat("EEEE");
		String dayOfWeek = df.format(date);
		System.out.println(dayOfWeek.toUpperCase());
	}
	
	static void Problem11() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();		
		System.out.println(String.valueOf(n));
		
	}

	static void Problem10() {

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
	}
	
	static void Problem9() {
		Scanner scan = new Scanner(System.in);
        int ctr = 1;
		while (scan.hasNext()) {
            String line = scan.nextLine();
            System.out.println(ctr + " " + line);
            ctr++;
        }
		scan.close();
	}
	
	static void Problem8() {
	
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
		
	static void Problem7() {
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
	
	static void Problem6() throws NumberFormatException, IOException {
		
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
	
	static void Problem5() {
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
	
	static void Problem4() {
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
	
	static void Problem3() {
		
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
		
	static void Problem2() {
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
