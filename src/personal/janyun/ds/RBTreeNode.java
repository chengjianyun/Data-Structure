package personal.janyun.ds;

public class RBTreeNode<T> {
	public T key;
	public RBTreeNode<T> parent;
	public RBTreeNode<T> leftChild;
	public RBTreeNode<T> rightChild;
	public Color color;
	
	public RBTreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public RBTreeNode(Color color, T value) {
		// TODO Auto-generated constructor stub
		this.color=color;
		key=value;
	}
	public enum Color{
		red,
		black
	}
}


