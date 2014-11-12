package ds.java.test;

import personal.janyun.ds.BTreeNode;
import personal.janyun.ds.BinaryTree;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.constructATree();
	}
	
	public void constructATree() {
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		tree.root=new BTreeNode<Integer>();	
		Integer[] val=new Integer[]{0,1,2,3,4,5,6};
		tree.constructTree(tree.root, 0, val);
		tree.inOrderTravel_Recur(tree.root);
	}
}
