import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		int count = 0;
		int A = 0;
		int B = 0;
		
		for (int i = 1 ; i < n ; i++) {
			if (a*i + b*(n-i) == w) {
				count++;
				if (count == 2) break;
				A = i;
				B = n-i;
			}
		}
		if (count == 1) {
			System.out.print(A + " " + B);
		}
		else {
			System.out.print(-1);
		}

	}

}
