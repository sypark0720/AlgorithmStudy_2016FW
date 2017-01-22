package algorithm08.DynamicProgramming;

public class ArrayGenerator {
	
	public static int[][] generate(int size){
		int[][] array = new int[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++)
				array[i][j] = -1;
		}
		return array;
	}
	
	public static int[][] generateInt(int row, int col){
		int[][] array = new int[row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++)
				array[i][j] = -1;
		}
		return array;
	}
	
	public static int[] generate1d(int size){
		int[] array = new int[size];
		for(int i=0; i<size; i++)array[i] = -1;
		return array;
	}
	
	public static double[][] generateDouble(int row, int col){
		double[][] array = new double[row][col];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++)
				array[i][j] = -1;
		}
		return array;
	}
}
