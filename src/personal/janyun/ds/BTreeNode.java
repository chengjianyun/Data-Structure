package personal.janyun.ds;

public class BTreeNode<T> {
	public T value;
	public BTreeNode<T> leftClild;
	public BTreeNode<T> rightChild;
	
	public BTreeNode() {
		// TODO Auto-generated constructor stub
	}
	public BTreeNode(T value) {
		// TODO Auto-generated constructor stub
		this.value=value;
	}
}
