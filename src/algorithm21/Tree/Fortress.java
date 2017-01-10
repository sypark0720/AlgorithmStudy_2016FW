package algorithm21.Tree;

import java.util.Vector;

public class Fortress {
	
	//data
	static int n; //성벽 갯수
	static int[] y;
	static int[] x;
	static int[] radius;
	
	/** 1. 한 성벽이 다른 성벽에 포함 되는지 */
	static int sqr(int x){
		return x*x;
	}
	
	static int sqrdist(int a, int b){
		return sqr(y[a]-y[b])+sqr(x[a]-x[b]);
	}
	
	static boolean encloses(int a, int b){
		return radius[a]>radius[b] && sqrdist(a,b) <sqr(radius[a]-radius[b]);
	}
	
	/** 2. 트리 생성 -> root 성벽을 루트로 하는 트리를 생성한다.*/
	static TreeNode getTree(int root){
		TreeNode ret = new TreeNode();
		for(int ch = 0; ch<n; ++ch)
			if(isChild(root, ch))
				ret.children.add(getTree(ch));
		return ret;
	}
	

	//parent가 child의 부모인지 확인하는 함수
	static boolean isChild(int parent, int child){
		// case1: parent이 child 포함 안하면 false
		if(!encloses(parent, child)) return false;
		
		// case2: parent나 child사이에 다른 성벽이 있으면 false
		for(int i=0; i<n; ++i)
			if( i!= parent && i!= child && encloses(parent, i) && encloses(i, child)) 
				return false;
		
		// 그 외: true
		return true;
	
	}
	
	/** 3. 최장 경로 찾기 */
	static int longest;
	
	//root를 루트로 하는 서브트리의 높이 반환
	static int height(TreeNode root){
		
		//각 자식을 루트로 하는 서브트리의 높이 계산
		Vector<Integer> heights = new Vector<Integer>();
		for(int i=0; i<root.children.size(); ++i)
			heights.add(height(root.children.get(i)));
		//자식이 없다면 0반환		
		if(heights.isEmpty()) return 0;
		
		//root를 최상위 노드로 하는 경로
		sort(heights); //소트 해서 상위 2개
		if(heights.size()>=2)
			longest = Integer.max(longest, 2+heights.get(heights.size()-2)+heights.get(heights.size()-1));
		
		return heights.lastElement() + 1;
	}
	
	
	//root를 루트로 할 때, 가장 긴 경로 길이 계산.(트리의 높이와 최대 잎-잎 경로중 더 큰 것)
	static int solve(TreeNode root){
		longest = 0;
		int h = height(root);
		return Integer.max(longest, h);
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
