package list;

import java.util.*;

public class MultiColList {
	
	private static final String DUMMY = "**list is empty**";
	private final int DEFAULT_VERTICAL = 5;
	private final String DEFAULT_MARGIN = "    ";
	private int maxVertical = DEFAULT_VERTICAL;
	private String margin = DEFAULT_MARGIN;
	private ArrayList<String> items;
	private ArrayList<Character> status;
	//private ArrayList<String> headings;
	private int itemPad = 1;
	
	MultiColList() {this(DUMMY);}
	
	public MultiColList(String... items) {
	    this.items = new ArrayList<String>(Arrays.asList(items));
	    this.status = new ArrayList<Character>(Collections.nCopies(items.length,'_'));
	    //this.headings = new ArrayList<String>(Collections.nCopies(items.length, null));
	    initialize();
	}
	
	/** Adjust column size according to largest String */
	private void initialize() {
	    itemPad = 0;
	    for (String s : items) {
	        int len = s.length();
	        if (len > itemPad) {
	        	itemPad = len;
	        }
	    }
	}
	
	public void setVertical(int num) {
		maxVertical = num;
	}
	
	/*public void setItemPadding(String margin) {
		this.margin = margin;
	}*/
	
	public void setItem(int i, String newItem) {
		items.set(i, newItem);
	}
	
	public void setStatus(char... status) {
		for (int i = 0;i<items.size();i++) {
			setStatus(i,status[i]);
		}
	}
	
	public void setStatus(int i, char status) {
		this.status.set(i,status);
	}
	
	/*public void setHeading(int i, String heading) {
		this.headings.set(i, heading);
	}*/
	
	public void add(String... items) {
		for (String item : items) {
			add(item);
		}
	}
	
	public void add(String item) {
		items.add(item);
		status.add('_');
		//headings.add(null);
		
		if (items.get(0).equals(DUMMY)) {
			items.remove(0);
			status.remove(0);
			//headings.remove(0);
		}
		
		initialize();
	}
	
	public void remove(int i) {
		items.remove(i-1);
		status.remove(i-1);
		//headings.remove(i-1);
		initialize();
	}
	
	public void clear() {
		items.clear();
		status.clear();
		//headings.clear();
	}
	
	public String toString() {
		//Object[] headingsA = headings.toArray();
		Object[] itemsA = items.toArray();
		Object[] statusA = status.toArray();
		String[] line = new String[maxVertical];
		int index = 1;
		String str = "";
		//int hpad = itemPad+margin.length()+5;

		for (int i=0;i<items.size();i++) {
			line[i%maxVertical] += String.format("%2d %-" + itemPad + "s   %s%s",index,itemsA[i],statusA[i],margin);
			index++;
		}

		for (String l : line) {
			if (l != null) {
				str += l.substring(4) + "\r\n";
			}
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		
		MultiColList list;
		
		System.out.println("TEST TOSTRING\n");
		
			list = new MultiColList("one","two","three","four","five","six");
			System.out.println(list);
		
		System.out.println("\nTEST ADD\n");
		   	
		    list = new MultiColList("one","two","three","four","five");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    System.out.println(list);
		    
		System.out.println("\nTEST ADD TO EMPTY LIST\n");
		
			MultiColList emptylist = new MultiColList();
			emptylist.add("dummy");
			//emptylist.add("dummy");
			//emptylist.add("dummy");
			System.out.println(emptylist);
	   	
	    System.out.println("\nTEST REMOVE\n");
	    
		    list = new MultiColList("one","two","three","four","five");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.remove(1);
		    System.out.println(list);
	   	
	    System.out.println("\nTEST CLEAR\n");
		   	
	    	System.out.println(list);
	    	list.clear();
	    	System.out.println("deleted" + list);
	    	
	    System.out.println("\nTEST VARIABLE HEIGHT\n");
	    
		    list = new MultiColList("one","two","three","four","five");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    list.add("dummy");
		    System.out.println(list);
		    list.setVertical(7);
		    System.out.println(list);
	    	
		 
	}

}
