package personal.janyun.ds;

public class BTreeNode<T> {
	public T value;
	public BTreeNode<T> leftChild;
	public BTreeNode<T> rightChild;
	
	public BTreeNode() {
		// TODO Auto-generated constructor stub
	}
	public BTreeNode(T value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
	
	public boolean isLeftChild(BTreeNode<T> node) {
		// TODO Auto-generated method stub
		if(this.leftChild != null && this.leftChild==node)
			return true;
		return false;
	}
	
	public boolean isRightChild(BTreeNode<T> node) {
		// TODO Auto-generated method stub
		if(this.rightChild != null && this.rightChild==node)
			return true;
		return false;
	}
}
