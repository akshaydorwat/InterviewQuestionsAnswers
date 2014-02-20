package Tree;

import java.awt.Robot;

import basicDataStructure.BTnode;

public class LCA {
	BTnode root;
	
	
	
	final static int ZERO = 0;
	final static int ONE = 1;
	final static int TWO = 2;
	
	
	private int coverage(BTnode node, BTnode p, BTnode q)
	{
		int ret = ZERO;
		
		if(node == null)
		{
			return ret;
		}
		
		if(node == p ||node ==q)
		{
			ret = ret + 1; 
		}
		
		ret = ret + coverage(node.left, p, q);
		
		if(ret == TWO)
		{
			return ret;
		}
		
		return ret + coverage(node.right, p, q);
			
	}
	
	public BTnode leastCommonAnsesstor(BTnode node, BTnode p, BTnode q)
	{
		int leftCoverage, rightCoverage;
		
		leftCoverage = coverage(node.left, p, q);
		if(leftCoverage == TWO)
		{
			if(node.left == p || node.left == q)
			{
				return node.left;
			}
			else
			{
				return leastCommonAnsesstor(node.left, p, q);
			}
		}
		else if(leftCoverage == ONE)
		{
			if(node == p) return p;
			if(node == q) return q;
		}
		
		rightCoverage = coverage(node.right, p, q);
		if(rightCoverage == TWO)
		{
			if(node.right == p || node.right == q)
			{
				return node.right;
			}
			else
			{
				return leastCommonAnsesstor(node.right, p, q);
			}
		}else if(rightCoverage == ONE)
		{
			if(node == p) return p;
			if(node == q) return q;
		}
		
		if(leftCoverage == ONE && rightCoverage == ONE)
		{
			return root;
		}
		
		return null;
	}

	
	public static void main(String[] args) {
		LCA bt = new LCA();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		 BTnode node = bt.leastCommonAnsesstor(bt.root, bt.root, bt.root.right);
		 
		 if(node != null)
		 {
			 System.out.println("LCA is "+node.data);
		 }
		 else
		 {
			 System.out.println("LCA not found");
		 }
	}
}																									
