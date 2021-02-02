import java.util.Iterator;
import java.util.Vector;

public class TreeIterator<K extends Comparable<? super K>, V> implements Iterator<TreeItem<K, V>> {

	BinarySearchTree<K, V> bst; //bst = binary search tree
	Vector<TreeNode<K, V>> treeNodes;
	int size = 0;
	
	
	public TreeIterator(BinarySearchTree<K, V> bst) {
		this.bst = bst;
	}
	
	public int size() {
		int size = 0;
		int index = 0;
		TreeNode<K, V> currNode = treeNodes.get(index);
		while (currNode != null) {
			size++;
			index++;
			currNode = treeNodes.get(index);
		}
		
		return size;
	}
	
	@Override
	public boolean hasNext() {
		if (this.treeNodes == null) {
			return false;
		} else {
			return !this.treeNodes.isEmpty();
		}
	}

	@Override
	public TreeItem<K, V> next() {
		TreeItem<K, V> item = this.treeNodes.elementAt(0).getItem();
		this.treeNodes.remove(0);
		if (treeNodes.isEmpty()) {
			this.treeNodes = null;
		}
		return item;
	}
	
	public void setPreOrder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.preorder(this.bst.getRoot());
	}
	
	public void setInorder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.inorder(this.bst.getRoot());
	}
	
	public void setPostOrder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.postorder(this.bst.getRoot());
	}

	/******************************************************************/
	/*              Private Methods									  */
	/******************************************************************/

	private void preorder(TreeNode<K, V> node) {
		if (node != null) {
			this.treeNodes.add(node);
			preorder(node.getLeftChild());
			preorder(node.getRightChild());
		}
	}

	private void inorder(TreeNode<K, V> node) {
		if (node != null) {
			inorder(node.getLeftChild());
			this.treeNodes.add(node);
			inorder(node.getRightChild());
		}
	}

	private void postorder(TreeNode<K, V> node) {
		if (node != null) {
			postorder(node.getLeftChild());
			postorder(node.getRightChild());
			this.treeNodes.add(node);
		}
	}
}
