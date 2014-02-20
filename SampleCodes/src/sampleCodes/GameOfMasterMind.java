package sampleCodes;

class Result{
	int hit;
	int psuedo_hit;
	
	public Result(){
		this.hit = 0;
		this.psuedo_hit = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s;
		s = "Hit:"+hit+" Psuedo_hit: "+psuedo_hit;
		return s;
	}
}

public class GameOfMasterMind {
	
	Result getResult(String ques, String solution)
	{
		Result res = new Result();
		int soultion_vector = 0;
		int i;
		
		for(i=0;i<ques.length();i++)
		{
			soultion_vector |= (1 << (1+ques.charAt(i)-'A')); 
		}
		
		for(i=0;i<solution.length();i++)
		{
			if(solution.charAt(i)==ques.charAt(i))
			{
				res.hit++;
			}
			else if((soultion_vector & (1 << (1+solution.charAt(i)-'A'))) >=1)
			{
				res.psuedo_hit++;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		GameOfMasterMind g = new GameOfMasterMind();
		System.out.println(g.getResult("RGGB", "YRGB").toString());
	}
}
