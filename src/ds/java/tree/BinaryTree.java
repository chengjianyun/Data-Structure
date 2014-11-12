package ds.java.tree;

public class BinaryTree<T> {

	public BTreeNode<T> root;

	public void constructTree(BTreeNode<T> node, int i, T[] values) {
		if (i < values.length) {
			node = new BTreeNode<T>(values[i]);
			constructTree(node.leftClild, i*2-1, values);
			constructTree(node.rightChild, i*2, values);
		}
	}
	
	public void inOrderTravel(BTreeNode<T> node) {
		if(node!=null){
			System.out.print(" "+node.value.toString());
			inOrderTravel(node.leftClild);
			inOrderTravel(node.rightChild);
		}
		
	}

}
