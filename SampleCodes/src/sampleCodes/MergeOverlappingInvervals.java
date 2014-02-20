package sampleCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

class Intervals implements Comparable<Intervals>
{
	int start;
	int end;
	
	public Intervals(int start, int end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Intervals o) {
		// TODO Auto-generated method stub
		
		int start = o.start;
		return this.start - start;
	}
	
	
}
public class MergeOverlappingInvervals {
	
	ArrayList<Intervals> a;
	Stack<Intervals> s;
	
	public MergeOverlappingInvervals() {
		// TODO Auto-generated constructor stub
		s  = new Stack<Intervals>();
		a = new ArrayList<Intervals>();
	}
	void mergerIntervals()
	{
		Intervals i;
		
		Collections.sort(a);
		i = a.remove(0);
		
		s.add(i);
		
		for (Iterator<Intervals> iterator = a.iterator(); iterator.hasNext();) {
			i = (Intervals) iterator.next();
			
			if(i.start < s.peek().end)
			{
				if(i.end < s.peek().end)
				{
					i.end = s.peek().end;
					s.pop();
					s.push(i);	
				}
			}
			else
			{
				s.push(i);
			}
		}
		
		while(!s.isEmpty())
		{
			 i =  s.pop();
			 System.out.println('('+i.start+','+i.end+')');
		}
	}
	
	
	public static void main(String[] args) {
		MergeOverlappingInvervals m =  new MergeOverlappingInvervals();
		m.a.add(new Intervals(6, 8));
		m.a.add(new Intervals(1, 9));
		m.a.add(new Intervals(2, 4));
		m.a.add(new Intervals(4, 7));
		m.mergerIntervals();
	}
	


}
