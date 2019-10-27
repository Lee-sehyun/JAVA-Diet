package 적록색약;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 넓이 우선 탐색을 이용하는 것이 좋겠다.
		 한 구역을 구하고 처음부터 다시 살펴보면 너무 비효율적 
		 따라서 다이나믹 프로그래밍을 이용하자. 어떻게?
		 boolean 2차원 배열에서 마지막으로 시작한 곳... 음... !! 어렵네 
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] RGB = new String[N];
		for (int i = 0 ; i < N ; i++) {
			RGB[i] = sc.nextLine(); 
		}
		System.out.println(RGB);
		
//		1. boolean 2차원 배열로 N*N 만들기
		boolean[][] N_S = new boolean[N][N];
//		2. 1번자리 문자열 빼내고 true로 바꾸기 
//		3. 큐에서 하나씩 빼면서 넓이 우선 탐색을 이용
//		4. 큐가 다 없어지면 boolean에서 true인 값을 찾아 다시 넣어주기
//		(문제는 true인 값을 처음부터 다시 살펴보는 것 말고 또 뭐가 있냐는 거지)
//		5. 반

	}

}
