package personal.janyun.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

	public BTreeNode<T> root;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
		root = new BTreeNode<T>();
	}

	public void constructTree(BTreeNode<T> node, int i, T[] values) {
		if (i < values.length) {
			node.value = values[i];
			if (i * 2 + 1 < values.length) {
				node.leftChild = new BTreeNode<T>();
				constructTree(node.leftChild, i * 2 + 1, values);
			}
			if (i * 2 + 2 < values.length) {
				node.rightChild = new BTreeNode<T>();
				constructTree(node.rightChild, i * 2 + 2, values);
			}
		}
	}

	public void inOrderTravel_Recur(BTreeNode<T> node) {
		if (node != null) {
			inOrderTravel_Recur(node.leftChild);
			System.out.print(" " + node.value.toString());
			inOrderTravel_Recur(node.rightChild);
		}
	}

	public void inOrderTravel() {
		Stack<BTreeNode<T>> stack = new Stack<BTreeNode<T>>();
		BTreeNode<T> node = root;
		while (true) {

			while (node != null) {
				stack.push(node);
				node = node.leftChild;
			}
			
			if(stack.isEmpty())
				break;
			
			node = stack.pop();
			System.out.print(" " + node.value.toString());
			if (node != null)
				node=node.rightChild;

		}
	}
	
	public void preOrderTravle_Recur(BTreeNode<T> node){
		if(node != null){
			System.out.print(" "+node.value);
			preOrderTravle_Recur(node.leftChild);
			preOrderTravle_Recur(node.rightChild);
		}
	}
	
	public void preOrderTravel(){
		Stack<BTreeNode<T>> stack = new Stack<BTreeNode<T>>();
		BTreeNode<T> node = root;
		
		while(true){
			
			while(node != null){
				System.out.print(" "+ node.value.toString());
				stack.push(node);
				node=node.leftChild;
			}
			
			if(stack.isEmpty())
				break;
			
			node=stack.pop();
			if(node!=null){
				node=node.rightChild;
			}
		}
	}
	
	public void postOderTravel_Recur(BTreeNode<T> node){
		if(node!=null){
			postOderTravel_Recur(node.leftChild);
			postOderTravel_Recur(node.rightChild);
			System.out.print(" "+ node.value.toString());
		}
	}
	
	public void postOrderTrvel() {
		Stack<BTreeNode<T>> stack = new Stack<BTreeNode<T>>();
		BTreeNode<T> node = root;
		
		while(true){
			
			while(node != null){
				stack.push(node);
				node=node.leftChild;
			}
			
			if(stack.isEmpty())
				break;
			
			node=stack.pop();
			System.out.print(" "+ node.value.toString());
			if(node!=null){
				node=node.rightChild;
			}
		}
	}
	
	public void levelTravel(){
		Queue<BTreeNode<T>> queue=new LinkedList<BTreeNode<T>>();
		queue.add(root);
		while(!queue.isEmpty()){
			BTreeNode<T> node=queue.poll();
			System.out.print(" "+node.value.toString());
			if(node.leftChild!=null)
				queue.add(node.leftChild);
			if(node.rightChild!=null)
				queue.add(node.rightChild);
		}
	}
	
	public BTreeNode<T> convertToDList(BTreeNode<T> node, boolean isLeft) {
		if(node == null){
			return null;
		}
		
		BTreeNode<T> left=convertToDList(node.leftChild, true);
		node.leftChild=left;
		if(left!=null)
			left.rightChild=node;
		
		BTreeNode<T> right=convertToDList(node.rightChild, false);
		node.rightChild=right;
		if(right!=null)
			right.leftChild=node;
		
		if(right!=null && isLeft)
			return right;
		else if(left!=null && !isLeft)
			return left;
		else
			return node;
	}
	
	public BTreeNode<T> convertToDList(BinaryTree<T> tree){
		Stack<BTreeNode<T>> stack=new Stack<BTreeNode<T>>();
		BTreeNode<T> node=tree.root;
		BTreeNode<T> head=null;
		while(true){
			while(node!=null){
				stack.add(node);
				node=node.leftChild;
			}
			
			if(stack.isEmpty())
				break;
			
			node=stack.pop();			
			node.leftChild=head;	
			if(head!=null)
				head.rightChild=node;
			head=node;
			
			node=node.rightChild;
		}
		return head;
	}
}
