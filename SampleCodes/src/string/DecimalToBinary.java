package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DecimalToBinary {
	
	public String decimalToBinary(String str)
	{
		String int_part = str.substring(0, str.indexOf('.'));
		int integer = Integer.parseInt(int_part);
		
		String double_part = str.substring(str.indexOf('.'),str.length());
		double doub = Double.parseDouble(double_part);
		
		StringBuilder binary = new StringBuilder();
		
		while(integer > 0)
		{
			binary.append(integer%2);
			integer >>= 1;
		}
		
		binary.append('.');
		System.out.println(doub);
		while(doub > 0)
		{
			
			
			if(doub == 1)
			{
				binary.append("1");
				break;
			}
			
			double r  = doub *2;
			
			if(r > 1)
			{
				binary.append("1");
				doub = r -1;
			}
			else
			{
				binary.append("0");
				doub = r;
			}
		}
		
		return binary.toString();
	}
	public static void main(String[] args) {
		DecimalToBinary d = new DecimalToBinary();
		Double num = 3.22;
		System.out.println(d.decimalToBinary(num.toString()));
		
		Queue<Integer> q = new PriorityQueue<Integer>();
	
	}
}
