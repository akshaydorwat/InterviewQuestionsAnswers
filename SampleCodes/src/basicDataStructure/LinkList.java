package basicDataStructure;

public class LinkList {
	int data;
	LinkList next;
	
	public LinkList(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}

	void printList(LinkList l)
	{
		while(l != null){
			System.out.println(l.data);
			l = l.next;
		}
	}
	
	void addNode(LinkList l, int data)
	{
		while(l.next != null){
			l = l.next;
		}
		l.next = new LinkList(data);
	}
}
