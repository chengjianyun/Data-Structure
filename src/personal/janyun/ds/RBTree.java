package personal.janyun.ds;

import org.w3c.dom.Node;

import personal.janyun.ds.RBTreeNode.Color;

public class RBTree {
	public RBTreeNode<Integer> root;
	public static RBTreeNode<Integer> NIL = new RBTreeNode<Integer>(
			Color.black, null);

	public void left_rotate(RBTreeNode<Integer> node) {

		if (node != RBTree.NIL && node.rightChild != RBTree.NIL) {
			RBTreeNode<Integer> tmp = node.rightChild;

			tmp.parent = node.parent;

			node.rightChild = tmp.leftChild;
			if (tmp.leftChild != RBTree.NIL)
				tmp.leftChild.parent = node;

			tmp.leftChild = node;
			node.parent = tmp;

			if (tmp.parent != RBTree.NIL) {
				if (node == tmp.parent.leftChild)
					tmp.parent.leftChild = tmp;
				else {
					tmp.parent.rightChild = tmp;
				}
			} else {
				root = tmp;
			}
		}
	}

	public void right_rotate(RBTreeNode<Integer> node) {
		if (node != RBTree.NIL && node.leftChild != RBTree.NIL) {
			RBTreeNode<Integer> left = node.leftChild;

			left.parent = node.parent;

			node.leftChild = left.rightChild;
			if (left.rightChild != null)
				left.rightChild.parent = node;

			left.rightChild = node;
			node.parent = left;

			if (left.parent == NIL) {
				root = left;
			} else if (node == left.parent.leftChild) {
				left.parent.leftChild = left;
			} else {
				left.parent.rightChild = left;
			}
		}
	}

	public void insert(RBTreeNode<Integer> node) {
		RBTreeNode<Integer> index = root;
		RBTreeNode<Integer> tmp = NIL;
		while (index != NIL) {
			tmp = index;
			if (index.key.intValue() > node.key.intValue())
				index = index.leftChild;
			else {
				index = index.rightChild;
			}
		}
		node.parent = tmp;

		if (tmp == NIL)
			root = node;
		else if (node.key.intValue() > tmp.key.intValue())
			tmp.rightChild = node;
		else {
			tmp.leftChild = node;
		}
		node.leftChild = NIL;
		node.rightChild = NIL;
		node.color = Color.red;

		insert_fixup(node);
	}

	public void insert_fixup(RBTreeNode<Integer> node) {
		RBTreeNode<Integer> p = node.parent;
		while (p.color == Color.red) {
			// 调整节点的父节点是左孩子
			if (p == p.parent.leftChild) {
				// 调整节点的叔节点是红色
				if (p.parent.rightChild.color == Color.red) {
					p.parent.color = Color.red;
					p.parent.color = Color.black;
					p.color = Color.black;
					node = p.parent;
					p = node.parent;
				} else {// 调整节点的叔节点是黑色
					// 调整节点是右孩子，则转为左孩子
					if (node == node.parent.rightChild) {
						node = node.parent;
						left_rotate(node);
					}
					// 调整节点是左孩子
					node.parent.color = Color.black;
					node.parent.parent.color = Color.red;
					right_rotate(node.parent.parent);
					p = node.parent;
				}
			} else {// 插入节点的父节点是右孩子
				if (p.parent.leftChild.color == Color.red) {
					p.parent.color = Color.red;
					p.color = Color.black;
					node = p.parent;
					p = node.parent;
				} else {
					if (node == node.parent.rightChild) {
						node = node.parent;
						right_rotate(node);
					}
					node.parent.color = Color.black;
					node.parent.parent.color = Color.red;
					left_rotate(node.parent.parent);
					p = node.parent;
				}
			}
		}
	}

	public void transplant(RBTreeNode<Integer> des, RBTreeNode<Integer> sour) {

		sour.parent = des.parent;

		if (des.parent == NIL)
			root = sour;
		else if (des == des.parent.leftChild)
			des.parent.leftChild = sour;
		else {
			des.parent.rightChild = sour;
		}
	}

	public RBTreeNode<Integer> getMin(RBTreeNode<Integer> node) {
		RBTreeNode<Integer> index = node;
		while (index != NIL && index.leftChild != NIL) {
			index = index.leftChild;
		}
		return index;
	}

	public void delete(RBTreeNode<Integer> node) {
		RBTreeNode<Integer> moved_node = node;
		Color ori_color = moved_node.color;
		RBTreeNode<Integer> ori_pos = NIL;

		if (node.leftChild == NIL) {
			ori_pos = node.leftChild;
			transplant(node, node.rightChild);
		} else if (node.rightChild == NIL) {
			ori_pos = node.rightChild;
			transplant(node, node.leftChild);
		} else {
			moved_node = getMin(node.rightChild);
			ori_color = moved_node.color;
			ori_pos = moved_node.rightChild;

			if (moved_node == node.rightChild) {
				ori_pos.parent = moved_node;
				transplant(node, moved_node);
				moved_node.leftChild = node.leftChild;
				moved_node.leftChild.parent = moved_node;
			} else {
				node.key = moved_node.key;
				transplant(moved_node, moved_node.rightChild);
			}
		}

		if (ori_color == Color.black)
			delete_fixup(ori_pos);
	}

	private void delete_fixup(RBTreeNode<Integer> moved_node) {
		// TODO Auto-generated method stub
		while (moved_node != root && moved_node.color == Color.black) {
			if (moved_node == moved_node.parent.leftChild) {
				RBTreeNode<Integer> right = moved_node.parent.rightChild;
				if (right.color == Color.red) { // case 1, 兄弟节点为红色
					moved_node.parent.color = Color.red;
					right.color = Color.black;
					left_rotate(moved_node.parent);
					right = moved_node.parent.rightChild;
				}

				if (right.leftChild.color == Color.black
						&& right.rightChild.color == Color.black) { // case 2,
																	// 兄弟节点为黑色，且子节点都为黑色
					right.color = Color.red;
					moved_node = moved_node.parent;
				} else {
					if (right.rightChild.color == Color.black) { // case 3,
																	// 兄弟节点为黑色，仅有左孩子为红色
						right.color = Color.red;
						right.leftChild.color = Color.black;
						right_rotate(right);
						right=moved_node.parent.rightChild;
					}
					right.color = moved_node.parent.color; // case 4,
															// 兄弟节点为黑色，仅有右孩子为红色
					moved_node.parent.color = Color.black;
					right.rightChild.color=Color.black;
					left_rotate(moved_node.parent);
					moved_node = root;
				}
			} else {
				RBTreeNode<Integer> left = moved_node.parent.leftChild;
				if(left.color==Color.red){
					moved_node.parent.color=Color.red;
					left.color=Color.black;
					right_rotate(moved_node.parent);
					left=moved_node.parent.leftChild;
				}
				
				if(left.leftChild.color==Color.black && left.rightChild.color==Color.black){
					left.color=Color.red;
					moved_node=moved_node.parent;
				}else{
					if(left.leftChild.color==Color.black){
						left.color=Color.red;
						left.rightChild.color=Color.black;
						left_rotate(left);
						left=moved_node.parent.leftChild;
					}
					
					left.color=moved_node.parent.color;
					moved_node.parent.color=Color.black;
					left.leftChild.color=Color.black;
					right_rotate(moved_node.parent);
					left=root;
				}
			}
		}
		moved_node.color = Color.black;
	}
}
