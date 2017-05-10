
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class PageEntry
{
	int count=1;
	String name="";
	boolean flag=true;
	PageIndex pageind=new PageIndex();
	PageEntry(String pageName)
	{
		name=pageName;
		BufferedReader br=null;
		try{
			String str;
			br = new BufferedReader(new FileReader(pageName));
			while((str=br.readLine())!=null){
				Read(str);
			}
		}
		catch(IOException e){
			System.out.println("file not found");
			flag=false;
		}
		finally {
			try {
				if (br != null)
					br.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void Read(String a)
	{
		Scanner s= new Scanner(a);
		while(s.hasNext()){
			boolean flag=true;
			String temp= s.next();
			Position p= new Position(this,count);
			temp= temp.toLowerCase();
			int size= temp.length();
			while(flag==true)
			{
				size=temp.length();
				for(int i=0;i<size;i++){
					if(temp.charAt(i)=='{' ||temp.charAt(i)=='}' ||temp.charAt(i)=='[' ||temp.charAt(i)==']' ||temp.charAt(i)=='<' ||temp.charAt(i)=='>' ||temp.charAt(i)=='=' ||temp.charAt(i)=='(' ||temp.charAt(i)==')' ||temp.charAt(i)=='.' ||temp.charAt(i)==',' ||temp.charAt(i)==';' ||temp.charAt(i)=='\'' ||temp.charAt(i)=='\"' ||temp.charAt(i)=='?' ||temp.charAt(i)=='#' || temp.charAt(i)=='!' ||temp.charAt(i)=='-' ||temp.charAt(i)==':' )
					{
						temp= temp.substring(0, i)+temp.substring(i+1);
						flag=true;
						size=temp.length();
						if(size==0)
							flag=false;
					}
					else
						flag=false;
				}
			}
			if(temp.length()>0){
				if(temp.equals("structures") ||temp.equals("stacks") ||  temp.equals("applications")){
					temp= temp.substring(0, temp.length()-1) + temp.substring(temp.length());
				}
				pageind.addPositionForWord(temp, p);
				count++;
			}
		}
		s.close();
	}


	PageIndex getPageIndex()
	{
		return pageind;
	}

}
/*class PageIndex
{
	MyLinkedList<WordEntry> plist=new MyLinkedList<WordEntry>();
	MyLinkedList<String> slist=new MyLinkedList<String>();
	void addPositionForWord(String str, Position p)
	{

		WordEntry word=new WordEntry(str);
		word.addPosition(p);
		if(slist.IsMember(str))
		{
			WordEntry temp=plist.getMember(word);
			temp.addPosition(p);
		}
		else
		{
			slist.Insert(str);
			plist.Insert(word);
		}
	}
	 MyLinkedList<WordEntry> getWordEntries()
	{
		return plist;
	}
	 public boolean wordIsMember(String str){
			return slist.IsMember(str);
		}
}*/
 class PageIndex
 {
	private MyHashTable hashtable= new MyHashTable();
	public void addPositionForWord(String str, Position p)
	{
		WordEntry w = new WordEntry(str);
		w.addPosition(p);
		hashtable.addPositionsForWord(w);
	}
	public MyLinkedList<WordEntry> getWordEntries()
	{
		MyLinkedList<WordEntry> ans=new MyLinkedList<WordEntry>();
		int j=0;
		for(j=0;j<100;j++)
		{
			if(hashtable.HashArray[j].Size()!=0)
			{
				ans.Insertall(hashtable.HashArray[j]);
			}
		}
		return ans;
	}
	public boolean wordIsMember(String str)
	{
		return hashtable.wordIsMemberhash(str);
	}
	public WordEntry getWordEntry(String str)
	{
		return hashtable.getWordEntry(str);
	}
 }


