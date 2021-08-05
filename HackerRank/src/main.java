import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
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
		
	}

}
