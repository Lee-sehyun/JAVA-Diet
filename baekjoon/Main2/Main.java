import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LinkedList<String> A = new LinkedList<String>();
		int count = 0;
		int B = 0;
		String Y;
		int L;
		String P = "";
	
		while(true) {
			String X = sc.nextLine();
			if (X.charAt(0) == '.' && P == "") break;
			if (X.charAt(X.length()-1) == '.') {
				P = P + X.substring(0, X.length()-1);
				A.add(P);
				count++;
				P = "";
			}
			else {
				P = P + X + "\n"; 
			}	
		}
	
		for(int i = 0 ; i < count ; i++) {
			Y = A.poll();
			B = 0;
			L = Y.length();
			for (int k = 0 ; k < L ; k++) {
				if (B != 0) {
					break;
				}
				char Z = Y.charAt(k);
				if (Z == '(' || Z == '[') {
					char X = Y.charAt(k);
					Y = Y.substring(0, k) + Y.substring(k+1, Y.length());
					L = Y.length(); 
					B = 1;
					for (int l = k ; l < L ; l++) {
						char C  = Y.charAt(l);
						if (C == '(' || C == '[') {
							if (X == '(' || X == '[') {
								B++;
								X = C;
							}
							else {
								X = C;
							}
						}
						else if (C == ')' || C == ']') {
							if (X == ')' || X == ']') {
								B--;
								X = C;
							}
							else {
								X = C;
							}
							if (B == 1) {
								if (Z == '(' && X == ')') {
									Y = Y.substring(0, l) + Y.substring(l+1, Y.length());
									L = Y.length();
									B = 0;
								}
								else if (Z == '[' && X == ']') {
									Y = Y.substring(0, l) + Y.substring(l+1, Y.length());
									L = Y.length();
									B = 0;
								}
								else {
									B = -1;
								}	
								k--;
								break;
							}
						}
					}
				}	
				else if (Y.charAt(k) == ')' || Y.charAt(k) == ']') {
					B = -1;
					break;
				}
			}
			if (B == 0) {
				System.out.println("yes");
			}	
			else {
				System.out.println("no");
			}
		}

	}

}
