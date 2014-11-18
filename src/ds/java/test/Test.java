package ds.java.test;

import java.util.ArrayList;

import personal.janyun.ds.BSTreeNode;
import personal.janyun.ds.BTreeNode;
import personal.janyun.ds.BinaryTree;
import personal.janyun.ds.ListBSTree;
import personal.janyun.ds.RBTree;
import personal.janyun.ds.RBTreeNode;
import personal.janyun.ds.RBTreeNode.Color;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		test.constructATree();
	}
	
	public void constructATree() {
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		tree.root=new BTreeNode<Integer>();	
		Integer[] val=new Integer[]{8,5,15,3,7,12,23};
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
		
//		BTreeNode<Integer> list = tree.convertToDList(tree.root, true);
//		while(list.leftChild != null)
//			list=list.leftChild;
//		
//		System.out.println("\n=======Convert to list Travel=========");
//		while(list!=null){
//			System.out.print(" "+list.value.toString());
//			list=list.rightChild;
//		}
		
		BTreeNode<Integer> listtail=tree.convertToDList(tree);
		System.out.println("\n=======Convert to list Travel=========");
		while(listtail!=null){
			System.out.print(" "+listtail.value.toString());
			listtail=listtail.leftChild;
		}
		
		//Binary search tree
		ListBSTree bsTree=new ListBSTree();
		Integer[] vals=new Integer[]{15,12,24,4,13,17,25,3,7,19};
		for(Integer i : vals){
			BSTreeNode<Integer> node=new BSTreeNode<Integer>();
			node.value=i;
			bsTree.insert(node);
		}
		
		System.out.println("\nMAX in bsTree: " + bsTree.maximum(bsTree.root).value);
		System.out.println("MIN in bsTree: " + bsTree.minimum(bsTree.root).value);
		System.out.println("Search 7 in bsTree: " + bsTree.search(new Integer(7)).value);
		
		RBTree rbTree=new RBTree();
		Integer[] ints=new Integer[]{41,38,31,12,19,8};
		
		for(Integer i : ints){
			RBTreeNode<Integer> node=new RBTreeNode<Integer>();
			node.key=i;
			node.color=Color.red;
			rbTree.insert(node);
		}		
		rbTree.getClass();
		
		while(rbTree.root!=rbTree.NIL){
			RBTreeNode<Integer> min=rbTree.getMin(rbTree.root);
			rbTree.delete(min);
		}
		
	}
}
