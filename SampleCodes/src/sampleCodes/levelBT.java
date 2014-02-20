package sampleCodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import basicDataStructure.BTnode;

/*Given a binary search tree, design an algorithm which creates a linked list of all the
nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
 * */

public class levelBT {
	BTnode root;
	
	public ArrayList<LinkedList<BTnode>> printLevel()
	{
		int level = 0;
		int i;
		BTnode temp;
		
		ArrayList<LinkedList<BTnode>> result = new ArrayList<LinkedList<BTnode>>();
		LinkedList<BTnode> list =  new LinkedList<BTnode>();
		
		if(root == null)
		{
			return result;
		}
		
		list.add(root);
		result.add(level, list);
		
		while(true)
		{
			list = new LinkedList<BTnode>();
			for(i=0; i< result.get(level).size(); i++)
			{
				temp = result.get(level).get(i);
				if(temp != null)
				{
					if(temp.left != null) list.add(temp.left);
					if(temp.right != null) list.add(temp.right);
				}
			}	
			if(list.size() > 0 )
			{
				level++;
				result.add(level, list);
			}
			else
			{
				break;
			}	
		}
		return result;
	} 
	
	public static void main(String[] args) {
		
		ArrayList<LinkedList<BTnode>> result;
		LinkedList<BTnode> list;
		BTnode node;
		
		levelBT bt = new levelBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		result = bt.printLevel();
		
		for(Iterator<LinkedList<BTnode>> i = result.iterator();i.hasNext(); ){
			list = i.next();
			
			for(Iterator<BTnode> j = list.iterator();j.hasNext(); )
			{
				node = j.next();
				System.out.println(node.data);
			}
		}
	}
}
