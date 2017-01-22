package alglrithm22.BinarySearchTree;

import java.util.Random;

public class TreapNode<T>{
	T key;
	//size: 이 노드를 루트로 하는 서브트리의 크기
	int priority, size;
	TreapNode<T> left, right;
	
	//Constructor
	TreapNode(T key){
		this.key = key;
		
		Random rand = new Random();
		priority = rand.nextInt();
		
		size = 1;
		left = right = null;
	}
	
	void setLeft(TreapNode newLeft){ this.left = newLeft; calcSize();}
	void setRight(TreapNode newRight){ this.right = newRight; calcSize();}
	
	void calcSize(){
		size = 1;
		if(left != null) size += left.size;
		if(right != null) size += right.size;
	}
	
}
