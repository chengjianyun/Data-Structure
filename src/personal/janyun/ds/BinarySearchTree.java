package personal.janyun.ds;

public class BinarySearchTree<T> {
	BSTreeNode<T> root;
	
	public void convertToDList(BSTreeNode<T> last_node,BSTreeNode<T> curr_node) {
		if(curr_node == null){
			return;
		}
		
		convertToDList(curr_node, curr_node.leftChild);
		
		BSTreeNode<T> left=node.leftChild;
		BSTreeNode<T> right=node.rightChild;
		
		node.leftChild=findMax(node.leftChild);
		node.rightChild=findMin(node.rightChild);
		
		convertToDList(right);
	}
	
	public BSTreeNode<T> findMax(BSTreeNode<T> tree) {
		BSTreeNode<T> node=tree;
		while(node.rightChild != null){
			node=node.rightChild;
		}
		return node;
	}
	
	public BSTreeNode<T> findMin(BSTreeNode<T> tree) {
		BSTreeNode<T> node=tree;
		while(node.leftChild != null){
			node=node.leftChild;
		}
		return node;
	}
}
