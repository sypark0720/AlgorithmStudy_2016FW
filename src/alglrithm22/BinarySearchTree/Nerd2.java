package alglrithm22.BinarySearchTree;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Nerd2 {
	
	static TreeMap<Integer,Integer> coords = new TreeMap<Integer, Integer>();
	
	//새로운 점이 기존 점들에게 지배당하는지.
	static boolean isDominated(int x, int y){
		coords.put(x, y);
		if(x==coords.lastKey()) return false;
		
		Entry<Integer, Integer> next = coords.higherEntry(x);
		return (y<next.getValue());
	}
	
	//새로운 점에 지배당하는 점들을 트리에서 지운다.
	static void removeDominated(int x, int y){
		if(x==coords.firstKey()) return;
		
		Entry<Integer, Integer> current = coords.lowerEntry(x);
//		while(current.getValue()<y){
//			coords.remove(current);
//			current = coords.lowerEntry(current.getKey());
//		}
		
		while(true){
			
			if(current.getValue()>y) break; 
			
			if(current == coords.firstEntry()) {
				coords.remove(current);
				break;
			}
			
			else{
				coords.remove(current.getKey());
				current = coords.lowerEntry(current.getKey());
			}
		}
	}
	
	static int registered(int x, int y){
		if(isDominated(x,y)) return coords.size();
		removeDominated(x,y);
		return coords.size();
	}

	public static void main(String[] args) {
		int[] xs = {72,57,74,64};
		int[] ys = {50,67,55,60};
		
		for(int i=0; i<4; i++){
			System.out.println(registered(xs[i], ys[i]));
		}
	}

}
