package sampleCodes;

/*Given a sorted array of strings which is interspersed with empty strings, write a meth-
od to find the location of a given string.
Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
*/

public class StringFinder {
	String[] str;

	public StringFinder(String[] str)
	{
		this.str = str; 
	}
	
	public int stringFinder(int start, int end, String string )
	{
		int mid;
		
		while(start <= end && str[start] == "")
		{
			start++;
		}
		
		while(end >= start && str[end] == "")
		{
			end--;
		}
		System.out.println("start:"+start+"  "+"end:"+end);
		if(start > end)
		{
			return -1;
		}
		
		mid = (start+end)/2;
		
		while(str[mid] == ""){mid++;}
			
		if(str[mid].compareTo(string) == 0)
		{
			return mid;
		}
		else if(str[mid].compareTo(string) < 0)
		{
			return stringFinder(mid+1, end, string);
		}
		else 
		{
			return stringFinder(start, mid-1, string);
		}
	}
	
	public static void main(String[] args) {
		String str[] = {"","","","at","","","","ball","","car","", "", "dad","",""};
		StringFinder strF = new StringFinder(str);
		System.out.println(strF.stringFinder(0, str.length -1, "car"));
	}
}
