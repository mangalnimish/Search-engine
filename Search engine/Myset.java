

public class Myset<X> {

	ob<X> top =new ob<X>();
	int flag;
	int size=0;
	public int SetSize()
	{
		return size;
	}
	public Boolean IsEmpty()
	{
		if (top.data==null)
			return true;
		else
			return false;
	}
	public Boolean IsMember(X o)
	{
		flag=0;
		ob<X> temp=top;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==1)
			return true;
		else
			return false;
	}
	public void Insert(X o)
	{

		if(top==null)
		{
			top.data=o;
		}
		else
		{
			ob<X> temp=new ob<X>();
			temp.data=o;
			temp.next=top;
			top=temp;
		}
		size++;
	}
	public void Delete(X o)
	{

		ob<X> temp=null;
		ob<X> temp2=null;
		temp2=top;
		temp=top;
		if(temp.data==o)
		{
			top=top.next;
		}
		else
		{
			temp=temp.next;
			while(temp.data!=null)
			{
				if(temp.data==o)
				{
					temp2.next=temp.next;
					break;
				}
				temp=temp.next;
				temp2=temp2.next;
			}
		}
	}
	public Myset<X> Union(Myset<X> a)
	{
		Myset<X> union =new Myset<X>();
		if(a.IsEmpty()==true && this.IsEmpty()==true )
		{
		}
		else if(a.IsEmpty()==true && this.IsEmpty()==false)
		{
			union=this;
		}
		else if(a.IsEmpty()==false && this.IsEmpty()==true)
		{
			union=a;
		}
		else{
		union.top=top;
		ob<X> temp2=new ob<X>();
		temp2=a.top;
		while(temp2!=null)
		{
			if(union.IsMember(temp2.data))
			{
				temp2=temp2.next;
			}
			else
			{
				union.Insert(temp2.data);
				temp2=temp2.next;
			}
		}}
		return union;
	}
	public X getSetMemberAt(int i)
	{
		int j=1;
		ob<X> temp;
		temp=top;
		for(j=1;j<i;j++)
		{
			temp=temp.next;
		}
		return temp.data;
	}
	public Myset<X> Intersection(Myset<X> a)
	{
		Myset<X> intersection=new Myset<X>();
		ob<X> temp3=new ob<X>();
		temp3=top;
		while(temp3!=null)
		{
			if(a.IsMember(temp3.data))
			{
				intersection.Insert(temp3.data);
				//System.out.println(Intersection.top.data + "aa");
			}
			temp3=temp3.next;
		}
		return intersection;
	}


}
class ob<X>
{
	ob<X> next=null;
	X data;
}

class MyLinkedList<X>
{
	ob<X> top =new ob<X>();
	int flag;
	int s=0;

	public Boolean IsEmpty()
	{
		if (top.data==null)
			return true;
		else
			return false;
	}
	public Boolean IsMember(X o)
	{
		flag=0;
		ob<X> temp=top;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==1)
			return true;
		else
			return false;
	}
	public X getMember(X o)
	{
		ob<X> temp=top;
		ob<X> temp2=null;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				temp2=temp;
				break;
			}
			temp=temp.next;
		}
		return temp2.data;
	}
	public X getMemberAt(int i)
	{
		int j=1;
		ob<X> temp;
		temp=top;
		for(j=1;j<i;j++)
		{
			temp=temp.next;
		}
		return temp.data;
	}
	public void Insert(X o)
	{
		s=s+1;
		if(top==null)
		{
			top.data=o;
		}
		else
		{
			ob<X> temp=new ob<X>();
			temp.data=o;
			temp.next=top;
			top=temp;
		}
	}
	public int Size()
	{
		return s;
	}
	public void Insertall(MyLinkedList<X> o)
	{
		s=s+o.Size();
		ob<X> temp;
		temp=o.top;
		if(top.data==null)
		{
			top.data=temp.data;
			temp=temp.next;
			while(temp.data!=null)
			{
				ob<X> temp2=new ob<X>();
				temp2.data=temp.data;
				temp2.next=top;
				top=temp2;
				temp=temp.next;
			}
		}
		else
		{
			while(temp.data!=null)
			{
				ob<X> temp2=new ob<X>();
				temp2.data=temp.data;
				temp2.next=top;
				top=temp2;
				temp=temp.next;
			}
		}
	}
	public void Delete(X o)
	{

		s=s-1;
		ob<X> temp=null;
		ob<X> temp2=null;
		temp2=top;
		temp=top;
		if(temp.data==o)
		{
			top=top.next;
		}
		else
		{
			temp=temp.next;
			while(temp.data!=null)
			{
				if(temp.data==o)
				{
					temp2.next=temp.next;
					break;
				}
				temp=temp.next;
				temp2=temp2.next;
			}
		}
	}

}
