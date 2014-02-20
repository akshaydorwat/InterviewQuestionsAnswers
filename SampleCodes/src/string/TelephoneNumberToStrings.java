package string;

public class TelephoneNumberToStrings {
	
	char alphabet[][];
	int phoneNum[];
	
	public TelephoneNumberToStrings(int num[]) {
		// TODO Auto-generated constructor stub
		int i,j;
		int temp = 65;
		
		this.phoneNum = num;
		
		alphabet = new char[10][3];
		for(i=2;i<10;i++)
		{
			for(j=0;j<3;j++)
			{
				alphabet[i][j] = (char)temp;
				temp++;
			}
		}
		
	}
	
	char getChar(int number, int count)
	{
		char tmp = 0;
		
		if(number > 9 || number < 0 ) 
			return 0;
		
		if(count < 0 || count > 2)  
			return 0;
		
		tmp = 	alphabet[number][count];
		return tmp;
	}
	
	void printTelephone( int start, int end, char result[])
	{
		int i;
		
		if(start == end)
		{
			System.out.println(new String(result));
			return;
		}
		
		if(phoneNum[start] == 0 || phoneNum[start] == 1)
			return;
		
		for(i=0; i<3 ;i++ )
		{
			result[start] = getChar(phoneNum[start], i);
			printTelephone(start+1, end, result);
		}
	}
	
	public static void main(String[] args) {
		int temp[] = {3,4,5,2,7,8,9};
		TelephoneNumberToStrings t = new TelephoneNumberToStrings(temp);
		t.printTelephone(0, temp.length, new char[temp.length]);
	}

}
