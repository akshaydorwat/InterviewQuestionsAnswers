package Tree;

import java.util.Stack;

import basicDataStructure.BTnode;

public class PreOrderTraversal {

	BTnode root;
	
	
	BTnode preOrderTraverse(BTnode root)
	{
		BTnode left, right;
		
		if(root == null)
			return null;
		
		if(root.right == null && root.left == null)
			return root;
		
			
		right =  preOrderTraverse(root.right);
		left = preOrderTraverse(root.left);
		
		if(root.left != null)
		{
			root.right = left;
			while(left.right !=null)
				left= left.right;
			
			left.right = right;
		}
		else
		{
			root.right = right;
		}	
		
		return root;
	}
	
	void printTree(BTnode root)
	{
		while(root.right != null)
		{
			System.out.println(root.data);
			root = root.right;
		}
	}
	public static void main(String[] args) {
		PreOrderTraversal bt = new PreOrderTraversal();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.preOrderTraverse(bt.root);
		bt.printTree(bt.root);
		
	}
}
