package Tree;

import basicDataStructure.BTnode;

public class NumberOfElementBT {
	BTnode root;
	
	public int numberofElemement(BTnode root)
	{
		if(root == null)
		{
			return(0);
		}
		else
		{
			return(numberofElemement(root.left) + numberofElemement(root.right)+1);
		}
	}
	
	public static void main(String[] args) {
		NumberOfElementBT bt = new NumberOfElementBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		System.out.println(bt.numberofElemement(bt.root));
	}
}
