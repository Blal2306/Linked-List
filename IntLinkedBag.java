
public class IntLinkedBag implements Cloneable {

	//TO STORE DATA IN THE LIST
	private IntNode head;
	//HOW MANY ITEMS IN THE LIST
	private int manyNodes;
	
	
	public IntLinkedBag()
	{
		head = null;
		manyNodes = 0;
	}
	public void add(int element)
	{
		//THE NEW NODES ARE INSERTED AT THE BEGINING
		head = new IntNode(element, head);
		manyNodes++;
	}
	public void addAll(IntLinkedBag addend)
	{
		IntNode[] copyInfo;
		
		//special case
		if(addend == null)
			throw new IllegalArgumentException("ADDEND IS NULL");
		
		if(addend.manyNodes > 0)
		{
			copyInfo = IntNode.listCopyWithTail(addend.head); //Insert the list from "addend" into the new output list; this will also give us head and tail of that list
			copyInfo[1].setLink(head); //set the tail of that to the current "HEAD"
			head = copyInfo[0]; //make "HEAD" the beginning of a newly inserted list
			manyNodes+=addend.manyNodes;
		}
		
		
	}
	public void addMany(int...elements)
	{
		for(int i : elements)
			add(i);
	}
	public IntLinkedBag clone()
	{
		IntLinkedBag output;
		
		try
		{
			output = (IntLinkedBag) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("THIS CLASS HAS NO CLONEABLE ...");
		}
		
		output.head = IntNode.listCopy(head);
		//because the head points to the initial list, we must copy the list into head
		
		return output;
		
		
	}
	public int countOccurrences(int target)
	{
		int count = 0;
		IntNode cursor;
		
		for(cursor = head; cursor!=null; cursor = cursor.getLink())
			if(cursor.getData() == target)
				count++;
		return count;
	}
	public int grab()
	{
		IntNode out;
		
		if(manyNodes == 0)
			throw new IllegalStateException("BAG HAS ZERO ITEMS ...");
		
		int n = (int) (Math.random()*manyNodes)+1;
		
		out = IntNode.listPosition(head, n);
		
		return out.getData();
	}
	public boolean remove(int target)
	{
		IntNode targetNode = IntNode.listSearch(head, target);
		
		if(targetNode == null)
			return false;
		
		else
		{
			targetNode.setData(head.getData());
			head = head.getLink();
			manyNodes--;
			
			return true;
		}
		
		
	}
	public int size()
	{
		return manyNodes;
	}
	public static IntLinkedBag union(IntLinkedBag b1, IntLinkedBag b2)
	{
		if(b1 == null)
			throw new IllegalArgumentException("b1 is null.");
		if(b2 == null)
			throw new IllegalArgumentException("b2 is null.");
		
		IntLinkedBag output = new IntLinkedBag();
		
		
		output.addAll(b1);
		output.addAll(b2);
		
		return output;
	}
	
	//print the Bag
	public static void printBag(IntLinkedBag a)
	{
		IntNode x;
		
		for(x = a.head; x!=null; x=x.getLink())
			System.out.print(x.getData()+", ");
		
		System.out.println();
	}
}
