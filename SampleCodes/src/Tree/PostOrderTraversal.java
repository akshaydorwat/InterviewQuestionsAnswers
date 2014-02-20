package Tree;

import basicDataStructure.BTnode;

public class PostOrderTraversal {
	BTnode root;
	
	public BTnode postOrderTraversal(BTnode root)
	{
	
		BTnode left, right;
		
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root;
				
		left  = postOrderTraversal(root.left);
		right = postOrderTraversal(root.right);
		
		//if(right != null)
		//{
			//for(;right.left != null; right = right.left);
			
			
		//}
		
		if(left != null && right != null)
		{
			 right.right = root;
			 root.left = right;
			 root.right = null;
			 for(;right.left != null; right = right.left);
			 left.right = right;
			 right.left = left;
			 //for(;right.right!=null; right=right.right);
			 
			 return root;
		}
		
		/*if(left == null && right != null)
		{
			right.left = left;
			for(;right.right!=null; right=right.right);
			//System.out.println("for2 done");
			right.right = root;
			return root;
		}
		
		if(left != null && right == null)
		{
			left.right = root;
			root.left = left;
			return root;
		}*/
		
		return null;
	}
	
	void printTree(BTnode root)
	{
		
		while(root.left != null){
			root = root.left;
		}
		
		while(root.right != null)
		{
			System.out.println(root.data);
			root = root.right;
		}
	}
	public static void main(String[] args) {
		PostOrderTraversal bt = new PostOrderTraversal();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.postOrderTraversal(bt.root);
		bt.printTree(bt.root);
		
	}
}
