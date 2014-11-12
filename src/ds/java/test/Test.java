package ds.java.test;

import ds.java.tree.BinaryTree;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		Integer[] val=new Integer[]{0,1,2,3,4,5,6};
		tree.constructTree(tree.root, 0, val);

		tree.inOrderTravel(tree.root);
	}

}
