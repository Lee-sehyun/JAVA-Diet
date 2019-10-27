package 지뢰찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int Count_L(int[][] array, int a, int b) {
		
		int count = 0;
		
		for (int i = a-1 ; i <= a+1 ; i++) {
			for (int j = b-1 ; j <= b+1 ; j++) {
				if (array[i][j] == '*') {
					count++;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList List_x = new ArrayList();
		ArrayList List_y = new ArrayList();
		int x, y;
		int count = 0;
		
		while(true) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(x == 0 && y == 0) {
				break;
			}
			List_x.add(x);
			List_y.add(y);
			count++;
		}
		
		int i = 0;
		
		while(i != count) {
			x = List_x[i];
			y = List_y[i];
			
			int[][] find = new int[x][y];
		}
		


	}

}