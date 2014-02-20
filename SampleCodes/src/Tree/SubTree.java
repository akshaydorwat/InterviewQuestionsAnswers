package Tree;

import basicDataStructure.BTnode;

public class SubTree {
	BTnode root1, root2;
	
	public boolean findSubTree( BTnode orignal, BTnode treeTofind)
	{
		if(treeTofind == null)
		{
			return false;
		}
		else
		{
			return subTree(orignal, treeTofind);
		}
	} 
	
	private boolean subTree(BTnode orignal, BTnode treeTofind)
	{
		if(orignal == null){
			return false;
		}
		if(orignal.data == treeTofind.data)
		{
			return matchTree(orignal, treeTofind);
		}
		return (subTree(orignal.left, treeTofind) || subTree(orignal.right, treeTofind));
	}
	
	private boolean matchTree(BTnode orignal, BTnode treeToFind)
	{
		if(orignal == null && treeToFind == null)
		{
			return true;
		}
		
		if(orignal == null || treeToFind == null)
		{
			return false;
		}
		
		if(orignal.data != treeToFind.data)
		{
			return false;
		}
		
		return(matchTree(orignal.left, treeToFind.left) && matchTree(orignal.right, treeToFind.right));
	}
	
	public static void main(String[] args) {
		SubTree bt = new SubTree();
		/*bt.root1 = new BTnode(4);
		bt.root1.left = new BTnode(2);
		bt.root1.left.left = new BTnode(1);
		bt.root1.left.right = new BTnode(3);
		bt.root1.right = new BTnode(6);
		bt.root1.right.left = new BTnode(5);
		bt.root1.right.right = new BTnode(7);
		*/
		bt.root2 = new BTnode(6);
		bt.root2.left = new BTnode(5);
		bt.root2.right = new BTnode(7);
	
		System.out.println(bt.findSubTree(bt.root1, bt.root2));
	}
	
}
