package sampleCodes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeSet;


class emp
{
	int no;
	String name;
	
	public emp(int no, String name) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "No :"+no+" Name:"+name;
	}
}

public class JavaDataStrcutures  {
	
	TreeSet<emp> tset;
	
	public JavaDataStrcutures() {
		// TODO Auto-generated constructor stub
		tset = new TreeSet<emp>(new Comparator<emp>() {

			@Override
			public int compare(emp o1, emp o2) {
				// TODO Auto-generated method stub
				 if(o1.no == o2.no) 
					 return 0;
				 else if(o1.no > o2.no)
					 return 1;
				 else 
					 return -1;
					  
			}
		});
	}
	
public static void main(String[] args) {
	JavaDataStrcutures jd = new JavaDataStrcutures();
	jd.tset.add(new emp(1, "Akshay"));
	jd.tset.add(new emp(10,"Sahil"));
	jd.tset.add(new emp(2, "Sumit"));
	jd.tset.add(new emp(5, "ROhit"));
	
	for (Iterator<emp> iterator = jd.tset.iterator(); iterator.hasNext();) {
		emp e = (emp) iterator.next();
		System.out.println(e.toString());
		
	}
	/*for(emp e : jd.tset)
	{
		System.out.println(e.toString());
	}*/
	
}
}
