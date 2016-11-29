package algorithm08.DynamicProgramming;

public class Poly {
	
	private static final int MOD = 10000000;
	static int[][] cache = ArrayGenerator.generate(101);
	
	static //n개의 정사각형으로 이루어졌고, 맨 위 가로줄에 first 개의 정사각형을 포함하는 폴리오미노의 수를 반환한다.
	int poly(int n, int first){
		//Base case
		if(n==first) return 1;
		
		int ret = cache[n][first];
		if(ret!=-1) return ret;
		ret=0;
		for(int second = 1; second<= n-first; ++second){
			int add = second+first-1;
			add *= poly(n-first, second);
			add %= MOD;
			ret += add;
			ret %= MOD;
		}
		cache[n][first] = ret;
		return ret;
	}
	
	
	public static void main(String[] args){
		int ret = 0;
		for(int i=1; i<93; i++){
			ret+= poly(92, i);
		}
		System.out.println(ret);
	}
}
