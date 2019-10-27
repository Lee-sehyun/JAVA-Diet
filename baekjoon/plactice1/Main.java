package plactice1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;
		int t = -1;
		int[] visit = new int[8];
		boolean[] visited = new boolean[100001];
		LinkedList<Integer> N_t = new LinkedList<Integer>();
		LinkedList<Integer> N_f = new LinkedList<Integer>();
		
		N_t.add(N);
		visited[N] = true; 
		
		
		
		while(true) {
			while(N_t.size() != 0) {
				t = N_t.poll();
				N_f.add(t);
			}
			while(N_f.size() != 0) {
				t = N_f.poll();
				visit[0] = t-1;
				visit[1] = t-A;
				visit[2] = t-B;
				visit[3] = t+1;
				visit[4] = t+A;
				visit[5] = t+B;
				visit[6] = t*A;
				visit[7] = t*B;
				
				for (int i = 0 ; i < 8 ; i++) {
					if (visit[i] < 0 || 100000 < visit[i]) ;
					else if (visit[i] == M) {
						t = visit[i];
						break;
					}
					else if (visited[visit[i]] == false) {
						visited[visit[i]] = true;
						N_t.add(visit[i]);
					}
				}
				if (t == M) {
					break;
				}
				
			}
			count++;
			if (t == M) {
				break;
			}
		}
		System.out.print(count);
		
	}

}
