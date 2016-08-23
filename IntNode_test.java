
public class IntNode_test {

	public static void main(String[] args)
	{
		int Random1 = (int)(Math.random()*9 +1);
		int Random2;
		IntNode a = new IntNode(Random1, null);
		
		IntNode cursor = a;
		
		for(int i = 1; i <= 2; i++)
		{
			Random2 = (int)(Math.random()*9 +1);
			cursor.addNodeAfter(Random2);
			cursor = cursor.getLink();
		}
		
		IntNode.printIntList(a);
		
		IntNode.reverse(a);
		IntNode.printIntList(a);
		
		
	}
	
	
}
