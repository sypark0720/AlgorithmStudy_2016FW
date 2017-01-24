package algorithm09.DynamicProgrammingTechnique;

import java.util.Vector;

import algorithm08.DynamicProgramming.ArrayGenerator;

public class Packing {
	
	static int n = 6;
	static int capacity = 10;
	static int[] volume = {4,2,6,4,2,10};
	static int[] need = {7,10,6,7,5,4};
	static int[][] cache = ArrayGenerator.generateInt(1001, 100);
    static String[] name = {"laptop", "camera", "xbox", "grinder", "dumbell", "encyclopedia"};

	public static int pack(int capacity, int item){
		//Base case
		if(item == n) return 0;
		
		int ret = cache[capacity][item];
		if(ret != -1) return ret;
		
		//물건 담지 않을 경우
		ret = pack(capacity, item+1);
		
		//물건 담을 경우
		if( capacity >= volume[item])
			ret = Integer.max(ret, pack(capacity - volume[item], item+1)+need[item]);
		cache[capacity][item] = ret;
		return ret;
		
	}
	
	static void reconstruct(int capacity, int item, Vector<String> picked){
		if(item == n) return;
		if(pack(capacity, item) == pack(capacity, item+1)){
			reconstruct(capacity, item+1, picked);
		}
		else{
			picked.add(name[item]);
			reconstruct(capacity-volume[item], item+1, picked);
		}
	}
	
	public static void main(String[] args) {
		int result = pack(10, 0);
		System.out.println(result);
		
		int item = 0;
		Vector<String> picked = new Vector<String>();
		
		reconstruct(capacity, item, picked);
		for(int i=0; i<picked.size(); i++){
			System.out.println(picked.get(i));
		}
	}

}
