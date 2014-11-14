package personal.janyun.ds;

public interface IBinarySearchTree<E> {
	public void insert(BSTreeNode<E> node);
	public boolean delete(BSTreeNode<E> node);
	public BSTreeNode<E> search(E key);
}
