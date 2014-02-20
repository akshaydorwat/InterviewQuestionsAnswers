package sampleCodes;

import basicDataStructure.BTnode;

public class SumTree {
	BTnode root;
	int sum;
	
	public SumTree() {
		// TODO Auto-generated constructor stub
		sum = 0;
	}
	int convertToSumTree(BTnode root)
	{
		int left;
		int right;
		int temp;
		
		if(root == null) return 0;
		
		temp = root.data;
		left = (root.left == null) ? 0 : convertToSumTree(root.left);
		right = (root.right == null) ? 0 :convertToSumTree(root.right);
				
		root.data = left+right;
		
		return root.data + temp;
		
	}
	
	void updateNodeWithValuesGreaterThanNode(BTnode root)
	{
				
		if(root == null)
		{
			return;
		}
		
		updateNodeWithValuesGreaterThanNode(root.right);
			
		sum = sum + root.data;
		root.data = sum;
		
		updateNodeWithValuesGreaterThanNode(root.left);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumTree st = new SumTree();
		st.root = new BTnode(4);
		st.root.left = new BTnode(2);
		st.root.left.left = new BTnode(1);
		st.root.left.right = new BTnode(3);
		st.root.right = new BTnode(6);
		st.root.right.left = new BTnode(5);
		st.root.right.right = new BTnode(7);
		
		//st.convertToSumTree(st.root);
		st.updateNodeWithValuesGreaterThanNode(st.root);
		st.root.postorderTraversal(st.root);
		
	}
}
