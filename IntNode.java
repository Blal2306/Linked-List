
public class IntNode 
{
	//A node has 2 main things DATA, and a link into next NODE
	private int data;
	private IntNode link;
	//CONSTRUCTOR
	public IntNode(int initialData, IntNode initialLink)
	{
		data = initialData;
		link = initialLink;
	}
	//After the CURRENT NODE add new NODE with the given element
	public void addNodeAfter(int element)
	{
		link = new IntNode(element, link);
	}
	public int getData()
	{
		return data;
	}
	public IntNode getLink()
	{
		return link;
	}
	//To create a duplicate of a list
	public static IntNode listCopy(IntNode source)
	{
		IntNode copyHead;
		IntNode copyTail;
		
		// |head| ------> node <-------------|tail|
		
		if(source == null)
			return null;
		
		copyHead = new IntNode(source.data, null);
		copyTail = copyHead;
		
		//----------------
		for(source = source.link; source!= null; source = source.link)
		{
			//insert the next node
			copyTail.addNodeAfter(source.data);
			//move the link forward to the newly inserted NODE
			copyTail = copyTail.link;
		}
		
		return copyHead;
	}
	public static IntNode[] listCopyWithTail(IntNode source)
	{
		IntNode copyHead;
		IntNode copyTail;
		
		//return array
		IntNode[] answer = new IntNode[2];
		
		// |head| ------> node <-------------|tail|
		
		if(source == null)
			return null;
		
		//the first node
		copyHead = new IntNode(source.data, null);
		copyTail = copyHead;
		
		//----------------
		for(source = source.link; source!= null; source = source.link)
		{
			//insert the next node
			copyTail.addNodeAfter(source.data);
			//move the link forward to the newly inserted NODE
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		
		return answer;
		
	}
	//how big is the list
	public static int listLength(IntNode head)
	{
		IntNode pointer;
		int count = 0;
		
		for(pointer = head; pointer !=null; pointer = pointer.link)
			count++;
		
		return count;
	}
	//get part of a list
	public static IntNode[] listPart(IntNode start, IntNode end)
	{
		IntNode copyHead;
		IntNode copyTail;
		
		IntNode[] answer = new IntNode[2];
		
		//special cases
		if(start == null)
			throw new IllegalArgumentException("START IS NULL");
		if(end == null)
			throw new IllegalArgumentException("END IS NULL");
		
		//initial data
		copyHead = new IntNode(start.data, null);
		copyTail = copyHead;
		
		for(start = start.link; start!=end; start=start.link)
		{
			if(start == null)
				throw new IllegalArgumentException("END NOT FOUND");
			copyTail.addNodeAfter(start.data);
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		
		
		return answer;
	}
	public static IntNode listPosition(IntNode head, int position)
	{
		//keep moving forward in list until you reach the position and then return that node
		
		IntNode x = head;
		//special case
		if(position <=0)
			throw new IllegalArgumentException("position is not positive.");
		
		for(int i = 1; (i < position) && (x != null); i++)
			x = x.link;
		
		return x;
	}
	public static IntNode listSearch(IntNode head, int target)
	{
		for(IntNode x = head; x!= null; x= x.link)
			if(target == x.data)
				return x;
		return null;
	}
	public void removeNodeAfter()
	{
		link = link.link;
	}
	public void setData(int newdata)
	{
		data = newdata;
	}
	public void setLink(IntNode newLink)
	{
		link = newLink;
	}
	
	//PRINT THE LIST
	
	public static void printIntList(IntNode head)
	{
		IntNode mover;
		int lineCount = 1;
		for(mover = head; mover != null; mover = mover.link)
		{
			System.out.print(mover.data+", ");
			
			if(lineCount % 10 == 0)
				System.out.println();
			lineCount++;
		}
		
		System.out.println();
	}
	
	//Switch data in 2 nodes	
	public static void Switch2Nodes(IntNode node1, IntNode node2)
	{
		int temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}
	
	//Sort the list
	public static void sort(IntNode a)
	{
		for(int i = IntNode.listLength(a); i >=1; i--)
		{
			for(int j = 1; j <= i-1; j++)
			{
				if((IntNode.listPosition(a, j)).getData() > (IntNode.listPosition(a, j+1)).getData())
				{
					Switch2Nodes(IntNode.listPosition(a, j),IntNode.listPosition(a, j+1));
					
				}
			}
		}
	}
	
	//Reverse node
	public static void reverse(IntNode a)
	{
		//Begin and end marks
		int i = 1;
		int j = listLength(a)-2;
		
		IntNode start = a;
		IntNode end = reverse_b(a, null);
		
		while (j > i)
		{
			start = start.getLink();
			end = reverse_b(start, end);
			
			j--;
			i++;
		}
	}
	public static IntNode reverse_b(IntNode next, IntNode end)
	{

		IntNode cursor;
		IntNode temp = null;
		for(cursor = next; cursor!=end; cursor = cursor.getLink())
			temp = cursor;
		
		swap2nodes(next, temp);
		
		return temp;
			
	}
	public static void swap2nodes(IntNode a, IntNode b)
	{
		int temp = a.getData();
		a.setData(b.getData());
		b.setData(temp);
	}
}





