
import java.util.Scanner;

public class SearchEngine {
	InvertedPageIndex ipi=new InvertedPageIndex();
	public SearchEngine()
	{
		InvertedPageIndex temp=new InvertedPageIndex();
		ipi=temp;
	}

	void performAction(String ActionMessage)
	{

		Scanner s=new Scanner(ActionMessage);
		//System.out.println(ActionMessage);
		String str=s.next();
		switch(str)
		{
		case "addPage":
		{
			String a="";
			try{
			a=s.next();}
			catch(Exception e)
			{
				System.out.println("Wrong input format");
				break;
			}
			PageEntry page=new PageEntry(a);
			ipi.addPage(page);
			break;
		}
		case "queryFindPagesWhichContainWord":
		{
			String a="";
			try{
			a=s.next();}
			catch(Exception ee)
			{
				System.out.println(ActionMessage+": Wrong input format");
				break;
			}
			a=a.toLowerCase();
			Myset<PageEntry>ans=ipi.getPagesWhichContainWord(a);


			int size=ans.SetSize();
			int i;
			if(size==0)
			{
				System.out.println(ActionMessage+": No webpage contains word "+ a);
			}
			else{
				System.out.print(ActionMessage+": ");
			for(i=1;i<=size-1;i++)
			{
				PageEntry page=ans.getSetMemberAt(i);
				System.out.print(page.name+", ");
			}
			PageEntry page=ans.getSetMemberAt(i);
			System.out.println(page.name);
			}
			break;
		}
		case "queryFindPositionsOfWordInAPage":
		{
			String a="";
			String b="";
			try{
			a=s.next();
			b=s.next();}
			catch (Exception ae)
			{
				System.out.println(ActionMessage+": Wrong input format");
				break;
			}
			int size=0;
			PageEntry temp=ipi.getPage(b);
			if(temp==null)
			{
				System.out.println(ActionMessage+": Given page does not exist");
				break;
			}
			else
			{
				PageIndex index=temp.getPageIndex();
				System.out.print(ActionMessage+": ");
				if(index.wordIsMember(a))
				{
					int j;
					MyLinkedList<Position>ans =new MyLinkedList<Position>();
					MyLinkedList<Position>par =new MyLinkedList<Position>();
					par=index.getWordEntry(a).getAllPositionsForThisWord();
					size=par.Size();
					for(j=1;j<=size;j++)
					{
						ans.Insert(par.getMemberAt(j));
					}
					for( j=1;j<size;j++)
					{
						System.out.print(ans.getMemberAt(j).i+" ,");
					}

					System.out.println(ans.getMemberAt(j).i);
				}
				else
				{
					System.out.println("Webpage "+b+" does not contain word "+a);
					break;
				}
			}
			break;
		}
		default:
		{
			System.out.println(ActionMessage+": No such Query found");
			break;
		}
		}
		s.close();
	}

}

