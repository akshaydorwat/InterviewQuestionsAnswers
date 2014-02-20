package sampleCodes;

public class PermutationOfString {
	String str;
	
	public PermutationOfString() {
		// TxODO Auto-generated constructor stub
		str = new String();
	}
	
	String swap(int i, int j, String str)
	{
		char[] charArray = str.toCharArray();
		char temp;
		
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		
		return new String(charArray);
	}
	
	void permute(int i, int n, String s)
	{
		String str;
		int j;
		
		if(i == n )
		{
			System.out.println(s.toString());
			return;
		}
		
		for( j=i ; j<=n; j++)
		{
			str = swap(i,j,s);
			permute(i+1,n,str);
		}
	}
	
	public static void main(String[] args) {
		PermutationOfString s = new PermutationOfString();
		s.str = "ASD";
		s.permute(0, s.str.length()-1,s.str);
	}

}
