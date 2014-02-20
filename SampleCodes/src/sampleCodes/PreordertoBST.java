package sampleCodes;

import basicDataStructure.BTnode;

public class PreordertoBST {

	int list[];
	static int count = 0;

	public PreordertoBST(int list[]) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	public BTnode preOrderToBST(int key, int min, int max, int size)
	{
		if(count > size)
		{
			return null;
		}
		
		BTnode root = null;
		
		if(key > min && key < max)
		{
			root = new BTnode();
			root.data = key;
			count++;		
			if(count <= size){
				root.left = preOrderToBST(list[count], min, key, size);
			
				root.right = preOrderToBST(list[count], key, max, size);
			}
		}
		
		return root;
	}
	
	public BTnode preOrderStub()
	{
		count = 0;
		if(list.length == 0)
			return null;
		else
			return preOrderToBST(list[count], Integer.MIN_VALUE, Integer.MAX_VALUE, list.length-1);
	}
	
	public static void main(String[] args) {
		int list[] = {5,3,2,4,7,6,8};
		BTnode n = new BTnode();
		PreordertoBST bt  = new PreordertoBST(list);
		n.preorderTraversal( bt.preOrderStub());
	}
}
