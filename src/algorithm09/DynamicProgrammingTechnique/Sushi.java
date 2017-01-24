package algorithm09.DynamicProgrammingTechnique;

import algorithm08.DynamicProgramming.ArrayGenerator;

public class Sushi {

	static int MAX_BUDGET;
	static int n, m;
	static int[] price, pref;
	static int[] c = ArrayGenerator.generate1d(201); //각 셀에는 budget-price[dish]	
	
	static int sushi(){
		int ret=0;
		for(int budget=1; budget<=m; ++budget){
			c[budget] = 0;
			for(int dish=0; dish<n; ++dish)
				if(budget>=price[dish])
					c[budget]=Integer.max(c[budget], c[budget-price[dish]]+pref[dish]);
			ret=Integer.max(ret, c[budget]);
		}
		return ret;
	}
	
	
	
	public static void main(String[] args) {

	}

}
