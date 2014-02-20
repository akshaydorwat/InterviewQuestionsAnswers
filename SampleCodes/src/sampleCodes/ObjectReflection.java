package sampleCodes;

import java.lang.reflect.Method;

import basicDataStructure.BTnode;

public class ObjectReflection {
	
	public static void main(String[] args) {
		try {
			int i;
			Class c = Class.forName("basicDataStructure.BTnode");
			Method m[] = c.getDeclaredMethods();
			
			for(i=0; i<m.length;i++)
			{
				System.out.println(m[i].toString());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
