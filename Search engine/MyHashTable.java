
import java.util.*;
class WElist extends MyLinkedList<WordEntry>
{

}
public class MyHashTable
{

	WElist[] HashArray=new WElist[100];
	int getHashIndex (String a)
    {
		int ans=0;
    	a=a.toLowerCase();
    	int b=a.charAt(0);
    	if(b>=97&&b<=122)
    	{
    		ans=a.charAt(0)-'a';
    	}
    	else if(b>=49&&b<=58)
    		{
    		ans=b-48;
    		}

    	else
    		ans=0;
    	return ans;
    }
	void addPositionsForWord(WordEntry w)
	{
		int key=getHashIndex(w.str);
		int c=1;
		if(HashArray[key]==null)
		{
			HashArray[key]= new WElist();
			HashArray[key].Insert(w);
			return;
		}
		if(HashArray[key].IsEmpty())
		{
			HashArray[key].Insert(w);
		}
		else
		{
			boolean flag=false;
			int size=HashArray[key].Size();
			for(int i=1;i<=size;i++)
			{
				WordEntry temp=HashArray[key].getMemberAt(i);
				if(temp.str.equals(w.str))
				{
					MyLinkedList<Position> add=w.getAllPositionsForThisWord();
					//temp.addPositions(add);
					int sd= add.Size();
					//System.out.println(popon+ " positions in a new wordEntry");
					for(int j=0;j<sd;j++){
						temp.addPosition(add.getMemberAt(j));
					}
					flag=true;
					break;
				}
			}
				if(flag==false)
				{
					HashArray[key].Insert(w);
				}

		}
	}
	public boolean wordIsMemberhash(String str)
	{
		boolean ans=false;
		int key=getHashIndex(str);
		int size=HashArray[key].Size();
		for(int i=0;i<size;i++)
		{
			WordEntry temp=HashArray[key].getMemberAt(i+1);
			if(temp.str.equals(str))
			{
				ans=true;
				break;
			}
		}
		return ans;
	}
	public WordEntry getWordEntry(String a)
	{
		int i=getHashIndex(a);
		int size= HashArray[i].Size();
		for(int j=0;j<size;j++)
		{
			WordEntry w= HashArray[i].getMemberAt(j+1);
			if(w.str.equals(a))

				return w;
		}
		return null;
	}
}
class InvertedPageIndex {
	Myset<PageEntry> inverted = new Myset<PageEntry>();
	public void addPage(PageEntry p){
		if(p.flag==true)
		{
			inverted.Insert(p);
		}
	}
	public Myset<PageEntry> getPagesWhichContainWord(String str){
		int size=inverted.SetSize();
		int i=1;
		Myset<PageEntry> temp2 = new Myset<PageEntry>();
		while(i<=size){
			PageEntry temp=inverted.getSetMemberAt(i);
			PageIndex index = temp.getPageIndex();
			if(index.wordIsMember(str)==true){
				temp2.Insert(temp);
			}
			i++;
		}
		return temp2;
	}
	public PageEntry getPage(String a)
	{
		PageEntry ans;
		int size= inverted.SetSize();
		for(int i=0;i<size;i++)
		{
			ans=inverted.getSetMemberAt(i+1);
			if(ans.name.equals(a))
				return ans;
		}
		return null;
	}
}
