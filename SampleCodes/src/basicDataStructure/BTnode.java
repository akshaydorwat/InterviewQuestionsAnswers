package basicDataStructure;

public class BTnode {
	public int data;
	public int height;
	public BTnode left;
	public BTnode right;
	
	public BTnode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	
	public BTnode() {
		// TODO Auto-generated constructor stub
		this.left = null;
		this.right = null;
		this.height = 0;
	}
	
	public void preorderTraversal(BTnode root)
	{
		if(root != null)
		{
			System.out.println(root.data);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	public void inorderTraversal(BTnode root)
	{
		if(root != null)
		{
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
	
	public void postorderTraversal(BTnode root)
	{
		if(root != null)
		{
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.println(root.data);
			
		}
	}
}
