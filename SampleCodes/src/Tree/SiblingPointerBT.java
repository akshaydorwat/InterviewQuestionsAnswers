/*Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.*/

package Tree;

import java.util.LinkedList;
import java.util.Queue;


class Node
{
	int data;
	Node left;
	Node right;
	Node sibling;
	
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class SiblingPointerBT {
	Node root;
	Queue<Node> q1;
	Queue<Node> q2;
	
	public SiblingPointerBT() {
		// TODO Auto-generated constructor stub
		this.q1 = new LinkedList<Node>();
		this.q2 = new LinkedList<Node>();
	}
	
	void addQ(Node prev)
	{
		if(prev.left != null)
			q2.add(prev.left);
		
		if(prev.right != null)
			q2.add(prev.right);
	}
	
	void siblingConnector2(Node root)
	{
		if(root == null)
			return;
		
		root.sibling = null;
		connect(root);
	}
	void connect(Node root)
	{
		if(root == null)
			return;
		
		if(root.left != null)
			root.left.sibling = root.right;
		
		if(root.right != null)
			root.right.sibling = (root.sibling == null) ? null : root.sibling.left;
		
		connect(root.left);
		connect(root.right);
	}
	
	void siblingConnector(Node root)
	{
		Node prev;
		Node temp;
		Queue<Node> q;
		
		if(root == null)
			return;
		
		q1.add(root);
		
		while(!q1.isEmpty()){
			
			prev = q1.remove();
			addQ(prev);
			
			while(!q1.isEmpty())
			{
			    temp = q1.remove();
				prev.sibling = temp;
				prev = temp;
				
				addQ(prev);
			}
			
			prev.sibling = null;
			
			q = q1;
			q1 = q2;
			q2 = q;
		}
	}
	
	void nodePrint(Node root)
	{
		Node temp = root;
		Node temp1;
		while(temp != null)
		{	
			System.out.println("new");
			temp1 = temp;
			while(temp1 != null)
			{
				System.out.print(temp1.data);
				temp1 = temp1.sibling;
			}
			temp = temp.left;
		}
	}
	
	public static void main(String[] args) {
		SiblingPointerBT bt = new SiblingPointerBT();
		bt.root = new Node(4);
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(3);
		bt.root.right = new Node(6);
		bt.root.right.left = new Node(5);
		bt.root.right.right = new Node(7);
		
		bt.siblingConnector2(bt.root);
		bt.nodePrint(bt.root);
	}
}
