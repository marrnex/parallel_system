//
// HelloTaker.java
// 

import net.jini.space.JavaSpace;

public class HelloTaker {
    public static void main(String[] argv)
    {
	Lookup finder = new Lookup(JavaSpace.class);
	JavaSpace space = (JavaSpace) finder.getService();
	if( space == null )
	{
	    System.err.println("No JavaSpace found.");
	    System.exit( 1 );
	}

	Message template = new Message();
	Message result;
	try
	{
	    result = (Message)space.take(template, null, Long.MAX_VALUE);
	    System.out.println("HelloTaker: took ["+result.content+"]");
	}
	catch( Exception e )
	{
	    System.err.println("JavaSpace read error "+e.getMessage());
	    e.printStackTrace();
	    System.exit( -1 );
	}

	System.exit( 0 );
    }
}
