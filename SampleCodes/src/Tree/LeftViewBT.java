package Tree;

import basicDataStructure.BTnode;

public class LeftViewBT {
	BTnode root;
	int maxLevel;
	
	public LeftViewBT() {
		// TODO Auto-generated constructor stub
		this.maxLevel = 0;
	}
	
	void printLeftView(BTnode root, int level)
	{
		if(root == null)
			return;
		
		if(maxLevel < level)
		{
			System.out.println(root.data);
			maxLevel = level;
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
	}
	
	public static void main(String[] args) {
		
		LeftViewBT bt = new LeftViewBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);

		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.printLeftView(bt.root, 1);
	}
	
}
