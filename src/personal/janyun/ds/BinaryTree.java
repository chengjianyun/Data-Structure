package personal.janyun.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

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
				node.leftClild = new BTreeNode<T>();
				constructTree(node.leftClild, i * 2 + 1, values);
			}
			if (i * 2 + 2 < values.length) {
				node.rightChild = new BTreeNode<T>();
				constructTree(node.rightChild, i * 2 + 2, values);
			}
		}
	}

	public void inOrderTravel_Recur(BTreeNode<T> node) {
		if (node != null) {
			inOrderTravel_Recur(node.leftClild);
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
				node = node.leftClild;
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
			preOrderTravle_Recur(node.leftClild);
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
				node=node.leftClild;
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
			postOderTravel_Recur(node.leftClild);
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
				node=node.leftClild;
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
			if(node.leftClild!=null)
				queue.add(node.leftClild);
			if(node.rightChild!=null)
				queue.add(node.rightChild);
		}
		
	}
}
