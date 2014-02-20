package sampleCodes;

import basicDataStructure.BTnode;

public class LongestPathBT {
	BTnode root;
	
	int max(int a, int b)
	{
		return (a>b) ?  a : b;
	}
	
	int height(BTnode root)
	{
		if(root == null)
		{
			return 0;
		}
		 
		return 1 + max(height(root.left), height(root.right));
	}
	
	int diameterOfBT(BTnode root)
	{	
		int lheight;
		int rheight;
		int ldiameter;
		int rdiameter;
		
		if(root == null)
		{
			return 0;
		}
		
		lheight = height(root.left);
		rheight = height(root.right);
		
		ldiameter =  diameterOfBT(root.left);
		rdiameter =  diameterOfBT(root.right);
		
		return max(lheight +rheight +1, max(ldiameter,rdiameter));	
	}
	
	public static void main(String[] args) 
	{
		LongestPathBT lpb = new LongestPathBT();
		lpb.root = new BTnode(4);
		lpb.root.left = new BTnode(2);
		lpb.root.left.left = new BTnode(1);
		lpb.root.left.right = new BTnode(3);
		lpb.root.right = new BTnode(6);
		lpb.root.right.left = new BTnode(5);
		lpb.root.right.right = new BTnode(7);
		
		System.out.println(lpb.diameterOfBT(lpb.root));
	}
}
