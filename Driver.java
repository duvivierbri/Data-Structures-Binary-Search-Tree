import java.util.Vector;
import java.util.Random;

public class Driver implements DriverInterface{
	
	public static void main (String[]args) {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		TreeItem<Integer, String> m = new TreeItem<Integer,String>(new Integer(4), "");
		TreeItem<Integer, String> m1 = new TreeItem<Integer,String>(new Integer(1), "");
		TreeItem<Integer, String> m2 = new TreeItem<Integer,String>(new Integer(2), "");
		
		bst.insert(m);
		bst.insert(m1);
		bst.insert(m2);
		
		//System.out.println(bst.isBalanced());
		bst.balance();
		System.out.println(bst.isBalanced());
	}

	@Override
	public Vector<TreeItem<Integer, String>> getVectorOfTreeItems() {
		Vector<TreeItem<Integer, String>> vector = new Vector<TreeItem<Integer, String>>();
		Random random = new Random();
		
		for (int i = 0; i < 131071; i++) {
			Integer key = random.nextInt(1000000);
			TreeItem<Integer, String> item = new TreeItem<Integer, String>(new Integer(key), "String " + key);
			vector.add(item);
		}
		
		return vector;
	}

	@Override
	public BinarySearchTree<Integer, String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems) {
		Driver driver = new Driver();
		treeItems = driver.getVectorOfTreeItems();
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		for(int i = 0; i < 131071; i++) {
			bst.insert(treeItems.get(i));
		}
		
		return bst;
		
		
	}

}
