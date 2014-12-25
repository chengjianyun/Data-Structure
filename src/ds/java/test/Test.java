package ds.java.test;

import java.util.ArrayList;
import java.util.Hashtable;

import personal.janyun.ds.BSTreeNode;
import personal.janyun.ds.BTreeNode;
import personal.janyun.ds.BinaryTree;
import personal.janyun.ds.ListBSTree;
import personal.janyun.ds.RBTree;
import personal.janyun.ds.RBTreeNode;
import personal.janyun.ds.RBTreeNode.Color;
import personal.jianyun.algo.ArrayAlgo;
import personal.jianyun.algo.Recursion;
import personal.jianyun.algo.Sort;

public class Test {
	
	 public static class RandomListNode {
	      int label;
	      public RandomListNode next, random;
	      public RandomListNode(int x) { this.label = x; }
	 };
	
	public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode n1=head,n2=null,copyHead=null;
        while(n1!=null){
            n2=new RandomListNode(n1.label);
            n2.next=n1.next;
            n1.next=n2;
            n1=n2.next;
        }
        n1=head;
        n2=n1.next;
        while(n1!=null && n2!=null){
            if(n1.random!=null)
                n2.random=n1.random.next;
            n1=n2.next;
            if(n1!=null)
            	n2=n1.next; 
        }
        n1=head;
        copyHead=n2=n1.next;
        while(n1!=null && n2!=null){
            n2=n1.next;
            n1.next=n2.next;
            n1=n1.next;
            if(n1!=null){
                n2.next=n1.next;
            }
            else
                break;
        }
        return copyHead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test = new Test();
		RandomListNode n1=new RandomListNode(-1);
		RandomListNode n2=new RandomListNode(-1);
		n1.next=n2;
		n2.next=null;
		n1.random=null;
		n2.random=n1;
		
		RandomListNode n3=copyRandomList(n1);
		System.out.print(n3.toString());
		
//		test.constructATree();
	}

	public void constructATree() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTreeNode<Integer>();
		Integer[] val = new Integer[]{8, 5, 15, 3, 7, 12, 23};
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
		tree.postOderTravel_Recur(tree.root);
		System.out.println("\n=======post order=========");
		tree.postOrderTrvel();

		System.out.println("\n=======Level Travel=========");
		tree.levelTravel();

		// BTreeNode<Integer> list = tree.convertToDList(tree.root, true);
		// while(list.leftChild != null)
		// list=list.leftChild;
		//
		// System.out.println("\n=======Convert to list Travel=========");
		// while(list!=null){
		// System.out.print(" "+list.value.toString());
		// list=list.rightChild;
		// }

		BTreeNode<Integer> listtail = tree.convertToDList(tree);
		System.out.println("\n=======Convert to list Travel=========");
		while (listtail != null) {
			System.out.print(" " + listtail.value.toString());
			listtail = listtail.leftChild;
		}

		// Binary search tree
		ListBSTree bsTree = new ListBSTree();
		Integer[] vals = new Integer[]{15, 12, 24, 4, 13, 17, 25, 3, 7, 19};
		for (Integer i : vals) {
			BSTreeNode<Integer> node = new BSTreeNode<Integer>();
			node.value = i;
			bsTree.insert(node);
		}

		System.out.println("\nMAX in bsTree: "
				+ bsTree.maximum(bsTree.root).value);
		System.out.println("MIN in bsTree: "
				+ bsTree.minimum(bsTree.root).value);
		System.out.println("Search 7 in bsTree: "
				+ bsTree.search(new Integer(7)).value);

		RBTree rbTree = new RBTree();
		Integer[] ints = new Integer[]{41, 38, 31, 12, 19, 8};

		for (Integer i : ints) {
			RBTreeNode<Integer> node = new RBTreeNode<Integer>();
			node.key = i;
			node.color = Color.red;
			rbTree.insert(node);
		}
		rbTree.getClass();

		while (rbTree.root != rbTree.NIL) {
			RBTreeNode<Integer> min = rbTree.getMin(rbTree.root);
			rbTree.delete(min);
		}

		int[] values = new int[]{8, 7, 12, 9, 20, 15, 3, 38, 26};
		System.out.println("=============before sort=================");
		for (int i = 0; i < values.length; i++) {
			System.out.print(" " + values[i]);
		}

		Sort sort = new Sort();
		// sort.insertSort(values, values.length);
		// System.out.println("=============insertion sort=================");
		// for(int i=0;i<values.length;i++){
		// System.out.print(" "+values[i]);
		// }

		// sort.quickSort(values, 0, values.length-1);
		// System.out.println("\n=============quick sort=================");
		// for(int i=0;i<values.length;i++){
		// System.out.print(" "+values[i]);
		// }

		sort.mergeSort(values, 0, values.length - 1);
		System.out.println("\n=============merge sort=================");                              
		for (int i = 0; i < values.length; i++) {
			System.out.print(" " + values[i]);
		}

		int[] v1 = new int[]{1, -2, 3, 5, -3, 2};
		int[] v2 = new int[]{0, -2, 3, 5, -1, 2};
		int[] v3 = new int[]{-9, -2, -3, -5, -3};
		
		int max1 = ArrayAlgo.getMaxSubArray(v1, v1.length);
		int max2 = ArrayAlgo.getMaxSubArray(v2, v2.length);
		int max3 = ArrayAlgo.getMaxSubArray(v3, v3.length);

		System.out.println("\nmax sub array in v1: " + max1);
		System.out.println("max sub array in v2: " + max2);
		System.out.println("max sub array in v3: " + max3);

		Recursion recurision = new Recursion();
		ArrayList<Character> c = new ArrayList<Character>();
		Recursion.combine("abcde".toCharArray(), 0, 2, c);
		
		int[] a=new int[]{88, 7, 5, 99, 8, 3, 54, 65, 12};
		System.out.println(Recursion.getLIS(a, 9));
		
		Recursion a1=null,a2=null;
		System.out.println(a1==a2);
		
		Hashtable<Integer, Integer> table=new Hashtable<Integer,Integer>();
		table.put(2, 3);
		if(table.contains(2)){
			table.get(3);
		}
	}
}
