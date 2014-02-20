package sampleCodes;

import java.util.Arrays;



public class Anagram {
	
	public String reverse(String s)
	{
		char c[] = null;
				
		if(s != null)
		{
			
			int i = 0;
			int j = s.length()-1;
			
			c = 	s.toCharArray();
			char tmp;
			
			while(i < j)
			{
				tmp = c[i];
				c[i] = c[j];
				c[j] = tmp;
				i++;
				j--;
			}
		}
		
		String s1 = new String(c);
		
		return s1;
	}
	
	public static void main(String[] args) {
		
				
		String s1 = "Akshay";
		String s2 = "yahskA";
		char c1[] = s1.toLowerCase().toCharArray();
		char c2[] = s2.toLowerCase().toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String s1new = new String(c1);
		String s2new = new String(c2);

		if (s1new.compareTo(s2new) == 0 )
		{
			System.out.println("Anagram");
		}else
		{
			System.out.println("nor anagram");
		}
		
		System.out.println(new Anagram().reverse("Akshay"));
		
		
	}

}
