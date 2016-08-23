
public class IntLinkedBag_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntLinkedBag a = new IntLinkedBag();
		a.addMany(5, 4, 3, 2, 1);
		IntLinkedBag.printBag(a);
		
		IntLinkedBag b = new IntLinkedBag();
		b.addMany(10, 9, 8, 7, 6);
		
		
		IntLinkedBag.printBag(b);
		
	
		
		IntLinkedBag c = new IntLinkedBag();
		c = IntLinkedBag.union(b, a);
		IntLinkedBag.printBag(c);
	}

}
