package sampleCodes;

import java.util.ArrayList;
import java.util.List;

class TrieNode
{
	TrieNode parent;
	char character;
	TrieNode childrean[];
	boolean isLeaf;
	boolean isWord;
	int count;
	static final int NO_OF_CHAR = 26;  
	
	public TrieNode()
	{
		this.parent = null;
		this.childrean = new TrieNode[NO_OF_CHAR];
		this.isLeaf = true;
		this.isWord = false;
		this.count = 0;
	}
	
	public TrieNode(char c)
	{
		this();
		this.character = c;
	}
	
	protected void addWord(String word)
	{
		int charPos;
		String lowerString = word.toLowerCase();
		
		charPos =  lowerString.charAt(0) - 'a';
			
		if(childrean[charPos] == null)
		{
			childrean[charPos] = new TrieNode(lowerString.charAt(0));
			childrean[charPos].parent = this;
		}
		
		if(word.length() > 1)
		{
			childrean[charPos].addWord(word.substring(1));
		}else
		{
			childrean[charPos].isWord = true;
			childrean[charPos].count ++;
		}
	}	
	
	protected List<String> getWords()
	{
		int i;
		ArrayList<String> list = new ArrayList<String>();
		if(this.isWord)
		{
			list.add(toString());
		}
		
		if(!isLeaf){
			
			for(i=0; i>childrean.length; i++)
			{
				if(childrean[i] != null)
				{
					list.addAll(childrean[i].getWords());
				}
			}
		}
		return list;
	}
	
	protected TrieNode getNode(char c)
	{
		int char_pos = c - 'a';
		return childrean[char_pos];
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		TrieNode node = parent;
		StringBuilder s = new StringBuilder();
		s.append(character);
		
		while(node != null)
		{
			s.append(node.character);
			node = node.parent;
		}
		
		return s.reverse().toString(); 
	}
}

public class TrieDictionary {
	TrieNode root;
	
	public void addword(String word)
	{
		root.addWord(word);
	}
	
	public List getWords(String word)
	{
		ArrayList<String> list = new ArrayList<String>();
		int i;
		String lowerWord = word.toLowerCase();
		TrieNode node = root;
		
		for(i=0; i<word.length(); i++)
		{
			node = node.getNode(lowerWord.charAt(i));
			
			if(node == null)
			{
				return new ArrayList<String>();
			}
		}
		node.getWords();
		return list;
	}
	
	public int getCount(String word)
	{
		int count=0;
		int i;
		String lowerWord = word.toLowerCase();
		TrieNode node = root;
		
		for(i=0; i<word.length(); i++)
		{
			node = node.getNode(lowerWord.charAt(i));
			
			if(node == null)
			{
				return 0;
			}
		}
		count = node.count;
		return count;
	}
	
	
}
