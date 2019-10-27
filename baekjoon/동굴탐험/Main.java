package 동굴탐험;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i = 0, j = 0, k = 0;
		
//		1.테스트 케이스 T를 입력 받는다.
		int T = sc.nextInt();
		LinkedList<Integer> max_sun = new LinkedList<Integer>();
		LinkedList<Integer> max_cost = new LinkedList<Integer>();
		LinkedList<String> max_Sun = new LinkedList<String>();
//		2.(2, 3, 4를 T만큼 반복하여) 동굴의 수 N과 연결된 동굴 쌍 수 E를 입력
		for (i = 0 ; i < T ; i++) {
			int N = sc.nextInt();
			int E = sc.nextInt();
			int count = 1;
			
//			3. N개의 정수를 입력 받는다 (각각의 동굴의 가치)
			int[] N_Gachi = new int[N];
			for (j = 0 ; j < N ; j++) {
				N_Gachi[j] = sc.nextInt();
			}
			
//			4. E줄에 걸쳐서 시작하는 동굴, 끝나는 동굴, 탐험하는 가격을 입력 
			int[][] E_T = new int[E][3];
			for (j = 0 ; j < E ; j++) {
				for (k = 0 ; k < 3 ; k++) {
					E_T[j][k] = sc.nextInt();
				}
			}

//			5. 1부터 갈 수 있는 동굴의 가격을 전부 계산 
//			   간 동굴에서 갈 수 있는 동굴의 가격을 전부 계산 
			LinkedList<String> E_Sun = new LinkedList<String>();
			E_Sun.add(String.valueOf(1));
			LinkedList<String> E_Sun_T = new LinkedList<String>();
			LinkedList<String> E_Sun_F = new LinkedList<String>();
			LinkedList<Integer> cost = new LinkedList<Integer>();
			cost.add(N_Gachi[0]);
			LinkedList<Integer> E_S = new LinkedList<Integer>();
			E_S.add(1);
			LinkedList<Integer> E_F = new LinkedList<Integer>();
			LinkedList<Integer> E_True = new LinkedList<Integer>();
			LinkedList<Integer> cost_True = new LinkedList<Integer>();
			while(true) {
				int p = 0;
				while(E_S.size() != 0) {
					int t = E_S.poll();
					String a = E_Sun.poll();
					E_F.add(t);
					E_Sun_F.add(a);
					p = 1;
				}
				while(E_F.size() != 0) {
					int t = E_F.poll();
					String a = E_Sun_F.poll();
					int cost_F = cost.poll();
					int q = 0;
					for (j = 0 ; j < E ; j++) {
						if (E_T[j][0] == t) {
							q = 1;
							E_S.add(E_T[j][1]);
							int X = cost_F + N_Gachi[E_T[j][1]-1] - E_T[j][2];
							String x = a + " " + String.valueOf(E_T[j][1]);
							cost.add(X);
							E_Sun.add(x);
						}
					}
					if (q == 0) {
						E_True.add(count);
						cost_True.add(cost_F);
						E_Sun_T.add(a);
					}
				}
				if(p == 0) {
					break;
				}
				count++;
			}
//			6. 가격의 크기 비교
			int max = cost_True.poll();
			int sun = E_True.poll();
			String a = E_Sun_T.poll();
			while(cost_True.size() != 0) {
				int t = E_True.poll();
				int cost_F = cost_True.poll();
				String x = E_Sun_T.poll();
				if(max < cost_F) {
					max = cost_F;
					sun = t;
					a = x;
				}
			}
			max_sun.add(sun);
			max_cost.add(max);
			max_Sun.add(a);
			
		}
		while(max_cost.size() != 0) {
			int X = max_sun.poll();
			int Y = max_cost.poll();
			String a = max_Sun.poll();
			System.out.println(Y + " " + X);
			System.out.println(a);
		}

	}

}
