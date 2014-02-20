package sampleCodes;

import java.util.Stack;

import basicDataStructure.BTnode;

public class ZigZagBT {
	BTnode root;
	Stack<BTnode> currentLevel;
	Stack<BTnode> nextLevel;
	boolean leftToRight;
	
	public ZigZagBT() {
		// TODO Auto-generated constructor stub
		this.root = null;
		this.currentLevel = new Stack<BTnode>();
		this.nextLevel = new Stack<BTnode>();
		this.leftToRight = false;
		
	}
	void printZigZagBT(BTnode root)
	{
		BTnode tmpNode;
		Stack<BTnode> tmpStack;
		if(root == null)
			return;
		
		currentLevel.push(root);
		
		while(!currentLevel.empty())
		{
			tmpNode = currentLevel.pop();
			
			if(tmpNode != null)
			{
				if(leftToRight){
					System.out.println(tmpNode.data);
					nextLevel.add(tmpNode.left);
					nextLevel.add(tmpNode.right);
				}
				else
				{
					nextLevel.add(tmpNode.left);
					System.out.println(tmpNode.data);
					nextLevel.add(tmpNode.right);
				}
			}
			
			if(currentLevel.empty())
			{
				leftToRight = leftToRight ? false : true;
				tmpStack = currentLevel;
				currentLevel = nextLevel;
				nextLevel = tmpStack;
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagBT bt = new ZigZagBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.printZigZagBT(bt.root);
	}
}
