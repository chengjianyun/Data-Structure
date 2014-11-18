package personal.janyun.ds;

public class ListBSTree implements IBinarySearchTree<Integer> {
	public BSTreeNode<Integer> root;

	public void insert(BSTreeNode<Integer> node) {
		// TODO Auto-generated method stub
		if(root==null){
			root=node;
			return;
		}
		
		if(node==null)
			return;
		
		BSTreeNode<Integer> tmp=root;
		while(tmp!=null){
			if(tmp.value.intValue()>node.value.intValue()){
				if(tmp.leftChild==null){
					tmp.leftChild=node;
					node.parent=tmp;
					break;
				}
				tmp=tmp.leftChild;
			}else {
				if(tmp.rightChild==null){
					tmp.rightChild=node;
					node.parent=tmp;
					break;
				}
				tmp=tmp.rightChild;
			}
		}
	}

	public boolean delete(BSTreeNode<Integer> node) {
		// TODO Auto-generated method stub
		if(node==null)
			return false;
		
		if(node.leftChild == null){
			transplant(node, node.rightChild);
		}else if(node.rightChild == null)
			transplant(node, node.leftChild);
		else{
			BSTreeNode<Integer> suc=maximum(node.rightChild);
			if(suc==node.rightChild){
				transplant(node, suc);
				suc.leftChild=node.leftChild;
				suc.leftChild.parent=node.parent;
			}else{
				node.value=suc.value;
				transplant(suc, suc.rightChild);	
			}
		}
		
//		if(node==node.parent.leftChild){
//			if(node.leftChild==null && node.rightChild==null){
//				node.parent.leftChild=null;
//			}else if(node.leftChild==null){
//				node.rightChild.parent=node.parent;
//				node.parent.leftChild=node.rightChild;
//			}else if(node.rightChild==null){
//				node.leftChild.parent=node.parent;
//				node.parent.leftChild=node.leftChild;
//			}else {
//				BSTreeNode<Integer> suc=successor(node);
//				if(suc==node.rightChild){
//					node.parent.leftChild=suc;
//					suc.parent=node.parent;
//				}else{
//					node.value=suc.value;
//					suc.parent.leftChild=suc.rightChild;
//					if(suc.rightChild!=null)
//						suc.rightChild.parent=suc.parent;
//				}
//			}
//		}
//		else {
//			if(node.leftChild==null && node.rightChild==null){
//				node.parent.rightChild=null;
//			}else if(node.leftChild==null){
//				node.rightChild.parent=node.parent;
//				node.parent.rightChild=node.rightChild;
//			}else if(node.rightChild==null){
//				node.leftChild.parent=node.parent;
//				node.parent.rightChild=node.leftChild;
//			}else {
//				BSTreeNode<Integer> suc=successor(node);
//				if(suc==node.rightChild){
//					node.parent.rightChild=suc;
//					suc.parent=node.parent;
//				}else{
//					node.value=suc.value;
//					suc.parent.leftChild=suc.rightChild;
//					if(suc.rightChild!=null)
//						suc.rightChild.parent=suc.parent;
//				}
//			}
//		}
		return true;
	}
	
	public void transplant(BSTreeNode<Integer> n1, BSTreeNode<Integer> n2) {
		if(n1.parent==null){
			root=n2;
		} else {
			if(n1==n1.parent.leftChild)
				n1.parent.leftChild=n2;
			else {
				n1.parent.rightChild=n2;
			}
		}
		if(n2!=null)
			n2.parent=n1.parent;
	}

	public BSTreeNode<Integer> search(Integer key) {
		// TODO Auto-generated method stub
		
		BSTreeNode<Integer> node=root;
		while(node!=null){
			if(node.value.intValue()> key.intValue())
				node=node.leftChild;
			else if(node.value.intValue() < key.intValue()){
				node=node.rightChild;
			}else {
				break;
			}
		}
		return node;
	}
	
	public BSTreeNode<Integer> maximum(BSTreeNode<Integer> node) {
		while(node.rightChild != null)
			node=node.rightChild;
		return node;

	}
	
	public BSTreeNode<Integer> minimum(BSTreeNode<Integer> node){
		while(node.leftChild!=null)
			node=node.leftChild;
		return node;
	}
	
	public BSTreeNode<Integer> successor(BSTreeNode<Integer> node){
		if(node.rightChild != null)
			return maximum(node.rightChild);
		BSTreeNode<Integer> tmp=node.parent;
		while(tmp!=null && tmp.leftChild==node){
			node=tmp;
			tmp=tmp.parent;
		}	
		return tmp;
	}
	
	public BSTreeNode<Integer> precursor(BSTreeNode<Integer> node){
		if(node.leftChild !=null)
			return minimum(node.leftChild);
		BSTreeNode<Integer> tmp=node.parent;
		while(tmp!=null && tmp.rightChild==node){
			node=tmp;
			tmp=tmp.parent;
		}
		return tmp;
	}
}
