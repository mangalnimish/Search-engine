
public class Position
{
PageEntry p;
int i;
public Position(PageEntry a,int b)
{
	p=a;
	i=b;
}
PageEntry getPageEntry()
{
	return p;
}
int getWordIndex()
{
	return i;
}
}
class WordEntry {
String str;
int size=0;
public WordEntry(String a)
{
	str=a;
}
MyLinkedList<Position> list=new MyLinkedList<Position>();
void addPosition(Position position)
{

	size++;
	list.Insert(position);
}
void addPositions(MyLinkedList<Position> positions)
{
	MyLinkedList<Position> a=new MyLinkedList<Position>();
	size=size+a.Size();
	a=positions;
	int i=0;
	int c=a.Size();
	for(i=0;i<c;i++)
	{
		list.Insert(a.top.data);
		a.top=a.top.next;
	}
}
MyLinkedList<Position> getAllPositionsForThisWord()
{
	return list;
}
}
