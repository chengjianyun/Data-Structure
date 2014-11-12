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
		System.out.println("=======in order recurive=========");
		tree.inOrderTravel_Recur(tree.root);
		System.out.println("\n=======in order=========");
		tree.inOrderTravel();
		System.out.println("\n=======pre order recurive=========");
		tree.preOrderTravle_Recur(tree.root);
		System.out.println("\n=======pre order=========");
		tree.preOrderTravel();
		System.out.println("\n=======post order recurive=========");
		tree.preOrderTravle_Recur(tree.root);
		System.out.println("\n=======post order=========");
		tree.preOrderTravel();
		
		System.out.println("\n=======Level Travel=========");
		tree.levelTravel();
	}
}
