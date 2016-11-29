package algorithm08.DynamicProgramming;

public class Jlis {

	public static void main(String[] args) {
		

	}
	
	final long NEGINF = Long.MIN_VALUE;
	int n,m;
	int[] A = new int[100];	
	int[] B = new int[100];	
	int cache[][] = ArrayGenerator.generate(101);
	
	int jlis(int indexA, int indexB){
		int ret = cache[indexA+1][indexB+1];
		if(ret!=-1) return ret;
		
		ret=2;
		long a = (indexA == -1? NEGINF:A[indexA]);
		long b = (indexB == -1? NEGINF:A[indexB]);
		
		long maxElement = Long.max(a, b);
		
		for(int nextA = indexA+1; nextA<n; ++nextA)
			if(maxElement < A[nextA]) ret = Integer.max(ret, jlis(nextA, indexB)+1);
		for(int nextB = indexB+1; nextB<m; ++nextB)
			if(maxElement<B[nextB]) ret = Integer.max(ret, jlis(indexA,nextB)+1);
		
		return ret;		
	}
}
