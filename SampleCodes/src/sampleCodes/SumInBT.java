package sampleCodes;

import java.util.ArrayList;
import java.util.Iterator;

import basicDataStructure.BTnode;

/*You are given a binary tree in which each node contains a value. Design an algorithm
to print all paths which sum up to that value. Note that it can be any path in the tree
- it does not have to start at the root
 * */

public class SumInBT {
	
	BTnode root;
	
	public void findSum(BTnode root, int sum, ArrayList<Integer> list, int level)
	{
		int i;
		int temp=0;
		
		if(root == null){
			return;
		}
		list.add(root.data);
		
		for(i=level; i>=0; i--)
		{
			temp = temp+list.get(i);
			if(temp == sum)
			{
				printList(list,i,level);
			}
		}
		ArrayList<Integer> list1 =  (ArrayList<Integer>) list.clone();
		ArrayList<Integer> list2 =  (ArrayList<Integer>) list.clone();
		
		findSum(root.left, sum, list1, level+1);
		findSum(root.right, sum, list2, level+1);
	}  
	
	private void printList(ArrayList<Integer> list, int start, int end)
	{
		System.out.println("soulution");
		for (int i = start; i <= end; i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void main(String[] args) {
		
		SumInBT bt = new SumInBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.findSum(bt.root, 6, new ArrayList<Integer>(), 0);
	}
}
