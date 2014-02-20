package sampleCodes;

import java.util.ArrayList;
import java.util.Collections;

/*A circus is designing a tower routine consisting of people standing atop one anoth-
er’s shoulders. For practical and aesthetic reasons, each person must be both shorter
and lighter than the person below him or her. Given the heights and weights of each
person in the circus, write a method to compute the largest possible number of peo-
ple in such a tower.
EXAMPLE:
Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
Output: The longest tower is length 6 and includes from top to bottom: (56, 90)
(60,95) (65,100) (68,110) (70,150) (75,190)
 * */

class HtWt implements Comparable<HtWt>
{
	int height;
	int weight;
	
	public HtWt(int ht, int wt)
	{
		this.height = ht;
		this.weight = wt;
	}

	@Override
	public int compareTo(HtWt o) {
		// TODO Auto-generated method stub
		
		if(o.height < height){
			return 1;
		}
		else if((o.height == height) && (o.weight < weight))
		{
			return 1;
		}else
		{
			return 0;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder s = new  StringBuilder();
		s.append("Height : "+ height+"Weight: "+weight);
		return s.toString();
	}
}


public class HtWtSort  {
	
	ArrayList<HtWt> list;
	
	public HtWtSort(ArrayList<HtWt> list)
	{
		this.list = list;
	}
	
	public void sortList()
	{
		Collections.sort(list);
	}
	
	public void printList()
	{
		for(HtWt temp : list)
		{
			System.out.println(temp.toString());
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<HtWt> l = new ArrayList<HtWt>();
		
		l.add(new HtWt(65, 100));
		l.add(new HtWt(70, 150));
		l.add(new HtWt(56, 90)); 
		l.add(new HtWt(75, 180)); 
		l.add(new HtWt(75, 190)); 
		l.add(new HtWt(60, 95));
		l.add(new HtWt(68, 110));
		
		HtWtSort h = new HtWtSort(l);
		h.sortList();
		h.printList();
	}
}

