package bitManipulations;

/*Consider the statement 
 result = a ? b : c; 
 Implement the above statement without using any conditional statments.
 * */
public class TernaryOprations {
	public static void main(String[] args) {
		int a = 12;
		int b = 112;
		int c = 12;
		int result;
		
		int t = (a >> 31) + 1;
		result =  (t)*b + (1-t)*c; 
		System.out.println(result);
		
	}
}
