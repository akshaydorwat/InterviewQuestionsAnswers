package Tree;

import basicDataStructure.BTnode;

class BTnodeWithParent 
{
	BTnodeWithParent left;
	BTnodeWithParent right;
	BTnodeWithParent parent;
	int data;
	
	public BTnodeWithParent(int data, BTnodeWithParent parent)
	{
		this.left = null;
		this.right = null;
		this.parent = parent;
		this.data = data;
				
	}
}

public class InOrderSuccBT {

	BTnodeWithParent root;

	public BTnodeWithParent InorderSuccessorWithParent(BTnodeWithParent nodeToFind)
	{
		BTnodeWithParent succ;
		
		if(nodeToFind == null) return null;
		
		if(nodeToFind.right != null)
		{
			return nodeToFind.right;
		}
		else
		{
			succ = nodeToFind.parent;
			while(succ.left != nodeToFind && succ != null)
			{
				succ = succ.parent;
				nodeToFind = nodeToFind.parent;
			}
			return succ;
		}
	}
	
	public BTnodeWithParent InorderSuccessorWithOutParent(BTnodeWithParent nodeToFind )
	{
		BTnodeWithParent succ = null;
		
		if(nodeToFind == null) return null;
		
		if(nodeToFind.right != null)
		{
			return nodeToFind.right;
		}
		else
		{
			while(root != null)
			{
				if(nodeToFind.data < root.data)
				{
					succ = root;
					root = root.left;
				}else if(nodeToFind.data > root.data)
				{
					root = root.right;
				}else
				{
					break;
				}
			}
			return succ;
		}
	}
	
	public static void main(String[] args) {
		InOrderSuccBT bt = new InOrderSuccBT();
		bt.root =  new BTnodeWithParent(4,null);
		bt.root.left = new BTnodeWithParent(2,bt.root);
		bt.root.left.left = new BTnodeWithParent(1,bt.root.left);
		bt.root.left.right = new BTnodeWithParent(3,bt.root.left);
		bt.root.right = new BTnodeWithParent(6,bt.root);
		bt.root.right.left = new BTnodeWithParent(5, bt.root.right);
		bt.root.right.right = new BTnodeWithParent(7, bt.root.right);
		System.out.println(bt.InorderSuccessorWithParent(bt.root.right).data);
		System.out.println(bt.InorderSuccessorWithOutParent(bt.root.right).data);
	}
	
}


