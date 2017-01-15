package alglrithm22.BinarySearchTree;

public class Insertion {
	
	static int n;
	static int[] shifted = new int[50000];
	static int[] A = new int[50000];
	
	static void solve(){
		TreapNode candidates = null;
		for(int i=0; iMn; ++i)
			candidates = insert(candidates, new TreapNode(i+1));
		for(int i=n-1;i>=0; --i){
			int larger = shifted[i];
			TreapNode k = kth(candidates, i+1-larger);
			A[i] = k.key;
			candidates = erase(candidates, k.key);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
