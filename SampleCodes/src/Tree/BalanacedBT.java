package Tree;

import basicDataStructure.BTnode;

public class BalanacedBT {
	BTnode root;
	
	
	public int height(BTnode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		return(Math.max(height(root.left),height(root.right))+1);
	}
	
	public boolean isBalanced(BTnode root)
	{
		int lh,rh;
		boolean l,r;
		
		if(root == null)
			return true;
		
		l = isBalanced(root.left);
		r = isBalanced(root.right);
		
		lh = (root.left != null) ? root.left.height : 0;
		rh = (root.right != null) ? root.right.height : 0;
		
		root.height = (lh > rh) ? lh :rh; 
		return ((Math.abs(lh-rh) <= 1) && l && r);
		
	}
	
	public static void main(String[] args) {
		BalanacedBT bt = new BalanacedBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		System.out.println(bt.isBalanced(bt.root));
		System.out.println("Height:" + bt.height(bt.root));
	}
}
