package personal.janyun.ds;

public class BinaryTree<T> {

	public BTreeNode<T> root;

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
	
	public void inOrderTravel(){
		
	}
}
