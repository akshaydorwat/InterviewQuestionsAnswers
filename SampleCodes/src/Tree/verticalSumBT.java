package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import basicDataStructure.BTnode;

public class verticalSumBT {
	BTnode root;
	HashMap<Integer, Integer> hm;

	public verticalSumBT() {
		// TODO Auto-generated constructor stub
		this.hm = new HashMap<Integer, Integer>();
	}
	
	void verticleSum(BTnode root)
	{
		if(root == null)
			return;
		
		verticleUtil(root,0,hm);
	}
	
	void verticleUtil(BTnode root, int HD, HashMap<Integer, Integer> hm)
	{
		int sum;
		
		if(root == null)
			return;
		
		sum = (hm.get(HD) == null) ? 0 : hm.get(HD);
		hm.put(HD, sum+root.data);
		
		verticleUtil(root.left, HD-1, hm);
		verticleUtil(root.right, HD+1, hm);
	}
	
	public static void main(String[] args) {
		
		verticalSumBT bt = new verticalSumBT();
		bt.root = new BTnode(4);
		bt.root.left = new BTnode(2);
		bt.root.left.left = new BTnode(1);
		bt.root.left.right = new BTnode(3);
		bt.root.right = new BTnode(6);
		bt.root.right.left = new BTnode(5);
		bt.root.right.right = new BTnode(7);
		
		bt.verticleSum(bt.root);
		
		for(Integer n : bt.hm.keySet())
		{
			Integer sum = bt.hm.get(n);
			System.out.println(n +" "+sum);
		}
	
		
		
		
	}
}
