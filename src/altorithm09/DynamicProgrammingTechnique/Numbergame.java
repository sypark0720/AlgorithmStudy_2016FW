package altorithm09.DynamicProgrammingTechnique;

import algorithm08.DynamicProgramming.ArrayGenerator;

public class Numbergame {

	public static final int EMPTY = -987654321;
	int n;
	int[] board = new int[50];
	int[][] cache = ArrayGenerator.generateInt(50, 50);
	
	int play(int left, int right){
		//basic
		if(left>right) return 0;
		int ret = cache[left][right];
		if(ret != EMPTY) return ret;
		
		//수를 가져가는 경우
		ret = Integer.max(board[left]-play(left+1, right), board[right]-play(left, right-1));
		
		//수를 없애는 경우
		if(right-left+1 >= 2){
			ret=Integer.max(ret, -play(left+2, right));
			ret = Integer.max(ret, -play(left+2, right));
			ret=Integer.max(ret, -play(left, right-2));
			
		}
		return ret;		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
