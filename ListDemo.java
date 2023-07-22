package list;

public class ListDemo {
	
	public static void p(Object o) {System.out.println(o);} // shorthand notation
	
	public static void main(String[] args) {
		
		MultiColList list;
		
		p("TEST TOSTRING\n");
		
			list = new MultiColList("one","two","three","four","five","six","seven");
			p(list);
		
		p("\nTEST ADD\n");
		   	
		    list = new MultiColList("one","two","three","four");
		    list.add("dummy").add("dummy").add("dummy").add("dummy")
		    	.add("dummy").add("dummy").add("dummy").add("dummy");
		    p(list);
		    
		p("\nTEST ADD TO EMPTY LIST\n");
		
		p("\tSingle add:\n");
		
			MultiColList emptylist = new MultiColList();
			emptylist.add("dummy");
			System.out.println(emptylist);
			
		p("\tMultiple add:\n");
		
			emptylist = new MultiColList();
			emptylist.add("dummy", "dummy", "dummy", "dummy");
			p(emptylist);
	   	
	    p("\nTEST REMOVE\n");
	    
	    list = new MultiColList("one","two","three","remove me","four","five");
	    
	    	p("  Before remove:\n");
	    	p(list);
	    	
	    	p("  After remove:");
		    p(list.remove(4));
	   	
	    p("\nTEST CLEAR\n");
		   	
	    	p(list);
	    	
	    	p("""
	    	list.clear();
	    	p(list);
	    	^ this yields V	
	    			""");
	    	list.clear();
	    	p(list);
	    	p("(empty string)");
	    	
	    p("\nTEST VARIABLE HEIGHT\n");
	    
	    p("  DEFAULT LENGTH IS 5:");
	    
		    list = new MultiColList("dummy","dummy","dummy","dummy","dummy","dummy",
		    		"dummy","dummy","dummy","dummy","dummy","dummy","dummy","dummy");
		    p(list);
		    
		p("  SET LENGTH TO 7:");
		    list.setVertical(7);
		    p(list);
		    
	    p("  SET LENGTH TO 13:");
		    list.setVertical(13);
		    p(list);
		    
		p("  SET LENGTH TO 1:");
		    list.setVertical(1);
		    p(list);
	}
}
